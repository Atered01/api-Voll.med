package med.vol.api.domain.consulta.validacoes.agendamento;

import jakarta.validation.ValidationException;
import med.vol.api.domain.consulta.DadosAgendamentoConsulta;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas {
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null){
            return;
        }
        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidationException("Consulta não pode ser agendada com médico");
        }
    }
}
