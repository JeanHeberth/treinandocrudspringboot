package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Departamento;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class DepartamentoResponseDto {

    private Long id;
    private String nome;
    private Long numero;

    public DepartamentoResponseDto(Departamento departamento) {
        this.id = departamento.getId();
        this.nome = departamento.getNome();
        this.numero = departamento.getNumero();
    }
}


