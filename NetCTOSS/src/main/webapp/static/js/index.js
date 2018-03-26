$(function() {

	// 为按钮添加一个“点击”事件
	$('#btn1').click(function() {
		var url = "tree/find";
		var data = {
			name : "白皮松"
		};
		$.ajax({
			type : "GET",
			url : url,
			data : data,
			success : function(msg) {
				console.info(msg);
			}
		});

	});

	$('#btn2').click(function() {
		var url = "tree/10";
		$.ajax({
			type : "DELETE",
			url : url,
			success : function(msg) {
				console.info(msg);
			}
		});

	});

	$('#btn3').click(function() {
		var url = "tree/13";
		$.ajax({
			type : "PUT",
			url : url,
			data : {
				name : "葡萄树",
				nums : 40
			},
			success : function(msg) {
				console.info(msg);
			}
		});

	});

	$('#btn4').click(function() {
		var url = "tree/-1";
		$.ajax({
			type : "POST",
			url : url,
			data : {
				name : "枇杷树",
				type : "水果",
				genera : "高山植物",
				nums : "30"
			},
			success : function(msg) {
				console.info(msg);
			}
		});
	});
});