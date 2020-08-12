package com.isoft.servlet;

import com.isoft.bean.ResponseData;
import com.isoft.entity.News;
import com.isoft.entity.Type;
import com.isoft.service.NewsService;
import com.isoft.util.JsonUtil;
import com.isoft.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    NewsService newsService;

    @Override
    public void init() throws ServletException {
        super.init();
        newsService = new NewsService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String param = request.getParameter("param");
        if (StringUtil.isEmpty(param)){
            response.sendRedirect(request.getContextPath()+"/show.html");
            return;
        }
        switch (param.toLowerCase()){
            case "top":
                top5(request, response);
                break;
            case "bytype":
                getByTypeid(request, response);
                break;
            case "byid" :
                getById(request, response);
                break;
            case"getallbytypeid":
                getAllByTypeId(request, response);
        }
    }
    protected void top5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> list = newsService.getTopN();
        int errCode = (null == list || list.size() ==0 ? -1 : 0 );
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(errCode);
        responseData.setMsg(errCode == 0 ? "成功" : "请求失败");
        responseData.setData(list);
        response.getWriter().print(JsonUtil.obj2Json(responseData));
    }
    protected void getByTypeid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newsId = request.getParameter("newsId");
        int id = 0;
        if (null != newsId){
            try {
                id = Integer.parseInt(newsId);
            }catch (Exception e){
                response.sendRedirect(request.getContextPath()+"/show.html");
                return;
            }
        }
        News news = newsService.getById(id);
        int errCode = (news==null) ? -1: 0;
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(errCode);
        responseData.setMsg(errCode == 0 ? "成功" : "请求失败");
        responseData.setData(news);
        response.getWriter().print(JsonUtil.obj2Json(responseData));
//        System.out.println(JsonUtil.obj2Json(responseData));
    }
    protected void getAllByTypeId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        System.out.println(typeId);
        int id =0;
        if (null != typeId){
            try {
                id = Integer.parseInt(typeId);
            }catch (Exception e){
                response.sendRedirect(request.getContextPath()+"/show.html");
                return;
            }
        }
        List<News> list = newsService.getAllByTypeId(id);
        int errCode = (typeId==null) ? -1: 0;
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(errCode);
        responseData.setMsg(errCode == 0 ? "成功" : "请求失败");
        responseData.setData(list);
        response.getWriter().print(JsonUtil.obj2Json(responseData));
//        System.out.println(JsonUtil.obj2Json(responseData));
    }
}
