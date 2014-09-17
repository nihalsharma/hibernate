package com.tm.midservice.db.impl;

import com.tm.midservice.db.service.UserDao;
import com.tm.midservice.db.dto.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Nihal on 9/10/14.
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public List<User> getUserInRange(int start, int size) {
        Query query = startOperation().createQuery("from User c");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List companyList = query.list();
        return companyList;
    }

}