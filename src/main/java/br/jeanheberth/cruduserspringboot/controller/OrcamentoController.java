package br.jeanheberth.cruduserspringboot.controller;

import br.jeanheberth.cruduserspringboot.dto.OrcamentoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.OrcamentoResponseDto;
import br.jeanheberth.cruduserspringboot.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {
    @Autowired
    private OrcamentoService orcamentoService;


    @GetMapping
    public ResponseEntity<List<OrcamentoResponseDto>> findAllOrcamento() {
        return ResponseEntity.ok(orcamentoService.findAllOrcamento());
    }

    @GetMapping("{id}")
    public ResponseEntity<OrcamentoResponseDto> findByIdOrcamento(@PathVariable Long id) {
        return ResponseEntity.ok(orcamentoService.findByIdOrcamento(id));
    }

    @DeleteMapping("{id}")
    public void deleteByIdOrcamento(@PathVariable Long id) {
      orcamentoService.deleteByIdOrcamento(id);
    }

    @PostMapping
    public ResponseEntity<OrcamentoResponseDto> saveOrcamento(@Validated @RequestBody OrcamentoRequestDto orcamentoRequestDto) {
        return ResponseEntity.ok(orcamentoService.saveDepartamento(orcamentoRequestDto));
    }

    @PutMapping
    public ResponseEntity<Optional<OrcamentoResponseDto>> updateOrcamento(@Validated @RequestBody OrcamentoRequestDto orcamentoRequestDto) {
        return ResponseEntity.ok(orcamentoService.updateDepartamento(orcamentoRequestDto));
    }
}
