package com.isoft.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "person")
@PropertySource(value = "classpath:application.properties",encoding = "utf-8")
public class Person implements Serializable {
    private Integer id;
    private String name;
    private Date birth;
}
