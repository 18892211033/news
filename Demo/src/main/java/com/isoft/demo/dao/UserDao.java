package com.isoft.demo.dao;

import com.isoft.demo.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from tb_users where id=#{id}")
    Users getById(Integer id);
}
