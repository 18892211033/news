package com.isoft.servlet;

import com.isoft.bean.ResponseData;
import com.isoft.entity.Type;
import com.isoft.service.TypeService;
import com.isoft.util.JsonUtil;
import com.isoft.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newstype")
public class TypeServlet extends HttpServlet {
    TypeService typeService;

    @Override
    public void init() throws ServletException {
        super.init();
        typeService = new TypeService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Type> list = typeService.getAll();
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(0);
        responseData.setMsg("请求成功");
        responseData.setData(list);
        response.getWriter().print(JsonUtil.obj2Json(responseData));
    }
}

