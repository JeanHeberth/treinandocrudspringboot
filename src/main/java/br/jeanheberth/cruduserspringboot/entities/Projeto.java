package br.jeanheberth.cruduserspringboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Builder
public class Projeto extends GenericDomain{

    private String nome;
    private Double valorDoProjeto;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;

    @ManyToOne()
    private Departamento departamento;
}
