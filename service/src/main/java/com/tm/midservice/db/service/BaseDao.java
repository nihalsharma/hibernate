package com.tm.midservice.db.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nihal on 9/10/14.
 */
public interface BaseDao {

    public <T> T get(Class<T> c, Serializable key);

    public <T> List<T> getAll(Class<T> c);

    //public void update(Object entity);

    public <T> void save(Object entity);

    public <T> void delete(Object entity);

    public <T> void deleteAll(Collection entities);

    public <T> void saveAll(Collection entities);

    public <T> int getTotalCount(Class aClass);

    public <T> void update(Object entity);
}
