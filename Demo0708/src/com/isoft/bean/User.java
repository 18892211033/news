package com.isoft.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String name;
    @JsonIgnore
    private String pass;
    private String mobile;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss" , timezone = "Asia/Shanghai")
    private Date regDatetime;

    public User() {
    }

    public User(String name, String pass, String mobile, Date regDatetime) {
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
        this.regDatetime = regDatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", mobile='" + mobile + '\'' +
                ", regDatetime=" + regDatetime +
                '}';
    }
}
