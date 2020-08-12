package com.isoft.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_news")
public class News implements Serializable {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";

    @TableId(type = IdType.AUTO)
    private Integer id ;
    private Integer typeid;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai")
    @TableField(value = "pubdatetime")
    private Date pubDatetime;
    private String comefrom;
    @TableField(exist = false)
    private String typename;


}
