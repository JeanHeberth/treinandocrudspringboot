package br.jeanheberth.cruduserspringboot.repository;

import br.jeanheberth.cruduserspringboot.entities.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
}
