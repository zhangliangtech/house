<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <title>青鸟租房 - 回收站</title>
    <meta content="text/html; charset=utf-8" http-equiv=Content-Type>
    <link rel=stylesheet type=text/css href="../css/style.css">
    <link rel=stylesheet type=text/css href="../css/mystyle.css">
    <meta name=GENERATOR>
    <script>
        function removeHouse(id) {
            if (confirm("该操作无法恢复,确认删除吗? ")) {
                location.href = "removeHouse?id=" + id;
            }
        }

        function removeHouses() {
            if (confirm("该操作无法恢复,继续吗? ")) {
                location.href = "removeHouses";
            }
        }
    </script>
</head>
<body>
<div id=header class=wrap>
    <div id=logo><img src="../images/logo.png" width="200px" onclick="location.href='goList'" class="logo"></div>
    <div class=search>
        欢迎您：${sessionScope.loginInfo.name}
        <input class="button_class" onclick="location.href='logout'" value="退 出" type=button name=search>
        <input class="button_class" onclick="location.href='goGuanLi'" value="管理页面" type=button name=search>
    </div>
</div>
<header style="height: 50px;background-color: #00acaf;margin:0 auto"></header>
<br>

<div class="main wrap" style="height: 700px">
    <table class=house-list>
        <tr align="right">
            <td colspan="5">
                <input class="button_class" onclick="removeHouses()" value="清空回收站" type=button name=search
                       style="width: 100px">
            </td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="house">
            <tr style="height: 135px">
                <td class=house-thumb>
                    <span> <a href="detailHouse?id=${house.id}">
                    <img src="http://localhost:80/${house.path}" width="120" height="90"> </a> </span>
                </td>
                <td>
                    <dl>
                        <dt>
                            <a href="detailHouse?id=${house.id}">${house.title}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${house.price}元/月
                        </dt>
                        <dd>${house.districtName}${house.streetName},${house.floorage}平米<BR>联系方式：${house.contact}
                        </dd>
                    </dl>
                </td>
                <td class=house-type>
                    <INPUT onclick="location.href='doRecover?id=${house.id}'" value="恢 复" type=button
                           name=search class="action_button_class">
                </td>
                <td class=house-type>
                    <INPUT onclick="location.href='goUpdate?id=${house.id}'" value="修 改" type=button
                           name=search class="action_button_class">
                </td>
                <td class=house-price>
                    <INPUT onclick="removeHouse(${house.id})" value="彻底删除" type=button
                           name=search class="action_button_class" style="width: 100px">
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class=pager>
        <ul>
            <li class=current><a href="http://localhost:8080/page/goRecycle?page=1">首页</a></li>
            <li><a href="http://localhost:8080/page/goRecycle?page=${pageInfo.pageNum-1}">上一页</a></li>
            <li><a href="http://localhost:8080/page/goRecycle?page=${pageInfo.pageNum+1}">下一页</a></li>
            <li><a href="http://localhost:8080/page/goRecycle?page=${pageInfo.pages}">末页</a></li>
        </ul>
        <span class=total>${pageInfo.pageNum}/${pageInfo.pages}页</span>
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
