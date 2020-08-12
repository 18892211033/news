package com.isoft.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {
    // 上传配置
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 4; // 4MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 10; // 10MB
    public static final String KEY_FILE = "upfile" ;
    public static Map<String , String> fileFormData(HttpServletRequest request , HttpServletResponse response , String path) {
        String fileName = null ;
        Map<String , String> map = new HashMap<>() ;
        // 获取文件上传的绝对物理路径
        String upPath = request.getServletContext().getRealPath("/") + File.separator + path ;
//        System.out.println(upPath);
        // 如果目录不存在，则创建目录
        File uploadDirectory = new File(upPath) ;
        if(! uploadDirectory.exists()) {
            uploadDirectory.mkdirs() ;
        }
        // 文件上传配置
        DiskFileItemFactory factory = new DiskFileItemFactory() ;
        ServletFileUpload upload = new ServletFileUpload(factory) ;
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");

        // 上传内容解析
        try {
            // 获取所有表单提交数据：文件内容+普通文本
            List<FileItem> formItems = upload.parseRequest(request) ;
            if(null != formItems && formItems.size() > 0) {
                // 迭代处理表单数据
                for(FileItem item : formItems) {
                    if(item.isFormField()) {  // 普通表单元素
                        map.put(item.getFieldName() , item.getString("UTF-8")) ;
                    } else {  // 文件域
                        String oriName = item.getName() ;
                        String extName = oriName.substring(oriName.lastIndexOf(".")) ;
                        fileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + extName ;
                        String fileFullName = upPath + File.separator + fileName ;
                        item.write(new File(fileFullName));
                        map.put(KEY_FILE , url(request , path , fileName)) ;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map ;
    }

    /**
     * 将参数路径+文件名字映射一个网络绝对url : http:// ....
     * @param path
     * @param fileName
     * @return
     */
    public static String url(HttpServletRequest request , String path , String fileName) {
        path = path == null ? "" : path ;
        String protocol = request.getProtocol() ;  // HTTP/1.1
        protocol = protocol.substring(0 , protocol.indexOf("/")) ;
        String url = protocol + "://" +
                request.getServerName() + ":" +
                request.getServerPort() + "/" +
                request.getContextPath() + "/" +
                path + "/" + fileName ;
        System.out.println(url);
        return url;
    }
    /**
     * 改变文件名编码格式，避免中文乱码
     */
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if(null == agent) {
            return URLEncoder.encode(filename, "utf-8") ;
        }
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

    public static void downFile(HttpServletRequest request, HttpServletResponse response, String download, String filename) {
    }
}
