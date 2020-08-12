package com.isoft.dao;

import com.isoft.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NewsDao {
    @Select("select * from tb_news where typeid=#{typeId}")
    List<News>getByTypeid(Integer typeId);
    @Select("select * from tb_type where id=#{id}")
    News getBaseById(Integer id);
    News getById(Integer id);

}
