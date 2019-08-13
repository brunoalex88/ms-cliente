package com.obruno.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ClienteNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Cliente %s não foi encontrado";

    public ClienteNotFoundException(Long id) {
        super(String.format(DEFAULT_MESSAGE, id));
    }

}
