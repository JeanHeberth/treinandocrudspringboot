package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Projeto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProjetoRequestDto {

    private Long id;

    private String nome;


    public ProjetoRequestDto(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
    }
}