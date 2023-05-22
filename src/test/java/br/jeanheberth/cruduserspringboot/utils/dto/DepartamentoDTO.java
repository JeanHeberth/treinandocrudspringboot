package br.jeanheberth.cruduserspringboot.utils.dto;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
public class DepartamentoDTO {
    private Long id;
    private String nome;
    private Long numero;



}
