package com.isoft.dao;

import com.isoft.entity.NewsType;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface NewsTypeDao {
    @Select("select * from tb_type where id=#{id}")
    NewsType getBaseById(Integer typeId);


    NewsType getById(Integer typeId);


    @Select("    select tb_type.id as tid,tb_type.typename,tb_news.*" +
            "    from tb_type inner join tb_news on tb_type.id=tb_news.typeid" +
            "    where tb_type.id=#{typeId}")
    @ResultMap("com.isoft.mapper.resultmapper.NewsTypeMap")
    NewsType getById2(Integer typeId);


    NewsType getById3(Integer typeId);
    NewsType getById4(Integer typeId);
}
