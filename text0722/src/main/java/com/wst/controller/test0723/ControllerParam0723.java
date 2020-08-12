package com.wst.controller.test0723;

import com.wst.bean.Users;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/param")
public class ControllerParam0723 {
    @RequestMapping("param1")
    public Map<String , Object> test1(String girlfriend,Integer money){
        Map<String , Object> map = new HashMap<>();
        map.put("girlfriend",girlfriend);
        map.put("money",money);
        return map;
    }
    @RequestMapping("param2")
    public Map<String , Object> test2(@RequestParam("girl") String girlfriend,@RequestParam("qian") Integer money){
        Map<String , Object> map = new HashMap<>();
        map.put("girlfriend",girlfriend);
        map.put("money",money);
        return map;
    }
    @RequestMapping("param3")
    public Users test3(Users users){
        return users;
    }
    @RequestMapping("param4")
    public Map<String , Object> test4(Boolean flag , @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dt){
        Map<String , Object> map = new HashMap<>();
        map.put("flag",flag);
        map.put("dt",dt);
        return map;
    }
    @PostMapping("paramFrom")
    public Map<String , Object> test5(String regname , String notes, String[] hobby){
        Map<String , Object> map = new HashMap<>();
        map.put("regname",regname);
        map.put("notes",notes);
        map.put("hobby",hobby);
        return map;
    }

}
