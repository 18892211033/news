package com.isoft.demo.listener;

import com.isoft.demo.servlet.TestServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class TestListener implements ServletContextListener {
    public TestListener(){
        System.out.println("call TestListener 空构造方法");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("call TestListener.contextInitialized");
    }
}
