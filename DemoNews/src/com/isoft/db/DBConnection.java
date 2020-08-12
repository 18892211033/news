package com.isoft.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection ourInstance = new DBConnection() ;
    private static Connection conn ;

    public static DBConnection getInstance(){
        return ourInstance ;
    }

    private DBConnection(){
        Properties properties = new Properties() ;
        //再入一个属性文件
        try {
            properties.load(DBConnection.class.getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //连接数据库，完成connect实例化
        try {
            Class.forName(properties.getProperty("mysql.driver")) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(
                    properties.getProperty("mysql.url"),
                    properties.getProperty("mysql.username") ,
                    properties.getProperty("mysql.userpass")
            ) ;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Connection getConn(){
        return conn ;
    }
    public void closeConn(){
        if(null!=conn){
            try {
                conn.close();
                conn = null ;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
