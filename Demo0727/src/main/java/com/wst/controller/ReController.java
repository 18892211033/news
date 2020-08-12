package com.wst.controller;

import com.wst.bean.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ReController {
    @RequestMapping("/re/test1")
    public String test(Boolean isRe , Boolean isHtml) {
        System.out.println("Call ReController.test");
        if(null != isRe  && isRe) {
            if(null != isHtml && isHtml) {
                return "redirect:/syspages/Login.html" ;   // 重定向到另一个页面
            }
            return "redirect:/test/name" ;   // 重定向到另一个Controller的方法

        }
        return "welcome" ;
    }

    @RequestMapping("/re/test2")
    public ModelAndView test2(Boolean isRe , Boolean isHtml) {
        System.out.println("Call ReController.test");
        ModelAndView modelAndView = new ModelAndView() ;
        if(null != isRe  && isRe && null != isHtml && isHtml) {
            modelAndView.setViewName("redirect:/syspages/Login.html" );
        }  else if(null != isRe  && isRe) {
            modelAndView.setViewName("redirect:/test/name");
        }  else {
            modelAndView.setViewName("welcome");
        }
        return modelAndView ;
    }


    @RequestMapping("/re/test3")
    @ResponseBody
    public ResponseData test3(HttpServletRequest request , HttpServletResponse response , Boolean isRe) {
        System.out.println("Call ReController.test2");
        if(null != isRe  && isRe) {
            try {
                request.getRequestDispatcher("/test/name").forward(request, response);
                return null ;
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseData(0 , "ok" , null);
    }
}