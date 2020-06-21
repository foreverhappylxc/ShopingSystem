<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册页面</title>
    <link rel="stylesheet" href="css/Style.css">
<script type="text/javascript" src="js/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="js/register.js">
</script>
</head>
<body>
    <h1 style="font-size:40px">用户注册</h1>
    <table class="table">
        <tr>
            <td>用户ID:</td>
            <td>
                <input type="text" name="u_id" id="u_id">
            </td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td>
                <input type="text" name="u_name" id="u_name">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="u_pwd" id="u_pwd">
            </td>
        </tr>
        <tr>
            <td>再次输入密码:</td>
            <td>
                <input type="password" name="u_pwd0" id="u_pwd0">
            </td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><input type="text" name="u_mail" id="u_mail"></td>
        </tr>
        <tr> 
            <td>
                <button id="register">注册</button>
            </td>
            <td>
                <button id="cancel">取消</button>
            </td>
        </tr>
    </table>
</body>
</html>