package com.isoft.dao;

import com.isoft.entity.News;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsDao0720 {
    List<News> getNews(@Param("typeid") Integer typeid,@Param("titleKey") String titleKey, @Param("dateStr") String dateStr);
    int updateById(News news);
    int deleteByIds(List<Integer> ids);

    List<News> getNews2(@Param("typeid") Integer typeid,@Param("titleKey") String titleKey, @Param("dateStr") String dateStr);
    int updateById2(News news);
    List<News> getNewsByOne(@Param("typeid") Integer typeid,@Param("titleKey") String titleKey, @Param("dateStr") String dateStr);

    int insertMore(List<News> list);

    @Select("<script>"+
            "        select tb_news.*" +
            "        from tb_news" +
            "        <where>" +
            "            <if test=\"null !=typeid\">" +
            "                and typeid=#{typeid}" +
            "            </if>" +
            "            <if test=\"null !=dateStr\">" +
            "                and DATE_FORMAT(pubdatetime,'%Y-%m-%d')=#{dateStr}" +
            "            </if>" +
            "            <if test=\"null !=titleKey\">" +
            "                <bind name=\"titleK\" value=\"'%'+titleKey+'%'\"/>" +
            "                and title like #{titleK}" +
            "            </if>" +
            "        </where>"
            +"</script>"
    )
    List<News> getNews3(@Param("typeid") Integer typeid,@Param("titleKey") String titleKey, @Param("dateStr") String dateStr);

    @Select("select * from tb_news order by pubdatetime DESC limit #{offset},#{size}")
    List<News> getPageNews(@Param("offset") int offset ,@Param("size") Integer size);
    @Select("select count(*) from tb_news")
    int getNewsCount();
}
