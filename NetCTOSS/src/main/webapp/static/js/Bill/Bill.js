$(function () {

    var flag = true;
    var onpay = true;

    //双击数据行
    $('#tt').datagrid({
        onDblClickRow:function (rowIndex, rowData) {
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
				console.log("对象"+msg);
				console.log(msg);
			
				$('#server_ip').html(msg.serverIP);
				$('#time').html(msg.onlineTimr);
			
				
				$('#startTime').html(changeDate(msg.startTime));
				$('#endTime').html(changeDate(msg.endTime));
//				
//				$('#startTime').html(msg.startTime);
//				$('#endTime').html(msg.endTime);
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
    
    function changeDate(da){
    	  console.info("时间"+da);
    	
    	 var year = da.year+1900;
			var month = da.month+1;
			var day = da.date;
			
			var time = da.time;
			console.info(time);
			
			var result = year+"-"+month+"-"+day;
			return result;
    	
//		var time = da.time;
//		var date = new Date(time);
//		console.info(da);
//		
//		var formatDate = date.format("yyyy-MM-dd hh:mm:ss");
//		
//		console.info(formatDate);
//		return formatDate;
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
    };
    
    //点击支付按钮
    $('#pay').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
        	console.info(row.status);
	        	if(row.status=="0"){
	        		
	        		$('#win').window('open');
	        	     
    				$('#s_id').attr('value',row.id);
    				$('#s_name').attr('value',row.name);
    				$('#s_year').attr('value',row.year);
    				$('#s_month').attr('value',row.month);
    				$('#s_IDcard').attr('value',row.IDcard);
    				$('#s_account').attr('value',row.account);
    				$('#s_name').attr('value',row.name);
    				$('#s_money').attr('value',row.money);
    				$('#s_type').combobox('select', row.type);
    				$('#update_month').form('validate');
        	}else{
        		 $.messager.show({
                     title:'消息提示',
                     msg:"该账户已支付",
                     timeout:5000,
                     showType:'slide'
                 });
        	}
        
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
    	console.info("ok");
    	var data = "";
		$('#update_month').form ('submit',{
			   url:"/NetCTOSS/monthAcc/check",   
			    onSubmit: function(){   
			    	return true;
			    },
			    success:function(data){ 
			    	console.info("数据");
			    	console.info(data);
			    	
			    	if(data){
			    		 $('#win').window('close');
			    		
			    	}
			    	 $.messager.show({
							title:'消息提示',
							msg:"操作成功！！！",
							timeout:5000,
							showType:'slide'
					});
			    	 
					$('#tt').datagrid('reload',moth(data));// 重新加载数据
			    } 
		});
		
    });
    
    //支付取消
    $('#not').click(function () {
        $('#win').window('close');
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
     
        toolbar:'#tb',
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