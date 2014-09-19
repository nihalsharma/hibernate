package com.tm.midservice.web;

import com.tm.midservice.db.core.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Nihal on 9/10/14.
 */
public class AppContextListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext ctx = servletContextEvent.getServletContext();
        LOGGER.debug("***************************Creating Database Connection*********************");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        ctx.setAttribute("sessionFactory", sessionFactory);

        LOGGER.info("*****************DB Connection initialized successfully**********************");
        System.out.println("*****************DB Connection initialized successfully**********************");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("*****************Application Context Destroyed**********************");
    }
}
