package com.wst.dao;

import com.wst.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

public interface UserDao {
    @Select("select * from tb_users where name=#{name}")
    int nameExists(String name);//验证用户名是否存在
    @Select("select * from tb_users where name=#{name} and password=#{password}")
    Users getUser(@Param("name") String name,@Param("password") String password);//根据账号密码查询
    @Insert("insert into tb_users values(null,#{name},#{password},now(),null,null)")
    int add(Users user);//新增
    @Update("update tb_users set password=#{password} where id=#{id}")
    int updateUser(@Param("password") String password , @Param("id") Integer id);//修改

}
