package com.java.agendador_horarios.infrastructure.exeptions;

import  jakarta.servlet.http.HttpServletRequest;
import  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;
import com.java.agendador_horarios.infrastructure.exeptions.StandardError;
import com.java.agendador_horarios.infrastructure.exeptions.ConflitoHorarioException;

@ControllerAdvice

public class ResourceExceptionHandler {
    @ExceptionHandler(ConflitoHorarioException.class)
    public ResponseEntity<StandardError> conflitoHorario(ConflitoHorarioException e,
                                                         HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setError("Conflito de Agendamento");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);


    }
}
