<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
    <div class="container">
        <script src="js/jquery-3.5.1.min.js"></script>
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
        <form target="_top" action="Search" name="search" id="J_TSearchForm" class="search-panel-focused">
            <div style="text-align:center">
                <input type="text" size="45"><input type="submit" value="搜索"><p>
                <button type="button" class="btn btn-primary" onclick="window.location='MyShoppingCart.jsp'"> 
                    查看我的购物车
                </button>
            </div>
            <div class="search-panel-fields search-hp-fields search-common-panel">
            </div>
            <div class="J_TbSearchContent J_TbPlaceholder J_Placeholder" id="tbSearchContent">
            </div>
        </form>
    </div>
    <div class="row" id="r">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img src="commodity_img/03.jpg">
                <div class="caption">
                    <h3>男士卫衣</h3>
                    <p>价格：369元</p>
                    <p>
                        <a href="#" class="btn btn-primary" role="button" onclick="window.location='Cloth0.jsp'">
                            查看商品详细信息
                        </a> 
                        <a href="#" class="btn btn-default" role="button">
                            加入购物车
                        </a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>