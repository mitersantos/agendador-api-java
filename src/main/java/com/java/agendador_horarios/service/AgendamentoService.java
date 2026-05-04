package com.java.agendador_horarios.service;

import com.java.agendador_horarios.infrastructure.entity.Agendamento;
import com.java.agendador_horarios.infrastructure.exeptions.ConflitoHorarioException;
import com.java.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento) {
       boolean horarioOcupado = agendamentoRepository.existsByDataHoraAgendamento(agendamento.getDataHoraAgendamento());


        if (horarioOcupado) {
            throw new ConflitoHorarioException("Horário já está preenchido");
        }
        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }

    public List<Agendamento> buscarAgendamentoDia(LocalDate data) {
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinalDia = data.atTime(23, 59, 59);

        return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDia, horaFinalDia);
    }

    public Agendamento alterarAgendamento(Agendamento agendamentoEntrada, String cliente, LocalDateTime dataHoraAgendamento) {
        // Buscamos como lista para evitar o erro de tamanho
        List<Agendamento> agendaBancoLista = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

        if (agendaBancoLista.isEmpty()) {
            throw new RuntimeException("Agendamento não encontrado para este cliente nesta data");
        }

        // Pegamos o primeiro da lista para poder editar (já que você quer alterar UM registro)
        Agendamento agendaBanco = agendaBancoLista.get(0);

        agendamentoEntrada.setId(agendaBanco.getId());
        return agendamentoRepository.save(agendamentoEntrada);
    }
} // Esta chave fecha a CLASSE e deve ser a última do arquivo
