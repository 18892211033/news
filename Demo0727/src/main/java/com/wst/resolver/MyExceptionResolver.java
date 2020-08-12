package com.wst.resolver;

import com.wst.bean.MyException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView() ;
        if(ex instanceof MyException) {
            modelAndView.setViewName("error/errorCustom");
        } else if(ex instanceof MaxUploadSizeExceededException) {
            modelAndView.setViewName("error/errorFileOutofMax");
        } else {
            modelAndView.setViewName("error");
        }
        modelAndView.addObject("ex" , ex) ;
        return modelAndView;
    }
}
