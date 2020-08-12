package com.wst.service.impl;

import com.wst.entity.Users;
import com.wst.service.UserService;
import junit.framework.TestCase;

public class UserServiceImplTest extends TestCase {

    public void testRegister() {
        UserService userService = new UserServiceImpl();
        Users u = new Users(null,"张6666","123123",null,null,null);
        System.out.println(userService.register(u));
//        userService.loginCheck("张6666","123123");
//        userService.nameCheck("张三");
    }

}