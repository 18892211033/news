package com.wst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("用了test方法");
        return "test";
    }
}
