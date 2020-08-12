package com.wst.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LifeC implements Serializable {
    private int n;
    private String str;
    public void init(){
        System.out.println("Call LifeC-init()");
    }
    public void destroy(){
        System.out.println("Call LifeC-destroy()");
    }
}
