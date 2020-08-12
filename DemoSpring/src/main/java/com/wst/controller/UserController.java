package com.wst.controller;

import com.wst.bean0729.User;
import com.wst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(){
        System.out.println("UserController无参构造函数");
    }
    public User get(Integer id){
        System.out.println("UserController。getById");
        userService.getById(id);
        return null;
    }
    public Boolean add(User user){
        System.out.println("UserController。add");
        userService.add(user);
        return null;
    }
}
