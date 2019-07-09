<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-25
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/bootstrap/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script language="JavaScript" src="js/usersa.js"></script>
</head>
<body>
<%--数据显示表格--%>
<table id="showUsers"></table>
<%--RUD工具栏--%>
<div id="rudToolBar">
    <c:if test="${sessionScope.adminInfo.id==1}">
        <a href="javascript:openDialog('addDialog','添加用户')" class="easyui-linkbutton" iconCls="icon-add"
           plain="true">添加</a>
        <a href="javascript:updateButton()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteUsers()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </c:if>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    用户名:<input type="text" name="name" id="name" style="width: 100px">
    &nbsp;&nbsp;&nbsp;&nbsp;
    联系方式:<input type="number" name="telephone" id="telephone" style="width: 100px">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
</div>
    <%--添加窗口--%>
    <div id="addDialog" buttons="#addButtons">
            <%--表单--%>
        <form id="addSubmit" method="post">
            <table align="center" style="margin-top: 30px">
                <tr>
                    <td>用户名称:</td>
                    <td><input type="text" class="easyui-validatebox" required name="name"/></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                    <td><input type="text" class="easyui-validatebox" required name="password"/></td>
                </tr>
                <tr>
                    <td>联系方式:</td>
                    <td>
                        <input type="text" class="easyui-validatebox" required name="telephone"/>
                        <input type="hidden" class="easyui-validatebox" required name="isadmin" value="1"/>
                    </td>
                </tr>
            </table>
        </form>
            <%--按钮--%>
        <div id="addButtons" align="center" style="padding-right: 100px">
            <a href="javascript:addSaveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
            <a href="javascript:closeDialog('addDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
        </div>
    </div>
    <%--修改窗口--%>
    <div id="updateDialog" buttons="#updateButtons">
            <%--表单--%>
        <form id="updateSubmit" method="post">
            <table align="center" style="margin-top: 30px">
                <tr>
                    <td>用户名称:</td>
                    <td>
                        <input type="text" class="easyui-validatebox" required name="name"/>
                        <input type="hidden" class="easyui-validatebox" required name="id"/>
                    </td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                    <td><input type="text" class="easyui-validatebox" required name="password" id="upassword"/></td>
                </tr>
                <tr>
                    <td>联系方式:</td>
                    <td><input type="text" class="easyui-validatebox" required name="telephone"/></td>
                </tr>
            </table>
        </form>
            <%--按钮--%>
        <div id="updateButtons" align="center" style="padding-right: 100px">
            <a href="javascript:updateSaveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
            <a href="javascript:closeDialog('updateDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
        </div>
    </div>
</body>
</html>
