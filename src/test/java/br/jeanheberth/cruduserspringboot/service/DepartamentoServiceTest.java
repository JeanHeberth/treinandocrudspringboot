package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.DepartamentoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.DepartamentoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Departamento;
import br.jeanheberth.cruduserspringboot.repository.DepartamentoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class DepartamentoServiceTest {

    @SpyBean
    DepartamentoService departamentoService;

    @MockBean
    DepartamentoRepository departamentoRepository;

    @Test
    public void deveSalvarUmDepartamento(){
        Departamento departamento = Departamento.builder()
                .nome("Teste1")
                .numero(10L)
                .build();
        Mockito
                .when(departamentoRepository.save(Mockito.any(Departamento.class)))
                .thenReturn(departamento);

        //Ação
        DepartamentoResponseDto departamentoSalvo = departamentoService.saveDepartamento(new DepartamentoRequestDto());

        //Verificação
        assertThat(departamentoSalvo).isNotNull();
        assertThat(departamentoSalvo.getNome()).isEqualTo("Teste1");
    }

}
