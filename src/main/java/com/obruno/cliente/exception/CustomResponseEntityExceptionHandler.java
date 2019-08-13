package com.obruno.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetailsResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetailsResponse errorDetailsResponse = new ErrorDetailsResponse(new Date(), ex.getMessage(),
                request.getDescription(true));
        return new ResponseEntity<>(errorDetailsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public final ResponseEntity<ErrorDetailsResponse> handleClienteNotFoundException(ClienteNotFoundException ex, WebRequest request) {
        ErrorDetailsResponse errorDetailsResponse = new ErrorDetailsResponse(new Date(), ex.getLocalizedMessage(),
                request.getDescription(true));
        return new ResponseEntity<>(errorDetailsResponse, HttpStatus.NOT_FOUND);
    }

}
