package com.wst.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("name")
    public String test(String name) {
        System.out.println("name");
        return name == null ? "name-null" : name ;
    }
    @GetMapping()
    public String test() {
        System.out.println("get");
        return "get" ;
    }
    @PostMapping()
    public String test2() {
        System.out.println("post");
        return "post" ;
    }
    @PutMapping()
    public String test3() {
        System.out.println("put");
        return "put" ;
    }
    @DeleteMapping()
    public String test4() {
        System.out.println("delete");
        return "delete" ;
    }
}
