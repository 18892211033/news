package com.wst.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/counter")
public class CounterServlet extends HttpServlet {
    final String KEY_COUNTER = "counter";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext app = request.getServletContext();
        int count = 0;
        Object obj = app.getAttribute(KEY_COUNTER);
        if (null != obj){
            try {
                count = (Integer) obj;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        count++;
        app.setAttribute(KEY_COUNTER , count);
        response.getWriter().print(count);
    }
}
