$(function(){

	showData();
	// 数据展示
	function showData(json){
		$('#tt').datagrid({
	        url:'/NetCTOSS/user/find',
	        queryParams:json,
	        columns:[[
	            {field:'userName',title:'姓名',width:12,align:'center'},
	            {field:'loginName',title:'账务帐号',width:12,align:'center'},
	            {field:'idCard',title:'身份证号码',width:12,align:'center'},
	            {field:'tel',title:'联系电话',width:12,align:'center'},
	            {field:'address',title:'通讯地址',width:12,align:'center'}
	        ]],
	        toolbar:'#tb'
	    });
	};
	
	// 查询数据
	function queryData(){
		var name = $('#name').val();
		var acc = $('#acc').val();
		
		var json = {
				userName:name,
				loginName:acc
		}
		return json;
	}
	
	// 点击查询
	$('#query').click(function(){
		var json = queryData();
		showData(json);
	})

	// 添加
    $('#add').click(function(){
        $('#add_dialog').dialog('open');
    });
    
	//添加获取数据
    function queryParamsToSave(){
        var customName = $('#u_name').val();
        var loginName = $('#login_name').val();
        var password = $('#pass_word').val();
        var gender = $('#gender').combobox('getValue');
        var idcard = $('#id_card').val();
        var tel = $('#u_tel').val();
        var postcode = $('#u_postcode').val();
        var address = $('#u_address').val();
        var qq = $('#u_qq').val();
        var createTime = new Date();
        
        var data = {
            "userName":customName,
            "tel":tel,
            "idCard":idcard,
            "gender":gender,
            "address":address,
            "postcode":postcode,
            "qq":qq,
            "loginName":loginName,
            "password":password
        };
        
        return data;
    }

    // 新增
    $('#save_users').click(function(){
       console.info(queryParamsToSave());
       $.post("/NetCTOSS/user/addone", queryParamsToSave(),
    		   function(data){
		    	   var msg = eval('(' + data + ')');
		    	   	if(msg){
		    	   		showMessager('添加成功');
		    	   		winClose();
		    	   	}else{
		    	   		showMessager('失败');
		    	   	}
    		   });
    });
    //添加确定后 关闭窗口 并且清空数据
    function winClose(){
    	 $('#add_dialog').dialog('close');
    	 $('#tt').datagrid('reload');
    	 addDataClean();
    }
    //清空ADD数据
    function addDataClean(){
    	validatebox :$("#u_name").val('');
    	validatebox :$("#login_name").val('');
    	validatebox :$("#pass_word").val('');
    	validatebox :$("#id_card").val('');
    	validatebox :$("#u_tel").val('');
    	validatebox :$("#u_postcode").val('');
    	validatebox :$("#u_address").val('');
    	validatebox :$("#u_qq").val('');
    }
    
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


    // 修改
    $('#edit').click(function(){
        var rows = $('#tt').datagrid('getSelected')// 返回的第1行记录
        if(rows){// 如果选中了数据，就进入if语句
        	$('#update_dialog').dialog('open');
        	showUpdateData(rows);
        }else{
        	showMessager('请选择需要修改的数据！');
        }
    });
    
    //修改显示原数据
    function showUpdateData(rows){
    	validatebox :$("#up_name").val(rows.userName);
	    validatebox :$("#up_loginName").val(rows.loginName);
	    
	    validatebox :$("#up_idCard").val(rows.idCard);
	    validatebox :$("#up_tel").val(rows.tel);
	    validatebox :$("up_postcode").val(rows.postcode);
	    validatebox :$("#up_address").val(rows.address);
	    validatebox :$("#up_qq").val(rows.qq);
    }
    
    //修改数据的获取
    function getUpdataData(rows){
    	var name = $("#up_name").val(rows.userName);
    	var loginName = $("#up_loginName").val();
    	var gender = $('#up_gender').combobox('getValue');
    	var idCard = $("#up_idCard").val(rows.idCard);
    	var tel = $("#up_tel").val(rows.tel);
    	var postcode = $("up_postcode").val(rows.postcode);
    	var address = $("#up_address").val(rows.address);
    	var qq = $("#up_qq").val(rows.qq);
    	var json = {
    			id:rows.id,
    			userName:name,
    			loginName:loginName,
    			gender:gender,
    			idCard:idCard,
    			tel:up_tel,
    			postcode:postcode,
                address:address,
                qq:qq
    	}
    	return json;
    }
   
    // 修改保存
    $('#update_users').click(function(){
        var url = "/NetCTOSS/user/updateone";
        var row = $('#tt').datagrid('getSelected');
        $.ajax({
			   url: url,
			   type:'PUT',
			   data: getUpdataData(row),
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
    });





    $('#delete').click(function(){
        // 返回的是：所选择数据的数组
        var rows = $('#tt').datagrid('getSelections')
        var lenth = rows.length;
        
        var url = "/NetCTOSS/user/deleteone";
        if(lenth == 0){// 没有选择任何需要被删除的数据
            $.messager.show({
                title:'消息提示',
                msg:'请选择需要删除的数据！',
                timeout:5000,
                showType:'slide'
            });
        }else{// 已经选择了，需要被删除的数据
            $.messager.confirm('友情提示', '你确定需要删除这些数据么?', function(r){
                if (r){
                    var json = $.toJSON(rows);
                    $.ajax({
                        type: "DELETE",
                        url: url,
                        contentType:"application/json",
                        data: json,
                        success: function(){
                            $.messager.show({
                                title:'消息提示',
                                msg:"删除成功",
                                timeout:5000,
                                showType:'slide'
                            });
                            $('#tt').datagrid('reload');// 重新加载数据
                        }
                    });
                }
            });
        }
    });
});


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
}



$(function () {

    $('#tip').click(function(){

    	 var url = "/NetCTOSS/user/findone";
        var rows = $('#tt').datagrid('getSelections');
        var row = $('#tt').datagrid('getSelected')// 返回的第1行记录
        if(row){// 如果选中了数据，就进入if语句
            var lenth = rows.length;
            if(lenth == 1){
            	
            	var json = $.toJSON(rows);
            	 $.ajax({
                     type: "GET",
                     url: url,
                     contentType:"application/json",
                     data: json,
                     success: function(row){
                    	 
                    	  $('#t_loginname').attr('value',row.loginName);
                          $('#t_name').attr('value',row.userName);
                          if(row.gender == 1){
                        	  $('#t_gender').attr('value',"男");
                          }else{
                          $('#t_gender').attr('value',"女");
                          }
                          
                          $('#t_idcard').attr('value',row.idCard);
                          $('#t_tel').attr('value',row.tel);
                          $('#t_posd').combobox('select', row.u_postcode);
                          $('#t_add').combobox('select', row.address);
                          $('#t_qq').combobox('select', row.qq);
                     }
                 });
            	
                $('#tip_dialog').dialog('open');// 打开窗体
            }else{
                $.messager.show({
                    title:'消息提示',
                    msg:'每次只能修改一条数据！',
                    timeout:5000,
                    showType:'slide'
                });
            }
        }else{
            $.messager.show({
                title:'消息提示',
                msg:'请选择需要查看的数据！',
                timeout:3000,
                showType:'slide'
            });
        }
    });

    $('#adds_from').form({    
        url:"/NetCTOSS/user/users",
        onSubmit: function(){    
            // do some check
            // return false to prevent submit;
        	return true;
        },    
        success:function(data){    
           
        }    
    });    
    // submit the form
    $(function(){   
        $('#sub').bind('click', function(){   
        	 $('#adds_from').submit();
        });   
    });  
   
})

