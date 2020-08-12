import com.wst.dao.UserDao;
import com.wst.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
    SqlSession sqlSession = null;
    @org.junit.Test
    public void test(){
        SqlSessionFactory factory = null;
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"));
            sqlSession = factory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            Users u = new Users();
//            u.setId(9);
//            u.setPassword("1231234");
//            u.setPhotoUrl("123");
            userDao.updateUser("123123",9);
            System.out.println(u);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != sqlSession) {
                sqlSession.close();
                sqlSession = null;
            }
        }

    }
}
