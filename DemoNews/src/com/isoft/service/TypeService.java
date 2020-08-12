package com.isoft.service;

import com.isoft.dao.TypeDao;
import com.isoft.entity.Type;

import java.sql.SQLException;
import java.util.List;

public class TypeService {
    private TypeDao typeDao;
    public TypeService(){
        typeDao = new TypeDao();
    }
    public List<Type> getAll(){
        try {
            return typeDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
