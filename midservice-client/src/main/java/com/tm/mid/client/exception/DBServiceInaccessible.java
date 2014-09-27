package com.tm.mid.client.exception;

/**
 * Created by BigP on 9/17/14.
 */
public class DBServiceInaccessible extends Exception {

    public DBServiceInaccessible(String message, Throwable cause) {
        super(message, cause);
    }

    public DBServiceInaccessible(String message) {
        super(message);
    }

}
