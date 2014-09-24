package com.tm.midservice.db.impl;

import org.hibernate.Session;

import java.util.List;

/**
 * For TM, Created by Nihal on 9/24/14.
 */
public interface SessionOperationCallback<T> {

    public <T> void execute(Session session);

    public T get();
}
