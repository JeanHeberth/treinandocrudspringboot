package br.jeanheberth.cruduserspringboot.controller;

import br.jeanheberth.cruduserspringboot.dto.DepartamentoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.DepartamentoResponseDto;
import br.jeanheberth.cruduserspringboot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @RequestMapping
    public ResponseEntity<List<DepartamentoResponseDto>> findAllDepartamentos() {
        return ResponseEntity.ok(departamentoService.findAllDepartamento());
    }

    @RequestMapping("{id}")
    public ResponseEntity<DepartamentoResponseDto> findByIdDepartamento(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.findByIdDepartamento(id));
    }

    @DeleteMapping("{id}")
    public void deleteByIdDepartamento(@PathVariable Long id) {
        departamentoService.deleteByIdDepartamento(id);
    }

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> saveDepartamento(@Validated @RequestBody DepartamentoRequestDto departamentoRequestDto) {
        return ResponseEntity.ok(departamentoService.saveDepartamento(departamentoRequestDto));
    }

    @PutMapping
    public ResponseEntity<Optional<DepartamentoResponseDto>> updateDepartamento(@Validated @RequestBody DepartamentoRequestDto departamentoRequestDto) {
        return ResponseEntity.ok(departamentoService.updateDepartamento(departamentoRequestDto));
    }

    @GetMapping("/teste")
    public String index(){
        return  "Ola Mundo!";
    }
}
