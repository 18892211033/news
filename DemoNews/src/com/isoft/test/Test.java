package com.isoft.test;

import com.isoft.dao.NewsDao;
import com.isoft.dao.TypeDao;
import com.isoft.service.NewsService;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
/*        TypeDao typeDao = new TypeDao();
        System.out.println(typeDao.getAll());*/
/*        NewsDao newsDao = new NewsDao();
        System.out.println(newsDao.getById(1));
        System.out.println(newsDao.getByTypeId(2));
        System.out.println(newsDao.getTopN(5));*/
        NewsService newsService = new NewsService();
//        System.out.println(newsService.getTopN());
//        System.out.println(newsService.getByTypeid(1));
        System.out.println(newsService.getByTypeid(2));
    }
}
