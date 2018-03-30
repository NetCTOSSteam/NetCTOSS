$(function(){
	
    // 默认数据列表的显示
    $('#tt').datagrid({
        url:"/NetCTOSS/role/findAllRoles",
        method:"GET",
        queryParams:queryParams(),
        columns:[[    
            {field:'ck',checkbox:true},    
            {field:'roleName',title:'角色名称',width:100,align:'center'},    
            {field:'powers',title:'权限',width:100,align:'center',
            	formatter:function(value,row,index){
            		var str = '';
            		for (var i = 0; i < row.powers.length; i++) {
            			if(row.powers.length ==1){
            				str = row.powers[i].powerName
            			}else{
            				str = row.powers[i].powerName + ',';
            			}
					}
            			return str;
                }
            }    
        ]]    
    });
    // 查询参数的封装
    function queryParams(){

        var roleName = $('#roleName').val();
        var permission = $('#permission').val();
        /*var str="";
        $("input[name=items]:checkbox:checked").each(function(){
            str = str + $(this).val() + ",";
        });*/
        var data = {
        	roleName:roleName,
        	permission:permission
        };
        return data;
    }
    
    $(document).keydown(function(event){ 
		if(event.keyCode==13){ 
			$('#query').click(); 
			} 
		}); 
    
    // 条件查询功能
    $('#query').click(function(){

        $('#tt').datagrid('reload',queryParams());

    });
    
    $('#add').click(function(){
        $('#add_dialog').dialog('open');
        $.ajax({
        	   type: "GET",
        	   url: "/NetCTOSS/power/findAllPowers",
        	   success: function(result){
        		   $("#allPermission").html('');
        		   for(var i=0; i < result.length; i++ ){
        	           $("#allPermission").append(
        	                "<label>" 
        	                    + "<input name='items' type='checkbox' value=" 
        	                        + result[i].powerName
        	                    + ">"
        	                        + result[i].powerName
        	                +"</label>" + "&nbsp;&nbsp;"
        	            );
        	          //一个汉字占两个字符
        	            if(result[i].powerName.length == 6){
        	                $("#permission").append("&nbsp;&nbsp;");
        	            }
        	            //每三个进行换行
        	            if( (i+1) % 3 == 0){
        	                $("#permission").append("<br>");
        	            }
        	        }
        	   }
        	});
    });
    
    // 新增
    $('#save_roles').click(function(){
        var url = "/NetCTOSS/role/save";
        $('#add_form').form('submit', {
            type:"POST",
            url:url,
            data:{
            	add_roleName : $("add_roleName").val(),
            	add_type : $("add_type").val(),
            	allPermission : $("input[type='checkbox']").attr('value')
            },
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
            	if($("input[type='checkbox']").is(':checked')){
            		return true;
            	}
            	return false;
            },
            success:function(data){
            	var data = eval('(' + data + ')');
                if(data.status==1){
                	$('#add_dialog').dialog('close');
                    $.messager.alert({
    					title : '消息提示',
    					msg : data.information,
    					timeout : 5000,
    					showType : 'slide'
    				});
                }
                $('#tt').datagrid('reload',queryParams());
            }
        });
    });
    // 修改
    $('#edit').click(function(){
        var rows = $('#tt').datagrid('getSelections');
        var row = $('#tt').datagrid('getSelected')// 返回的第1行记录
        
        if(row){// 如果选中了数据，就进入if语句
            var lenth = rows.length;
            if(lenth == 1){
                $('#update_dialog').dialog('open');// 打开修改窗体
                
                $.ajax({
             	   type: "GET",
             	   url: "power/findAllPowers",
             	   success: function(result){
             		   for(var i=0; i < result.length; i++ ){
             	            $("#permission1").append(
             	                "<label>" 
             	                    + "<input name='items' type='checkbox' value=" 
             	                        + result[i].powerName
             	                    + ">"
             	                        + result[i].powerName
             	                +"</label>" + "&nbsp;&nbsp;"
             	            );
             	            
             	          //一个汉字占两个字符
             	            if(result[i].powerName.length == 2){
             	                $("#permission1").append("&nbsp;&nbsp;");
             	            }
             	            //每三个进行换行
             	            if( (i+1) % 3 == 0){
             	                $("#permission1").append("<br>");
             	            }
             	        }
             	   }
             	});
                
				$('#roleName1').attr('value', row.roleName);
				$('#type1').attr('value', row.type);
				
				$('#update_customer').form('validate');
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
                msg:'请选择需要修改的数据！',
                timeout:3000,
                showType:'slide'
            });
        }
    });
    // 修改保存
    $('#update_role_bb').click(function(){
        var row = $('#tt').datagrid('getSelected')
        var url = "role/"+row.id;
        $('#update_role').form('submit', {
            url:url,
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
                return true;
            },
            success:function(data){
                var data = eval('(' + data + ')');
                if(data.status==1){
                    $('#update_dialog').dialog('close');
                }
                $.messager.show({
                    title:'消息提示',
                    msg:data.information,
                    timeout:3000,
                    showType:'slide'
                });

                $('#tt').datagrid('reload',queryParams());// 重新加载数据
            }
        });
    });
    $('#delete').click(function(){
        // 返回的是：所选择数据的数组
        var rows = $('#tt').datagrid('getSelections')
        var lenth = rows.length;
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
                    var url = "role/delete";
                    $.ajax({
                        type: "DELETE",
                        url: url,
                        contentType:"application/json",
                        data: json,
                        success: function(msg){
                            $.messager.show({
                                title:'消息提示',
                                msg:msg.information,
                                timeout:5000,
                                showType:'slide'
                            });
                            $('#tt').datagrid('reload',queryParams());// 重新加载数据
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