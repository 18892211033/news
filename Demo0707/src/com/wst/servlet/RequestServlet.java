package com.wst.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request/othermethod")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath(); //获取项目的虚拟路径名
        out.print("ContextPath : " + contextPath);//    /DemoWeb
        ServletContext application = request.getServletContext();  //
        out.print("<br/>Server Path : " + application.getRealPath("/"));//项目发布的绝对路径
        out.print("<br/>Project Path : " + application.getRealPath(request.getContextPath()));//getRealPath这个实际上输出的就是文件在电脑中的绝对路径，也就是读取web中的资源文件；

    }
}
