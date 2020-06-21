$(document).ready(function(){
	
	$("#cancel").click(function() {
		$(window).attr('location','/ShopingSystem/login');
	});
	
	$("#register").click(function() {
		if ($("#u_id").val() == "") {
			alert("请填写id");
		    $('#u_id').focus();
		    return;
		}
		if ($("#u_name").val() == "") {
			alert("请填写用户名");
		    $('#u_name').focus();
		    return;
		}
		if ($("#u_pwd").val() == "") {
			alert("请填写密码");
		    $('#u_pwd').focus();
		    return;
		}
		if ($("#u_mail").val() == "") {
			alert("请填写邮箱");
		    $('#u_mail').focus();
		    re
		}
		if ($("#u_pwd").val() != $("#u_pwd0").val()) {
			alert("两次输入密码不正确");
		    $('#u_pwd0').focus();
		    return;
		}
		var search_str = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
		if (!search_str.test($("#u_mail").val())) {
			alert("邮箱格式错误！");
		    $('#u_mail').focus();
		    return;
		}

		var json = {
            "u_id": $("#u_id").val(),
            "u_img": "",
            "u_mail": $("#u_mail").val(),
            "u_pwd": $("#u_pwd").val(),
            "u_name": $("#u_name").val(),
            "u_address": "",
		};
		var postdata = JSON.stringify(json);
		$.ajax({
            type: 'POST',
            url: "registerUser",
            dataType: 'text',
            contentType: "application/json;charset=utf-8",
            data: postdata,
            cache: false,
            processData: false,
               success: function(data, statu, xhr) {
            	var data = JSON.parse(data);
            	alert(data.msg);
            	if (data.msg == "注册成功") {
            		$(window).attr('location','/ShopingSystem/login');
            	}
            },
        	error: function(data, type, err) {
				return;
			}
        });
	});
	
});