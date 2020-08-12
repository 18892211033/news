package com.wst.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ScopeC implements Serializable {
    private String info;
    private int n;
    public ScopeC(){
        System.out.println("ScopeC无参构造方法-----------");
    }
}
