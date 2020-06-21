$(document).ready(function(){
	$("#index").click(function() {
		$(window).attr('location','/ShopingSystem/indexSearch');
	});
	$("#personal").click(function() {
		$(window).attr('location','/ShopingSystem/personal');
	});
	$("#order_finish").click(function() {
		$(window).attr('location','/ShopingSystem/searchOrder');
	});
	$("#shoping_cart").click(function() {
		$(window).attr('location','/ShopingSystem/searchCart');
	});
});