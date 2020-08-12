package com.isoft.dao;

import com.isoft.bean.User;

import java.sql.SQLException;

public interface UserDao {
    int nameExists(String name) throws SQLException;//验证用户名是否存在
    User getUser(String name, String pass) throws SQLException;//根据账号密码查询
    int add(User user) throws SQLException;//新增
    int updateUser(User user) throws SQLException;//修改
}
