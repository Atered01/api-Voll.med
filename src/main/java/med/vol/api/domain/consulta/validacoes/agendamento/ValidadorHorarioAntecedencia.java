package med.vol.api.domain.consulta.validacoes.agendamento;

import jakarta.validation.ValidationException;
import med.vol.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsultas {
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferençaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferençaEmMinutos < 30){
            throw new ValidationException("Consulta deve ser agendada com antecedência minima de 30 minutos");
        }
    }
}
