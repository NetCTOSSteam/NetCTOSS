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
            url:'',
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


    //查询条件获取
    function queryData() {
        var year = $('#year').val();
        var month = $('#month').val();
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
        $('#year').html('');
        $('#month').html('');
        if(num<1){
            accounting(queryData());
        }else if(num==1){
            business (queryData());
        }else if(num>1){
            serverData(queryData());
        }
    })
})