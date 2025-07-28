package med.vol.api.domain.consulta.validacoes.agendamento;

import med.vol.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsultas {
    void validar(DadosAgendamentoConsulta medico);
}
