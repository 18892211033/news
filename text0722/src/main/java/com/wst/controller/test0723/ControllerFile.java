package com.wst.controller.test0723;

import com.wst.bean.ResponseData;
import com.wst.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.wst.util.FileUtil.getFileName;

@Controller
@RequestMapping("/file")
public class ControllerFile {
    @PostMapping("upload")
    @ResponseBody
    public ResponseData upFile(Integer uid , @RequestParam("userphoto") MultipartFile file , HttpServletRequest request ){
        if (null == file){
            return new ResponseData(-1 , "上传文件为空" , null);
        }
        //处理文件名
        String oriFilename = file.getOriginalFilename();
        String extName = oriFilename.substring(oriFilename.lastIndexOf("."));
        //文件新名字
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + "_" + uid +extName ;
        //文件路径
        String path = "userphoto/";
        //保存文件
            //路径检测
        ServletContext application = request.getServletContext();
        String absPath = application.getRealPath("/" + path);
        File tempF = new File(absPath);
        if (! tempF.exists()){
            tempF.mkdirs();
        }
            //IO流保存文件
        boolean r = false;
        FileOutputStream fos =null ;
        try {
            fos = new FileOutputStream(tempF + File.separator + newFileName);
            InputStream fis = file.getInputStream();
            byte[] buffer = new byte[1024 * 8];
            int len ;
            while ((len = fis.read(buffer , 0 ,buffer.length)) != -1){
                fos.write(buffer , 0 , len);
            }
            fos.flush();
            r = true ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fos){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                fos = null;
            }
        }
        //保存成功后，处理文件的绝对url
        String photoUrl = null ;
        if (r){
            photoUrl = FileUtil.url(request , path ,newFileName);
            //更改数据库
        }
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(r ? 0 : -1);
        responseData.setMsg(r ? "上传成功" : "上传失败");
        responseData.setData(photoUrl);
        return responseData;
    }
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename=request.getParameter("fname");
        System.out.println(filename);
        FileUtil.downFile(request , response , "download" , filename);
    }
}
