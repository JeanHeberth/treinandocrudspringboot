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
public class Projeto extends GenericDomain{

    private String nome;
   /* private Double valorDoProjeto;
    private Date dataInicio;
    private Date dataFinal;*/
}
