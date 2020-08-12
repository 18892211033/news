package com.wst.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private String id;
    private String name;
    private Car car;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
