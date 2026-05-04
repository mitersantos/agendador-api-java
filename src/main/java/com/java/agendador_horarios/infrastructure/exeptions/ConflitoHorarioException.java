package com.java.agendador_horarios.infrastructure.exeptions;

public class ConflitoHorarioException extends RuntimeException {

    public ConflitoHorarioException(String msg) {
        super(msg);
    }
}
