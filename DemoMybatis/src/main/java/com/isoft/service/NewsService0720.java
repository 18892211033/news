package com.isoft.service;

import com.isoft.bean.Page;
import com.isoft.dao.NewsDao;
import com.isoft.dao.NewsDao0720;
import com.isoft.db.DBSqlSession;
import com.isoft.entity.News;
import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsService0720 {
    NewsDao0720 newsDao0720;
    public NewsService0720(){
        newsDao0720 = DBSqlSession.getInstance(null).getSqlSession().getMapper(NewsDao0720.class);
    }
    public boolean updateById(News news){
        if (news.getId() == null || news.getId() < 1){
            return false;
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(news.getTitle()) || StringUtils.isEmptyOrWhitespaceOnly(news.getContent()) ||
                StringUtils.isEmptyOrWhitespaceOnly(news.getComefrom()) || null == news.getPubdatetime() || null == (news.getTypeid()) || news.getTypeid() < 1){
            return false;
        }
        return newsDao0720.updateById(news) > 0;
    };
    public boolean updateById(Integer newsId , Integer typeId ,String title , String content , String comefrom , String pubdatetimeStr){
        if (newsId == null || newsId < 1){
            return false;
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(title) || StringUtils.isEmptyOrWhitespaceOnly(content) || StringUtils.isEmptyOrWhitespaceOnly(comefrom) || StringUtils.isEmptyOrWhitespaceOnly(pubdatetimeStr)){
            return false;
        }
        Date pubdt = null;
        try {
            pubdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(pubdatetimeStr);
        }catch (Exception e){
            try {
                pubdt = new SimpleDateFormat("yyyy-MM-dd").parse(pubdatetimeStr);
            } catch (ParseException e1) {

            }
        }
        News news = new News(newsId , typeId ,title ,content,pubdt,comefrom);
        return newsDao0720.updateById(news) > 0;
    }
//    @Param("typeid") Integer typeid,@Param("titleKey") String titleKey, @Param("dateStr") String dateStr
    public List<News> getMore(Integer typeid,String titleKey,String dateStr){
        if (StringUtils.isEmptyOrWhitespaceOnly(titleKey)){
            titleKey = null;
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(dateStr)){
            dateStr = null;
        }
        if (typeid == null || typeid < 1){
            typeid = null;
        }
        return newsDao0720.getNews(typeid,titleKey,dateStr);
    }
    public Page<News> getPageData(Integer page , Integer size){
        if (null == page || page < 1){
            page = 1;
        }
        if (null == size || size < 1){
            page = 10;
        }
        List<News> list = newsDao0720.getPageNews((page-1)*page , size);
        int count = newsDao0720.getNewsCount();
        int pageCount = (int)Math.ceil(count*1.0/size);
        return new Page<>(count , pageCount , page ,size ,list);
    }
}
