package br.jeanheberth.cruduserspringboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Builder
public class Departamento extends GenericDomain {

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false)
    private Long numero;

    @OneToMany(mappedBy = "departamento")
    private List<Projeto> projetos;

    public void adicionarProjeto(Projeto projeto){
        getProjetos().add(projeto);
        projeto.setDepartamento(this);
    }

    public List<Projeto>getProjetos(){
        if (projetos == null){
            projetos = new ArrayList<>();
        }
        return projetos;
    }
}
