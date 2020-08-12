package com.isoft.demo.controller;

import com.isoft.demo.bean.Person;
import com.isoft.demo.entity.Users;
import com.isoft.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
//@RequestMapping
public class TestController {
    @Value("${user.upload.photo}")
    String userphotoPath;
    @Autowired
    UserService userService;
    @Autowired
    Person person;
    static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/test/user/{id}")
    public Users getUser(@PathVariable("id") Integer id){
        if (null == id || id < 1){
            return null;
        }
        LOG.info(System.currentTimeMillis() + "call  getById(" + id + ")");
        return userService.getById(id);
    }
    @RequestMapping("/test/hello/")
    public String root(){
        System.out.println("hello world success!!!");
        LOG.info(System.currentTimeMillis() + "call root");
        return "Hello World!";
    }
    @GetMapping("/test/pros/")
    public String testPros(){
        System.out.println(userphotoPath);
        System.out.println("Person" + person);
        return userphotoPath + "\n" + person;
    }
    @GetMapping("/test/devtools")
    public String testDevTools(){
        return "DevTools---------------------";
    }
}
