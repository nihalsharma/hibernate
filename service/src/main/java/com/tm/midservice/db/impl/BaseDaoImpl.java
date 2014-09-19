package com.tm.midservice.db.impl;

import com.tm.midservice.db.core.HibernateUtil;
import com.tm.midservice.db.service.BaseDao;
import com.tm.midservice.exception.TMMIDException;
import com.tm.midservice.utilities.TMUtils;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Projections;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nihal on 9/10/14.
 */
public class BaseDaoImpl implements BaseDao {
    //TODO

    private static Logger LOGGER = Logger.getLogger(BaseDaoImpl.class);
    private Session session;
    private Transaction tx;

    @Override
    public <T> T get(Class<T> c, Serializable key) {
        T obj = null;
        try {
            startOperation();
            obj = (T) session.load(c, key);
            obj = (T) HibernateUtil.unproxy(obj);
            tx.commit();
        } catch (HibernateException e) {
            LOGGER.error("Exception occured while fetching all objects of class " + c.getName());
        } finally {
            HibernateUtil.close(session);
        }
        return obj;
    }

    @Override
    public <T> List<T> getAll(Class<T> c) {
        List<T> objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + c.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            LOGGER.error("Exception occured while fetching all objects of class " + c.getName());
        } finally {
           HibernateUtil.close(session);
        }
        return objects;
    }

    /*@Override
    public void update(Object entity) {
        startOperation();
    }*/

    @Override
    public void save(Object entity) {
        try {
            startOperation();
            session.save(entity);
            tx.commit();
            LOGGER.debug("save successful");
        } catch (RuntimeException re) {
            HibernateUtil.rollback(tx);
            throw new TMMIDException(TMUtils.createErrorMessage(re));
        } finally {
            HibernateUtil.close(session);
        }
    }

    @Override
    public void delete(Object entity) {
        try {
            startOperation();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close(session);
        }
    }

    @Override
    public void deleteAll(Collection entities) {
        try {
            startOperation();
            for (Object entity : entities) {
                session.delete(entity);
            }
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close(session);
        }
    }

    @Override
    public void saveAll(Collection entities) {
        try {
            startOperation();
            for (Object entity : entities) {
                session.save(entity);
            }
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close(session);
        }
    }

    @Override
    public int getTotalCount(Class aClass) {
        return (Integer) startOperation().createCriteria(aClass.getName()).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public void update(Object entity) {
        try {
            startOperation();
            session.merge(entity);
            tx.commit();
            LOGGER.debug("save successful");

        } catch (RuntimeException re) {
            HibernateUtil.rollback(tx);
            throw new TMMIDException(TMUtils.createErrorMessage(re));
        } finally {
            HibernateUtil.close(session);
        }
    }

    protected Session startOperation() throws HibernateException {
        if(HibernateUtil.getSessionFactory().getCurrentSession() != null && HibernateUtil.getSessionFactory().getCurrentSession().isOpen()) {
            //session = HibernateUtil.getSessionFactory().getCurrentSession();
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        return session;
    }

    protected void handleException(HibernateException e) throws TMMIDException {
        HibernateUtil.rollback(tx);
        throw new TMMIDException(e);
    }
}
