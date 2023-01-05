package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Orcamento;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrcamentoResponseDto {

    private Long id;
    private Double valor;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Long idDepartamento;


    public OrcamentoResponseDto(Orcamento orcamento) {
        this.id = orcamento.getId();
        this.valor = orcamento.getValor();
        this.dataInicio = orcamento.getDataInicio();
        this.dataFinal = orcamento.getDataFinal();
        this.idDepartamento = orcamento.getDepartamento().getId();
    }
}
