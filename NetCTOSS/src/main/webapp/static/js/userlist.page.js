$(function(){
	
	
	/*
	 * 以下内容：是对Rest HTTP 4种提交方式的示例
	 * */
	
	//查询
	$('#btn06').click(function(){
		var url = "users/张/123456/2018-01-01/2018-03-13/1/10";
		$.ajax({
			type:"GET",
			url:url,
			success :function(msg){
				console.log(msg);
			}
		});
	});
	
	
	//查询
	$('#btn05').click(function(){
		var url = "users/张/123456";
		$.ajax({
			type:"GET",
			url:url,
			success :function(msg){
				console.log(msg);
			}
		});
	});
	
	//查询
	$('#btn04').click(function(){
		var url = "users/9";
		$.ajax({
			type:"GET",
			url:url,
			success :function(msg){
				console.log(msg);
			}
		});
	});
	
	//删除
	$('#btn03').click(function(){
		var url = "users/10";
		var user = {version:1};
		$.ajax({
			type:"DELETE",
			url:url,
			data:user,
			success :function(msg){
				console.log(msg);
			}
		});
	});
	
	//修改
	$('#btn02').click(function(){
		var url = "users/10";
		var user = {userName:"王老五",loginName:"ww",password:"123456",gender:1,birthday:"2017-01-02",version:0};
		$.ajax({
			type:"PUT",
			url:url,
			data:user,
			success :function(msg){
				console.log(msg);
			}
		});
	});
	
	//新增
	$('#btn01').click(function(){
		var url = "users/-1";
		var user = {userName:"李四",loginName:"ls",password:"123456",gender:1,birthday:"2017-01-02"};
		$.ajax({
			type:"POST",
			url:url,
			data:user,
			success :function(msg){
				console.log(msg);
			}
		});
	});
	
	
	
	
});