<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
    <h1>用户登录</h1>
    <form method="post" action="login" style="margin-left:510px;">
        <table>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="name" id="name" size="45"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="pwd" id="pwd" size="45"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" name="submit0" id="submit0" value="登录"  style="width:100px;height:50px;">
                    <input type="reset" name="submit0" id="submit0" value="重置" style="width:100px;height:50px;">
                </td>
            </tr>
        </table>
        <table>
            <tr> 
                <td>
                    <a href="register.jsp">没有开通？转往注册页面</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>