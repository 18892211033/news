package com.wst.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post");
        PrintWriter out = response.getWriter();//输出到网页的控制台
        String name = request.getParameter("loginname");//request.getParameter 简单的说 是获取客户端用户表bai单中提交的数据
        String pass = request.getParameter("loginpass");
        System.out.println(name + "***" + pass);
        if ("admin".equalsIgnoreCase(name) && "123".equals(pass) || "user".equalsIgnoreCase(name) && "1234".equals(pass)){
            out.print("true");
        }else {
            out.print("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
