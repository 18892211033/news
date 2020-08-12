package com.wst.dao.impl;

import com.wst.bean0729.User;
import com.wst.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplJdbc implements UserDao {
    @Override
    public User getById(Integer id) {
        System.out.println("UserDaoImplJdbc.getById()");
        return null;
    }

    @Override
    public int add(User user) {
        System.out.println("UserDaoImplJdbc.add()");
        return 0;
    }
}
