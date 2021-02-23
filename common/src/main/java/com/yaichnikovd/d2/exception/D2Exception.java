package com.yaichnikovd.d2.exception;

public class D2Exception extends RuntimeException {

    public D2Exception(final String message) {
        super(message);
    }

    public D2Exception(final String message, final Throwable cause) {
        super(message, cause);
    }
}
