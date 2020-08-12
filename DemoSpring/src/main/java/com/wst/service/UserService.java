package com.wst.service;

import com.wst.bean0729.User;
import com.wst.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    User getById(Integer id);
    boolean add(User user);
}
