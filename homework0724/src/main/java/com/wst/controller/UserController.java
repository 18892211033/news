package com.wst.controller;

import com.wst.bean.ResponseData;
import com.wst.service.UserService;
import com.wst.entity.Users;
import com.wst.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService = new UserServiceImpl();
    Users u = new Users();


    @GetMapping
    public ResponseData login(String name ,String password) throws IOException {
        Map<String , Object> map = userService.loginCheck(name , password);
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
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(errCode);
        responseData.setMsg(errCode == 0 ? "登录成功" : "登录失败-密码或用户名不正确");
        responseData.setData(map.get(UserService.USER_KEY));
        return responseData;
    }
    @PostMapping
    public ResponseData register(String name ,String password) throws IOException {
        u.setName(name);
        u.setPassword(password);
        userService.register(u);
        ResponseData responseData = new ResponseData();
        int errCode = 0;
        if(userService.register(u) < 0){
            errCode = -1;
        }
        responseData.setErrCode(errCode);
        responseData.setMsg(errCode == 0 ? "注册成功":"注册失败(用户名已存在)");
        responseData.setData(u);
        return responseData;
    }
    @PutMapping
    public ResponseData updateU(@RequestBody Users users) throws IOException {
        System.out.println(users);
        userService.updateUser(users);
        System.out.println(users);
        ResponseData responseData = new ResponseData();
        int errCode = 0;
        responseData.setErrCode(errCode);
        responseData.setMsg(errCode == 0 ? "修改成功":"修改失败");
        responseData.setData(users);
        return responseData;
    }
}
