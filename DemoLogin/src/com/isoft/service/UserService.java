package com.isoft.service;

import com.isoft.bean.User;

import java.sql.SQLException;
import java.util.Map;

public interface UserService {
    public  static  final String USER_KEY = "user";
    String USER_CODE = "code";
    int USER_CODE_EXIST = 0;
    int USER_CODE_NAME_NOEXEIST = 1;
    int USER_PASS_ERRO = 2;

    Map<String , Object> loginCheck(String name, String pass);
    User register(User user);
    boolean nameCheck(String name);

    /*boolean updatePass(int id , String pass) throws SQLException ;
    boolean updateMobile(int id , String mobile) throws SQLException ;*/
    boolean updateUser(String pass, String mobile,int id) throws SQLException;

    Boolean namecheck(String name) throws SQLException;
}
