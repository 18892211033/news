package com.wst.service;

import com.wst.entity.Users;

import java.util.Map;

public interface UserService {
    public  static  final String USER_KEY = "user";
    String USER_CODE = "code";
    int USER_CODE_EXIST = 0;
    int USER_CODE_NAME_NOEXEIST = 1;
    int USER_PASS_ERRO = 2;
    Map<String, Object> loginCheck(String name, String pass);
    int register(Users user);
    boolean nameCheck(String name);
    Users updateUser(Users users);
}
