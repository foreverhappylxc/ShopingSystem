<%@page import="com.fhlxc.shopingsystem.model.ShopingCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的购物车</title>
<script type="text/javascript" src="js/jquery-3.5.1.min.js">
</script>
<link rel="stylesheet" href="css/two.css">
</head>
<body>
    <jsp:include page="central.jsp"></jsp:include>
    <%
    List<Object> list = (ArrayList<Object>) request.getAttribute("list");
    if (list != null) {
        for (Object o: list) {
            ShopingCart shopingCart = (ShopingCart) o;
    %>
    <table>
        <tr>
            <td>
                商品ID
            </td>
            <td>
                <a>
                    <%= shopingCart.getC_id() %>
                </a>
            </td>
        </tr>
        <tr>
            <td>
                商品数量
            </td>
            <td>
                <a>
                    <%= shopingCart.getC_number() %>
                </a>
            </td>
        </tr>
        <tr>
            <td>
                商品总价格
            </td>
            <td>
                <a>
                    <%= shopingCart.getS_price() * shopingCart.getC_number() %>
                </a>
            </td>
        </tr>
    </table>
    <%
        }
    }
    %>
    <button onclick="$(window).attr('location','/ShopingSystem/indexSearch');">返回</button>
</body>
</html>