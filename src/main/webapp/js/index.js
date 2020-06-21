$(document).ready(function(){
	
	$(".add").click(function() {
		var json = {
	           "c_id": $(this).prev().val(),
	           "c_number": "3",
	           "s_price": $(this).parent().prev().val(),
	           "u_id": $(this).next().val(),
		};
		var postdata = JSON.stringify(json);
		$.ajax({
	           type: 'POST',
	           url: "addCommodity",
	           dataType: 'json',
	           contentType: "application/json;charset=utf-8",
	           data: postdata,
	           cache: false,
	           processData: false,
	           success: function(data, statu, xhr) {
	        	   alert(data.msg);
	           },
	       	error: function(data, type, err) {
				return;
			}
	      });
	});
	
	$(".look").click(function() {
		var json = {
	        "c_id": $(this).next().val(),
			"o_finish": "",
			"o_number": $(this).next().next().val(),
			"o_price": $(this).next().next().next().val(),
			"o_receiving_address": $(this).next().next().next().next().val(),
			"o_shipping_address": $(this).next().next().next().next().next().val(),
			"o_time": "",
			"u_id": $(this).next().next().next().next().next().next().val(),
		};
		var postdata = JSON.stringify(json);
		$.ajax({
	           type: 'POST',
	           url: "addOrder",
	           dataType: 'json',
	           contentType: "application/json;charset=utf-8",
	           data: postdata,
	           cache: false,
	           processData: false,
	           success: function(data, statu, xhr) {
	        	   alert(data.msg);
	           },
	       	error: function(data, type, err) {
				return;
			}
	      });
	});
	
});