package com.isoft.emile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class RunApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(com.isoft.emile.RunApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(com.isoft.emile.RunApplication.class);
    }
}
