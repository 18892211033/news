//package com.wst.service;
//
//import com.wst.dao.UserDao;
//import com.wst.db.DBSqlSession;
//import com.wst.entity.Users;
//
//public class UserService {
//    UserDao userDao;
//    public UserService(){
//        userDao = DBSqlSession.getInstance(null).getSqlSession().getMapper(UserDao.class);
//    }
//    public Users checkUser(Users users){
//        Users u = new Users();
//        userDao.checkUser(u.getId(),u.getPassword());
//    }
//}
