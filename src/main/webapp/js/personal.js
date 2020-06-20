$(document).ready(function(){
	
	$(".personal_button").click(function() {
		if ($(this).css("background-image").indexOf("modify") >= 0) {
			$(this).css("background-image", "url('/ShopingSystem/resources/save.png')");
		} else {
			$(this).css("background-image", "url('/ShopingSystem/resources/modify.png')");
		}
	});
	
	$("#personal_button1").click(function() {
		if ($(this).css("background-image").indexOf("modify") >= 0) {
			alert("xxx");
		} else {
			
		}
	});
	
});