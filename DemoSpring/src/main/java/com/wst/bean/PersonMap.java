package com.wst.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonMap implements Serializable {
    private String id;
    private String name;
    private Map<String , Car> mapCar;
}
