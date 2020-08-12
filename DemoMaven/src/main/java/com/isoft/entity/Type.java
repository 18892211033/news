package com.isoft.entity;

import java.io.Serializable;

public class Type implements Serializable {
    private Integer id ;
    private String typename;

    public Type() {
    }

    public Type(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}
