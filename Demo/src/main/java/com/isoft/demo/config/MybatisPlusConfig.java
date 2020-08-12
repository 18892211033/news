package com.isoft.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        paginationInterceptor.setLimit(-1);//默认单页最多500条   -1标识不受限
        return paginationInterceptor;
    }
}
