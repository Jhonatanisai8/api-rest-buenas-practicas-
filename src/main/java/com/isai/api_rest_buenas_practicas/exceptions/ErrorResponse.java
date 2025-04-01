package com.isai.api_rest_buenas_practicas.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String code;
    private HttpStatus httpStatus;
    private String message;
    private List<String> detailMessages;
    private LocalDateTime dateTime;
}
