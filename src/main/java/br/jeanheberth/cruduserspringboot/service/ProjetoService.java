package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.ProjetoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.ProjetoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Departamento;
import br.jeanheberth.cruduserspringboot.entities.Projeto;
import br.jeanheberth.cruduserspringboot.repository.DepartamentoRepository;
import br.jeanheberth.cruduserspringboot.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    /* Metodo para listar todos os projetos */
    public List<ProjetoResponseDto> findAllProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        List<ProjetoResponseDto> projetoResponseDtos = projetos.stream()
                .map(projeto -> new ProjetoResponseDto(projeto)).collect(Collectors.toList());
        return projetoResponseDtos;

    }

    /* Metodo para buscar projeto por id */
    public ProjetoResponseDto findByIdProjeto(Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        ProjetoResponseDto projetoResponseDto = new ProjetoResponseDto(projeto.get());
        if (projeto.isPresent()) {
            return projetoResponseDto;
        }
        throw new RuntimeException();
    }

    /* Metodo para deletar o projeto por id */
    public void deleteByIdProjeto(Long id) {
        projetoRepository.deleteById(id);
    }

   /* Metodo para salvar projeto */
    public ProjetoResponseDto saveProjeto(ProjetoRequestDto projetoRequestDto) {
        Optional<Departamento> departamento = departamentoRepository.findById(projetoRequestDto.getIdDepartamento());
        Projeto projeto = Projeto.builder()
                .nome(projetoRequestDto.getNome())
                .valorDoProjeto(projetoRequestDto.getValorDoProjeto())
                .dataInicio(projetoRequestDto.getDataInicio())
                .dataFinal(projetoRequestDto.getDataFinal())
                .departamento(departamento.get())
                .build();
        ProjetoResponseDto projetoResponseDto = new ProjetoResponseDto(projetoRepository.save(projeto));
        return projetoResponseDto;
    }

    /* Metodo par atualizar projeto */
    public Optional<ProjetoResponseDto> updateProjeto(ProjetoRequestDto projetoRequestDto) {
        Optional<Departamento> departamento = departamentoRepository.findById(projetoRequestDto.getIdDepartamento());
        return projetoRepository.findById(projetoRequestDto.getId())
                .map(projeto -> {
                    projeto.setNome(projetoRequestDto.getNome());
                    projeto.setDataInicio(projetoRequestDto.getDataInicio());
                    projeto.setDataFinal(projetoRequestDto.getDataFinal());
                    projeto.setValorDoProjeto(projetoRequestDto.getValorDoProjeto());
                    projeto.setDepartamento(departamento.get());
                    ProjetoResponseDto projetoResponseDto = new ProjetoResponseDto(projetoRepository.save(projeto));
                    return projetoResponseDto;
                });
    }
}
