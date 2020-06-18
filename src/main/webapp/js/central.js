$(document).ready(function(){
	$("#central").click(function() {
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
		$(window).attr('location','central');
	});
});