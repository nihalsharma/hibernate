package com.tm.midservice.db.service;

import com.tm.midservice.db.dto.User;

import java.util.List;

/**
 * Created by Nihal on 9/10/14.
 */
public interface UserDao extends BaseDao{

    public List<User> getUserInRange(int start, int size);

}
