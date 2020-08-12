package com.wst.dao;

import com.wst.controller.UserController;
import com.wst.entity.Users;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class UserDaoTest extends TestCase {
    SqlSession sqlSession = null;
    @org.junit.Test
    public void test(){
        SqlSessionFactory factory = null;
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"));
            sqlSession = factory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            UserController u = new UserController();
            Users uu = new Users();
            uu.setId(9);
            uu.setPassword("123321");
            u.updateU(uu);
            System.out.println(u.updateU(uu));

//            System.out.println(userDao.nameExists("张三"));
//            sqlSession.commit();
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
