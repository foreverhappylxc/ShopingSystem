<%@page import="com.fhlxc.shopingsystem.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="js/central.js">
</script>
<link rel="stylesheet" href="css/central.css">
<div id="central_background" class="central_background">
    <div class="img" id="img">
        <img id="u_img" class="u_img" alt="头像" src=" ${ user.u_img } ">
    </div>
    <div class="central_item" id="index">网站首页</div>
    <div class="central_item" id="personal">个人中心</div>
    <div class="central_item" id="order_finish">我的订单</div>
    <div class="central_item" id="shoping_cart">我的购物车</div>
</div>