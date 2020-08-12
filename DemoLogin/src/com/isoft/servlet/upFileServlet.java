package com.isoft.servlet;

import com.isoft.bean.ResponseData;
import com.isoft.util.FileUtil;
import com.isoft.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/file/upload")
public class upFileServlet extends HttpServlet {
    private static final String UP_PATH = "userphoto" ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Map<String , String> map = FileUtil.fileFormData(request , response , UP_PATH) ;
        System.out.println(map);
        String fname = map.get(FileUtil.KEY_FILE) ;
        ResponseData responseData = new ResponseData() ;
        responseData.setErrCode(fname == null ? -1 : 0);
        responseData.setMsg(fname == null ? "上传失败!" : "上传成功！");
        responseData.setData(fname);
        System.out.println(JsonUtil.obj2Json(responseData));
        response.getWriter().print(JsonUtil.obj2Json(responseData));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileUtil.url(request ,"userphoto" , "a.jpg") ;
        doPost(request , response);
    }
}
