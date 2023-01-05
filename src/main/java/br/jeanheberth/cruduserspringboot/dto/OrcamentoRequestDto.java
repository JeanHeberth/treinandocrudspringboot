package br.jeanheberth.cruduserspringboot.dto;

import br.jeanheberth.cruduserspringboot.entities.Orcamento;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrcamentoRequestDto {

    private Long id;
    private Double valor;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    private Long idDepartamento;


    public OrcamentoRequestDto(Orcamento orcamento){
        this.id = orcamento.getId();
        this.valor = orcamento.getValor();
        this.dataInicio = orcamento.getDataInicio();
        this.dataFinal = orcamento.getDataFinal();
        this.idDepartamento = orcamento.getDepartamento().getId();
    }
}
