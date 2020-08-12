package com.isoft.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

@Controller
@RequestMapping("/file")
public class FileController {
    @Value("${download.path}")
    String downPath ;
    @RequestMapping("download/{fid}")
    public void download(@PathVariable("fid") String fileId , HttpServletRequest request , HttpServletResponse response) throws Exception {
        String fileName = "test下载.rar" ;
        //获取下载文件输入流
        InputStream fis = FileController.class.getClassLoader().getResourceAsStream(downPath+ File.separator+fileName);
        System.out.println(downPath+ File.separator+fileName);

        //通知浏览器以下载的方式响应请求资源
        //a.Content-Type 设置文件媒体格式
        response.setContentType(request.getServletContext().getMimeType(fileName));
        //查看请求头"User-Agent"以获取浏览器类型，并设置链接的编码方式
        String header=request.getHeader("User-Agent");

        Base64.Encoder encoder = Base64.getEncoder();
        if(header.contains("firefox")){
            fileName="=?utf-8?"+encoder.encodeToString(fileName.getBytes("utf-8"))+"?=";
        }else{
            fileName= URLEncoder.encode(fileName,"utf-8");
        }

        //b.Content-Disposition 设置要被下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename="+fileName);
        //获取输出流
        ServletOutputStream sos=response.getOutputStream();
        //设置缓冲区
        byte []buffer = new byte[2048];
        int len=0;
        while((len=fis.read(buffer))!=-1){
            sos.write(buffer,0,len);
        }
        fis.close();
        System.out.println("over");
    }
}
