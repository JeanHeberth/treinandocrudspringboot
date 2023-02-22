package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.DepartamentoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.DepartamentoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Departamento;
import br.jeanheberth.cruduserspringboot.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<DepartamentoResponseDto> findAllDepartamento() {
        List<Departamento> departamentos = departamentoRepository.findAll();
        List<DepartamentoResponseDto> departamentoResponseDtos = departamentos.stream()
                .map(departamento -> new DepartamentoResponseDto(departamento)).collect(Collectors.toList());
        return departamentoResponseDtos;
    }

    public DepartamentoResponseDto findByIdDepartamento(Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        DepartamentoResponseDto departamentoResponseDto = new DepartamentoResponseDto(departamento.get());
        if (departamento.isPresent()) {
            return departamentoResponseDto;
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteByIdDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }

    public DepartamentoResponseDto saveDepartamento(DepartamentoRequestDto departamentoRequestDto) {
        Departamento departamento = Departamento.builder()
                .nome(departamentoRequestDto.getNome())
                .numero(departamentoRequestDto.getNumero())
                .build();
        DepartamentoResponseDto departamentoResponseDto = new DepartamentoResponseDto(departamentoRepository.save(departamento));
        return departamentoResponseDto;
    }

    public Optional<DepartamentoResponseDto> updateDepartamento(DepartamentoRequestDto departamentoRequestDto) {
        return departamentoRepository.findById(departamentoRequestDto.getId())
                .map(departamento -> {
                    departamento.setNome(departamentoRequestDto.getNome());
                    departamento.setNumero(departamentoRequestDto.getNumero());
                    DepartamentoResponseDto departamentoResponseDto = new DepartamentoResponseDto(departamentoRepository.save(departamento));
                    return departamentoResponseDto;
                });
    }
}



