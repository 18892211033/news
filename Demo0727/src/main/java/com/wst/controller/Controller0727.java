package com.wst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller0727 {
    @RequestMapping("/ljq/test1")
    public String test1(){
        System.out.println("test-----------------------------1");
        return "index2";
    }
    @RequestMapping("/ljq/test2")
    @ResponseBody
    public String test2(){
        System.out.println("test-----------------------------2");
        return "index2json";
    }
    @GetMapping("/system/get/1")
    @ResponseBody
    public String test3(){
        return "user1";
    }
    @GetMapping("/system/login")
    @ResponseBody
    public String test4(){
        return "login-user";
    }
}
