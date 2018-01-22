package com.kornievich.selectionCommition.exception;

public class ConnectionUnavailException extends Exception{
    public ConnectionUnavailException() {
    }

    public ConnectionUnavailException(String message) {
        super(message);
    }

    public ConnectionUnavailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionUnavailException(Throwable cause) {
        super(cause);
    }

    public ConnectionUnavailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
