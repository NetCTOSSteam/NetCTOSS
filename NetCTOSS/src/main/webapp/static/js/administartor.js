//初始化加载
$(function() {
	$('#tt').datagrid({
		url : '/NetCTOSS/admin/1',
		columns : [ [ {
			field : 'adminName',
			title : '管理员名称',
			width : 12,
			align : 'center'
		}, {
			field : 'loginName',
			title : '管理员账号',
			width : 12,
			align : 'center'
		}, {
			field : 'telephone',
			title : '联系电话',
			width : 12,
			align : 'center'
		}, {
			field : 'email',
			title : '邮箱',
			width : 12,
			align : 'center'
		}, {
			field : 'type',
			title : '角色',
			width : 12,
			align : 'center',
			formatter : function(value, row, index) {
				return row.role.type;
			}
		} ] ],
		toolbar : '#tb'
	});
})

$(function() {
	// 模糊查询点击
	$('#query').click(function() {
		var json = data();
		show_data(json);
	})

	// 查询过后 数据对应的更新
	function show_data(json) {
		$('#tt').datagrid({
			url : '/NetCTOSS/admin/2',
			method : "GET",
			queryParams : json,
			columns : [ [ {
				field : 'adminName',
				title : '管理员名称',
				width : 12,
				align : 'center'
			}, {
				field : 'loginName',
				title : '管理员账号',
				width : 12,
				align : 'center'
			}, {
				field : 'telephone',
				title : '联系电话',
				width : 12,
				align : 'center'
			}, {
				field : 'email',
				title : '邮箱',
				width : 12,
				align : 'center'
			}, {
				field : 'role',
				title : '角色',
				width : 12,
				align : 'center',
				formatter : function(value, row, index) {
					return row.role.type;
				}
			} ] ],
			toolbar : '#tb'
		});
	}

	// 数据获取
	function data() {
		var admin_name = $('#admin_name').val();
		var admin_acc = $('#admin_acc').val();
		var json = {
			adminName : admin_name,
			loginName : admin_acc
		}
		return json
	}

	/**
	 * 添加
	 */

	// 添加需要的数据
	function add_data() {
		var add_admin_name = $('#add_admin_name').val();
		var add_admin_acc = $('#add_admin_acc').val();
		var add_admin_pwd = $('#add_admin_pwd').val();
		var add_admin_phone = $('#add_admin_phone').val();
		var add_admin_e = $('#add_admin_e').val();
		var roleID = $('#role_combox').combobox('getValue');
		var data = {
			adminName : add_admin_name,
			loginName : add_admin_acc,
			password : add_admin_pwd,
			telephone : add_admin_phone,
			email : add_admin_e,
			roleID : roleID
		};
		return data;
	}

	// 添加
	$('#add').click(function() {
		$('#add_win').window('open');
		$('#role_combox').combobox({
			url : '/NetCTOSS/role/findAll',
			method : 'GET',
			valueField : 'id',
			textField : 'roleName'
		});
	})

	// add_ok 确定 关闭窗口 提交数据
	$('#add_ok').click(function() {
		// 先验证 密码相不相同 然后 邮箱格式验证
		// 密码验证
		var add_admin_pwd = $('#add_admin_pwd').val();
		var add_admin_pwd_2 = $('#add_admin_pwd_2').val();
		if (add_admin_pwd === add_admin_pwd_2) {
			$.post("/NetCTOSS/admin/add", add_data(), function(msg) {
				var data = eval('(' + msg + ')');
				if (data) {
					showMessager("添加成功！");// 提示
				} else {
					showMessager("抱歉！系统繁忙！");// 提示
				}
			});
			$('#add_win').window('close');//关闭窗口
			$('#tt').datagrid('reload');// 刷新
		} else {
			showMessager("两次密码不一致");
		}

	})

	// add_not 取消 关闭窗口
	$('#add_not').click(function() {
		$('#add_win').window('close');
	})

	/**
	 * 修改功能模块
	 */
	
	
	// 修改获取数据
	function update_data(row) {
		var update_admin_name = $('#update_admin_name').val();
		var update_admin_acc = $('#update_admin_acc').val();
		var update_admin_pwd = $('#update_admin_pwd').val();
		var update_admin_phone = $('#update_admin_phone').val();
		var update_admin_e = $('#update_admin_e').val();
		var roleID = $('#update_role_combox').combobox('getValue');
		var json = {
			id : row.id,
			adminName : update_admin_name,
			loginName : update_admin_acc,
			telephone : update_admin_pwd,
			password : update_admin_phone,
			email : update_admin_e,
			roleID : roleID
		}
		return json;
	}



	//将选中行的数据显示到修改input框里面
	function showUpdateData(row){
		// 更改所有修改框里面的值
		$("#update_admin_name").textbox('setValue', row.adminName);
		$("#update_admin_acc").textbox('setValue', row.loginName);
		$("#update_admin_phone").textbox('setValue', row.telephone);
		$("#update_admin_e").textbox('setValue', row.email);
		// 显示角色
		$('#update_role_combox').combobox({ 
			url : '/NetCTOSS/role/findAll',
			method : 'GET',
			valueField : 'id',
			textField : 'roleName'
		});
	}
	
	// 点击修改按钮
	$('#edit').click(function() {
		var row = $('#tt').datagrid('getSelected');
		if (row != null) {
			$('#update_win').window('open');
			showUpdateData(row);//显示修改的原数据
		} else {
			showMessager('请选择需要修改的行！');
		}
	});
	
	// 原密码验证
	function oldpwd(row) {
		var old_pwd = $('#update_admin_old_pwd').val();
		if (old_pwd == row.password) {
			return true;
		}
		return false;
	}

	// update_ok 确定 关闭窗口 提交数据
	$('#update_ok').click(function() {
		var row = $('#tt').datagrid('getSelected');
		// 先验证 密码相不相同 然后
		if(oldpwd(row)){  // oldpwd(row)验证原密码
			 $.ajax({
				   url: "/NetCTOSS/admin/update",
				   type:'PUT',
				   data: update_data(row),
				   success: function(msg) {
						var data = eval('(' + msg + ')');
						if (data) {
							showMessager('修改成功！'); // 提示
							$('#update_win').window('close');// 关闭窗口
							$('#tt').datagrid('reload'); // 刷新
						} else {
							showMessager('抱歉！系统繁忙！');// 提示
							$('#update_win').window('close');// 关闭窗口
							$('#tt').datagrid('reload'); // 刷新
						}
					}
				 });
		}else{
			showMessager('原密码错误！');// 提示
		}
		
		$('#add_win').window('close');
	})

	// update_not 取消 关闭窗口
	$('#update_not').click(function() {
		$('#update_win').window('close');
	})

	/**
	 * 删除功能块
	 */
	
	// 删除
	$('#delete').click(function() {
		var row = $('#tt').datagrid('getSelected');
		if (row != null) {
			$.ajax({
				url : "/NetCTOSS/admin/delete",
				data : {
					id : row.id,
					adminName : row.adminName,
					loginName : row.loginName,
					telephone : row.telephone,
					password : row.password,
					email : row.email,
				},
				type : 'DELETE',
				success : function(msg) {
					var data = eval('(' + msg + ')');
					if (data) {
						// 提示
						showMessager('删除成功！');
						// 刷新
						$('#tt').datagrid('reload');
					} else {
						// 提示
						showMessager('抱歉！系统繁忙！');
					}
				}
			});
		} else {
			showMessager("请选择需要删除的行");
		}
	});

	/**
	 * 消息提示
	 */
	function showMessager(mag) {
		$.messager.show({
			title : '消息提示',
			msg : mag,
			timeout : 2000,
			showType : 'slide'
		});
	}

})