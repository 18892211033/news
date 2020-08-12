package com.isoft.dao;

import com.isoft.db.DBConnection;
import com.isoft.entity.News;
import com.isoft.entity.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {
    private Connection conn;
    private PreparedStatement psta;
    private String sql;

    public TypeDao() {
        this.conn = DBConnection.getInstance().getConn();
    }

    public List<Type> getAll() throws SQLException {
        List<Type> list = new ArrayList<>();
        sql = "select * from tb_type";
        psta = conn.prepareStatement(sql);
        ResultSet rs = psta.executeQuery();
        while (rs.next()){
            list.add(new Type(rs.getInt(1),rs.getString(2)));
        }
        rs.close();
        return list;
    }
}
