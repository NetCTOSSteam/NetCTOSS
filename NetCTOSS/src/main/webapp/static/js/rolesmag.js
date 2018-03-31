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
            				str = row.powers[i].powerName;
            			}else{
            				str = row.powers[i].powerName;
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
        	            if(result[i].powerName.length == 2){
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
            	add_roleName : $("#add_roleName").val(),
            	add_type : $("#add_type").val(),
            	allPermission : $("input[type='checkbox']").attr('value')
            },
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
            	if($("input[type='checkbox']").is(':checked')
            			&&$("#add_roleName").val() != "" || $.trim($("#add_roleName").val()).length != 0){
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
             	   url: "/NetCTOSS/power/findAllPowers",
             	   success: function(result){
             		  $("#permission1").html('');
             		   for(var i=0; i < result.length; i++ ){
             	            $("#permission1").append(
             	                "<label>" 
             	                    + "<input name='items' type='checkbox' value=" 
             	                        + result[i].powerName
             	                    + ">"
             	                        + result[i].powerName
             	                +"</label>" + "&nbsp;&nbsp;"
             	            );
             	          /* if(row.powers[i].powerName=result[i].powerName){
              				  $("input[type=checkbox value='result[i].powerName']").attr("checked","checked");
              			   };*/
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
				$('#permission1').attr('value', row.powers);
				
				$('#update_dialog').form('validate');
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
        // 返回第一个被选中的行或如果没有选中的行则返回null
        var row = $('#tt').datagrid('getSelected')
        
        //jquery获取复选框值  
        var chk_value =[];//定义一个数组  
        $('input[name="items"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数  
        	chk_value.push($(this).val());//将选中的值添加到数组chk_value中  
        });
        var json = $.toJSON(chk_value);
        
        if (row == null) {// 没有选择任何需要被修改的数据
			$.messager.alert({
				title : '消息提示',
				msg : '请选择需要修改的数据！',
				timeout : 5000,
				showType : 'slide'
			});
        }else{// 已经选择了，需要被修改的数据
            $.messager.confirm('友情提示', '你确定需要修改这条数据么?', function(r){
                    var url = "/NetCTOSS/role/"+row.id;
                    $.ajax({
                        type: "PUT",
                        url: url,
                        data :{
                   		   id : row.id,
                   		 roleName : $('#roleName1').val(),
                   		  items : json
                   	   },
                        success: function(msg){
                            $.messager.show({
                                title:'消息提示',
                                msg:msg.information,
                                timeout:5000,
                                showType:'slide'
                            });
                            
                            $('#update_dialog').dialog('close');
                            
                            $('#tt').datagrid('reload',queryParams());// 重新加载数据
                        }
                    });
                
            });
        }
    });
    
    $('#delete').click(function(){
        // 返回第一个被选中的行或如果没有选中的行则返回null
        var row = $('#tt').datagrid('getSelected')
        if (row == null) {// 没有选择任何需要被删除的数据
			$.messager.alert({
				title : '消息提示',
				msg : '请选择需要删除的数据！',
				timeout : 5000,
				showType : 'slide'
			});
        }else{// 已经选择了，需要被删除的数据
            $.messager.confirm('友情提示', '你确定需要删除这条数据么?', function(r){
                    var json = $.toJSON(row);
                    var url = "/NetCTOSS/role/delete/"+row.id;
                    $.ajax({
                        type: "PUT",
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
                
            });
        }
    });
});