package com.isoft.demo.service.impl;

import com.isoft.demo.dao.UserDao;
import com.isoft.demo.entity.Users;
import com.isoft.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Users getById(Integer id) {
        if (null == id || id < 1){
            return null;
        }
        return userDao.getById(id);
    }
}
