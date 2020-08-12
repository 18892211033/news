package com.wst.service.impl;

import com.wst.bean0729.User;
import com.wst.dao.UserDao;
import com.wst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
//    @Qualifier("userDaoImplJdbc")
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    public UserServiceImpl(){
        System.out.println("UserServiceImpl无参构造函数");
    }
    @Override
    public User getById(Integer id) {
        System.out.println("UserServiceImpl.getById");
        userDao.getById(id);
        return null;
    }

    @Override
    public boolean add(User user) {
        System.out.println("UserServiceImpl.add");
        userDao.add(user);
        return false;
    }
}
