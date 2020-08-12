package com.wst.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/url/dispatcher")
public class DispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Call DispatcherServlet.doGet()");//DispatcherServlet 前端控制器
        //重定向
        request.setAttribute("test","I'am from DispatcherServlet");
        request.setAttribute("info","test dispatcher");
        request.getRequestDispatcher("../temp").forward(request , response);
    }
}
