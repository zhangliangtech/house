<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-07-01
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="js/jquery.easyui.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="dropdown-header">
        <img src="images/logo.gif">
    </div>
    <div class="container" style="width: 300px">
        <form role="form">
            <div class="form-inline">
                用&nbsp;&nbsp;&nbsp;户:<input type="text" class="form-control" id="name"  placeholder="请输入名称">
            </div>
            <div class="form-inline">
                密&nbsp;&nbsp;&nbsp;码:<input type="password" class="form-control" id="name"  placeholder="请输入名称">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> 请打勾
                </label>
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>

    </div>

</div>

</body>
</html>
