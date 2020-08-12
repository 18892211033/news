package com.wst.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if (null == obj){
            response.sendRedirect(request.getContextPath() + "/syspages/Login.html");
//            request.getRequestDispatcher("/syspages/Login.html").forward(request, response);
            return false;
        }
        return true;
    }
}
