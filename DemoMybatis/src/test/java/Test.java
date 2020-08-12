import com.isoft.dao.NewsDao;
import com.isoft.dao.NewsDao0720;
import com.isoft.dao.User2Dao;
import com.isoft.db.DBSqlSession;
import com.isoft.entity.News;
import com.isoft.entity.User2;
import com.isoft.service.NewsService0720;
import com.isoft.util.DateUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() {
        SqlSession sqlSession = null ;
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"))  ;
            sqlSession = factory.openSession();
            User2Dao user2Dao = sqlSession.getMapper(User2Dao.class) ;
//            System.out.println(user2Dao.getById(1));
            User2 user2 = new User2(null , "Spring" , "123" , null , null) ;
            if(user2Dao.add(user2) > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != sqlSession) {
                sqlSession.close();
                sqlSession = null ;
            }
        }
    }
    @org.junit.Test
    public void test2() {
        SqlSession sqlSession = DBSqlSession.getInstance(null).getSqlSession() ;

        User2Dao user2Dao = sqlSession.getMapper(User2Dao.class) ;
        System.out.println(user2Dao.getById(2));

        System.out.println(user2Dao.getUser("张三" , "123"));
        System.out.println(user2Dao.getAll());
        DBSqlSession.close();
    }
    @org.junit.Test
    public void test3(){
        SqlSession sqlSession = DBSqlSession.getInstance(null).getSqlSession();
//        NewsTypeDao newsTypeDao = sqlSession.getMapper(NewsTypeDao.class);
//        System.out.println(newsTypeDao.getById(2));
//        System.out.println(newsTypeDao.getById2(3));
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        System.out.println(newsDao.getByTypeid(3));
    }
    @org.junit.Test
    public void test4(){
        SqlSession sqlSession = DBSqlSession.getInstance(null).getSqlSession();
        NewsDao0720 newsDao0720 = sqlSession.getMapper(NewsDao0720.class);
//        System.out.println(newsDao0720.getNews(null,null,null));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(newsDao0720.getNews(1,null,null));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(newsDao0720.getNews(null,"子",null));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(newsDao0720.getNews(null,null,"2020-07-10"));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(newsDao0720.getNews(2,null,null));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(newsDao0720.getNews(2,"子","2020-07-10"));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        News news = new News();
//        news.setId(1);
//        news.setTypeid(1);
//        news.setComefrom("华信HXTV");
//        news.setContent("全员毕业");
//        news.setPubdatetime(DateUtil.Str2Date("2020-02-03"));
//        System.out.println(newsDao0720.updateById(news));
/*        List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(17);
        System.out.println(newsDao0720.deleteByIds(ids));*/
//        System.out.println(newsDao0720.getNews2(3,null,null));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(newsDao0720.getNews2(1,null,null));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(newsDao0720.getNewsByOne(3,"",null));
//        System.out.println(newsDao0720.getNewsByOne(null,"姐",null));
//        System.out.println(newsDao0720.getNewsByOne(null,null,"2020-02-02"));
//        List<News> list = new ArrayList<>();
//        list.add(new News(null,1,"类型1","内容1",null,"微信"));
//        list.add(new News(null,2,"类型2","内容2",null,"QQ"));
//        list.add(new News(null,3,"类型3","内容3",null,"微薄"));
//        System.out.println(list);
//        System.out.println(newsDao0720.insertMore(list));
//        System.out.println(newsDao0720.getNews3(1,"一","2020-02-02"));
//        System.out.println(newsDao0720.getNewsCount());
//        System.out.println(newsDao0720.getPageNews(1,5));
        sqlSession.commit();
    }
    @org.junit.Test
    public void test5(){
        NewsService0720 newsService0720 = new NewsService0720();
        System.out.println(newsService0720.getPageData(2,5));
    }
}
