package com.wst.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
    private Integer id ;
    private String name ;
    // @JsonIgnore
    private String password ;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai")
    private Date regDatetime ;
    private Integer status ;
    private String photoUrl ;

    public Users() {
    }

    public Users(Integer id, String name, String password, Date regDatetime, Integer status, String photoUrl) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", regDatetime=" + regDatetime +
                ", status=" + status +
                ", photoUrl='" + photoUrl +
                '}';
    }
}
