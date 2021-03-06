package com.isoft.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class DBSqlSession {
    private static DBSqlSession ourInstance = null;

    public static synchronized DBSqlSession getInstance(String configName) {
        ourInstance = new DBSqlSession(configName) ;
        return ourInstance;
    }

    private static SqlSession sqlSession ;
    private DBSqlSession(String configName) {
        if(null == configName || configName.trim().length() == 0) {
            configName = "mybatis-conf.xml";
        }
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(configName))  ;
            sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SqlSession getSqlSession() {
        return sqlSession ;
    }
    public static void close() {
        if(null != sqlSession) {
            sqlSession.close();
            sqlSession = null ;
        }
    }

}