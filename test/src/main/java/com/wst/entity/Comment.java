package com.wst.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer id;
    private Integer newsid;
    private Integer userid;
    private String content_text;
    private Date addDatetime;
    Users user;

    public Comment() {
    }

    public Comment(Integer id, Integer newsid, Integer userid, String content_text, Date addDatetime, Users user) {
        this.id = id;
        this.newsid = newsid;
        this.userid = userid;
        this.content_text = content_text;
        this.addDatetime = addDatetime;
        this.user = user;
    }
    public Comment(Integer newsid, Integer userid, String content_text, Date addDatetime) {
        this.newsid = newsid;
        this.userid = userid;
        this.content_text = content_text;
        this.addDatetime = addDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public Date getAddDatetime() {
        return addDatetime;
    }

    public void setAddDatetime(Date addDatetime) {
        this.addDatetime = addDatetime;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", newsid=" + newsid +
                ", userid=" + userid +
                ", content_text='" + content_text + '\'' +
                ", addDatetime=" + addDatetime +
                ", user=" + user +
                '}';
    }
}
