package com.tm.midservice.db.impl;

import com.tm.midservice.db.core.HibernateUtil;
import com.tm.midservice.db.service.BaseDao;
import com.tm.midservice.exception.TMMarketPlaceDatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Projections;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nihal on 9/10/14.
 * 
 * This class contains the generic crud operation code for all the dtos
 */
public class BaseDaoImpl implements BaseDao {
    //TODO

    private static Logger LOGGER = Logger.getLogger(BaseDaoImpl.class);
    private Session session;
    private Transaction tx;

    
    @Override
    public <T> T get(final Class<T> c, final Serializable key) {
        SessionOperationCallback<T> execution = new SessionOperationCallback<T>() {
            public Object obj;

            @Override
            public <T> void execute(Session session) {
                obj = session.load(c, key);
                obj = HibernateUtil.unproxy(obj);
            }

            @Override
            public T get() {
                return (T) obj;
            }
        };
        execution.execute(session);
        return execution.get();
    }

    @Override
    public <T> List<T> getAll(final Class<T> c) {

        SessionOperationCallback<List<T>> execution = new SessionOperationCallback<List<T>>() {
            public List objects;

            @Override
            public void execute(Session session) {
                Query query = session.createQuery("from " + c.getName());
                objects = query.list();
            }

            @Override
            public List<T> get() {
                return (List<T>) objects;
            }
        };
        execution.execute(session);
        return execution.get();
    }

    @Override
    public <T> void save(final Object entity) {
        SessionOperationCallback<T> execution = new SessionOperationCallback<T>() {
            public List objects;

            @Override
            public void execute(Session session) {
                session.save(entity);
            }

            @Override
            public T get() {
                return null;
            }
        };
        execution.execute(session);
    }

    @Override
    public <T> void delete(final Object entity) {

        SessionOperationCallback<T> execution = new SessionOperationCallback<T>() {
            public List objects;

            @Override
            public void execute(Session session) {
                session.delete(entity);
            }

            @Override
            public T get() {
                return null;
            }
        };
        execution.execute(session);
    }

    @Override
    public <T> void deleteAll(final Collection entities) {
        SessionOperationCallback<T> execution = new SessionOperationCallback<T>() {
            public List objects;

            @Override
            public void execute(Session session) {
                for (Object entity : entities) {
                    session.delete(entity);
                }
            }

            @Override
            public T get() {
                return null;
            }
        };
        execution.execute(session);
    }

    @Override
    public <T> void saveAll(final Collection entities) {
        SessionOperationCallback<T> execution = new SessionOperationCallback<T>() {
            public List objects;

            @Override
            public void execute(Session session) {
                for (Object entity : entities) {
                    session.save(entity);
                }
            }

            @Override
            public T get() {
                return null;
            }
        };
        execution.execute(session);
    }

    @Override
    public int getTotalCount(final Class aClass) {
        SessionOperationCallback<Integer> execution = new SessionOperationCallback<Integer>() {
            public int count;

            @Override
            public void execute(Session session) {
                count = (Integer) session.createCriteria(aClass.getName()).setProjection(Projections.rowCount()).uniqueResult();
            }

            @Override
            public Integer get() {
                return count;
            }
        };
        execution.execute(session);
        return execution.get();
    }


    @Override
    public <T> void update(final Object entity) {

        SessionOperationCallback<T> execution = new SessionOperationCallback<T>() {
            public List objects;

            @Override
            public void execute(Session session) {
                session.merge(entity);
            }

            @Override
            public T get() {
                return null;
            }
        };
        execution.execute(session);

    }

    /**
     * Call Back Implemented to get a session and then close it after the operation is completed
     */
    protected <T> void executeOperation(SessionOperationCallback<T> sqlCommand) throws HibernateException {
        if (HibernateUtil.getSessionFactory().getCurrentSession() != null && HibernateUtil.getSessionFactory().getCurrentSession().isOpen()) {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            sqlCommand.execute(session);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } catch (Exception e) {
            throw new TMMarketPlaceDatabaseException(e.getMessage(), e);
        } finally {
            if (session != null) {
                HibernateUtil.close(session);
            }
        }
    }

    protected void handleException(HibernateException e) throws TMMarketPlaceDatabaseException {
        HibernateUtil.rollback(tx);
        throw new TMMarketPlaceDatabaseException(e);
    }
}
