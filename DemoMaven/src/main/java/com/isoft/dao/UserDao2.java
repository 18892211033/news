package com.isoft.dao;

import com.isoft.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao2 {

    User nameExists(@Param("name") String name);//验证用户名是否存在

    User getUser(@Param("name") String name,@Param("password") String password);//根据账号密码查询

    int add(User user);//新增

    int updatePassword(@Param("id") Integer id , @Param("password") String password);//byid修改密码

    List<User> getAll();
}
