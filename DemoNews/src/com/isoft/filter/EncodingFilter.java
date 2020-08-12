package com.isoft.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/*@WebFilter(filterName = "EncodingFilter" ,
            urlPatterns = "/*" ,
            initParams = {@WebInitParam(name="encode",value="UTF-8") , @WebInitParam(name="dt" , value = "2020-07-09")})*/
public class EncodingFilter implements Filter {
    private String encode , dt ;
    public void destroy() {
        System.out.println("EncodingFilter.destroy()");
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encode);
        resp.setCharacterEncoding(encode);
        System.out.println("EncodingFilter.doFilter() --  before -- chain.doFilter");
        chain.doFilter(req, resp);
        System.out.println("EncodingFilter.doFilter() --  after -- chain.doFilter");
    }

    /**
     * 该方法中可以获取Filter初始化配置时所设置的参数
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode") ;
        dt = config.getInitParameter("dt") ;
        System.out.println("EncodingFilter.init() : " + encode + "--" + dt) ;
        if(null == encode || encode.trim().length() == 0) {
            encode = "UTF-8" ;
        }
    }
}
