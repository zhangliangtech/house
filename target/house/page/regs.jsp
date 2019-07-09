<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><TITLE>青鸟租房 - 用户注册</TITLE>
    <meta content="text/html; charset=utf-8" http-equiv=Content-Type>
    <link rel=stylesheet type=text/css href="../css/style.css">
    <link rel=stylesheet type=text/css href="../css/mystyle.css">
    <meta name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script type="text/javascript" src="../admin/js/jquery-1.8.3.js"></script>
    <script language="JavaScript">
        $(function () {
            $("span").css("font-size", "14px");
            $("#userName").blur(function () {
                $.post("checkUser", {name: $("#userName").val()}, function (data) {
                    if (data.result) {
                        $("#uname").html("用户名已存在").css("color", "red");
                        $("#userName").focus();
                    } else if ($("#userName").val() == "") {
                        $("#uname").html("")
                    } else {
                        $("#uname").html("✔验证通过").css("color", "green");
                    }
                }, "json");
            });
            $("#password").blur(function () {
                if ($("#password").val() == "") {
                    $("#upwd").html("")
                } else {
                    $("#upwd").html("✔验证通过").css("color", "green");
                }
            });

            $("#repeatPassword").blur(function () {
                if ($("#repeatPassword").val() == "") {
                    $("#rpwd").html("")
                } else if ($("#repeatPassword").val() != $("#password").val()) {
                    $("#rpwd").html("密码输入不一致").css("color", "red");
                    $("#repeatPassword").focus();
                } else {
                    $("#rpwd").html("✔验证通过").css("color", "green");
                }
            });
            $("#telephone").blur(function () {
                if ($("#telephone").val() == "") {
                    $("#tel").html("");
                } else {
                    $("#tel").html("✔验证通过").css("color", "green");
                }
            });
            setTimeout(showMessage, 2000);
        });

        function registerButton() {
            if ($("#userName").val() == "") {
                $("#userName").focus();
            } else if ($("#password").val() == "") {
                $("#password").focus();
            } else if ($("#repeatPassword").val() == "" || $("#repeatPassword").val() != $("#password").val()) {
                $("#repeatPassword").focus();
            } else if ($("#telephone").val() == "") {
                $("#telephone").focus();
            } else {
                $("#registerForm").submit();
            }
        }

        function showMessage() {
            $("#showMessage").css("display", "none");
        }
    </script>

</head>
<body>
<div id=header class=wrap>
    <div id=logo><img src="../images/logo.png" width="200px" onclick="location.href='goList'" class="logo"></div>
    <div class=search>
        <input class="button_class" onclick="location.href='login.jsp'" value="登 陆" type=button name=search>
    </div>
</div>
<header style="height: 50px;background-color: #00acaf;margin:0 auto"></header>
<div id=regLogin class=wrap>
    <div class=dialog>
        <dl class=clearfix>
            <dt>新用户注册</dt>
            <dd class=past>填写个人信息</dd>
        </dl>
        <div class=box>
            <form action="registerUser" id="registerForm" method="post">
                <div class=infos>
                    <table class=field>
                        <tr>
                            <td class=field>用&nbsp;&nbsp;户&nbsp;名：</td>
                            <td>
                                <input class=text type=text name=name placeholder="请输入用户名" id="userName">
                                <span id="uname"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class=field>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                            <td>
                                <input class=text type=password name=password placeholder="请输入密码" id="password">
                                <span id="upwd"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class=field>确认密码：</td>
                            <td>
                                <input class=text type=password name=repassword placeholder="请确认密码" id="repeatPassword">
                                <span id="rpwd"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class=field>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
                            <td>
                                <input class=text type=text name=telephone placeholder="请输入联系方式" id="telephone">
                                <span id="tel"></span>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input value=立即注册 type=button id="loginButton" class="button_class" onclick="registerButton()">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input value=去登录 type=button  class="button_class"  onclick="location.href='login.jsp'" >
                            </td>
                        </tr>
                    </table>
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
