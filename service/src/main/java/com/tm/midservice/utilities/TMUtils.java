package com.tm.midservice.utilities;

/**
 * Created by Nihal on 9/11/14.
 */
public class TMUtils {

    public static final String createErrorMessage(Exception e)
    {
        return "error class: " + e.getClass().getName() + " " + e.getMessage();
    }
}
