<%--
  Created by IntelliJ IDEA.
  User: XZZ
  Date: 2020/7/23
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>获取Controller数据</h3>
    <p>姓名:<%=request.getAttribute("name")%></p>
    <p>城市:<%=request.getAttribute("city")%></p>
    <p><hr/></p>
    <p>信息:<%=request.getAttribute("info")%></p>
    <p>时间:<%=request.getAttribute("dt")%></p>
    <p><hr/></p>
<%--    <p>对象:<%=request.getAttribute("girlfriend")%></p>
    <p>存款:<%=request.getAttribute("money")%></p>--%>
</body>
</html>
