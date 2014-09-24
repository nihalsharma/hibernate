package com.tm.midservice.db.impl;

import com.tm.midservice.db.service.UserDao;
import com.tm.midservice.db.dto.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nihal on 9/10/14.
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public List<User> getUserInRange(final int start, final int size) {

        SessionOperationCallback<List<User>> execution = new SessionOperationCallback<List<User>>() {

            public List companyList;

            @Override
            public <T> void execute(Session session) {
                Query query = session.createQuery("from User c");
                query.setFirstResult(start);
                query.setMaxResults(size);
                companyList = query.list();
            }

            @Override
            public List<User> get() {
                return companyList;
            }
        };
        executeOperation(execution);
        return execution.get();
    }

}