package com.isoft.servlet0713;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/life")
public class LifeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("lifeServlet ------------------init()");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("lifeServlet ------------------service()");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("lifeServlet ------------------doPost()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("lifeServlet ------------------doGet()");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("lifeServlet ------------------destroy()");
    }
}
