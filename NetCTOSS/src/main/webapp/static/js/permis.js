$(function(){
	
    // 默认数据列表的显示
    $('#tt').datagrid({
        url:"/NetCTOSS/power/findPowers",
        method:"GET",
        queryParams:queryParams(),
        columns:[[    
            {field:'ck',checkbox:true},    
            {field:'powerName',title:'权限名称',width:100,align:'center'},    
            {field:'describe',title:'权限描述',width:100,align:'center'}    
        ]]    
    });
    // 查询参数的封装
    function queryParams(){

        var powerName = $('#permissionName').val();
        var data1 = {
        	powerName:powerName
        };
        return data1;
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
    });
    // 新增
    $('#save_power').click(function(){
        var url = "/NetCTOSS/power/save";
        $('#add_form').form('submit', {
            type:"POST",
            url:url,
            data:{
            	powerName:$("#powerName").val(),
            	describe:$("#describe").val()
            },
            onSubmit: function(){
            	return $("#add_dialog").form('validate');
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
    $('#update').click(function(){
        var row = $('#tt').datagrid('getSelected')// 返回的第1行记录
        
        if(row){// 如果选中了数据，就进入if语句
                $('#update_dialog').dialog('open');// 打开修改窗体
                
				$("#powerName1").html(row.powerName);
				$("#describe1").val(row.describe);
				
				$('#update_dialog').form('validate');
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
    $('#update_power').click(function(){
    		var row = $('#tt').datagrid('getSelected')// 返回的第1行记录
            $.messager.confirm('友情提示', '你确定需要修改这条数据么?', function(r){
                    var url = "/NetCTOSS/power/"+row.id;
                    $.ajax({
                        type: "PUT",
                        url: url,
                        data :{
                   		   id : row.id,
                   		powerName:$("#powerName1").text().replace($("#powerName1").children().text(),''),
                   		 describe : $('#describe1').val()
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
                    var url = "/NetCTOSS/power/delete/"+row.id;
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