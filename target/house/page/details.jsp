<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>青鸟租房 -发布房屋信息</title>
    <meta content="text/html; charset=utf-8" http-equiv=Content-Type>
    <link
            rel=stylesheet type=text/css href="../css/style.css">
    <link rel=stylesheet type=text/css href="../css/mystyle.css">
    <meta name=GENERATOR content="MSHTML 8.00.7601.17514">
</head>
<body>
<div id=header class=wrap>
    <div id=logo><img src="../images/logo.png" width="200px" onclick="location.href='goList'" class="logo"></div>
    <div class=search>
        <form method="post" action="goList">
            <input class=text name="title" type=text placeholder="输入关键字查询房源信息">
            <input type="submit" value="搜索房屋" class="button_class">
        </form>
    </div>
</div>
<div id=position class=wrap>当前位置：青鸟租房网 - 浏览房源</div>
<header style="height: 50px;background-color: #00acaf;margin:0 auto"></header>
<div id=view class="main wrap">
    <div class=intro>
        <div class=lefter>
            <h1>${house.title}</h1>
            <div class=subinfo><fmt:formatDate pattern="yyyy-MM-dd" value="${house.pubdate}"/></div>
            <div class=houseinfo>
                <div style="float: left">
                    <p>户　　型：<span>${house.typeName}</span></p>
                    <p>面　　积：<span>${house.floorage}m<sup>2</sup></span></p>
                    <p>位　　置：<span>${house.districtName}${house.streetName}</span></p>
                    <p>联系方式：<span>${house.contact}</span></p>
                </div>
                <div style="float: left; margin-top: 60px;margin-left: 100px">
                    <span style="font-size: 30px">${house.price}元/月</span>
                </div>
                <div style="float: right; margin-top: 20px">
                    <img src="../images/logo.png" width="300px">
                </div>
            </div>
        </div>
        <div class=clear></div>
        <div class=introduction>
            <h2><span><strong>房源描述信息</strong></span></h2>
            <div class=content>
                <p>${house.description}</p></div>
        </div>
        <div class=introduction>
            <h2><span><strong>图片展示</strong></span></h2>
            <div class=content style="text-align: center">
                <img src="http://localhost:80/${house.path}" width="960px">
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
</html>
