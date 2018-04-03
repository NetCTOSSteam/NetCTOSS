$(function(){

	$('#tt').datagrid({
        url:'/NetCTOSS/user/find',
        columns:[[
            {field:'userName',title:'姓名',width:12,align:'center'},
            {field:'loginName',title:'账务帐号',width:12,align:'center'},
            {field:'idCard',title:'身份证号码',width:12,align:'center'},
            {field:'tel',title:'联系电话',width:12,align:'center'},
            {field:'address',title:'通讯地址',width:12,align:'center'}
        ]],
        
        toolbar:'#tb'
    });
	
    //条件查询功能
    $('#query').click(function(){

    	  var customName = $('#name').val();
          var loginName = $('#acc').val();
    	var data = {"userName":customName,"loginName":loginName};
    	 $('#tt').datagrid({
    	        url:'/NetCTOSS/user/find',
    	        mothod:GET,
    	        data:data
    	    });
    });

    $('#add').click(function(){
        $('#add_dialog').dialog('open');
    });
    
    function queryParamsToSave(){
        var customName = $('#u_name').val();
        var loginName = $('#login_name').val();
        var password = $('#pass_word').val();
        var gender
        if($('#u_gender').val() == "男"){
        	 gender =1;
        }else{
        	 gender = 0;
        }
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

    //新增
    $('#save_users').click(function(){
        console.info("进来了");
        
        var url = "/NetCTOSS/user/addone";
        console.info(queryParamsToSave());
        
        $('#add_form').form('submit', {
            type:"POST",
            url:url,
            data:queryParamsToSave(),
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
                return true;
            },
            success:function(data){
                
            	$('#add_dialog').dialog('close');

                //添加成功 更新数据
                $('#tt').datagrid('reload',queryParams());
            }
        });
    });


    //修改
    $('#edit').click(function(){

        var rows = $('#tt').datagrid('getSelections');
        var row = $('#tt').datagrid('getSelected')//返回的第1行记录
        if(row){//如果选中了数据，就进入if语句
        	var json = $.toJSON(row);
            var lenth = rows.length;
            if(lenth == 1){
                $('#update_dialog').dialog('open');//打开修改窗体
                $.ajax({
                	url: "/NetCTOSS/user/findone",
                	type: "GET", 
                	data:json,
                	contentType:"application/json",
                	async: false,
                	success: function(row){
                		$('#loginname').attr('value',row.loginName);
                        $('#names').attr('value',row.userName);
                        if(row.ggender==1){
                        	$('#gender').attr('value',"男");
                        }else{
                        	$('#gender').attr('value',"女");
                        }
                        $('#idCard').attr('value',row.idCard);
                        $('#password').attr('value',row.password);
                        $('#tel').attr('value', row.tel);
                        $('#postcode').attr('value', row.postcode);
                        $('#address').attr('value', row.address);
                        $('#qq').attr('value', row.qq);
                        $('#id').attr('value', row.id);
                }});
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
    //得到修改对象
    function queryParamsToUpdate(){
        var customName = $('#names').val();
        var loginName = $('#loginname').val();
        var password = $('#pass_word').val();
        var gender
        if($('#u_gender').val() == "男"){
        	 gender =1;
        }else{
        	 gender = 0;
        }
        var idcard = $('#idCard').val();
        var tel = $('#tel').val();
        var postcode = $('#postcode').val();
        var address = $('#address').val();
        var qq = $('#qq').val();
        var id = $('#id').val();
   
        var data = {
            "userName":customName,
            "tel":tel,
            "idCard":idcard,
            "gender":gender,
            "address":address,
            "postcode":postcode,
            "qq":qq,
            "loginName":loginName,
            "id":id
        };
        
        return data;
    }
    //修改保存
    $('#update_users').click(function(){
    	
        
        var url = "/NetCTOSS/user/updateone";
        $('#update_custom').form('submit', {
            url:url,
            data:queryParamsToUpdate(),
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
                return true;
            },
            success:function(data){
                
                $('#update_dialog').dialog('close');
                
                $('#tt').datagrid('reload',queryParams());// 重新加载数据
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
                    var json = $.toJSON(row);
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



$(function () {

    $('#tip').click(function(){

    	 var url = "/NetCTOSS/user/findone";
        var rows = $('#tt').datagrid('getSelections');
        var row = $('#tt').datagrid('getSelected')//返回的第1行记录
        if(row){//如果选中了数据，就进入if语句
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

