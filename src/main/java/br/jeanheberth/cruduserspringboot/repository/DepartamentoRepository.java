package br.jeanheberth.cruduserspringboot.repository;

import br.jeanheberth.cruduserspringboot.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
