<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>青鸟租房 - 首页</TITLE>
    <meta content="text/html; charset=utf-8" http-equiv=Content-Type>
    <link rel=stylesheet type=text/css href="../css/style.css">
    <link rel=stylesheet type=text/css href="../css/mystyle.css">
    <meta name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script type="text/javascript" src="../admin/js/jquery-1.8.3.js"></script>
    <script language="JavaScript">
        $(function () {
            $("#typeId").val(${houseUtils.typeId});
            $("#floorage").val(${houseUtils.floorage});
            $("#district").val(${houseUtils.districtId});
            $("#street").val(${houseUtils.streetId});
            $("#district").change(function () {
                $.post("getAllStreetById", {"id": $(this).val()}, function (data) {
                    $("#street>option:gt(0)").remove();
                    for (var i in data) {
                        var node = $("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                        $("#street").append(node);
                    }
                }, "json");
            });
        });

        function doPage(page) {
            $("#page").val(page);
            $(searchForm).submit();
        }

    </script>
</HEAD>
<body>
<div id=header class=wrap>
    <div id=logo><img src="../images/logo.png" width="200px" onclick="location.href='/page/goList'" class="logo"></div>
    <div class=search>
        <c:choose>
            <c:when test="${empty sessionScope.loginInfo}">
                <input class="button_class" type="button" onclick="location.href='/page/login.jsp'" value="登 录">
                <input class="button_class" type="button" onclick="location.href='/page/regs.jsp'" value="注 册">
            </c:when>
            <c:when test="${not empty sessionScope.loginInfo}">
                欢迎您：${sessionScope.loginInfo.name}
                <input class="button_class" onclick="location.href='/page/logout'" value="退 出" type=button name=search>
                <input class="button_class" onclick="location.href='/page/goGuanLi'" value="管理页面" type=button name=search>
            </c:when>
        </c:choose>

    </div>
</div>
<header style="height: 50px;background-color: #00acaf;margin:0 auto"></header>
<br>
<div align="center">
    <form action="/page/goList" method="post" id="searchForm">
        <table border="0px" width="1100xp" cellspacing="0px" cellpadding="0px" style="text-align: center">
            <tr>
                <td align="left">
                    <input class="input_class" type=text name=title value="${houseUtils.title}" placeholder=" 搜索出租房">
                    <input value=搜索 type="submit" class="little_button_class"></td>
                <input type="hidden" name="page" value="1" id="page">
                <td align="right"> 价格：
                    <select name="priceRange" id="priceRange" class="select_class">
                        <option value="">不限</option>
                        <option value="0-399"
                                <c:if test="${houseUtils.priceRange == '0-399'}">selected</c:if>>
                            400元以下
                        </option>
                        <option value="400-800"
                                <c:if test="${houseUtils.priceRange == '400-800'}">selected</c:if>>
                            400—800
                        </option>
                        <option value="800-1200"
                                <c:if test="${houseUtils.priceRange == '800-1200'}">selected</c:if>>
                            800—1200
                        </option>
                        <option value="1200-1000000"
                                <c:if test="${houseUtils.priceRange == '1200-1000000'}">selected</c:if>>
                            1200元以上
                        </option>
                    </select>
                </td>
                <td align="right">区域：
                    <select id=district name=districtId class="select_class">
                        <option selected value="">不限</option>
                        <c:forEach items="${districts}" var="district">
                            <option value=${district.id}>${district.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">街道：
                    <select id=street name=streetId class="select_class">
                        <option selected value="">不限</option>
                        <c:forEach items="${streets}" var="street">
                            <option value=${street.id}>${street.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">房型：
                    <select name=typeId id="typeId" class="select_class">
                        <option selected value="">不限</option>
                        <c:forEach items="${types}" var="type">
                            <option value=${type.id}>${type.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">面积：
                    <select name=floorage id="floorage" class="select_class">
                        </option>
                        <option selected value="">不限</option>
                        <option value=0>50以下</option>
                        <option value=50>50-100</option>
                        <option value=100>100-150</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<br>
<hr width="1100px"/>
<div class="main wrap" style="height: 700px">
    <table class=house-list>
        <c:forEach items="${pageInfo.list}" var="house">
            <tr style="height: 135px">
                <td class=house-thumb>
                <span>
                <a href="http://localhost:8080/page/detailHouse?id=${house.id}">
                    <img src="http://localhost:80/${house.path}" width="120" height="90">
                </a>
                </span>
                </td>
                <td style="color: #969193">
                    <dl>
                        <dt><a href="http://localhost:8080/page/detailHouse?id=${house.id}">${house.title}</a></dt>
                        <dd>${house.districtName}${house.streetName},${house.floorage}平米<br>联系方式：${house.contact}</dd>
                    </dl>
                </td>
                <td class=house-type style="color: #535556;font-family: 幼圆;font-weight: bold">${house.typeName}</td>
                <td class=house-price><span>${house.price}</span>元/月</td>
            </tr>
        </c:forEach>
    </table>
    <div class=pager>
        <ul>
            <li class=current><a href="javascript:doPage(1)">首页</a></li>
            <li><a href="javascript:doPage(${pageInfo.pageNum-1})">上一页</a></li>
            <li><a href="javascript:doPage(${pageInfo.pageNum+1})">下一页</a></li>
            <li><a href="javascript:doPage(${pageInfo.pages})">末页</a></li>
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