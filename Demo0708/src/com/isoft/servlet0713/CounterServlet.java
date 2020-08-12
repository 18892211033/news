package com.isoft.servlet0713;

import com.isoft.bean.ResponseData;
import com.isoft.util.JsonUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        ServletContext application = request.getServletContext();
        Object obj = application.getAttribute("total");
        Object obj2 = application.getAttribute("online");
        Map<String , Object> map = new HashMap<>();
        map.put("total" , obj);
        map.put("online" , obj2);
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(0);
        responseData.setMsg("请求成功");
        responseData.setData(map);
        response.getWriter().print(JsonUtil.obj2Json(responseData));

    }
}
