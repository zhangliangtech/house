﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head><TITLE>青鸟租房 - 用户登录</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <link rel=stylesheet type=text/css href="../css/style.css">
    <link rel=stylesheet type=text/css href="../css/mystyle.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script type="text/javascript" src="../admin/js/jquery-1.8.3.js"></script>
    <script language="JavaScript">
        $(function () {
            $("#loginButton").click(function () {
                if ($("#user_name").val() == "") {
                    $("#user_name").focus();
                } else if ($("#user_password").val() == "") {
                    $("#user_password").focus();
                } else {
                    $("#user").submit();
                }
            });
            setTimeout(showMessage, 2000);
        });

        function showMessage() {
            $("#showMessage").css("display", "none");
        }
    </script>
</head>
<body>
<div id=header class=wrap>
    <div id=logo><img src="../images/logo.png" width="200px" onclick="location.href='goList'" class="logo"></div>
    <div class=search>
        <input class="button_class" onclick="location.href='regs.jsp'" value="注 册" type=button name=search>
    </div>
</div>
<header style="height: 50px;background-color: #00acaf;margin:0 auto"></header>
<div id=regLogin class=wrap>
    <div class=dialog>
        <div class=box>
            <H4>用户登录</H4>
            <form id=user method=post name=user action="loginUser">
                <div class=infos>
                    <table class=field>
                        <tr>
                            <td colSpan=2></td>
                        </tr>
                        <tr>
                            <td class=field>用&nbsp;&nbsp;&nbsp;&nbsp;户：</td>
                            <td>
                                <input id=user_name class=text type=text name=name placeholder="输入用户名">
                            </td>
                        </tr>
                        <tr>
                            <td class=field>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                            <td>
                                <input id=user_password class=text type=password name=password placeholder="输入密码">
                            </td>
                        </tr>
                        <tr>
                            <td class="field">验 证 码：</td>
                            <td><input type="text" class="text verycode" name="veryCode" placeholder="输入验证码"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input value=登陆 type=button id="loginButton" class="button_class">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input value=注册 type=button  class="button_class"  onclick="location.href='regs.jsp'" >
                            </td>
                        </tr>
                    </table>
                    <div >

                    </div>
                </div>
            </form>
        </div>
    </div>
    <div align="center" style="height: 15px;margin-top: 10px;font-size: 15px">
        <span id="showMessage">${registerInfo}</span>
    </div>
</div>

<div id=footer class=wrap>
    <dl>
        <dt>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</html>
