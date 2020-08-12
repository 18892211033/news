package com.isoft.dao;

import com.isoft.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

public interface UserDao {
    @Select("select * from tb_user where name=#{name}")
    User nameExists(@Param("name") String name);//验证用户名是否存在
    @Select("select * from tb_user where name=#{name} and password=#{password}")
    User getUser(@Param("name") String name,@Param("password") String password);//根据账号密码查询
    @Insert("insert into tb_user values(null,#{name},#{password},#{mobile},now())")
    int add(User user);//新增
    @Update("update tb_user set password=#{password} where id=#{id}")
    int updatePassword(@Param("id") Integer id , @Param("password") String password);//byid修改密码
}
