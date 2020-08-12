package com.wst.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/register")
public class ParamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String s = "<!DOCTYPE html>\n" +
                "<html lang=\"zh\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>";
        out.print(s);
        out.print("用户名"+name+"<br/>密码"+pass+"<br/>移动电话"+phone+"<br/>生日"+birthday);
        out.print("</body>\n"+"</html>");

    }
}
