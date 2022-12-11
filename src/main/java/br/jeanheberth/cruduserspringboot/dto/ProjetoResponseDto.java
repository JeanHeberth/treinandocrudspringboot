package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Projeto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProjetoResponseDto {

    private Long id;

    private String nome;


    public ProjetoResponseDto(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
    }
}