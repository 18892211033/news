package com.isoft.servlet;


import com.isoft.bean.ResponseData;
import com.isoft.bean.User;
import com.isoft.service.UserService;
import com.isoft.service.impl.UserServiceImpl;
import com.isoft.util.DateUtil;
import com.isoft.util.FileUtil;
import com.isoft.util.JsonUtil;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@WebServlet("/user/Reg-Log")
public class RegLogServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String param = request.getParameter("param");
        if (StringUtils.isEmptyOrWhitespaceOnly("param")){
            response.sendRedirect(request.getContextPath() + "/Register.html");
        }
        switch (param.toLowerCase()){
            case "login":
                login(request, response);
                break;
            case "register":
                register(request, response);
                break;
            case "remake":
                try {
                    remake(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "yanzheng" :
                try {
                    yanzheng(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    private void yanzheng(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("textml; charset=utf-8");
        String name=request.getParameter("name");
        int errCode=-1;
        Boolean a=userService.namecheck(name);//输出王宇，false
        System.out.println(a);
        if (a=true){
            System.out.println("用户名已经存在了");
        }else{
            System.out.println("用户名可以注册");
            errCode=0;
        }
        System.out.println("errCode="+errCode);
        response.getWriter().print(errCode);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("logname");
        String pass = request.getParameter("logpass");
        Map<String , Object> map = userService.loginCheck(name , pass);
        int errCode = (Integer)map.get(UserService.USER_CODE);
        String errMsg = "";
        switch (errCode){
            case UserService.USER_CODE_EXIST :
                errMsg = "登陆成功";
                break;
            case UserService.USER_CODE_NAME_NOEXEIST:
                errMsg = "账号不存在";
                break;
            case UserService.USER_PASS_ERRO:
                errMsg = "密码错误";
                break;
        }
        ResponseData data = new ResponseData();
        data.setErrCode(errCode);
        data.setMsg(errCode == 0 ? "登录成功" : "登录失败-密码或用户名不正确");
        data.setData(map.get(UserService.USER_KEY));
        response.getWriter().print(JsonUtil.obj2Json(data));
    }
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("regname");
        String pass = request.getParameter("regpass");
        String mobile = request.getParameter("regmobile");
        String birthday = request.getParameter("regbirthday");
        User u = new User(name,pass,mobile, DateUtil.Str2Date(birthday));
        u = userService.register(u);
        int errCode = 0;
        if(null == u){
            errCode = -1;
        }
        System.out.println(u);
        ResponseData data = new ResponseData();
        data.setErrCode(errCode);
        data.setMsg(errCode == 0 ? "注册成功":"注册失败(用户名已存在)");
        data.setData(u);
        response.getWriter().print(JsonUtil.obj2Json(data));
    }
    private void remake(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String id = request.getParameter("reid");
        System.out.println(id);
        String name = request.getParameter("rename");
        System.out.println(name);
        String pass = request.getParameter("repass");
        String mobile = request.getParameter("remobile");
        String birthday = request.getParameter("rebirthday");
        User u = new User();
        u.setId(Integer.parseInt(id));
        u.setPass(pass);
        u.setMobile(mobile);
        u.setBirthday(DateUtil.Str2Date2(birthday));
        u.setName(name);
        /*userService.updatePass(Integer.parseInt(id),pass);
        userService.updateMobile(Integer.parseInt(id),mobile);*/
        userService.updateUser(pass, mobile,Integer.parseInt(id));
        ResponseData data = new ResponseData();
        int errCode = 0;
        data.setErrCode(errCode);
        data.setMsg(errCode == 0 ? "修改成功":"修改失败");
        data.setData(u);
        response.getWriter().print(JsonUtil.obj2Json(data));
    }
}