package com.wst.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonCars implements Serializable {
    private String id;
    private String name;
    private List<Car> list;
}
