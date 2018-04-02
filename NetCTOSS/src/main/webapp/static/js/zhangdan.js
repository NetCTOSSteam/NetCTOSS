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

    /**
     * 对应服务器的信息
     */
    function serverData(json) {
        $('#tt').datagrid({
            url:'',
            queryParams:json,
            columns:[[
                {field:'OSAccount',title:'OS账号',width:80,align:'center'},
                {field:'serverIP',title:'服务器IP',width:80,align:'center'},
                {field:'startTime',title:'登陆时间',width:80,align:'center'},
                {field:'endTime',title:'登出时间',width:80,align:'center'},
                {field:'onlineTimr',title:'在线总时长',width:80,align:'center'},
                {field:'money',title:'费用',width:80,align:'center'},
                {field:'tariff',title:'资费',width:80,align:'center'}
            ]],
            toolbar:'#tb'
        });
    }



    var num = 0;
    //双击单行数据更改表格
    $('#tt').datagrid({
        onDblClickRow: function(rowIndex, rowData){
        	$('#query_div').hide();
        	$('#accounting').show();
        	$('#accounting_name').html(rowData.name);
            if(num==0){
            	var json = {account:rowData.account};
                business (json);
                num+=1;
            }else if(num==1){
                serverData();
                num+=1;
            }
        }
    });
    //回退
    $('#tb').click(function () {
        if(num>1){
            business ();
            num=0;
        }else{
            accounting();
            $('#query_div').show();
            $('#accounting').hide();
            num=0;
        }
    })

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
        if(num<1){
            accounting(queryData());
        }else if(num==1){
            business (queryData());
        }else if(num>1){
            serverData(queryData());
        }
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