package com.tm.midservice.db.core;

import com.tm.midservice.exception.TMMarketPlaceDatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by Nihal on 9/11/14.
 */
public class HibernateUtil {

    private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);

    private static final SessionFactory sessionFactory;

    static {
        try {
            // creating the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory initial creation error." + ex);
            throw new TMMarketPlaceDatabaseException(ex.getMessage());
        }
    }

    public static void closeFactory() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException ignored) {
                LOGGER.error("Couldn't close SessionFactory", ignored);
            }
        }
    }

    public static void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException ignored) {
            LOGGER.error("Couldn't rollback Transaction", ignored);
        }
    }

    public static void close(Session session) {
        if (session != null) {
            try {
                if (session.isOpen())
                    session.close();
            } catch (HibernateException ignored) {
                LOGGER.error("Couldn't close Session", ignored);
            }
        }
    }

    public static Object unproxy(Object proxied)
    {
        Object entity = proxied;
        if (entity != null && entity instanceof HibernateProxy) {
            Hibernate.initialize(entity);
            entity = ((HibernateProxy) entity)
                    .getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
