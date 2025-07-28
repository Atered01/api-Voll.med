package med.vol.api.domain.consulta.validacoes.agendamento;

import jakarta.validation.ValidationException;
import med.vol.api.domain.consulta.DadosAgendamentoConsulta;
import med.vol.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas{
   @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idPaciente() == null){
            return;
        }
        var pacienteEstaAtivo =  pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidationException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
