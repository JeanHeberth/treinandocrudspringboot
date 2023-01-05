package br.jeanheberth.cruduserspringboot.controller;

import br.jeanheberth.cruduserspringboot.dto.ProjetoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.ProjetoResponseDto;
import br.jeanheberth.cruduserspringboot.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @GetMapping
    public List<ProjetoResponseDto> findAllProjetos() {
        return projetoService.findAllProjetos();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjetoResponseDto> findByIdProjetos(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.findByIdProjeto(id));
    }

    @DeleteMapping("{id}")
    public void deleteByIdProjeto(@PathVariable Long id) {
        projetoService.deleteByIdProjeto(id);
    }

    @PostMapping
    public ResponseEntity<ProjetoResponseDto> saveProjeto(@Validated @RequestBody ProjetoRequestDto projetoRequestDto) {
        return ResponseEntity.ok(projetoService.saveProjeto(projetoRequestDto));
    }

    @PutMapping
    public ResponseEntity<Optional<ProjetoResponseDto>> updateProjeto(@Validated @RequestBody ProjetoRequestDto projetoRequestDto) {
        return ResponseEntity.ok(projetoService.updateProjeto(projetoRequestDto));
    }
}
