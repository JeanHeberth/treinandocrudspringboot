package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.ProjetoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.ProjetoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Projeto;
import br.jeanheberth.cruduserspringboot.repository.ProjetoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepositoy projetoRepositoy;

    /* Metodo para listar todos os projetos */
    public List<ProjetoResponseDto> findAllProjetos() {
        List<Projeto> projetos = projetoRepositoy.findAll();
        List<ProjetoResponseDto> projetoResponseDtos = projetos.stream()
                .map(projeto -> new ProjetoResponseDto(projeto)).collect(Collectors.toList());
        return projetoResponseDtos;

    }

    /* Metodo para buscar projeto por id */
    public ProjetoResponseDto findByIdProjeto(Long id) {
        Optional<Projeto> projeto = projetoRepositoy.findById(id);
        ProjetoResponseDto projetoResponseDto = new ProjetoResponseDto(projeto.get());
        if (projeto.isPresent()) {
            return projetoResponseDto;
        }
        throw new RuntimeException();
    }

    /* Metodo para deletar o projeto por id */
    public void deleteByIdProjeto(Long id) {
        Optional<Projeto> projeto = projetoRepositoy.findById(id);
        if (projeto.isPresent()) {
            projetoRepositoy.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    /* Metodo para salvar projeto */
    public ProjetoResponseDto saveProjeto(ProjetoRequestDto projetoRequestDto) {
        Projeto projeto = new Projeto();
        projeto.setNome(projetoRequestDto.getNome());
        ProjetoResponseDto projetoResponseDto = new ProjetoResponseDto(projetoRepositoy.save(projeto));
        return projetoResponseDto;
    }

    /* Metodo par atualizar projeto */
    public ProjetoResponseDto updateProjeto(ProjetoRequestDto projetoRequestDto) {
        Optional<Projeto> buscaProjeto = projetoRepositoy.findById(projetoRequestDto.getId());
        if (buscaProjeto.isPresent()) {
            Projeto projeto = buscaProjeto.get();
            projeto.setNome(projetoRequestDto.getNome());
            ProjetoResponseDto projetoResponseDto = new ProjetoResponseDto(projetoRepositoy.save(projeto));
            return projetoResponseDto;
        } else {
            throw new RuntimeException();
        }
    }
}
