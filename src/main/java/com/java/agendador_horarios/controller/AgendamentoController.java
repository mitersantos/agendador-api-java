package com.java.agendador_horarios.controller;

import com.java.agendador_horarios.infrastructure.entity.Agendamento;
import com.java.agendador_horarios.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor

public class AgendamentoController {


    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento) {

        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));

    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente,
                                                   @RequestParam LocalDateTime dataHoraAgendamento) {

        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public List<Agendamento> buscarPorDia(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        // O Controller agora recebe a Lista do Service e envia para o Postman
        return agendamentoService.buscarAgendamentoDia(data);
    }


    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamento(
            @RequestBody Agendamento agendamento,
            @RequestParam String cliente,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraAgendamento) {

        Agendamento atualizado = agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento);
        return ResponseEntity.accepted().body(atualizado);

    }
}

