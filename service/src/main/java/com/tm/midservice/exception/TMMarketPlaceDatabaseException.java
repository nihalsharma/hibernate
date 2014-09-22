package com.tm.midservice.exception;

/**
 * Created by Nihal on 9/10/14.
 */
public class TMMarketPlaceDatabaseException extends RuntimeException {

    public TMMarketPlaceDatabaseException() {
        super("Could not connect to database.");
    }

    public TMMarketPlaceDatabaseException(String message) {
        super(message);
    }

    public TMMarketPlaceDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TMMarketPlaceDatabaseException(Throwable cause) {
        super(cause);
    }
}
