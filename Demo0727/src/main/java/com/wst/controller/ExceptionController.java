package com.wst.controller;

import com.wst.bean.MyException;
import com.wst.bean.SystemException;
import com.wst.bean.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@Controller
@RequestMapping("/exp")
public class ExceptionController {
    @RequestMapping("myExp")
    public String test1() throws MyException {
        if(true) {
            throw new MyException();
        }
        return "ok" ;
    }
    @RequestMapping("upExp")
    public String test2()  {
        if(true) {
            throw new MaxUploadSizeExceededException(555555) ;
        }
        return "ok" ;
    }
    @RequestMapping("defExp")
    public String test3() throws Exception {
        if(true) {
            throw new Exception() ;
        }
        return "ok" ;
    }

    @RequestMapping("/jsonr")
    @ResponseBody
    public String test4() throws Exception {
        if(true) {
            throw new Exception() ;
        }
        return "ok" ;
    }

    @RequestMapping("castExp")
    public String test5() {
        if(true) {
            throw new SystemException("发生了类型转换异常" , "208") ;
        }
        return "ok" ;
    }

 }
