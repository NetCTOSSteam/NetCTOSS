$(function(){
	 
    // 默认数据列表的显示
    $('#tt').datagrid({
        url:"customs/page",
        method:"GET",
        queryParams:queryParams()
    });

    //查询参数的封装
    function queryParams(){

        var customName = $('#customName').val();
        var loginName = $('#loginName').val();
        var password = $('#password').val();
        var gender = $('#gender').val();
        var birthday = $('#birthday').val();
        var createTime = $('#createTime').val();

        var data = {
            customName:customName,
            loginName:loginName,
            password:password,
            gender:gender,
            birthday:birthday,
            createTime:createTime
        };

        return data;
    }
    //条件查询功能
    $('#query').click(function(){

        $('#tt').datagrid('reload',queryParams());

    });

    $('#add').click(function(){

        $('#add_users_dialog').dialog('open');
        	
        ddd();
    });

    function queryParamsToSave(){
        var customName = $('#c_customName').val();
        var loginName = $('#c_loginName').val();
        var password = $('#c_password').val();
        var gender = $('#c_gender').val();
        var birthday = $('#c_birthday').val();
        var createTime = new Date();
        var data = {
            customName:customName,
            loginName:loginName,
            password:password,
            gender:gender,
            birthday:birthday,
            createTime:createTime
        };
        return data;
    }


    //新增
    $('#save_users').click(function(){
        console.info("进来了");
        var url = "customs/save";
        console.info(queryParamsToSave());
        $('#add_custom_form').form('submit', {
            type:"POST",
            url:url,
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
                return true;
            },
            success:function(data){
                var data = eval('(' + data + ')');
                if(data.status){
                    $('#add_users_dialog').dialog('close');
                }

                $('#tt').datagrid('reload',queryParams());
            }

        });
        console.info("111111222");
    });


    //修改
    $('#edit').click(function(){

        var rows = $('#tt').datagrid('getSelections');
        var row = $('#tt').datagrid('getSelected')//返回的第1行记录
        if(row){//如果选中了数据，就进入if语句
            var lenth = rows.length;
            if(lenth == 1){
                $('#update_users_dialog').dialog('open');//打开修改窗体
                $('#c_id').attr('value',row.id);
                $('#c_version').attr('value',row.version);
                $('#c_password').attr('value',row.password);
                $('#c_customName').attr('value',row.customName);
                $('#c_loginName').attr('value',row.loginName);
                $('#c_gender').combobox('select', row.gender);
             
                $('#c_birthday').datebox('setValue',text);
                $('#update_user').form('validate');
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








    //修改保存
    $('#update_users').click(function(){
        var row = $('#tt').datagrid('getSelected')
        var url = "customs/"+row.id;
        $('#update_custom').form('submit', {
            url:url,
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
                return true;
            },
            success:function(data){
                var data = eval('(' + data + ')');
                if(data.status){
                    $('#update_users_dialog').dialog('close');
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
                    var url = "customs/batch";
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
$(function(){
    $('#cc').combo({
        required:true,
        editable:false
    });
    $('#sp').appendTo($('#cc').combo('panel'));
    $('#sp input').click(function(){
        var v = $(this).val();
        var s = $(this).next('span').text();
        $('#cc').combo('setValue', v).combo('setText', s).combo('hidePanel');
    });
    
 
});

$(function(){
    $('#cc1').combo({
        required:true,
        editable:false
    });
    $('#sp1').appendTo($('#cc1').combo('panel'));
    $('#sp1 input').click(function(){
        var v = $(this).val();
        var s = $(this).next('span').text();
        $('#cc1').combo('setValue', v).combo('setText', s).combo('hidePanel');
    });
  
   
    
});


function ddd(){
	var checkValue=$("#cc");
   

    if(checkValue.val()=="包月"){
     document.getElementById('ji').style.display='block';
     document.getElementById('dan').style.display='none';
     document.getElementById('data').style.display='none';
   
    }else if(checkValue.val()=="包时"){
    	  document.getElementById('dan').style.display='inline';
    	   document.getElementById('data').style.display='none';
    	   document.getElementById('ji').style.display='none';
    
    }else if(checkValue.val()=="套餐"){
    	  
    	   document.getElementById('data').style.display='inline';
    	   document.getElementById('ji').style.display='inline';
    	   document.getElementById('dan').style.display='inline';
    }
    } 


