package med.vol.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.domain.endereco.DadosEndereco;

//NotBlank é apenas para String
public record DadosCadastroMedico(@NotBlank(message = "Nome é obrigatório") String nome,
                                  @NotBlank(message = "Email é obrigatório") @Email(message = "Formato do email invalido") String email,
                                  @NotBlank(message = "Telefone é obrigatório")String telefone,
                                  //São digitos de 4 a 6 caracteres
                                  @NotBlank(message = "CRM é obrigatório") @Pattern(regexp = "\\d{4,6}") String crm,
                                  @NotNull(message = "Especialidade é obrigatório") Especialidade especialidade,
                                  @NotNull(message = "Endereço é obrigatório") @Valid DadosEndereco endereco) {
}
