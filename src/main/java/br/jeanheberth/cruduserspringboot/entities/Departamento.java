package br.jeanheberth.cruduserspringboot.entities;

import jakarta.persistence.*;
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
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
