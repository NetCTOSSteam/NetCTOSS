$(function () {
    /**
     *  初始化数据
     */
    accounting();


    /**
     * 账务信息
     */
    function accounting(json) {
        $('#tt').datagrid({
            url:'/NetCTOSS/monthAcc/all',
            queryParams:json,
            columns:[[
                {field:'account',title:'账务账号',width:80,align:'center'},
                {field:'name',title:'真实姓名',width:80,align:'center'},
                {field:'d',title:'年月',width:80,align:'center',
                	formatter:function(value,row,index){
                		
                		var year_month = row.year+'-'+row.month;
                      	return year_month;}
                },
                {field:'money',title:'总消费',width:80,align:'center'}
            ]],
            toolbar:'#tb'
        });
    }
    /**
     *双击这条数据，可以查询这个月账务账号下所有的业务账号产生的费用明细。
     */
    function business (json) {
        $('#tt').datagrid({
            url:'/NetCTOSS/monthBusiness/likeAll',
            queryParams:json,
            columns:[[
                //field数据对应的名称字段
                {field:'businessAccount',title:'OS账号',width:80,align:'center'},
                {field:'server',title:'服务器信息',width:80,align:'center'},
                {field:'nowTime',title:'总时长',width:80,align:'center'},
                {field:'tariff',title:'资费套餐',width:80,align:'center'},
                {field:'money',title:'费用',width:80,align:'center'}
            ]],
            toolbar:'#tb'
        });
    }

    
    var flag = true;
    $('#tt').datagrid({
    	 onDblClickRow:function (rowIndex, rowData) {
    		$('#query_div').hide();
         	$('#accounting').show();
         	$('#accounting_name').html(rowData.name);
         	if(flag){
         		flag = false;
         		//获取行内参数传递到下面
         		var json = {account:rowData.account};
                business (json);//调用业务账单
         	}else{
         		var json = {businessAccount:rowData.businessAccount};
            	server(json);
            	 $('#x_data').window('open');
         	}
         }
    })
    
    
    //回退
    $('#tb').click(function () {
        if(flag){
    	
        }else{
        	flag = true;
        	 accounting();
             $('#query_div').show();
             $('#accounting').hide();
        }
    })
    
     //详细信息的返回按钮
    $('#x_back').click(function () {
        $('#x_data').window('close');
    })
    
    
    //服务器数据显示
    function server(data){
    	
    	$.ajax({
			type:"GET",
			url:"/NetCTOSS/serviceAndBusiness/one",
			data:data,
			success :function(msg){
//				console.log("对象"+msg);
//				console.log(msg);
			
				$('#server_ip').html(msg.serverIP);
				$('#time').html(msg.onlineTimr);
				$('#startTime').html(changeDate(msg.startTime));
				$('#endTime').html(changeDate(msg.endTime));
				$('#money').html(msg.money);
				$('#x_tariff').html(msg.tariff);
			
			}
		});
    	
 
    }
    
    function changeDate(da){
  	  console.info("时间"+da);
  	  var date = new Date(da);
        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()
         +' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();

	}
    

       $('#attYearMonth').datebox({
       //显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层
       onShowPanel: function () {
          //触发click事件弹出月份层
          span.trigger('click'); 
          if (!tds)
            //延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔
            setTimeout(function() { 
                tds = p.find('div.calendar-menu-month-inner td');
                tds.click(function(e) {
                   //禁止冒泡执行easyui给月份绑定的事件
                   e.stopPropagation(); 
                   //得到年份
                   var year = /\d{4}/.exec(span.html())[0] ,
                   //月份
                   //之前是这样的month = parseInt($(this).attr('abbr'), 10) + 1; 
                   month = parseInt($(this).attr('abbr'), 10);  

         //隐藏日期对象                     
         $('#attYearMonth').datebox('hidePanel') 
           //设置日期的值
           .datebox('setValue', year + '-' + month); 
                        });
                    }, 0);
            },
            //配置parser，返回选择的日期
            parser: function (s) {
                if (!s) return new Date();
                var arr = s.split('-');
                return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);
            },
            //配置formatter，只返回年月 之前是这样的d.getFullYear() + '-' +(d.getMonth()); 
            formatter: function (d) { 
                var currentMonth = (d.getMonth()+1);
                var currentMonthStr = currentMonth < 10 ? ('0' + currentMonth) : (currentMonth + '');
                return d.getFullYear() + '-' + currentMonthStr; 
            }
        });

        //日期选择对象
        var p = $('#attYearMonth').datebox('panel'), 
        //日期选择对象中月份
        tds = false, 
        //显示月份层的触发控件
        span = p.find('span.calendar-text'); 
        var curr_time = new Date();

        //设置前当月
        $("#attYearMonth").datebox("setValue", myformatter(curr_time));
    
    //查询条件获取
    function queryData() {
    	
    	var attYearMonth = $('#attYearMonth').val();
    	
    	var yearAndMonth = attYearMonth.split("-");
    	
        var year = parseInt(yearAndMonth[0]);
        var month = parseInt(yearAndMonth[1]);
        
        var data = {};
        if(year!=null && ''!=year){
            data = {year:year}
            if(month!=null && ''!=month){
                data = {year:year,month:month}
            }
        }
        return data;
    }

    //按年月查询
    $('#query').click(function () {
        accounting(queryData());
    })
});

//格式化日期
function myformatter(date) {
    //获取年份
    var y = date.getFullYear();
    //获取月份
    var m = date.getMonth() + 1;
    return y + '-' + m;
}