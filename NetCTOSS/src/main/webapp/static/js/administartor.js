//初始化加载
$(function () {
    $('#tt').datagrid({
        url:'/NetCTOSS/admin/1',
        columns:[[
            {field:'adminName',title:'管理员名称',width:12,align:'center'},
            {field:'loginName',title:'管理员账号',width:12,align:'center'},
            {field:'telephone',title:'联系电话',width:12,align:'center'},
            {field:'email',title:'邮箱',width:12,align:'center'},
            {field:'type',title:'角色',width:12,align:'center',formatter:function(value,row,index){
            	return row.role.type;
            }}
        ]],
        toolbar:'#tb'
    });
})

$(function () {
    //模糊查询点击
    $('#query').click(function () {
    	var json  =  data();
        show_data(json);
    })

    // 查询过后 数据对应的更新
    function show_data(json) {
        $('#tt').datagrid({
            url:'/NetCTOSS/admin/2',
            method:"GET",
            queryParams:json,
            columns:[[
            	  {field:'adminName',title:'管理员名称',width:12,align:'center'},
                  {field:'loginName',title:'管理员账号',width:12,align:'center'},
                  {field:'telephone',title:'联系电话',width:12,align:'center'},
                  {field:'email',title:'邮箱',width:12,align:'center'},
                  {field:'role',title:'角色',width:12,align:'center',formatter:function(value,row,index){
                  	return row.role.type;
                  }}
            ]],
            toolbar:'#tb'
        });
    }

    //数据获取
    function data(){
       var admin_name = $('#admin_name').val();
       var admin_acc = $('#admin_acc').val();
       var json = {adminName:admin_name,loginName:admin_acc}
       return json
    }

    /**
     * 添加
     */

    //添加需要的数据
    function add_data() {
        var add_admin_name = $('#add_admin_name').val();
        var add_admin_acc = $('#add_admin_acc').val();
        var add_admin_pwd = $('#add_admin_pwd').val();
        var add_admin_phone = $('#add_admin_phone').val();
        var add_admin_e = $('#add_admin_e').val();
        var data = {
        	adminName:add_admin_name,
        	loginName:add_admin_acc,
        	password:add_admin_pwd,
            telephone:add_admin_phone,
            email:add_admin_e
        };
        return data;
    }

    //添加
    $('#add').click(function () {
        $('#add_win').window('open');
    })

    //add_ok    确定  关闭窗口 提交数据
    $('#add_ok').click(function () {

        //先验证  密码相不相同 然后 邮箱格式验证
    	//密码验证
    	var add_admin_pwd = $('#add_admin_pwd').val();
    	var add_admin_pwd_2 = $('#add_admin_pwd_2').val();
    	if(add_admin_pwd===add_admin_pwd_2){
            $.post("/NetCTOSS/admin/add",add_data(),function (msg) {
                var data = eval('(' + msg + ')');
                if(data){
                    // 提示
                    $.messager.show({
                        title : '消息提示',
                        msg : '添加成功！',
                        timeout : 1000,
                        showType : 'slide'
                    });
                }else{
                    // 提示
                    $.messager.show({
                        title : '消息提示',
                        msg : '抱歉！系统繁忙！',
                        timeout : 1000,
                        showType : 'slide'
                    });
                }
            });
            $('#add_win').window('close');
    	}else{
    		  $.messager.show({
                  title : '消息提示',
                  msg : '两次密码不一致！',
                  timeout : 1000,
                  showType : 'slide'
              });
    	}
    	
    	
    	
    	
    })

    //add_not   取消  关闭窗口
    $('#add_not').click(function () {
        $('#add_win').window('close');
    })




    /**
     * 修改
     */
    //修改获取数据
    function update_data(row){
    	var update_admin_name = $('#update_admin_name').val();
    	var update_admin_acc = $('#update_admin_acc').val();
    	var update_admin_pwd = $('#update_admin_pwd').val();
    	var update_admin_phone = $('#update_admin_phone').val();
    	var update_admin_e = $('#update_admin_e').val();
    
    	var json = {
    				  id:row.id,
   			   adminName:update_admin_name,
   			   loginName:update_admin_acc,
   			   telephone:update_admin_pwd,
   			    password:update_admin_phone,
   			       email:update_admin_e
    	}
    	return json;
    }
    
    
    //update_admin_old_pwd  原密码验证
    function oldpwd(row){
    	var old_pwd = $('#update_admin_old_pwd').val();
    	if(old_pwd==row.password){
    		return true;
    	}
    	return false;
    }

    //修改
    $('#edit').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
            $('#update_win').window('open');
            
            //更改所有修改框里面的值
            $('#update_admin_name').html(row.adminName)
            $('#update_admin_acc').html(row.loginName)
            $('#update_admin_phone').html(row.telephone)
            $('#update_admin_e').html(row.email)
            
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要修改的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //update_ok    确定  关闭窗口 提交数据
    $('#update_ok').click(function () {

        //先验证  密码相不相同 然后 邮箱格式验证

        $.post("/NetCTOSS/admin/update",update_data(),function (msg) {
            var data = eval('(' + msg + ')');
            if(data){
                // 提示
                $.messager.show({
                    title : '消息提示',
                    msg : '添加成功！',
                    timeout : 3000,
                    showType : 'slide'
                });
                $('#update_win').window('close');
                //刷新
                $('#tt').datagrid('reload');
            }else{
                // 提示
                $.messager.show({
                    title : '消息提示',
                    msg : '抱歉！系统繁忙！',
                    timeout : 3000,
                    showType : 'slide'
                });
                $('#update_win').window('close');
            }
        });



        $('#add_win').window('close');
    })

    //update_not   取消  关闭窗口
    $('#update_not').click(function () {
        $('#update_win').window('close');
    })


    /**
     * 删除
     */
    //删除
    $('#delete').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
        	 $.ajax({
        		   url: "/NetCTOSS/admin/delete",
        		   data: {
        			   id:row.id,
        			   adminName:row.adminName,
        			   loginName:row.loginName,
        			   telephone:row.telephone,
        			   password:row.password,
        			   email:row.email,
        		   },
        		   type:'DELETE',
        		   success: function(msg){
        			   var data = eval('(' + msg + ')');
        			   if(data){
        	                // 提示
        	                $.messager.show({
        	                    title : '消息提示',
        	                    msg : '删除成功！',
        	                    timeout : 3000,
        	                    showType : 'slide'
        	                });
        	                $('#tt').datagrid('reload');
        	            }else{
        	                // 提示
        	                $.messager.show({
        	                    title : '消息提示',
        	                    msg : '抱歉！系统繁忙！',
        	                    timeout : 3000,
        	                    showType : 'slide'
        	                });
        	            }
        		   }
        		 });
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要删除的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });



})