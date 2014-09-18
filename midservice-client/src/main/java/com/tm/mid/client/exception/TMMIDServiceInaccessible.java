package com.tm.mid.client.exception;

/**
 * Created by BigP on 9/17/14.
 */
public class TMMIDServiceInaccessible extends RuntimeException {

    public TMMIDServiceInaccessible(Throwable cause, String message) {
        super(message, cause);
    }

    public TMMIDServiceInaccessible(String message) {
        super(message);
    }

    public TMMIDServiceInaccessible() {
    }
}
