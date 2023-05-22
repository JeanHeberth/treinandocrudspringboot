package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.DepartamentoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.DepartamentoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Departamento;
import br.jeanheberth.cruduserspringboot.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<DepartamentoResponseDto> findAllDepartamento() {
        return departamentoRepository.findAll()
                .stream()
                .map(DepartamentoResponseDto::new)
                .collect(Collectors.toList());
    }

    public DepartamentoResponseDto findByIdDepartamento(Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Departamento nao encontrado: " + id));
        return new DepartamentoResponseDto(departamento);

    }

    public void deleteByIdDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }

    public DepartamentoResponseDto saveDepartamento(DepartamentoRequestDto departamentoRequestDto) {
        return new DepartamentoResponseDto(departamentoRepository.save(Departamento.builder()
                .nome(departamentoRequestDto.getNome())
                .numero(departamentoRequestDto.getNumero())
                .build()));
    }

    public Optional<DepartamentoResponseDto> updateDepartamento(DepartamentoRequestDto departamentoRequestDto) {
        return departamentoRepository.findById(departamentoRequestDto.getId())
                .map(departamento -> {
                    departamento.setNome(departamentoRequestDto.getNome());
                    departamento.setNumero(departamentoRequestDto.getNumero());
                    return departamento;
                })
                .map(departamentoRepository::save)
                .map(DepartamentoResponseDto::new);
    }
}




