package com.wst.service.impl;

import com.mysql.cj.util.StringUtils;
import com.wst.dao.UserDao;
import com.wst.service.UserService;
import com.wst.entity.Users;
import com.wst.util.StringUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    SqlSession sqlSession = null;
    SqlSessionFactory factory = null;
    UserDao userDao;
    @Override
    public Map<String, Object> loginCheck(String name, String password) {
        if (StringUtils.isEmptyOrWhitespaceOnly(name) || StringUtils.isEmptyOrWhitespaceOnly(password)){
            return null ;
        }
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"));
            sqlSession = factory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            sqlSession.commit();
            Users user = null ;
            int code ;
            Map<String , Object> map = new HashMap<>();
            int nameCount = userDao.nameExists(name);
            if (nameCount < 1){    //账号不存在
                code = USER_CODE_NAME_NOEXEIST ;
            }else {      //账号存在
                user = userDao.getUser(name ,password);
                if (null == user){    //密码错误
                    code = USER_PASS_ERRO ;
                }else {
                    code = USER_CODE_EXIST ;
                }
            }
            map.put(USER_KEY , user);
            map.put(USER_CODE, code);
            return  map;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != sqlSession) {
                sqlSession.close();
                sqlSession = null;
            }
        }
        return null;
    }
    @Override
    public boolean nameCheck(String name) {
        if (StringUtils.isEmptyOrWhitespaceOnly(name)){
            return false;
        }
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"));
            sqlSession = factory.openSession();
            sqlSession.commit();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            return userDao.nameExists(name) > 0;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != sqlSession) {
                sqlSession.close();
                sqlSession = null;
            }
        }
        return false;
    }
    @Override
    public int register(Users user) {
        if(null == user || StringUtils.isEmptyOrWhitespaceOnly(user.getName()) || StringUtils.isEmptyOrWhitespaceOnly(user.getPassword())){
            return 0;
        }

        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"));
            sqlSession = factory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int nameC = userDao.nameExists(user.getName());
            if (nameC > 0){
                return -1;
            }
            int r = userDao.nameExists(user.getName());
//            System.out.println(user+"-----------------------------");
            if (r > 0){
                return -1;
            }
            userDao.add(user);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != sqlSession) {
                sqlSession.close();
                sqlSession = null;
            }
        }
        return 0;
    }
    @Override
    public Users updateUser(Users users) {
        if(users.getId() ==null || users.getId() <0 ) {
            return null ;
        }
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-conf.xml"));
            sqlSession = factory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.updateUser(users.getPassword(),users.getId());
/*            Users u = userDao.getUser(users.getName(),users.getPassword());*/
            sqlSession.commit();
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }
}

