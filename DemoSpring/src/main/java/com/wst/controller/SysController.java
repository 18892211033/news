package com.wst.controller;

import org.springframework.stereotype.Controller;

//@Controller(value = "sysCon")
@Controller
public class SysController {
    public String get(String name , String pass){
        System.out.println("SysController.get(String name , String pass)");
        if (null == name){
            throw new NullPointerException("name is null");
        }
        System.out.println("SysController.get end");
        return name + "," + pass;
    }
    public String get(String name){
        System.out.println("SysController.get(String name)");
        if (null == name){
            throw new NullPointerException("name is null");
        }
        System.out.println("SysController.get(String name) end");
        return name;
    }
    public void getU(Integer id){
        System.out.println("SysController.getU(Integer id)");
    }
}
