package br.jeanheberth.cruduserspringboot.repository;

import br.jeanheberth.cruduserspringboot.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepositoy extends JpaRepository<Projeto, Long> {
}
