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

public class NewsDao {
    private Connection conn;
    private PreparedStatement psta;
    private String sql;
    public NewsDao() {
        this.conn = DBConnection.getInstance().getConn();
    }
    //按日期返回最新新闻
    public List<News> getTopN(Integer topN) throws SQLException {
        sql = "select * from tb_news order by pubdatetime desc limit 0,?";//desc 降序  显示最新上传的前5条数据
        psta = conn.prepareStatement(sql);
        psta.setInt(1,topN);
        ResultSet rs = psta.executeQuery();
        return rs2List(rs);

    }
    //根据新闻的类别id查看本类别的新闻
    public List<News> getByTypeId(Integer typeid) throws SQLException{
        sql = "select * from tb_news where typeid=? order by pubdatetime desc";//desc 降序  显示最新上传的前5条数据
        psta = conn.prepareStatement(sql);
        psta.setInt(1,typeid);
        ResultSet rs = psta.executeQuery();
        return rs2List(rs);
    }
    //根据新闻的id查看详情
    public News getById(Integer id) throws SQLException {
        News news = null;
        sql = "select * from tb_news where id=?";
        psta = conn.prepareStatement(sql);
        psta.setInt(1,id);
        ResultSet rs = psta.executeQuery();
        if (rs.next()){
            java.util.Date pubdatetime = null;
            if (null != rs.getDate(5)){
                pubdatetime = new java.util.Date(rs.getDate(5).getTime());
            }
            news = new News(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    pubdatetime,
                    rs.getString(6)
            );
        }
        rs.close();
        return news;
    }
    public List<News> getAllbyTypeId(Integer typeid) throws SQLException {
        sql = "select * from tb_news where typeid=? order by pubdatetime desc";//desc 降序  显示最新上传的前5条数据
        psta = conn.prepareStatement(sql);
        psta.setInt(1,typeid);
        ResultSet rs = psta.executeQuery();
        return rs2List(rs);
    }

    private List<News> rs2List(ResultSet rs) throws SQLException {
        List<News> list = new ArrayList<>();
        java.util.Date pubdatetime = null;
        while (rs.next()) {
            if (null != rs.getDate(5)){
                pubdatetime = new java.util.Date(rs.getDate(5).getTime());
            }
            list.add(new News(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    pubdatetime,
                    rs.getString(6)
            ));
        }
        rs.close();
        return list;
    }
}
