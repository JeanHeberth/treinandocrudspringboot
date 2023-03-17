package br.jeanheberth.cruduserspringboot.service;

import br.jeanheberth.cruduserspringboot.dto.OrcamentoRequestDto;
import br.jeanheberth.cruduserspringboot.dto.OrcamentoResponseDto;
import br.jeanheberth.cruduserspringboot.entities.Departamento;
import br.jeanheberth.cruduserspringboot.entities.Orcamento;
import br.jeanheberth.cruduserspringboot.repository.DepartamentoRepository;
import br.jeanheberth.cruduserspringboot.repository.OrcamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class OrcamentoServiceTest {

    @SpyBean
    OrcamentoService orcamentoService;

    @MockBean
    DepartamentoRepository departamentoRepository;

    @MockBean
    OrcamentoRepository orcamentoRepository;

    @Test
    void deveSalvarOrcamento() {
        Orcamento orcamento = Orcamento.builder()
                .id(1L)
                .valor(1500D)
                .dataInicio(LocalDate.parse("2022-05-05"))
                .dataFinal(LocalDate.parse("2022-05-30"))
                .departamento(Departamento.builder()
                        .id(1L)
                        .build())
                .build();

        Mockito.when(orcamentoRepository.save(Mockito.any(Orcamento.class))).thenReturn(orcamento);

        OrcamentoResponseDto orcamentoResponseDto = orcamentoService.saveOrcamento(new OrcamentoRequestDto());

        assertThat(orcamentoResponseDto).isNotNull();


    }
}
