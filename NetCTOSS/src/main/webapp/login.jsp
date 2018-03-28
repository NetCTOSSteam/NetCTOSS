<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="static/js/fun.base.js"></script>
<script type="text/javascript" src="static/js/script.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript"
	src="static/jQuery-easyui/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript"
	src="static/jQuery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="static/js/date.js"></script>
<script type="text/javascript" src="static/js/jquery.json-2.4.js"></script>
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet"
	href="static/jQuery-easyui/themes/default/easyui.css" type="text/css" />
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="static/jQuery-easyui/themes/icon.css"
	type="text/css" />
<link href="static/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="login">
		<div class="box png">
			<div class="logo png"></div>
			<div class="input">
				<div class="log">
					<div class="name">
						<label>口 令：</label><input required type="text" class="text1"
							id="inp1" placeholder="登录口令" name="loginName" tabindex="1">
							<select id="sele">
								<option selected="selected">管理员</option>
								<option>用户</option>
							</select>
					</div>
					<div class="pwd">
						<label>密 码：</label><input required type="password" class="text"
							id="inp2" placeholder="口令密码" name="password" tabindex="1">
						<br/> <br />
						<label>验 证 码：</label>
						<input required type="text" class="text1" id="inp3" placeholder="验证码" name="code" tabindex="3">
						<img id="img" style="margin-top: -5px" src="img/1">
						<a href='javascript:ck()'>换一张</a>
						<input id="button1" type="button" class="submit" style="margin-top: 15px;margin-left: 70px" taindex="3" value="登录">
						<input id="button2" type="button" class="submit" style="margin-top: 15px;margin-left: 90px" taindex="3" value="重置">
						<div class="check"></div>
					</div>
					<div class="tip"></div>
				</div>
			</div>
		</div>
		<div class="air-balloon ab-1 png"></div>
		<div class="air-balloon ab-2 png"></div>
		<div class="footer"></div>
	</div>
	<script>
		function ck() {
			var oimg = document.getElementById("img");
			oimg.src = "img/1?" + Math.random();
		}

		
		$('#button2').click(function () {
			$('#inp1').val("");
			$('#inp2').val("");
			$('#inp3').val("");
		});
		
		$('#button1').click(function() {
			var sele = $('#sele').val();
			var seleStatus;
			var data;
			if(sele=='管理员'){
				seleStatus = 1;
				console.info(seleStatus)
				var userName = $('#inp1').val();
				var password = $('#inp2').val();
				var code = $('#inp3').val();
				data = {
					userName : userName,
					password : password,
					code : code
				};
			}else{
				seleStatus = 0;
				console.info(seleStatus)
			}
			var userName = $('#inp1').val();
			var password = $('#inp2').val();
			var code = $('#inp3').val();
			data = {
				loginName : userName,
				password : password,
				code : code
			};
			$.ajax({
				type : "POST",
				url : "admin/login",
				async :true,
				data : data,
				success : function(msg) {
					if (msg.status == 1) {
						$.messager.alert('提示',msg.information,'info',function(){
							window.location.href="static/jsp/index.jsp"; 
						}); 
					}else if(msg.status == -1){
						$.messager.alert('提示',msg.information,'info'); 
					}else{
						$.messager.alert('提示',msg.information,'info'); 
					}
				}
			});
		});
	</script>
	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">
		<p>2018-&copy;CopyRight by First-Group</p>
	</div>
</body>
</html>