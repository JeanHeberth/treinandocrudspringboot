package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.OrcamentoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.OrcamentoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Departamento;
import br.jeanheberth.cruduserspringboot.entities.Orcamento;
import br.jeanheberth.cruduserspringboot.repository.DepartamentoRepository;
import br.jeanheberth.cruduserspringboot.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {
    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;


    public List<OrcamentoResponseDto> findAllOrcamento() {
        List<Orcamento> orcamentos = orcamentoRepository.findAll();
        List<OrcamentoResponseDto> orcamentoResponseDtos = orcamentos.stream()
                .map(orcamento -> new OrcamentoResponseDto(orcamento)).collect(Collectors.toList());
        return orcamentoResponseDtos;
    }

    public OrcamentoResponseDto findByIdOrcamento(Long id) {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        OrcamentoResponseDto orcamentoResponseDto = new OrcamentoResponseDto(orcamento.get());
        if (true) {
            return orcamentoResponseDto;
        }
        throw new RuntimeException();
    }

    public void deleteByIdOrcamento(Long id) throws Throwable {
        if (orcamentoRepository.findById(id).isPresent()) {
            orcamentoRepository.deleteById(id);
        }
    }

    public OrcamentoResponseDto saveOrcamento(OrcamentoRequestDto orcamentoRequestDto) {
        Orcamento orcamento = Orcamento.builder()
                .id(orcamentoRequestDto.getId())
                .valor(orcamentoRequestDto.getValor())
                .dataInicio(orcamentoRequestDto.getDataInicio())
                .dataFinal(orcamentoRequestDto.getDataFinal())
                .departamento(Departamento.builder().id(orcamentoRequestDto.getIdDepartamento()).build())
                .build();
        OrcamentoResponseDto orcamentoResponseDto = new OrcamentoResponseDto(orcamentoRepository.save(orcamento));
        return orcamentoResponseDto;
    }

    public Optional<OrcamentoResponseDto> updateDepartamento(OrcamentoRequestDto orcamentoRequestDto) {
        Optional<Departamento> departamento = departamentoRepository.findById(orcamentoRequestDto.getIdDepartamento());
        return orcamentoRepository.findById(orcamentoRequestDto.getId())
                .map(orcamento -> {
                    orcamento.setValor(orcamentoRequestDto.getValor());
                    orcamento.setDataInicio(orcamentoRequestDto.getDataInicio());
                    orcamento.setDataFinal(orcamentoRequestDto.getDataFinal());
                    orcamento.setDepartamento(departamento.get());
                    OrcamentoResponseDto orcamentoResponseDto = new OrcamentoResponseDto(orcamentoRepository.save(orcamento));
                    return orcamentoResponseDto;
                });
    }
}
