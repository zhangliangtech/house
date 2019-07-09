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
    <title>房型</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/bootstrap/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script language="JavaScript" src="js/type.js"></script>
</head>
<body>
<%--数据显示表格--%>
<table id="showTypes"></table>
<%--RUD工具栏--%>
<div id="rudToolBar">
    <a href="javascript:openDialog('addDialog','添加房型')" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:updateButton()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:deleteTypes()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">批量删除</a>
</div>
<%--添加窗口--%>
<div id="addDialog" buttons="#addButtons">
    <%--表单--%>
    <form id="addSubmit" method="post">
        <table align="center" style="margin-top: 50px">
            <tr>
                <td>房屋类型:</td>
                <td><input type="text" class="easyui-validatebox" required name="name"/></td>
            </tr>
        </table>
    </form>
    <%--按钮--%>
    <div id="addButtons" align="center" style="padding-right: 100px">
        <a href="javascript:addSaveType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:closeDialog('addDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
</div>
<%--修改窗口--%>
<div id="updateDialog" buttons="#updateButtons">
    <%--表单--%>
    <form id="updateSubmit" method="post">
        <table align="center" style="margin-top: 50px">
            <tr>
                <td>房屋类型:</td>
                <td>
                    <input type="text" class="easyui-validatebox" required name="name"/>
                    <input type="hidden" class="easyui-validatebox" required name="id"/>
                </td>
            </tr>
        </table>
    </form>
    <%--按钮--%>
    <div id="updateButtons" align="center" style="padding-right: 100px">
        <a href="javascript:updateSaveType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:closeDialog('updateDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
</div>
</body>
</html>
