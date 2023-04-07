package com.api.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExistEmailException extends RuntimeException{

    private boolean enabled = false;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ExistEmailException(boolean status, String message) {
        this.enabled= false;
        this.message = message;
    }

    public ExistEmailException(String message) {
        this.enabled = false;
        this.message = message;
    }
}
