<%@page import="com.fhlxc.shopingsystem.model.Commodity"%>
<%@page import="com.fhlxc.shopingsystem.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品浏览界面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <title> Things </title>
    <style>
        #title{background-color: lightskyblue; }
        #r{background-color:  linen;}
    </style>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="js/index.js">
    </script>
</head>
<body>
    <jsp:include page="central.jsp"></jsp:include>
    <div class="container">
        <div class="jumbotron text-center" id=title >
            <h1>淘宝购物</h1>
        </div>
    </div>
    <div class="search-tab-icon">
        <i>
            <em></em>
            <span></span>
        </i>
    </div>
    <div class="search-panel search-hp-panel ks-switchable-content J_SearchPanel">
        <form target="_top" method="get" action="search" id="J_TSearchForm" class="search-panel-focused">
            <div style="text-align:center">
                <input name="search" id="search" type="text" size="45"><input type="submit" value="搜索"><p>
            </div>
            <div class="search-panel-fields search-hp-fields search-common-panel">
            </div>
            <div class="J_TbSearchContent J_TbPlaceholder J_Placeholder" id="tbSearchContent">
            </div>
        </form>
    </div>
    <div class="row" id="r">
    
    <%
    List<Object> list = (ArrayList<Object>)request.getAttribute("list");
    if (list != null) {
    for (Object o: list) {
        Commodity commodity = (Commodity) o;
    %>
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
             <img src="<%= commodity.getC_img() %>">
             <div class="caption">
                 <h3>"<%= commodity.getC_name() %>"</h3>
                 <p>价格：<%= commodity.getC_price() %>元</p>
                 <input type="hidden" value="<%= commodity.getC_price() * 3 %>">
                 <p>
                     <button class="btn btn-primary look" id="look">
                        购买商品
                     </button>
                     <input type="hidden" value="<%= commodity.getC_id() %>">
                     <input type="hidden" value="2">
                     <input type="hidden" value="<%= commodity.getC_price() * 2 %>">
                     <input type="hidden" value=" ${ user.u_address }">
                     <input type="hidden" value="<%= commodity.getC_address() %>">
                     <input type="hidden" value="${ user.u_id }">
                     <input type="hidden" value="<%= commodity.getC_id() %>">
                     <button class="btn btn-default add" id="add">
                        加入购物车
                     </button>
                     <input type="hidden" value="${ user.u_id }">
                 </p>
             </div>
         </div>
    </div>
    <%
    }
    }
    %>
        
    </div>
</body>
</html>