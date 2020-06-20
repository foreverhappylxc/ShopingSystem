<%@page import="com.fhlxc.shopingsystem.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="js/personal.js">
</script>
<link rel="stylesheet" href="css/personal.css">
<title>个人中心</title>
</head>
<body>
    <jsp:include page="central.jsp"></jsp:include>
    <div class="personal_module">
        &nbsp;&nbsp;&nbsp;&nbsp;头像
        <button class="personal_button" id="personal_button1"></button>
    </div>
    <img alt="头像" src="${ user.u_img }">
    <div class="personal_module" id="personal_info">
        &nbsp;&nbsp;&nbsp;&nbsp;基本信息
        <button class="personal_button" id="personal_button2"></button>
    </div>
    <table class="personal_table">
        <tr class="personal_tr">
            <td>用户ID</td>
            <td>${ user.u_id }</td>
        </tr>
        <tr class="personal_tr">
            <td>用户名</td>
            <td>${ user.u_name }</td>
        </tr>
        <tr class="personal_tr">
            <td>用户邮箱</td>
            <td>${ user.u_mail }</td>
        </tr>
        <tr class="personal_tr">
            <td>用户密码</td>
            <td>*******</td>
        </tr>
    </table>
    <div class="personal_module" id="personal_addr">
        &nbsp;&nbsp;&nbsp;&nbsp;地址信息
        <button class="personal_button" id="personal_button3"></button>
    </div>
    <table class="personal_table">
        <%
        String[] strings = ((User) request.getSession().getAttribute("user")).getU_address().split(";");
        for (String s: strings) {
        %>
        <tr class="personal_tr">
            <td>
                <div>
                    <%= s %>
                    <button id="button_remove"></button>
                </div>
            </td>
        </tr>
        <%
        }
        %>
        <tr>
            <td>
                <button id="button_add">添加</button>
            </td>
        </tr>
    </table>
</body>
</html>