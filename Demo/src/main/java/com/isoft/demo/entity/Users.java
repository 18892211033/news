package com.isoft.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    private Integer id;
    private String name;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai+8")
    private Date regDatetime;
    private Integer status;
    private String photoUrl;
}