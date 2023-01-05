package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Projeto;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProjetoResponseDto {

    private Long id;

    private String nome;

    private Double valorDoProjeto;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    private Long idDepartamento;


    public ProjetoResponseDto(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.valorDoProjeto = projeto.getValorDoProjeto();
        this.dataInicio = projeto.getDataInicio();
        this.dataFinal = projeto.getDataFinal();
        this.idDepartamento = projeto.getDepartamento().getId();
    }
}