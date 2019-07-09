<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-25
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script language="JavaScript" src="js/users.js"></script>
</head>
<body>
<%--数据显示表格--%>
<table id="showUsers"></table>
<%--RUD工具栏--%>
<div id="rudToolBar">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    用户名:<input type="text" name="name" id="name" style="width: 100px">
    &nbsp;&nbsp;&nbsp;&nbsp;
    联系方式:<input type="number" name="telephone" id="telephone" style="width: 100px">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
</div>
</body>
</html>
