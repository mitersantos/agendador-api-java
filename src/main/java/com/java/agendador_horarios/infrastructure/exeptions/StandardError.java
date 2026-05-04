package com.java.agendador_horarios.infrastructure.exeptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StandardError {
    private  Instant timestamp;
    private Integer status;
    private  String error;
    private  String message;
    private  String path;
}
