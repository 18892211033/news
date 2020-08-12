package com.wst.dao;

import com.wst.bean0729.User;


public interface UserDao {
    User getById(Integer id);
    int add(User user);
}
