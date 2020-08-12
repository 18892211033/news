package com.isoft.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.demo.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
    @Select("<script>"+
            "        select tb_news.* , tb_type.typename" +
            "        from tb_news inner join tb_type on tb_news.typeid=tb_type.id" +
            "        <where>" +
            "            <if test=\"null !=title\">" +
            "                <bind name=\"titleK\" value=\"'%'+title+'%'\"/>" +
            "                and title like #{titleK}" +
            "            </if>" +
            "        </where>"
            +"</script>"
    )
    List<News> getNewsDetail(String title);
}
