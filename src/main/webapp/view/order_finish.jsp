<%@page import="com.fhlxc.shopingsystem.model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
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
            Order order = (Order) o;
    %>
    <table>
        <tr>
            <td>
                订单ID
            </td>
            <td>
                <a>
                    <%= order.getC_id() %>
                </a>
            </td>
        </tr>
        <tr>
            <td>
                商品数量
            </td>
            <td>
                <a>
                    <%= order.getO_number() %>
                </a>
            </td>
        </tr>
        <tr>
            <td>
                商品总价格
            </td>
            <td>
                <a>
                    <%= order.getO_price() * order.getO_number() %>
                </a>
            </td>
        </tr>
        <tr>
            <td>
                收货地址
            </td>
            <td>
                <a>
                    <%= order.getO_receiving_address() %>
                </a>
            </td>
        </tr>
        <tr>
            <td>
                发货地址
            </td>
            <td>
                <a>
                    <%= order.getO_shipping_address() %>
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