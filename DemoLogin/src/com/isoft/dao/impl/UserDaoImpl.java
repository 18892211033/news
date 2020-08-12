package com.isoft.dao.impl;

import com.isoft.bean.ResponseData;
import com.isoft.bean.User;
import com.isoft.dao.UserDao;
import com.isoft.db.DBConnection;
import com.isoft.service.UserService;

import java.sql.*;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    private PreparedStatement psta;
    private String sql;
/**
 * Statement用于在已经建立数据库连接的基础上，向数据库发送要执行的SQL语句。Statement对象，用于执行不带参数的简单SQL语句。
 * 作为 Statement 的子类，PreparedStatement 继承了 Statement 的所有功能。另外它还添加了一整套方法，用于设置发送给数据库以取代 IN 参数占位符的值。
 * 同时，三种方法 execute、 executeQuery 和 executeUpdate 已被更改以使之不再需要参数。这些方法的 Statement 形式（接受 SQL 语句参数的形式）不应该用于 PreparedStatement 对象。
 */

    public UserDaoImpl() {
      this.connection = DBConnection.getInstance().getConn();//连接数据库
    }

    @Override
    public int nameExists(String name) throws SQLException {
        int count = 0 ;
        sql = "select * from tb_user where name=?";
        psta = connection.prepareStatement(sql);
        psta.setString(1 , name);//parameterIndex:第几个?从1开始数，x：?的值。
        ResultSet rs = psta.executeQuery(); //存放数据
        if (rs.next()){   //下移一行
            count = 1 ;
        }
        rs.close();//结果集，用完关掉
        return count ;
    }

    @Override
    public User getUser(String name, String pass) throws SQLException {
        User user = null ;
        String sql = "select * from tb_user where name=? and password=?";
        psta = connection.prepareStatement(sql);
        psta.setString(1,name);
        psta.setString(2,pass);
        ResultSet rs = psta.executeQuery();
        if (rs.next()){
            java.util.Date birthday = null;
            if (null != rs.getDate(5)){
                birthday = new java.util.Date(rs.getDate(5).getTime());
            }
             user = new User(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    birthday
            );
        }
        rs.close();
        return user;
    }

    @Override
    public int add(User user) throws SQLException {
        sql = "insert into tb_user values(null,?,?,?,?)";
        psta = connection.prepareStatement(sql);
        psta.setString(1,user.getName());
        psta.setString(2,user.getPass());
        psta.setString(3,user.getMobile());
        psta.setDate(4,new java.sql.Date(user.getBirthday().getTime()));
        return psta.executeUpdate();
    }

    @Override
    public int updateUser(User user) throws SQLException {
        /*if(user.getPass() != null && user.getPass().trim().length() > 0) {
            sql = "update tb_user set password=? where id=?";
            psta = connection.prepareStatement(sql);
            psta.setString(1, user.getPass());
            psta.setInt(2, user.getId());
        } else if(user.getMobile() != null && user.getMobile().trim().length() > 0) {
            sql = "update tb_user set mobile=? where id=?";
            psta.setString(1, user.getMobile());
            psta.setInt(2, user.getId());
        } else if((user.getPass() != null && user.getPass().trim().length() > 0) && (user.getMobile() != null && user.getMobile().trim().length() > 0)) {
            sql = "update tb_user set password=? , mobile=? where id=?";
            psta.setString(1, user.getPass());
            psta.setString(2, user.getMobile());
            psta.setInt(3, user.getId());
        }*/
        sql = "update tb_user set password=? , mobile=? where id=?";
        psta = connection.prepareStatement(sql);
        psta.setString(1, user.getPass());
        psta.setString(2, user.getMobile());
        psta.setInt(3, user.getId());
        return  psta.executeUpdate();

    }
}
