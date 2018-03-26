$(function(){

	 // 默认数据列表的显示
	$('#tt').datagrid({

		queryParams:queryParams()
	});

	 // 查询参数的封装
	function queryParams(){
		

	}

	// 条件查询功能
	$('#query').click(function(){
		$('#tt').datagrid({

			queryParams:queryParams()
		});
	});
	
	$('#add').click(function(){
		$('#add_dialog').window('open');

	});

	 // 新增
	$('#save_users').click(function(){

	});

	
	// 修改
	$('#update').click(function(){
		$('#update_dialog').dialog('open');// 打开修改窗体


	});
	
	// 修改保存
	$('#update_users').click(function(){

	});

	$('#tip').click(function(){
		$('#tip_dialog').dialog('open');// 打开窗体


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