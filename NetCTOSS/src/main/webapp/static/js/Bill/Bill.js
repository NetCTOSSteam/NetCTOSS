$(function () {

    var flag = true;
    var onpay = true;

    //双击数据行
    $('#tt').datagrid({
        onDblClickRow:function (rowIndex, rowData) {
        	//console.info(rowData.account);
        	//var obj = eval('(' + rowData.account + ')');
           	var jso = {"account":rowData.account};
        	//console.info(jso);
            if(flag){
                $('#table_noe').hide();
                $('#table_two').show();
                osacc(jso);
            }else{
              	var jso = {"businessAccount":rowData.businessAccount};
              	console.info(jso);
              	server(jso);
                $('#x_data').window('open');
                
            }
        }
    });

    //服务器数据显示
    function server(data){
    	
    	$.ajax({
			type:"GET",
			url:"/NetCTOSS/serviceAndBusiness/one",
			data:data,
			success :function(msg){
				console.log(msg);
			
				$('#server_ip').html(msg.serverIP);
				$('#time').html(msg.onlineTimr);
				$('#startTime').html(msg.startTime);
				$('#endTime').html(msg.endTime);
				$('#money').html(msg.money);
				$('#x_tariff').html(msg.tariff);
			}
		});
//    	$('#server').datagrid({
//    		url:"/NetCTOSS/serviceAndBusiness/one",
//    		method:"GET",
//    		queryParams:data
//    	});
    }
    

    	
    //回退
    $('#back').click(function () {
        $('#table_noe').show();
        $('#table_two').hide();
        moth();
    });

    //详细信息的返回按钮
    $('#x_back').click(function () {
        $('#x_data').window('close');
    })

    //OS账号明细
    function osacc(data){
    	
        $('#pay').hide();
        flag = false;
        $('#tt').datagrid({
            url:"/NetCTOSS/monthBusiness/all",
         	queryParams:data,
         	method:"GET",
            columns:[[
                {field:'businessAccount',title:'OS账号',width:80,align:'center'},
                {field:'server',title:'服务器信息',width:80,align:'center'},
                {field:'nowTime',title:'时长（单位：时分秒）',width:80,align:'center'},
                {field:'money',title:'费用',width:80,align:'center'},
                {field:'tariff',title:'资费套餐',width:80,align:'center'},
            ]],
            toolbar:'#tb'
        });
        $('#tariff').combobox({
            url:'',
            valueField:'id',
            textField:'text'
        });
    };
    //月账单加载
    function moth(data){
        $('#pay').show();
        flag = true;
        $('#tt').datagrid({
        	url:'/NetCTOSS/monthAcc/all',
        	queryParams:data,
        	method:"GET",
            columns:[[
                {field:'account',title:'账务账号',width:12,align:'center'},
                {field:'IDcard',title:'身份证',width:12,align:'center'},
                {field:'name',title:'用户姓名',idth:12,align:'center'},
                {field:'money',title:'总费用',width:12,align:'center'},
                {field:'year',title:'年-月',width:12,align:'center'},
                {field:'status',title:'支付状态',width:12,align:'center',	
                	formatter: function(value,row,index){
    				var ret = '';
    				if (value == '1'){
    					ret = '刷卡';
    				} else if(value == '2'){
    					ret = '支付宝';
    				}
    				else if(value == '3'){
    					ret = '微信';
    				}
    				else if(value == '4'){
    					ret = '现金';
    				}
    				return ret;
    			}},
                {field:'type',title:'支付方式',width:12,align:'center'}
            ]],
            toolbar:'#tb'
        });
    };
    //点击支付按钮
    $('#pay').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
            $('#win').window('open');
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });
    //支付确认
    $('#ok').click(function () {

    });
    //支付取消
    $('#not').click(function () {
        $('#win').window('close');
    });

	/**
	 * 修改
	 */
	$('#edit').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')//返回的第1行记录
		if(row){//如果选中了数据，就进入if语句
			var lenth = rows.length;
			if(lenth == 1){
				$('#update_users_dialog').dialog('open');//打开修改窗体
				$('#u_id').attr('value',row.id);
				$('#u_version').attr('value',row.version);
				$('#u_password').attr('value',row.password);
				$('#u_userName').attr('value',row.userName);
				$('#u_loginName').attr('value',row.loginName);
				$('#u_gender').combobox('select', row.gender);
				var text = dateformatter(new Date(row.birthday));
				$('#u_birthday').datebox('setValue',text);
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
				timeout:5000,
				showType:'slide'
			});
		}
	});

    
    
    /**
	 * 月账务条件查询参数的封装
	 */
	function queryParams(){
		
		var account = $('#account').val().trim();
		var IDcard = $('#IDcard').val().trim();
		var name = $('#name').val().trim();
		
		var year = $('#year').combobox('getValue').trim();
		var month = $('#month').combobox('getValue').trim();
		
		var data = {
				account:account,
				year:year,
				month:month,
				IDcard:IDcard,
				name:name
				};
	
		return data;

	}
	
	/**
	 * 月账务条件条件查询功能
	 */
	  
	$('#query').click(function(){
		moth(queryParams());
	});
	
	
	 /**
	 * 月业务条件查询参数的封装
	 */
	function osQueryParams(){
		
		var businessAccount = $('#businessAccount').val().trim();
		var tariff = $('#tariff').val().trim();
		var server = $('#server').val().trim();
		var data = {
				businessAccount:businessAccount,
				tariff:tariff,
				server:server,
				};
	
		return data;
	}
	
	/**
	 * OS账号明细条件查询
	 */
	$('#query_two').click(function(){

    
        $('#tt').datagrid({
            url:"/NetCTOSS/monthBusiness/likeAll",
         	queryParams:osQueryParams(),
         	method:"GET",
            columns:[[
                {field:'businessAccount',title:'OS账号',width:80,align:'center'},
                {field:'server',title:'服务器信息',width:80,align:'center'},
                {field:'nowTime',title:'时长（单位：时分秒）',width:80,align:'center'},
                {field:'money',title:'费用',width:80,align:'center'},
                {field:'tariff',title:'资费套餐',width:80,align:'center'},
            ]],
            toolbar:'#tb',
        	onLoadSuccess:function(data){
        		if(data.total>0)return;
        		$('#dg').datagrid('appendRow',{
        		    中间显示的列的字段名称: '没有相关记录'
        		});
        		}
        });
     
	});
})

    //初始化加载
$(function () {
	
	
    $('#tt').datagrid({
        url:'/NetCTOSS/monthAcc/all',
        columns:[[
            {field:'account',title:'账务账号',width:12,align:'center'},
            {field:'IDcard',title:'身份证',width:12,align:'center'},
            {field:'name',title:'用户姓名',idth:12,align:'center'},
            {field:'money',title:'总费用',width:12,align:'center'},
            {field:'year',title:'年',width:12,align:'center'},
            {field:'month',title:'月',width:12,align:'center'},
            {field:'status',title:'支付状态',width:12,align:'center',	
            	formatter: function(value,row,index){
				var ret = '';
				if (value == '1'){
					ret = '已支付';
				} else if(value == '0'){
					ret = '未支付';
				}
					return ret;
			}},
            {field:'type',title:'支付方式',width:12,align:'center'}
        ]],
     
        toolbar:'#tb'
    });
    
 /*   $('#year').combobox({
    
        valueField:'id',
        textField:'year'
    });
    $('#month').combobox({
        url:'',
        valueField:'id',
        textField:'text'
        loader:function(param,success,error){
        	success(data):{
        	} 
        	
        }
    });*/
    
    
	
})