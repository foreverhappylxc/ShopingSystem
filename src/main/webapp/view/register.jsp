<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册页面</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
    <h1 style="font-size:40px">用户注册</h1>
    <form method="post" action="RegSucc.jsp" style="font-size: 30px;line-height: 150%;margin-left:510px;">
        <table>
            <tr>
                <td>姓名:</td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>用户名:</td>
                <td>
                    <input type="text" name="name0" id="name0">
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="password" name="pwd" id="pwd">
                </td>
            </tr>
            <tr>
                <td>再次输入密码:</td>
                <td>
                    <input type="password" name="pwd0" id="pwd0">
                </td>
            </tr>
            <tr>
                <td>联系方式：</td>
                <td><input type="text" name="tele" id="tele"></td>
            </tr>
        </table>
        <table>
            <tr>   
                <td>其他个人信息说明:</td>
                <td>
                    <textarea name="note" id="note"  rows="6" cols="30"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="button" class="btn btn-default btn-xs" onclick="window.location='RegSucc.jsp'" style="width:100px;height:50px"> 
                        查看信息
                    </button>
                </td>
                <td>
                    <input type="submit" name="submit0" id="submit0" value="注册" style="width:100px;height:50px;">
                </td>
            </tr>
        </table>
        <table>
            <tr> 
                <td>
                    <a href="Login.jsp">我已注册，转往登录界面</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>