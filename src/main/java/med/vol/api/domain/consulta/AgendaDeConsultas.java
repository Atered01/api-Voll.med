package med.vol.api.domain.consulta;

import jakarta.validation.ValidationException;
import med.vol.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsultas;
import med.vol.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.vol.api.domain.medico.Medico;
import med.vol.api.repository.ConsultaRepository;
import med.vol.api.repository.MedicoRepository;
import med.vol.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired //O spring porcura as classes que implementa as interfaces
    private List<ValidadorAgendamentoDeConsultas> validadores;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validaoresCancelamento;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        if (!medicoRepository.existsById(dados.idMedico())) {
            throw new ValidationException("Id do medico informado não existe");
        }
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidationException("Id do paciente informado não existe");
        }

        validadores.forEach(v -> v.validar(dados));
        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        if(medico == null) {
            throw new ValidationException("Não existe nenhum medico disponivel nesta data");
        }
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.idPaciente() == null) {
            throw new ValidationException("Especialidade é obrigatoria quando o médico não for escolhido!");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelarConsulta(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidationException("Id da consulta não existe");
        }

        validaoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}