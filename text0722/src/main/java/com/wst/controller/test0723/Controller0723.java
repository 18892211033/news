package com.wst.controller.test0723;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDate.now;

@Controller
@RequestMapping("/test0723")
public class Controller0723 {
    @RequestMapping("viewname")
    public String test1(Model model){
        model.addAttribute("name","王思桐");
        model.addAttribute("city","天津");
        return "t0723/test";
    }
    @RequestMapping("mav")
    public ModelAndView test2(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("info","Controller第二种方法");
        mav.addObject("dt", new Date());
        mav.setViewName("t0723/test");
        return mav;
    }
    @RequestMapping("Json")
    @ResponseBody
    public Map<String , Object> test3(){
        Map<String , Object> map = new HashMap<>();
        map.put("girlfriend","李其茹");
        map.put("money","0");
        return map;   //{"girlfriend":"李其茹","money":"0"}
    }
}
