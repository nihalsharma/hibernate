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

    public void save(Object entity);

    public void delete(Object entity);

    public void deleteAll(Collection entities);

    public void saveAll(Collection entities);

    public int getTotalCount(Class aClass);

    public void update(Object entity);
}
