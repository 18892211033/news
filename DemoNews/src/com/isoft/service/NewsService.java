package com.isoft.service;

import com.isoft.dao.NewsDao;
import com.isoft.entity.News;
import com.isoft.entity.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsService {
    NewsDao newsDao;
    public NewsService(){
        this.newsDao = new NewsDao();
    }
    //得到前5条新闻
    public List<News> getTopN(){
        try {
            return newsDao.getTopN(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //根据新闻Typeid，获取到新闻列表
    public List<News> getByTypeid(Integer typeid){
        if (null == typeid || typeid < 1){
            return null;
        }
        try {
            return newsDao.getByTypeId(typeid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //根据id查询新闻详情
    public News getById(Integer id){
        if (null == id || id < 1){
            return null;
        }
        try {
            return newsDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //根据typeid查询新闻详情
    public List<News> getAllByTypeId(Integer typeid){
        if (null == typeid || typeid < 1){
            return null;
        }
        try {
            return newsDao.getAllbyTypeId(typeid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
