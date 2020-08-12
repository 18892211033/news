import com.isoft.dao.NewsDao;
import com.isoft.dao.UserDao;
import com.isoft.dao.UserDao2;
import com.isoft.entity.News;
import com.isoft.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class Test {
    @org.junit.Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"));
            sqlSession = factory.openSession();
//            UserDao2 userDao = sqlSession.getMapper(UserDao2.class);
//            System.out.println("李五在不在"+userDao.nameExists("李五"));
//            System.out.println("张三在不在"+userDao.nameExists("张三"));
//            System.out.println("通过账号密码查询"+userDao.getUser("张三","123"));
//            System.out.println("通过账号密码查询"+userDao.getUser("张5","123"));
//            User u = new User(null,"王思桐","123","123123",null);
//            System.out.println("添加user"+userDao.add(u));
//            System.out.println("通过id修改密码"+userDao.updatePassword(2,"111111"));
//            System.out.println(userDao.getAll());

            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
//            System.out.println(newsDao.allNewsByTypeid(3));
//            News news = new News(null,1,"高考","wst高考狀元",null,"華信TV");
//            System.out.println(newsDao.add(news));
//            System.out.println(newsDao.delNews(16));
//            System.out.println(newsDao.updateNews(10,"wst牛逼嗷"));
            System.out.println(newsDao.likeTitle("高考"));
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != sqlSession){
                sqlSession.close();
                sqlSession = null;
            }
        }
    }
}
