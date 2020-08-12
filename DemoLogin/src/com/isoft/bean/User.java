package com.isoft.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String pass;
    private String mobile;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "Asia/Shanghai")
    private Date birthday;

    public User() {
    }

    public User(Integer id, String name, String pass, String mobile, Date birthday) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
        this.birthday = birthday;
    }

    public User(String name, String pass, String mobile, Date birthday) {
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", mobile='" + mobile + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
