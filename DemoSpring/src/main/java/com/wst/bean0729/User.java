package com.wst.bean0729;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@Scope("prototype")
@Data
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
    private String pass;

    public User() {
        System.out.println("User类的无参构造方法");
    }
}
