package com.wst.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Users implements Serializable {
    private Integer id ;
    private String name ;
    private String password ;
    private Date regDatetime ;
    private int status;
    private String photoUrl;
    private List<Comment> list;

    public Users() {

    }

    public Users(Integer id, String name, String password, Date regDatetime, int status, String photoUrl, List<Comment> list) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.regDatetime = regDatetime;
        this.status = status;
        this.photoUrl = photoUrl;
        this.list = list;
    }
    public Users(String name, String password, Date regDatetime, int status, String photoUrl) {
        this.name = name;
        this.password = password;
        this.regDatetime = regDatetime;
        this.status = status;
        this.photoUrl = photoUrl;
    }
    public Users(Integer id, String name, String password, Date regDatetime, int status, String photoUrl) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.regDatetime = regDatetime;
        this.status = status;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Date regDatetime) {
        this.regDatetime = regDatetime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Comment> getList() {
        return list;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", regDatetime=" + regDatetime +
                ", status=" + status +
                ", photoUrl='" + photoUrl + '\'' +
                ", list=" + list +
                '}';
    }
}
