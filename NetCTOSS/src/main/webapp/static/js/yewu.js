
$(function () {

    //双击数据行
    $('#tt').datagrid({
        onDblClickRow:function (row) {
        	var json = {"busName":row.busName,"state":row.state,"serverIP":row.serverIP};
        	$.ajax({
            	url: "/NetCTOSS/busi/findone",
            	type: "GET", 
            	data:json,
            	contentType:"application/json",
            	async: false,
            	success: function(row){
            		$('#server').text(row.loginName);
                    $('#zifei').text(row.mealBean.mealName);
                   
                    $('#service_ip').text(row.serverIP);
                    $('#os').text(row.loginName);
            }});
            $('#x_data').window('open');
        }
    });
    
    //详细信息的返回按钮
    $('#x_back').click(function () {
        $('#x_data').window('close');
    });

    
    //添加
    $('#not').click(function () {
        $('#add_win').window('close');
    });

    //修改
    $('#not_2').click(function () {
        $('#update_win').window('close');
    });

    
    
    /**
     * 工具按钮的功能
     */
    //改变状态  开通或者暂停
    $('#openOrClose').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
        	var json = {"busName":row.busName,"state":row.state,"serverIP":row.serverIP};
        	
        	$.ajax({
            	url: "/NetCTOSS/busi/updatSata",
            	type: "GET", 
            	data:json,
            	contentType:"application/json",
            	async: false,
            	success: function(){
            		$('#tt').datagrid('reload',queryParams());
            }});
        	
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //删除按钮
    $('#delete').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
        	var json = {"busName":row.busName,"state":row.state,"serverIP":row.serverIP};
        	$.ajax({
            	url: "/NetCTOSS/busi/delete",
            	type: "DELETE", 
            	data:json,
            	contentType:"application/json",
            	async: false,
            	success: function(){
            		$('#tt').datagrid('reload',queryParams());
            }});
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //修改按钮 控制弹窗
    $('#update').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
        	 var json = {"busName":row.busName,"state":row.state,"serverIP":row.serverIP};
            $('#update_win').window('open');
            //资费数据
            
            $.ajax({
            	url: "/NetCTOSS/busi/findone",
            	type: "GET", 
            	data:json,
            	contentType:"application/json",
            	async: false,
            	success: function(row){
            		 $("update_acc").text(row.userBean.userName);
            		 $("update_osacc").text(row.busName);
            		 $("hid").attr("value",row.id);
                     $('#update_zifei').combobox({
                         url:'/NetCTOSS/tar/allname',
                         valueField:'id',
                         textField:'text'
                     });
            }});
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //确定修改
    $('#ok_1').click(function () {
    	var json = {"id":$("#hid").val(),
    			"update_zifei":$("#update_zifei").combobox("getData"),
    			"update_pwd":$("#update_pwd").val()};
    	if($("#update_pwd").val() == $("#update_pwd2").val()){
        	 
            $('#update_win').window('close');
            //资费数据
           
            $.ajax({
            	url: "/NetCTOSS/busi/updateone",
            	type: "PUT", 
            	data:json,
            	contentType:"application/json",
            	async: false,
            	success: function(){
            		
            }});
            
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"两次输入的密码不同！！",
                timeout:5000,
                showType:'slide'
            });
        }
    });
    
    
    //添加按钮 控制弹窗
    $('#add').click(function () {
            $('#add_win').window('open');
            //资费数据
            $('#update_zifei').combobox({
                url:'/NetCTOSS/tar/allname',
                valueField:'id',
                textField:'text'
            });
            //显示所有的 的 账务账户
            $('#acc').combobox({
            	url:'/NetCTOSS/user/allname',
            	valueField:'id',
            	textField:'text'
            });


})
//确定  添加
$('#ok_1').click(function () {
	var json = {
			"acc":$("#acc").combobox("getData"),
			"zi_fei":$("#zi_fei").combobox("getData"),
			
			"busName":$("#OS_id").val(),
			"serverIP":$("#server_ip").val(),
			"serverIP":$("#server_ip").val(),
			"password":$("#pwd").val(),
			};
	if(($("#pwd").val()) == ($("#pwd2").val())){
    	 
        $('#update_win').window('close');
        //资费数据
        $.ajax({
        	url: "/NetCTOSS/busi/updateone",
        	type: "PUT", 
        	data:json,
        	contentType:"application/json",
        	async: false,
        	success: function(){
        		
        }});
        
    }else{
        $.messager.show({
            title:'消息提示',
            msg:"两次输入的密码不同！！",
            timeout:5000,
            showType:'slide'
        });
    }
});

})


/**
 * 初始化数据显示
 */
$(function () {
    $('#tt').datagrid({
        url:'/NetCTOSS/busi/find',
        columns:[[
            {field:'busName',title:'业务账号',width:12,align:'center'},
            {field:'mealBean.mealName',title:'资费名称',width:12,align:'center',
            	formatter: function(value,row,index){
            		if(row){
            			return row.mealBean.mealName;
            		}
            	}},
            {field:'state',title:'状态',width:12,align:'center'},
            {field:'serverIP',title:'服务器IP',width:12,align:'center'},
            {field:'userBean.userName',title:'账务账号',width:12,align:'center',
            	formatter: function(value,row,index){
            		if(row){
            			return row.userBean.userName;
            		}
            	}}
        ]],
        toolbar:'#tb'
    });
    
    //查询参数的封装
	function queryParams(){
		
		var busName = $('#busName').val();
		var mealName = $('#mealName').val();
		var state = $('#state').combobox('getValue'); 
		
		var data = {
				busName:busName,
				mealName:mealName,
				state:state,
				};
		return data;
	}
	 //条件查询功能
	$('#query').click(function(){
		console.info(queryParams());
//		$('#tt').datagrid('reload',queryParams());
		$('#tt').datagrid({
	        url:'/NetCTOSS/busi/find',
	        queryParams:queryParams(),
        	method:"GET",
	        columns:[[
	            {field:'busName',title:'业务账号',width:12,align:'center'},
	            {field:'mealBean.mealName',title:'资费类型',width:12,align:'center',
	            	formatter: function(value,row,index){
	            		if(row){
	            			return row.mealBean.mealName;
	            		}
	            	}},
	            {field:'state',title:'状态',width:12,align:'center'},
	            {field:'serverIP',title:'服务器IP',width:12,align:'center'},
	            {field:'userBean.userName',title:'账务账号',width:12,align:'center',
	            	formatter: function(value,row,index){
	            		if(row){
	            			return row.userBean.userName;
	            		}
	            	}}
	        ]],
	        toolbar:'#tb'
	    });
	});
})


