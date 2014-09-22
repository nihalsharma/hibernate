package com.tm.midservice.exception;

/**
 * For TM, Created by Nihal on 9/22/14.
 */
public class TMMarketPlaceServiceException extends Exception {

    public TMMarketPlaceServiceException() {
        super("Could not connect to database.");
    }

    public TMMarketPlaceServiceException(String message) {
        super(message);
    }

    public TMMarketPlaceServiceException(Throwable cause, String message) {
        super(message, cause);
    }

    public TMMarketPlaceServiceException(Throwable cause) {
        super(cause);
    }
}
