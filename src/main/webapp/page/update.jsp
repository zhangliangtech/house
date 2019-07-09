﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head><TITLE>青鸟租房 -修改房屋信息</TITLE>
    <meta content="text/html; charset=utf-8" http-equiv=Content-Type>
    <link rel=stylesheet type=text/css href="../css/style.css">
    <link rel=stylesheet type=text/css href="../css/mystyle.css">
    <meta name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script type="text/javascript" src="../admin/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../admin/js/jquery.form.js"></script>
    <script language="JavaScript">
        $(function () {
            $("#districtId").change(function () {
                $.post("getAllStreetById", {"id": $(this).val()}, function (data) {
                    $("#streetId>option:gt(0)").remove();
                    for (var i in data) {
                        var node = $("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                        $("#streetId").append(node);
                    }
                }, "json");
            });
            $("#upImage").change(function () {
                $("#up_action").ajaxSubmit({
                    url: 'uploadImage',
                    type: 'post',
                    success: function (data) {
                        $("#path").val(data);
                        $("#showImage").attr("src", "http://localhost:80/" + data);
                    }
                });
            });

            $("#updateButton").click(function () {
                if ($("#title").val() == "") {
                    $("#title").focus();
                } else if ($("#typeId").val() == "") {
                    $("#typeId").focus();
                } else if ($("#floorage").val() == "") {
                    $("#floorage").focus();
                } else if ($("#price").val() == "") {
                    $("#price").focus();
                } else if ($("#pubdate").val() == "") {
                    $("#pubdate").focus();
                } else if ($("#districtId").val() == "") {
                    $("#districtId").focus();
                } else if ($("#streetId").val() == "") {
                    $("#streetId").focus();
                } else if ($("#up_image").val() == "") {
                    $("#up_image").focus();
                } else if ($("#contact").val() == "") {
                    $("#contact").focus();
                } else if ($("#description").val() == "") {
                    $("#description").focus();
                } else {
                    $("#up_action").submit();
                }
            });
        });

    </script>
</head>
<body>
<div id=header class=wrap>
    <div id=logo><img src="../images/logo.png" width="200px" onclick="location.href='goList'" class="logo"></div>
    <div class=search>
        <input class="button_class" onclick="location.href='logout'" value="退 出" type=button name=search>
        <input class="button_class" onclick="location.href='goRecycle'" value="回收站" type=button name=search>
    </div>
</div>
<header style="height: 50px;background-color: #00acaf;margin:0 auto"></header>
<div id=regLogin class=wrap>
    <div class=dialog>
        <dl class=clearfix>
            <dt>房屋信息修改</dt>
            <dd class=past>更改房屋信息</dd>
        </dl>
        <div class=box>
            <form id=up_action method=post name=add.action action="updateHouse" enctype="multipart/form-data">
                <div class=infos>
                    <table class=field>
                        <tr>
                            <td class=field>标　　题：</td>
                            <td>
                                <input id=title class=text type=text name=title value="${house.title}">
                                <input id="id" class=text type=hidden name="id" value="${house.id}">
                            </td>
                        </tr>
                        <tr>
                            <td class=field>户　　型：</td>
                            <td>
                                <select class=text id="typeId" name=typeId style="text-align-last: center">
                                    <c:forEach items="${types}" var="type">
                                        <option value="${type.id}"
                                                <c:if test="${house.typeId==type.id}">selected</c:if>>${type.name}
                                        </option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                        <tr>
                            <td class=field>面　　积：</td>
                            <td><input id=floorage class=text type=number
                                       name=floorage value="${house.floorage}"></td>
                        </tr>
                        <tr>
                            <td class=field>价　　格：</td>
                            <td><input id=price class=text type=number name=price value="${house.price}"></td>
                        </tr>
                        <tr>
                            <td class=field>发布日期：</td>
                            <td><input class=text id="pubdate" type=date name=pubdate
                                       value="<fmt:formatDate pattern="yyyy-MM-dd" value="${house.pubdate}"/>"></td>
                        </tr>
                        <tr>
                            <td class=field>位　　置：</td>
                            <td>区:
                                <select class=text name=districtId id="districtId" style="text-align-last: center">
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${districts}" var="d">
                                        <option value="${d.id}"
                                                <c:if test="${d.id==house.districtId}">selected</c:if>>${d.name}
                                        </option>
                                    </c:forEach>
                                </select>
                                　街:
                                <select class=text name=streetId id="streetId" style="text-align-last: center">
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${allStreetById}" var="t">
                                        <option value="${t.id}"
                                                <c:if test="${t.id==house.streetId}">selected</c:if>>${t.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class=field>图　　片：</td>
                            <td><input id=upImage class=text type=file name=upImage></td>
                        </tr>
                        <tr>
                            <td class=field></td>
                            <td>
                                <img style="height: 100px" id="showImage" src="http://localhost:80/${house.path}">
                                <input type="hidden" id="path" name="path" value="${house.path}">
                            </td>
                        </tr>
                        <tr>
                            <td class=field>联系方式：</td>
                            <td>
                                <input id=contact class=text type=number name=contact value="${house.contact}">

                            </td>
                        </tr>
                        <tr>
                            <td class=field>详细信息：</td>
                            <td><TEXTAREA name=description id="description">${house.description}</TEXTAREA></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td align="left">
                                <input value=修改 type=button id="updateButton" class="button_class">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input value=重置 type=reset class="button_class">
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>
<div id=footer class=wrap>
    <dl>
        <dt>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</HTML>