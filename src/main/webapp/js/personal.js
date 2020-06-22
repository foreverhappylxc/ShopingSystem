$(document).ready(function(){
	
	$("#personal_button1").click(function() {
		if ($(this).css("background-image").indexOf("modify") >= 0) {
			$("#pictureUpload").click(function() {
				$("#pictureUpload").val("");
			});
			$("#pictureUpload").click();
			$(this).css("background-image", "url('/ShopingSystem/resources/save.png')");
		} else {
	        var formData = new FormData();
	        formData.append('file', $('#pictureUpload')[0].files[0]);  //添加图片信息的参数
			var files = $("#pictureUpload")[0].files;
			if (files.length == 0) {
				$("#personal_button1").css("background-image", "url('/ShopingSystem/resources/modify.png')");
				return;
			}
	        $.ajax({
	            type: "POST",
	            url: "pictureUpload",
	            data:formData,
	            cache: false,
	            processData: false,
	            contentType: false,
	            encType:"multipart/form-data",
	            success: function(data) {
	                $("img").attr("src", "/ShopingSystem/" + data);
	            },
	        	error: function(data,type, err) {
					alert(err);
					return;
				}
	        });
			$(this).css("background-image", "url('/ShopingSystem/resources/modify.png')");
		}
	});
	
	$("#personal_button2").click(function() {
		if ($(this).css("background-image").indexOf("modify") >= 0) {
			$("#info_name").attr("contenteditable", "true");
			$("#info_mail").attr("contenteditable", "true");
			$("#info_pwd").attr("contenteditable", "true");
			$("#info_name").focus();
			$(this).css("background-image", "url('/ShopingSystem/resources/save.png')");
		} else {
			var search_str = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
			if (!search_str.test($("#info_mail").text())) {
				alert("邮箱格式错误！");
			    $('#info_mail').focus();
			    return;
			}
			var address = "";
			$(".address").each(function() {
				address = address + ";" + $(this).text().trim();
			});
			var json = {
	            "u_id": $("#info_id").text(),
	            "u_address": address,
	            "u_img": $("#info_img").attr("src"),
	            "u_mail": $("#info_mail").text(),
	            "u_pwd": $("#info_pwd").text(),
	            "u_name": $("#info_name").text(),
			};
			var postdata = JSON.stringify(json);
	        $.ajax({
	            type: 'POST',
	            url: "infoModify",
	            dataType: 'json',
	            contentType: "application/json;charset=utf-8",
	            data: postdata,
	            cache: false,
	            processData: false,
	            success: function(data) {
	            	
	            },
	        	error: function(data, type, err) {
					return;
				}
	        });
	        $("#info_name").attr("contenteditable", "false");
			$("#info_mail").attr("contenteditable", "false");
			$("#info_pwd").attr("contenteditable", "false");
			$(this).css("background-image", "url('/ShopingSystem/resources/modify.png')");
		}
	});
	
	$("#personal_button3").click(function() {
		if ($(this).css("background-image").indexOf("modify") >= 0) {
			$(".address").attr("contenteditable", "true");
			$(".address").focus();
			$("#button_add").attr('disabled',true);
			$(this).css("background-image", "url('/ShopingSystem/resources/save.png')");
		} else {
			var address = "";
			$(".address").each(function() {
				address = address + ";" + $(this).text().trim();
			});
			var json = {
	            "u_id": $("#info_id").text(),
	            "u_address": address,
	            "u_img": $("#info_img").attr("src"),
	            "u_mail": $("#info_mail").text(),
	            "u_pwd": $("#info_pwd").text(),
	            "u_name": $("#info_name").text(),
			};
			var postdata = JSON.stringify(json);
	        $.ajax({
	            type: 'POST',
	            url: "infoModify",
	            dataType: 'json',
	            contentType: "application/json;charset=utf-8",
	            data: postdata,
	            cache: false,
	            processData: false,
	            success: function(data) {
	            	
	            },
	        	error: function(data, type, err) {
					return;
				}
	        });
	        $(".address").attr("contenteditable", "false");
	        $("#button_add").attr('disabled',false);
			$(this).css("background-image", "url('/ShopingSystem/resources/modify.png')");
		}
	});
	
	$("#button_add").click(function() {
		if ($(this).text() == "添加") {
			$(this).parent().parent().before("<tr class='personal_tr'><td><div class='address' contenteditable='true'></div></td><td><button class='button_remove' id='button_remove'></button></td></tr>");
			$(this).parent().parent().prev().find(".address").focus();
			$("#personal_button3").attr('disabled',true);
			$("#button_cancel").attr('disabled',false);
			$(this).text("保存");
		} else {
			if ($(this).parent().parent().prev().find(".address").text().trim() == "") {
				$(this).parent().parent().prev().remove();
				$("#personal_button3").attr('disabled',false);
				$("#button_cancel").attr('disabled',true);
				$(this).text("添加");
				return;
			}
			var address = "";
			$(".address").each(function() {
				address = address + ";" + $(this).text().trim();
			});
			var json = {
	            "u_id": $("#info_id").text(),
	            "u_address": address,
	            "u_img": $("#info_img").attr("src"),
	            "u_mail": $("#info_mail").text(),
	            "u_pwd": $("#info_pwd").text(),
	            "u_name": $("#info_name").text(),
			};
			var postdata = JSON.stringify(json);
	        $.ajax({
	            type: 'POST',
	            url: "infoModify",
	            dataType: 'json',
	            contentType: "application/json;charset=utf-8",
	            data: postdata,
	            cache: false,
	            processData: false,
	            success: function(data) {
	            	
	            },
	        	error: function(data, type, err) {
					return;
				}
	        });
			$(this).parent().parent().prev().find("div").attr("contenteditable", "false");
			//$(".address").attr("contenteditable", "false");
			$("#personal_button3").attr('disabled',false);
			$("#button_cancel").attr('disabled',true);
			$(this).text("添加");
		}
	});
	
	$("#button_cancel").click(function() {
		$(this).parent().parent().prev().remove();
		$("#button_add").text("添加");
		$("#personal_button3").attr('disabled',false);
		$("#button_cancel").attr('disabled',true);
	});
	
	$("#table").on("click", ".button_remove", function() {
		$(this).parent().parent().remove();
		var address = "";
		$(".address").each(function() {
			address = address + ";" + $(this).text().trim();
		});
		var json = {
            "u_id": $("#info_id").text(),
            "u_address": address,
            "u_img": $("#info_img").attr("src"),
            "u_mail": $("#info_mail").text(),
            "u_pwd": $("#info_pwd").text(),
            "u_name": $("#info_name").text(),
		};
		var postdata = JSON.stringify(json);
        $.ajax({
            type: 'POST',
            url: "infoModify",
            dataType: 'json',
            contentType: "application/json;charset=utf-8",
            data: postdata,
            cache: false,
            processData: false,
            success: function(data) {
            	
            },
        	error: function(data, type, err) {
				return;
			}
        });
	});
	
});