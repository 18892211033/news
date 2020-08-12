package com.isoft.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String mobile;
    private Date regDatetime;

    public User() {
    }

    public User(Integer id, String name, String password, String mobile, Date regDatetime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.regDatetime = regDatetime;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Date regDatetime) {
        this.regDatetime = regDatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", regDatetime=" + regDatetime +
                '}';
    }
}
