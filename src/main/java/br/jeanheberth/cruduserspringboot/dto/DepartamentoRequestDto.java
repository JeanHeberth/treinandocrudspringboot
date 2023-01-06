package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Departamento;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class DepartamentoRequestDto {

    private Long id;
    private String nome;
    private Long numero;

    public DepartamentoRequestDto(Departamento departamento) {
        this.id = departamento.getId();
        this.nome = departamento.getNome();
        this.numero = departamento.getNumero();
    }
}
