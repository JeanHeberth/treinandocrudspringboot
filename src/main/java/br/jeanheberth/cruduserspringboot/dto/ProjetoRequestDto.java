package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Projeto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProjetoRequestDto {

    private Long id;

    private String nome;
    private Double valorDoProjeto;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;

    private Long idDepartamento;



    public ProjetoRequestDto(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.valorDoProjeto = projeto.getValorDoProjeto();
        this.dataInicio = projeto.getDataInicio();
        this.dataFinal = projeto.getDataFinal();
        this.idDepartamento = projeto.getDepartamento().getId();

    }
}