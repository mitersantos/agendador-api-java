package com.java.agendador_horarios.infrastructure.repository;

import com.java.agendador_horarios.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);


    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    List<Agendamento> findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicial, LocalDateTime datahoraFinal);
    List<Agendamento> findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    boolean existsByDataHoraAgendamento(LocalDateTime dataHoraAgendamento);
}