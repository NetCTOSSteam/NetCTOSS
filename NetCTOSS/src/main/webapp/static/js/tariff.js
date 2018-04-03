$(function(){
	
	/*	var url = "/NetCTOSS/tar/all";
	$.ajax({
			type:"GET",
			url:url,
			success :function(msg){
				console.log(msg);
			}
		});*/

	  // 默认数据列表的显示
	$('#tt').datagrid({
		url:"/NetCTOSS/tar/all",
		method:"get",
		pagination: true,//是否使用分页功能  
        singleSelect:true//每次只能选中1行  
		
	});
	
	
	 var p = $('#tt').datagrid('getPager'); //获取page对象  	
	 $(p).pagination({   
         pageSize: 10,//每页显示的记录条数，默认为10   
         pageList: [10,20,30],//可以设置每页记录条数的列表   
         beforePageText: '第',//页数文本框前显示的文字   
         afterPageText: '页    共 {pages} 页',  //pages为默认的参数吗，代表总页数  
         displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'// from，to , total均为默认参数名，from, to 代表现在是总记录中的第几条到第几条，tatal代表总记录数  
            }); 
	
	//查询参数的封装
	function queryParams(){
		console.info(mealType);
	    var mealName = $('#mealName').val();
	    var mealId = $('#mealId').val();
        var mealTime = $('#mealTime').val();
        var mealMoney = $('#mealMoney').val();
        var mealDescribe = $('#mealDescribe').val();
        var mealType=$('#cc').combobox('getValue');  
        var mealBasicMoney = $('#mealBasicMoney').val();
        var mealStartTime = new Date();
        var data = {
        		mealId:mealId,
        		mealName:mealName,
        		mealType:mealType,
        		mealTime:mealTime,
        		mealMoney:mealMoney,
        		mealDescribe:mealDescribe,
        		mealStartTime:mealStartTime
        };
        return data;
	}
	 

   
  
    $('#add').click(function(){

        $('#add_users_dialog').dialog('open');
        	ddd();
      
    });

    function queryParamsToSave(){
    	var date = new Date();
    
    	var now = "";
    	now = date.getFullYear()+"-"; //读英文就行了
    	now = now + (date.getMonth()+1)+"-";//取月的时候取的是当前月-1如果想取当前月+1就可以了
    	now = now + date.getDate()+" ";
    	now = now + date.getHours()+":";
    	now = now + date.getMinutes()+":";
    	now = now + date.getSeconds()+"";
    	console.info(now);
        var mealName = $('#mea_name').val();
        
        var mealTime = $('#mea_time').val();
        var mealMoney = $('#mea_money').val();
        var mealDescribe = $('#mea_describe').val();
        var mealType=$('#cc').combobox('getValue'); 
        var mealBasicMoney = $('#mea_basic_money').val();
        if(mealType==""||mealType==null){
        	 mealType = "null";
        }if(mealTime==""||mealTime==null){
        	 mealTime = "0";
        }if(mealMoney==""||mealMoney==null){
        	 mealMoney = "0";
        }if(mealDescribe==""||mealDescribe==null){
        	 mealType = "无描述";
        }if(mealBasicMoney==""||mealBasicMoney==null){
        	 mealType = "0";
        }
           
        var data = {
        		mealName:mealName,
        		mealType:mealType,
        		mealTime:mealTime,
        		mealMoney:mealMoney,
        		mealDescribe:mealDescribe,
        		mealStartTime:now,
        		mealBasicMoney:mealBasicMoney
        };
        return data;
    }


    //新增
    $('#save_users').click(function(){
    	 var url = "/NetCTOSS/tar/adds";
    	 console.info(queryParamsToSave());
    	 
    	 
    	$.post(url,queryParamsToSave(),function(data){
    		
    		console.info("进来了");
    		
    		if(data){
                 $('#add_users_dialog').dialog('close');
             }

             $('#tt').datagrid('reload',queryParams());
    	});
        
      
    });


    //修改
    $('#edit').click(function(){
    	
    	
        var rows = $('#tt').datagrid('getSelections');
      
        var row = $('#tt').datagrid('getSelected')
        	
        	if(!row.mealStatus){
        		 //返回的第1行记录
        	        if(row){//如果选中了数据，就进入if语句
        	            var lenth = rows.length;
        	            if(lenth == 1){

        	                $('#mealId1').attr('value',row.mealId);
        					$('#mealBasicMoney1').attr('value',row.mealBasicMoney);
        					
        					$('#mealTime1').attr('value',row.mealTime);
        					$('#mealMoney1').attr('value',row.mealMoney);
        					$('#mealName1').attr('value',row.mealName);        				
        					$('#mealDescribe1').attr('value',row.mealDescribe);
        					$('#cc1').combobox('select', row.mealType);
        					$('#mealStartTime').attr('value',row.mealStartTime);
        	                $('#update_users_dialog').dialog('open');//打开修改窗体
        	          
        					
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
        	}else{
        		$.messager.show({
	                title:'消息提示',
	                msg:'正在使用中，不能进行操作！',
	                timeout:3000,
	                showType:'slide'
	            });
        	}
        
       
       
    });


    //修改保存
    $('#update_users').click(function(){
        var row = $('#tt').datagrid('getSelected')
        var url = "/NetCTOSS/tar/update";
        $('#update_user').form('submit', {   
		    url:url, 
		   
		    onSubmit: function(){   
		        // do some check   
		        // return false to prevent submit; 
		    	return true;
		    },   
		    success:function(data){ 
		    	
		    	if(data){
		    		$('#update_users_dialog').dialog('close');
		    	
		    	}
		    	 $.messager.show({
						title:'消息提示',
						msg:'修改成功',
						timeout:5000,
						showType:'slide'
				});
		    	 
				$('#tt').datagrid('reload',queryParams());// 重新加载数据
		    }   
		});  
     
    });





    $('#delete').click(function(){
    	  var row = $('#tt').datagrid('getSelected')
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
        	if(!rows[0].mealStatus){
        		 $.messager.confirm('友情提示', '你确定需要删除这些数据么?', function(r){
                     if (r){
                        
                         var url = "/NetCTOSS/tar/"+rows[0].mealId;
                         $.ajax({
                             type: "DELETE",
                             url: url,                                                  
                            success: function(msg){
                                 $.messager.show({
                                     title:'消息提示',
                                     msg:'删除成功',
                                     timeout:5000,
                                     showType:'slide'
                                 });
                                 $('#tt').datagrid('reload',queryParams());// 重新加载数据
                             }
                         });
                     }
                 });
        	}else{
        		$.messager.show({
	                title:'消息提示',
	                msg:'正在使用中，不能进行操作！',
	                timeout:3000,
	                showType:'slide'
	            });
        	}
           
        }
    });
    
    
    $('#kai').click(function(){
    	
        var rows = $('#tt').datagrid('getSelections');
        // 返回的是：所选择数据的数组
      
        var lenth = rows.length;
        if(lenth == 0){// 没有选择任何需要被删除的数据
            $.messager.show({
                title:'消息提示',
                msg:'请选择需要开通的资费！',
                timeout:5000,
                showType:'slide'
            });
        }else{// 已经选择了
        	if(!rows[0].mealStatus){
        		 
        		   $('#cc2').attr('value',rows[0].mealType);
        		
        	      $('#mealId2').attr('value',rows[0].mealId);        	   
        	      $('#mealStatus2').attr('value',rows[0].mealStatus);
        	      $('#mealName2').attr('value',rows[0].mealName);
        	      $('#mealDescribe2').attr('value',rows[0].mealDescribe);   
        	      $('#mealTime2').attr('value',rows[0].mealTime);   
        	      $('#mealBasicMoney2').attr('value',rows[0].mealBasicMoney);  
        	      $('#mealMoney2').attr('value',rows[0].mealMoney);
        	  	$('#mealStartTime1').attr('value',rows[0].mealStartTime);
        	  
        		 $.messager.confirm('友情示', '提你确定需要开通这个资费么?', function(r){
                     if (r){
                        
                         var url = "/NetCTOSS/tar/update1";
                         $('#update_user1').form('submit', {   
                 		    url:url, 
                 		   
                 		    onSubmit: function(){   
                 		        // do some check   
                 		        // return false to prevent submit; 
                 		    	return true;
                 		    },   
                 		    success:function(data){                 		    
                 		    	 $.messager.show({
                 						title:'消息提示',
                 						msg:'开通成功',
                 						timeout:5000,
                 						showType:'slide'
                 				});
                 		    	 
                 				$('#tt').datagrid('reload',queryParams());// 重新加载数据
                 		    }   
                 		});  
                     }
                 });
        	}else{
        		$.messager.show({
	                title:'消息提示',
	                msg:'正在使用中，不能进行操作！',
	                timeout:3000,
	                showType:'slide'
	            });
        	}
           
        }
    });


$('#zhan').click(function(){
	
    var rows = $('#tt').datagrid('getSelections');
    // 返回的是：所选择数据的数组
  
    var lenth = rows.length;
    if(lenth == 0){// 没有选择任何需要被删除的数据
        $.messager.show({
            title:'消息提示',
            msg:'请选择需要暂停的资费！',
            timeout:5000,
            showType:'slide'
        });
    }else{// 已经选择了
    	 if(rows[0].mealStatus){
 		   $('#cc3').attr('value',rows[0].mealType);
    	      $('#mealId3').attr('value',rows[0].mealId);        	   
    	      $('#mealStatus3').attr('value',rows[0].mealStatus);
    	      $('#mealName3').attr('value',rows[0].mealName);
    	      $('#mealDescribe3').attr('value',rows[0].mealDescribe);   
    	      $('#mealTime3').attr('value',rows[0].mealTime);   
    	      $('#mealBasicMoney3').attr('value',rows[0].mealBasicMoney);  
    	      $('#mealMoney3').attr('value',rows[0].mealMoney);
    	  	$('#mealStartTime3').attr('value',rows[0].mealStartTime);
    	  	
    		 $.messager.confirm('友情示', '提你确定需要暂停这个资费么?', function(r){
                 if (r){
                    
                     var url = "/NetCTOSS/tar/update2";
                     $('#update_user2').form('submit', {   
             		    url:url, 
             		   
             		    onSubmit: function(){   
             		        // do some check   
             		        // return false to prevent submit; 
             		    	return true;
             		    },   
             		    success:function(data){                 		    
             		    	 $.messager.show({
             						title:'消息提示',
             						msg:'暂停成功',
             						timeout:5000,
             						showType:'slide'
             				});
             		    	 
             				$('#tt').datagrid('reload',queryParams());// 重新加载数据
             		    }   
             		});  
                 }
             });
    	 }else{
    		 $.messager.show({
					title:'消息提示',
					msg:'无法暂停，请重新选址',
					timeout:5000,
					showType:'slide'
			});
    	 }
       
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

$(document).ready(function () {
	var checkValue=$('#cc').combobox('getValue');  
	$("#cc").combobox({

	onChange: function (checkValue,o) {
		var checkValue=$('#cc').combobox('getValue');  

	    if(checkValue=="0"){
	     document.getElementById('ji').style.display='block';
	     document.getElementById('dan').style.display='none';
	     document.getElementById('data').style.display='none';
	     document.getElementById('yong').style.display='block';
	     document.getElementById('fei').style.display='none';
	     document.getElementById('shi').style.display='none';
	   
	    }else if(checkValue=="1"){
	    	  document.getElementById('dan').style.display='inline';
	    	   document.getElementById('data').style.display='none';
	    	   document.getElementById('ji').style.display='none';
	    	   document.getElementById('yong').style.display='inline';
	    	   document.getElementById('shi').style.display='none';
	    	   document.getElementById('yong').style.display='none';
	    
	    }else if(checkValue=="2"){
	    	  
	    	   document.getElementById('data').style.display='inline';
	    	   document.getElementById('ji').style.display='inline';
	    	   document.getElementById('dan').style.display='inline';
	    	   document.getElementById('shi').style.display='inline';
	    	   document.getElementById('yong').style.display='inline';
	    	   document.getElementById('fei').style.display='inline';
	    }
	}

	});

	}); 

$(document).ready(function () {
	var checkValue=$('#cc1').combobox('getValue');  
	$("#cc1").combobox({

	onChange: function (checkValue,o) {
		var checkValue=$('#cc1').combobox('getValue');  
	    if(checkValue=="0"){	     
	     document.getElementById('yong').style.display='block';
	     document.getElementById('fei').style.display='none';
	     document.getElementById('shi').style.display='none';	   
	    }else if(checkValue=="1"){
	    	  
	    	   document.getElementById('yong').style.display='inline';
	    	   document.getElementById('shi').style.display='none';
	    	   document.getElementById('yong').style.display='none';
	    
	    }else if(checkValue=="2"){
	    	   document.getElementById('shi').style.display='inline';
	    	   document.getElementById('yong').style.display='inline';
	    	   document.getElementById('fei').style.display='inline';
	    }
	}

	});

	});  

function ddd(){
	var checkValue=$("#cc");
   

    if(checkValue.val()=="0"){
    	document.getElementById('ji').style.display='block';
	     document.getElementById('dan').style.display='none';
	     document.getElementById('data').style.display='none';
	   
   
    }else if(checkValue.val()=="1"){
    	document.getElementById('dan').style.display='inline';
 	   document.getElementById('data').style.display='none';
 	   document.getElementById('ji').style.display='none';
 	 
 
    }else if(checkValue.val()=="2"){
    	 document.getElementById('data').style.display='inline';
  	   document.getElementById('ji').style.display='inline';
  	   document.getElementById('dan').style.display='inline';
  	
    }
    } 
function ddd1(){
	var checkValue=$("#cc1");
   

    if(checkValue.val()=="0"){
    	 document.getElementById('yong').style.display='block';
	     document.getElementById('fei').style.display='none';
	     document.getElementById('shi').style.display='none';	   
   
    }else if(checkValue.val()=="1"){
    	   document.getElementById('yong').style.display='inline';
    	   document.getElementById('shi').style.display='none';
    	   document.getElementById('yong').style.display='none';
 	 
 
    }else if(checkValue.val()=="2"){
    	document.getElementById('shi').style.display='inline';
 	   document.getElementById('yong').style.display='inline';
 	   document.getElementById('fei').style.display='inline';
    }
    } 

