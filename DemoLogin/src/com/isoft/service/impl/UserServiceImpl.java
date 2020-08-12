package com.isoft.service.impl;

import com.isoft.bean.User;
import com.isoft.dao.UserDao;
import com.isoft.dao.impl.UserDaoImpl;
import com.isoft.service.UserService;
import com.mysql.cj.util.StringUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public Map<String, Object> loginCheck(String name, String pass) {
        if (StringUtils.isEmptyOrWhitespaceOnly(name) || StringUtils.isEmptyOrWhitespaceOnly(pass)){
            return null ;
        }
        User user = null ;
        int code ;
        Map<String , Object> map = new HashMap<>();
        try {
            int nameCount = userDao.nameExists(name);
            if (nameCount < 1){    //账号不存在
                code = USER_CODE_NAME_NOEXEIST ;
            }else {      //账号存在
                user = userDao.getUser(name ,pass);
                if (null == user){    //密码错误
                    code = USER_PASS_ERRO ;
                }else {
                    code = USER_CODE_EXIST ;
                }
            }
            map.put(USER_KEY , user);
            map.put(USER_CODE, code);
            return  map;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public User register(User user) {
        if(null == user || StringUtils.isEmptyOrWhitespaceOnly(user.getName()) || StringUtils.isEmptyOrWhitespaceOnly(user.getPass())){
            return null;
        }
        try {
            int nameC = userDao.nameExists(user.getName());
            if (nameC > 0){
                return null;
            }
            int r = userDao.add(user);
            if (r > 0){
                return userDao.getUser(user.getName() , user.getPass());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean nameCheck(String name) {
        if (StringUtils.isEmptyOrWhitespaceOnly(name)){
            return false;
        }
        try {
            return userDao.nameExists(name) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(String pass, String mobile,int id) throws SQLException {
        if(id < 0) {
            return false ;
        }
        User u = new User() ;
        u.setId(id);
        u.setPass(pass);
        u.setMobile(mobile);
        return userDao.updateUser(u) > 0;
    }

    @Override
    public Boolean namecheck(String name) throws SQLException {
        User user = new User();
        int nameEorN = userDao.nameExists(user.getName());
        if(nameEorN > 0){
            return true;
        }
        return false;
    }

    /*@Override
    public boolean updatePass(int id, String pass) throws SQLException {
        if(id < 0) {
            return false ;
        }
        User u = new User() ;
        u.setId(id);
        u.setPass(pass);
        return userDao.updateUser(u) > 0;
    }

    @Override
    public boolean updateMobile(int id, String mobile) throws SQLException {
        if(id < 0) {
            return false ;
        }
        User u = new User() ;
        u.setId(id);
        u.setMobile(mobile);
        return userDao.updateUser(u) > 0;
    }*/
}
