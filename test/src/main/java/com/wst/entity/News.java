package com.wst.entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private Integer id;
    private Integer typeid;
    private String title;
    private String content;
    private Date pubdatetime;
    private String comefrom;
    private NewsType newsType;

    public News() {
    }

    public News(Integer id, Integer typeid, String title, String content, Date pubdatetime, String comefrom, NewsType newsType) {
        this.id = id;
        this.typeid = typeid;
        this.title = title;
        this.content = content;
        this.pubdatetime = pubdatetime;
        this.comefrom = comefrom;
        this.newsType = newsType;
    }

    public News(Integer newsId, Integer typeid, String title, String content, Date pubdatetime , String comefrom) {
        this.id = id;
        this.typeid = typeid;
        this.title = title;
        this.content = content;
        this.pubdatetime = pubdatetime;
        this.comefrom = comefrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubdatetime() {
        return pubdatetime;
    }

    public void setPubdatetime(Date pubdatetime) {
        this.pubdatetime = pubdatetime;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", typeid=" + typeid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pubdatetime=" + pubdatetime +
                ", comefrom='" + comefrom + '\'' +
                ", newsType=" + newsType +
                '}';
    }
}
