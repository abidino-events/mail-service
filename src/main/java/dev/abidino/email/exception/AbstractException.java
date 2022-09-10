package dev.abidino.email.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException {
    AbstractException(String message) {
        super(message);
    }

    abstract HttpStatus getHttpStatus();
}
