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
import java.util.NoSuchElementException;
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
        return projetoRepository.findAll()
                .stream()
                .map(ProjetoResponseDto::new).collect(Collectors.toList());

    }

    /* Metodo para buscar projeto por id */
    public ProjetoResponseDto findByIdProjeto(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Projeto nao encontrado"));
        return new ProjetoResponseDto(projeto);
    }

    /* Metodo para deletar o projeto por id */
    public void deleteByIdProjeto(Long id) {
        projetoRepository.deleteById(id);
    }

    /* Metodo para salvar projeto */
    public ProjetoResponseDto saveProjeto(ProjetoRequestDto projetoRequestDto) {
        return new ProjetoResponseDto(projetoRepository.save(Projeto.builder()
                .id(projetoRequestDto.getId())
                .nome(projetoRequestDto.getNome())
                .valorDoProjeto(projetoRequestDto.getValorDoProjeto())
                .dataInicio(projetoRequestDto.getDataInicio())
                .dataFinal(projetoRequestDto.getDataFinal())
                .departamento(Departamento.builder().id(projetoRequestDto.getIdDepartamento()).build())
                .build()));
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
                    projeto.setDepartamento(departamento.orElseThrow(() -> new NoSuchElementException("Departamento not found with id: " + projetoRequestDto.getIdDepartamento())));
                    return projetoRepository.save(projeto);
                })
                .map(ProjetoResponseDto::new);
    }
}
