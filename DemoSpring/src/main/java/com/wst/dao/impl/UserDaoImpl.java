package com.wst.dao.impl;

import com.wst.bean0729.User;
import com.wst.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){
        System.out.println("UserDaoImpl无参构造函数");
    }
    @Override
    public User getById(Integer id) {
        System.out.println("UserDaoImpl。getById");
        return null;
    }

    @Override
    public int add(User user) {
        System.out.println("UserDaoImpl。add");
        return 0;
    }
}
