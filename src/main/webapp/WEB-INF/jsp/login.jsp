<%--
  Created by IntelliJ IDEA.
  User: CYQ
  Date: 2019/4/11
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%

    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);

%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>在线尝试 Bootstrap 实例</title>
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <%--<head>--%>
        <%--<title>登录页面</title>--%>
        <%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>--%>
        <%--<link href="${contextPath}/static/bootstrap-4.3.1/css/bootstrap.css" rel="stylesheet">--%>
        <%--<script type="text/javascript" src="${contextPath}/static/bootstrap-4.3.1/js/bootstrap.js"></script>--%>
    <%--</head>--%>
    <body>
        <form role="form">
            <div class="form-group">
                <label for="name">名称</label>
                <input type="text" class="form-control" id="name"
                       placeholder="请输入名称">
            </div>
            <div class="form-group">
                <label for="inputfile">文件输入</label>
                <input type="file" id="inputfile">
                <p class="help-block">这里是块级帮助文本的实例。</p>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> 请打勾
                </label>
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </body>
</html>
