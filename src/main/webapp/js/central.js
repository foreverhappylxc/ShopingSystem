$(document).ready(function(){
	$("#index").click(function() {
		$(window).attr('location','/ShopingSystem/index');
	});
	$("#personal").click(function() {
		/*$.ajax({
            type: 'POST',
            url: "central",
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: '',
            async: false,
            success: function (responseData) {
                alert("success");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });*/
		$(window).attr('location','/ShopingSystem/personal');
	});
	$("#order_finish").click(function() {
		$(window).attr('location','/ShopingSystem/orderFinish');
	});
	$("#order_unfinish").click(function() {
		$(window).attr('location','/ShopingSystem/orderUnfinish');
	});
	$("#shoping_cart").click(function() {
		$(window).attr('location','/ShopingSystem/shopingCart');
	});
});