$(function() {
	/**
	 * 默认数据列表的显示
	 */
	$('#table').datagrid({
		url : "customer/findAll",
		method : "GET",
		queryParams : queryParams()
	});

	/**
	 * 查询参数的封装
	 */
	function queryParams() {

		var name = $('#name').val();
		var loginName = $('#loginName').val();
		var password = $('#password').val();
		var gender = $('#gender').val();
		var birthday = $('#birthday').val();
		
		var data = {
			name : name,
			loginName : loginName,
			password : password,
			gender : gender,
			birthday : birthday,
		};
		return data;
	};
	
	
	$("#add").click(function() {
		$('#add_customer_dialog').dialog('open');// 打开新增窗体
		// $('#add_customer').form('clear');
	});
	/**
	 * 新增保存
	 */
	$('#save_newcustomer').click(function() {
		var url = "customer/-1";
		var text = {
			id : $('#u_id').val(),
			name : $('#u_name').val(),
			anotherName : $('#u_loginName').val,
			type : $('#u_password').val(),
			genera : $('#u_gender').val(),
			nums : $('#u_birthday').val()
		}
		$('#add_customer').form('submit', {
			url : url,
			onSubmit : function(text) {
				// do some check
				// return false to prevent submit;
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.status==1) {
					$('#add_customer_dialog').dialog('close');
				}
				$.messager.alert({
					title : '消息提示',
					msg : data.information,
					timeout : 5000,
					showType : 'slide'
				});

				$('#table').datagrid('reload', queryParams());// 重新加载数据
			}
		});
	});

	// 点击修改按钮
	$('#update').click(function() {
		var row = $('#table').datagrid('getSelected')// 返回的第1行记录
		if (row) { // 如果选中了数据，就进入if语句
				var date = new Date(row.birthday);
				text = date.format('yyyy-MM-dd hh:mm:ss');
				$('#update_customer_dialog').dialog('open');// 打开修改窗体
				$('#u_id1').attr('value', row.id);
				$('#u_name1').attr('value', row.name);
				$('#u_loginName1').attr('value', row.loginName);
				$('#u_gender1').attr('value', row.gender);
				$('#u_birthday1').attr('value', text);
				$('#update_customer').form('validate');
		} else {
			$.messager.alert({
				title : '消息提示',
				msg : '请选择需要修改的数据！',
				timeout : 5000,
				showType : 'slide'
			});
		}
	});
	/**
	 * 修改保存
	 */
	$('#save_customer').click(function() {
		var row = $('#table').datagrid('getSelected')
		var url = "customer/" + row.id;
		$('#update_customer').form('submit', {
			url : url,
			onSubmit : function() {
				// do some check
				// return false to prevent submit;
				return true;
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.status==1) {
					$('#update_customer_dialog').dialog('close');
				}
				$.messager.alert({
					title : '消息提示',
					msg : data.information,
					timeout : 5000,
					showType : 'slide'
				});

				$('#table').datagrid('reload', queryParams());// 重新加载数据
			}
		});
	});

	// 删除数据
	$('#remove').click(function() {
		// 返回的是：所选择数据的数组
		var rows = $('#table').datagrid('getSelected')
		if (rows == null) {// 没有选择任何需要被删除的数据
			$.messager.alert({
				title : '消息提示',
				msg : '请选择需要删除的数据！',
				timeout : 5000,
				showType : 'slide'
			});
		} else {// 已经选择了，需要被删除的数据
			$.messager.confirm('友情提示', '你确定需要删除这些数据么?', function(r) {
				if (r) {
					var json = $.toJSON(rows);
					var url = "customer/" + rows.id;
					$.ajax({
						type : "DELETE",
						url : url,
						contentType : "application/json",
						data : rows.id,
						success : function(msg) {
							$.messager.alert({
								title : '消息提示',
								msg : msg.information,
								timeout : 5000,
								showType : 'slide'
							});
							$('#table').datagrid('reload', queryParams());// 重新加载数据
						}
					});
				}
			});
		}
	});

	$('#btn').click(function () {
		var start = $('#start').datebox('getValue');
		var end = $('#end').datebox('getValue');
		var userName = $('#userName').val();
		
		var data = {
				start:start,
				end:end,
				name:userName
		}
		$('#table').datagrid({
			url : "customer/findByCondition",
			method : "GET",
			queryParams : data
		});
	});
});

	/**
	 * 日期格式化函数
	 */
	function dateformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	};
	
	Date.prototype.format = function(fmt) { 
	    var o = { 
	       "M+" : this.getMonth()+1,                 // 月份
	       "d+" : this.getDate(),                    // 日
	       "h+" : this.getHours(),                   // 小时
	       "m+" : this.getMinutes(),                 // 分
	       "s+" : this.getSeconds(),                 // 秒
	       "q+" : Math.floor((this.getMonth()+3)/3), // 季度
	       "S"  : this.getMilliseconds()             // 毫秒
	   }; 
	   if(/(y+)/.test(fmt)) {
	           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	   }
	    for(var k in o) {
	       if(new RegExp("("+ k +")").test(fmt)){
	            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	        }
	    }
	   return fmt; 
	};
	
	$.extend($.fn.validatebox.defaults.rules, {    
	    equals: {    
	        validator: function(value,param){    
	            return value == $(param[0]).val(); 
	        },    
	        message: '两次输入密码不匹配！'
	    }    
	});  

		
	

	
