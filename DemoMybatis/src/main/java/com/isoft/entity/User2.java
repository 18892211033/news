package com.isoft.entity;

import java.io.Serializable;
import java.util.Date;

public class User2 implements Serializable {
    private Integer uid ;
    private String uname , upass ;
    private String mobile ;
    private Date regDt ;
    public User2(){
    }

    public User2(Integer uid, String uname, String upass, String mobile, Date regDt) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.mobile = mobile;
        this.regDt = regDt;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegDt() {
        return regDt;
    }

    public void setRegDt(Date regDt) {
        this.regDt = regDt;
    }

    @Override
    public String toString() {
        return "User2{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", mobile='" + mobile + '\'' +
                ", regDt=" + regDt +
                '}';
    }
}