package com.wst.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")//去掉name=,前面必须加"/";()里的意思是:Servlet的配置信息的路径，相当于Web.xml<servlet-mapping>里的<url-pattern>
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("welcome");
        PrintWriter out = response.getWriter();
        out.println("<a href=\"http://www.baidu.com\">百度</a>");
    }
}
