package br.jeanheberth.cruduserspringboot.entities;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Orcamento extends GenericDomain {

    private Double valor;
    private Date dataInicio;
    private Date dataFinal;
}
