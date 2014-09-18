package com.tm.midservice.exception;

/**
 * Created by Nihal on 9/10/14.
 */
public class TMMIDException extends RuntimeException {

    public TMMIDException() {
        super("Could not connect to database.");
    }

    public TMMIDException(String message) {
        super(message);
    }

    public TMMIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public TMMIDException(Throwable cause) {
        super(cause);
    }
}
