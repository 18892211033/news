package com.isoft.demo.controller;

import com.isoft.demo.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ThymeleafController {
    @GetMapping("/leaf")
    public ModelAndView testLeaf(){
        Person person = new Person(810 , "thymeleaf", new Date());
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(new Person(12,"22name" , new Date()));
        ModelAndView mav = new ModelAndView();
        mav.addObject("info","-------------------");
        mav.addObject("imgName","444.jpg");
        mav.addObject("imgPath","assets/imgs/222.jpg");
        mav.addObject("person",person);
        mav.addObject("list",list);
        mav.setViewName("test");
//        mav.addObject("downlosd","static/download/test下载.rar");
        return mav;
    }
}
