<%--
  Created by IntelliJ IDEA.
  User: emin
  Date: 18-2-26
  Time: 下午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>消息生产者</title>


    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <form class="form-signin" role="form"  action="Send" method="POST">
        <h2 class="form-signin-heading">消息框</h2>
        <input type="text" class="form-control"    name = "message"   placeholder="发送消息" required autofocus>

        <button class="btn btn-lg btn-primary btn-block" type="submit">发送</button>
    </form>
</div>
</body>
</html>
</html>
