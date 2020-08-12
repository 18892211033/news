package com.isoft.test;

import com.isoft.bean.User;
import com.isoft.dao.UserDao;
import com.isoft.dao.impl.UserDaoImpl;
import com.isoft.service.UserService;
import com.isoft.service.impl.UserServiceImpl;
import com.isoft.util.DateUtil;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserServiceImpl();
/*      System.out.println(userDao.nameExists("王思桐"));  //测试dao第一个方法   */

/*      System.out.println(userDao.getUser("王思桐","123qwe"));    //测试dao第二个方法
        System.out.println(userDao.getUser("王思桐1","123qwe"));  */
/*      System.out.println(userDao.add(new User("李四2","123ASD","13072209723",null)));*/
/*      System.out.println(userService.loginCheck("李四","123ASD"));  //service登录验证
        System.out.println(userService.loginCheck("李四","123ASD"));
        System.out.println(userService.loginCheck("李四1","123ASD"));
        System.out.println(userService.loginCheck("李四","123ASD1"));*/
   //   System.out.println(userService.register(new User("圆圆3","123asd","18892211034", DateUtil.Str2Date("2020-02-02"))));
/*      System.out.println(userService.nameCheck("圆圆"));
        System.out.println(userService.nameCheck("圆圆2"));*/
        /*userService.updatePass(13 , "11111111");
        userService.updateMobile(13,"122121212");*/
    }
}
