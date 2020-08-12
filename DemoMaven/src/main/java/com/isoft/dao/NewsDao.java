package com.isoft.dao;

import com.isoft.entity.News;
import com.isoft.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NewsDao {
    @Select("select * from tb_news where typeid=#{typeid}")
    List<News> allNewsByTypeid(@Param("typeid") Integer typeid);//查询某个类别所有新闻

    @Insert("insert into tb_news values(null,#{typeid},#{title},#{content},now(),#{comefrom})")
    int add(News news);//添加一条新闻

    @Update("update tb_news set content=#{content} where id=#{id}")
    int updateNews(@Param("id") Integer id , @Param("content") String content);//修改新闻内容

    @Delete("delete from tb_news where id=#{id}")
    int delNews(@Param("id") Integer id);//根据id删除一条新闻

    /*mybatis注解模糊查询的两种方式
    一种拼接字符串
            @Select("select * from xxx where  name like #{name} ")
            List<xxx> findByName(String name)
            测试的时候,传入的参数要拼接为
            userDao.findByName("%name%")

            第二中是占位符,  ${value} ,$符号,属性必须是value,取参数的值
            @Select("select * from xxx where  name like   '%${value}%'  ")
            List<xxx> findByName(String name)
            测试的时候,直接传入参数
            userDao.findByName(name)
     */
    @Select("select * from tb_news where(title Like '%${title}%' )")
    List<News> likeTitle(@Param("title")String title);

}
