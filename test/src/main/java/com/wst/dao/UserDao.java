package com.wst.dao;

import com.wst.entity.News;
import com.wst.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
/*    @Select("select * from tb_news where id=#{id}")      //测试数据库是否正常连接
    List<News> getByTypeid(Integer id);*/
    /**
     * 用户登录
     */
    Users checkUser(@Param("id") Integer id ,@Param("password") String password);

    /**
     * 根据id查询用户信息
     */
    Users getUser(@Param("id") Integer id);

    /**
     * 用户修改个人信息 -- 可能修改status，也可能修改password，也可能修改photoUrl
     */
    int updateUser(Users users);
    /**
     * 查询多个用户 -- 可能会提供用户名进行查询，也可能按照状态进行查询
     */
    List<Users> getUsers(@Param("name") String name , @Param("status") Integer status);
    /**
     * 新增用户
     */
    int addUser(Users users);
    /**
     * 查询该用户详细信息：包括个人信息以及该用户所发表的新闻评论相关信息
     */
    Users getUserAll(@Param("id") Integer id);
}
