package com.isoft.demo.config;

import com.isoft.demo.interceptor.StaticInterceptor;
import com.isoft.demo.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;
@Configuration
public class MyWebConfigure implements WebMvcConfigurer {
    static final List<String> EXCLUDE_PATH = Arrays.asList("/", "/static/index.html","/assets/css/**","/assets/js/**","/assets/imgs/**","/error/**");   //Arrays.asList数组专辑和
    @Autowired
    StaticInterceptor staticInterceptor;
    @Autowired
    TestInterceptor testInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(staticInterceptor).//添加拦截器
                addPathPatterns("/**").//拦截谁（全拦截）
                excludePathPatterns(EXCLUDE_PATH);//不拦截谁
        registry.addInterceptor(testInterceptor).
                addPathPatterns("/test/**").
                excludePathPatterns(EXCLUDE_PATH);
        System.out.println("lanjieqi-------------------------------------------------");
    }
}
