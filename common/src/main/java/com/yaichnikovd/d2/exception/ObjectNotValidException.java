package com.yaichnikovd.d2.exception;

public class ObjectNotValidException extends D2Exception {

    public ObjectNotValidException(final String message) {
        super(message);
    }

    public ObjectNotValidException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
