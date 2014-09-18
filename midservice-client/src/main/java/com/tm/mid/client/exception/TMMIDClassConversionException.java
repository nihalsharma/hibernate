package com.tm.mid.client.exception;

/**
 * Created by Nihal on 9/17/14.
 */
public class TMMIDClassConversionException extends RuntimeException {

    public TMMIDClassConversionException(Throwable cause, String message) {
        super(message, cause);
    }

    public TMMIDClassConversionException() {
    }

    public TMMIDClassConversionException(String message) {
        super(message);
    }
}
