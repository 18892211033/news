package com.wst.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter() ;
        out.println("<!DocType html>");
        out.println("<html><head>") ;
        out.println("<meta charset=\"UTF-8\">") ;
        out.println("</head><body>") ;
        out.println("客户提交信息的方式 : " + request.getMethod() + "<br/>");
        out.println("使用的协议 : " + request.getRequestURI() + "<br/>");
        out.println("获取发出请求字符串的客户端地址 : " + request.getRequestURL() + "<br/>");
        out.println("获取提交数据的客户端IP地址 : " + request.getRemoteAddr() + "<br/>");
        out.println("获取服务器端口号 : " + request.getServerPort() + "<br/>");
        out.println("获取服务器的名称 : " + request.getServerName() + "<br/>");
        out.println("获取客户端的主机名 : " + request.getRemoteHost() + "<br/>");
        out.println("获取客户端所请求的脚本文件的文件路径 : " + request.getServletPath()+ "<br/>");
        out.println("获得Http协议定义的文件头信息Host的值 : " + request.getHeader("host") + "<br/>");
        out.println("获得Http协议定义的文件头信息User-Agent的值 : " + request.getHeader("user-agent") + "<br/>");
        out.println("获得Http协议定义的文件头信息accept-language的值 : " + request.getHeader("accept-language") + "<br/>");
        out.println("</body></html>") ;
    }
}
