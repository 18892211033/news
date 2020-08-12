package com.isoft.servlet0713;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/file/upload1")
public class FileServlet extends HttpServlet {
    private static final String UP_PATH = "userphoto" ;
    // 上传配置
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 4; // 4MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 10; // 10MB
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = null ,uname = null ,fileName = null;
        // 获取文件上传的绝对物理路径
        String upPath = request.getServletContext().getRealPath("/") + File.separator + UP_PATH;
//        System.out.println(upPath);
        // 如果目录不存在，则创建目录
        File uploadDirectory = new File(upPath);
        if (! uploadDirectory.exists()){
            uploadDirectory.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");

        try {
            List<FileItem> formItems = upload.parseRequest(request);
            if (null != formItems && formItems.size() > 0){
                for (FileItem item : formItems) {
                    System.out.println(item + "<br/>");
                    if (item.isFormField()){
                        switch (item.getFieldName()){
                            case "userid" :
                                uid = item.getString("UTF-8");
                                break;
                            case "username" :
                                uname = item.getString("UTF-8");
                                break;
                        }
                    }else {
                        String oriName = item.getName();
                        String extName = oriName.substring(oriName.lastIndexOf("."));
                        fileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + extName;
                        String fileFullName = upPath + File.separator + fileName;
                        try {
                            item.write(new File(fileFullName));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("save ok----------------" + fileFullName);
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        System.out.println(uid + "--------------" + uname);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
