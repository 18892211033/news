package com.isoft.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.demo.entity.News;
import com.isoft.demo.mapper.NewsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    NewsMapper newsMapper ;

    @Test
    void test4(){
        Page<News> page = new Page<>(1,3); //查看第一页，每页3条
        QueryWrapper<News> wrapper = new QueryWrapper<>();
        wrapper.isNotNull(News.COLUMN_ID);
        newsMapper.selectPage(page , wrapper) ;   // 可以不接收返回，将结果映射到参数Page对象上

        System.out.println("总记录个数 : " + page.getTotal() + "\n" + "共页数 : " + page.getPages());
        System.out.println("当前页码 :" + page.getCurrent() + "\n" + "每页记录个数 : " + page.getSize());
        System.out.println("本页数据 : " + page.getRecords());
    }

    @Test
    void test3(){
        UpdateWrapper<News> wrapper = new UpdateWrapper<>();
        wrapper.set("content" , "UpdateWrapper");
        wrapper.set("comefrom" , "微信小程序");
        wrapper.eq("id",1000);
        System.out.println(newsMapper.selectList(wrapper));
    }
    @Test
    void test2(){
        QueryWrapper<News> wrapper = new QueryWrapper<>();
        wrapper.select(new String[]{"title" , "id"});
        wrapper.like("title" , "高考");
        System.out.println(newsMapper.selectList(wrapper));

        wrapper.clear();
        wrapper.eq("comefrom" , "腾讯").or().isNotNull("content");
        System.out.println(newsMapper.selectList(wrapper));
        System.out.println(newsMapper.selectCount(wrapper));
    }

    
    @Test
    void contextLoads() {
//        System.out.println(newsMapper.selectById(1));//查询
//        System.out.println("----");
//        System.out.println(newsMapper.selectList(null));


//        News news = new News();//添加
////        news.setId(1000);
//        news.setTitle("mybatisPlus2222");
//        news.setPubDatetime(new Date());
//        System.out.println(newsMapper.insert(news));

//        News news = new News();  //修改
//        news.setId(1000);
//        news.setTitle("mybatisPlus-----update");
//        news.setTitle("今天没去上课");
//        System.out.println(newsMapper.updateById(news));

//        System.out.println(newsMapper.deleteById(25));根据id删除1条

//        List ids = new ArrayList();   //删除多条
//        ids.add(27);
//        ids.add(29);
//        ids.add(30);           //Arrays.asList(new Integer[]{21,22})
//        System.out.println(newsMapper.deleteBatchIds(ids));
//        System.out.println(newsMapper.getNewsDetail("高考"));
    }

}
