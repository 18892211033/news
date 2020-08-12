package com.isoft.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class TestListener implements ServletContextListener , HttpSessionListener {
    ServletContext application = null ;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web容器启动了");
        application = sce.getServletContext();
        application.setAttribute("total" , 10);
        application.setAttribute("online" , 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web容器销毁了");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int t = (Integer)application.getAttribute("total");
        application.setAttribute("total" , t+1);
        int o = (Integer)application.getAttribute("online");
        application.setAttribute("online" , o+1);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int o = (Integer)application.getAttribute("online");
        application.setAttribute("online" , o-1);

    }
}
