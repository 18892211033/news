package com.isoft.dao;

import com.isoft.entity.User2;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User2Dao {
    User2 getById(@Param("id") Integer id) ;
    int add(User2 u) ;

    @Select("select * from tb_user where name=#{name} and password=#{pass}")
    @Results({
            @Result(id = true , column = "id" , property = "uid") ,
            @Result(column = "name" , property = "uname") ,
            @Result(column = "password" , property = "upass") ,
            @Result(column = "mobile" , property = "mobile") ,
            @Result(column = "regDatetime" , property = "regDt") ,

    })
    User2 getUser(@Param("name") String name , @Param("pass") String pass) ;

    @Select("select * from tb_user")
    @ResultMap("com.isoft.mapper.resultmapper.UserMap")
    List<User2> getAll() ;
}
