package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.ProjetoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.ProjetoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Departamento;
import br.jeanheberth.cruduserspringboot.entities.Projeto;
import br.jeanheberth.cruduserspringboot.repository.DepartamentoRepository;
import br.jeanheberth.cruduserspringboot.repository.ProjetoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;


import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class ProjetoServiceTest {

    @SpyBean
    ProjetoService projetoService;

    @MockBean
    DepartamentoRepository departamentoRepository;

    @MockBean
    ProjetoRepository projetoRepository;


    @Test
    void deveSalvarProjeto(){
        Projeto projeto = Projeto.builder()
                .id(1L)
                .valorDoProjeto(8500D)
                .nome("Projeto X")
                .dataInicio(LocalDate.parse("2022-02-01"))
                .dataFinal(LocalDate.parse("2022-02-28"))
                .departamento(Departamento.builder().id(1L).build())
                .build();

        Mockito.when(projetoRepository.save(Mockito.any(Projeto.class))).thenReturn(projeto);
        ProjetoResponseDto projetoResponseDto = projetoService.saveProjeto(new ProjetoRequestDto());
        assertThat(projetoResponseDto.getId()).isEqualTo(1L);
        assertThat(projetoResponseDto.getNome()).isEqualTo("Projeto X");
        assertThat(projetoResponseDto.getIdDepartamento()).isPositive();
    }
}
