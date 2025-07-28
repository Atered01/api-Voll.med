package med.vol.api.controller;

import med.vol.api.domain.endereco.DadosEndereco;
import med.vol.api.domain.endereco.Endereco;
import med.vol.api.domain.medico.DadosCadastroMedico;
import med.vol.api.domain.medico.DadosDetalhamentoMedico;
import med.vol.api.domain.medico.Especialidade;
import med.vol.api.repository.MedicoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroMedico> dadosCadastroMedico;

    @Autowired
    private JacksonTester<DadosDetalhamentoMedico> dadosDetalhamentoMedico;

    @MockitoBean
    private MedicoRepository repository;

    @Test
    @DisplayName("Verifica se o código HTTP 400 é retornado quando as informações fornecidas são inválidas.")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(
                        post("/medicos/cadastroMedico"))
                .andReturn()
                .getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Garante que o código HTTP 201 seja retornado quando as informações fornecidas são válidas e que os dados do médico são cadastrados corretamente.")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var especialidade = Especialidade.DERMATOLOGIA;
        var endereco = new Endereco(new DadosEndereco("Rua 1", "Santa Luzia", "00000000", "São Paulo", "SP", "nada", 50));
        var endereco2 = new DadosEndereco("Rua 1", "Santa Luzia", "00000000", "São Paulo", "SP", "nada", 50);
        var dadosDetalhamento = new DadosDetalhamentoMedico(null, "Roberto", "roberto@voll.med", "123456", "00000000000", especialidade, endereco);

        var response = mvc.perform(
                        post("/medicos/cadastroMedico")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosCadastroMedico.write(
                                        new DadosCadastroMedico("Roberto", "roberto@voll.med", "00000000000", "123456", especialidade, endereco2)
                                ).getJson()))
                .andReturn()
                .getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        var jsonEsperado = dadosDetalhamentoMedico.write(dadosDetalhamento).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

}