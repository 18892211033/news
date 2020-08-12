package com.isoft.servlet;

import com.isoft.bean.ResponseData;
import com.isoft.bean.User;
import com.isoft.util.DateUtil;
import com.isoft.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/json/test")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date now = new Date();
        Map<String, Object> map = new HashMap<>();
        map.put("uname","eason");
        map.put("role","普通用户");
        map.put("logindt",now);
        map.put("lang", new String[]{"c","c++","java"});
        System.out.println(JsonUtil.obj2Json(DateUtil.date2Str(now)));
        System.out.println(JsonUtil.obj2Json(map));
        User u1 = new User("张三","123","18892211033",DateUtil.Str2Date("2020-02-02 10:10:10"));
        User u2 = new User("张四","123","18892211033",DateUtil.Str2Date("2020-02-02 10:10:11"));
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        System.out.println(JsonUtil.obj2Json(list));

        ResponseData res = new ResponseData();
        res.setErrCode(0);
        res.setMsg("注册成功");
        res.setData(list);
        System.out.println(JsonUtil.obj2Json(res));
    }
}
