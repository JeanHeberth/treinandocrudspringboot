package br.jeanheberth.cruduserspringboot.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.io.Serializable;
@SuppressWarnings("serial")
@MappedSuperclass
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
