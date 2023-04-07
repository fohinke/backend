package com.api.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExistEmailException.class)

    public ResponseEntity< ErrorDetails > userNotFoundException(ExistEmailException ex) {
        ErrorDetails errorModel = new ErrorDetails(0, ex.getMessage());
        return new ResponseEntity < ErrorDetails > (errorModel, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)

    public ResponseEntity < ? > globleExcpetionHandler(Exception ex) {
        ErrorDetails errorModel = new ErrorDetails(0, ex.getMessage());
        return new ResponseEntity < > (errorModel, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
