
$(function () {

    var clickNum = 0;
    //双击单行数据更改表格
    $('#tt').datagrid({
        onDblClickRow: function(rowIndex, rowData){
            clickNum+=1;
            if(clickNum==1){
                month_acc();
            }else if(clickNum==2){
                month_day();
            }
            if(clickNum>2){
                clickNum=0;
                month();
            }
        }
    });

    //账务月总账单
    function month(){
        $('#tt').datagrid({
            url:'datagrid_data.json',
            columns:[[
                {field:'acc',title:'账务账户',width:80,align:'center'},
                {field:'time',title:'总时间（/小时）',width:80,align:'center'},
                {field:'year',title:'年月',width:80,align:'center'},
                {field:'money',title:'总消费（/元）',width:80,align:'right'}
            ]]
        });
    }
    //账务月账单
    function month_acc(){
        $('#tt').datagrid({
            url:'datagrid_data.json',
            columns:[[
                {field:'acc',title:'OS账号',width:50,align:'center'},
                {field:'server',title:'服务器信息',width:50,align:'center'},
                {field:'time',title:'时长（单位：时分秒）',width:50,align:'center'},
                {field:'ca',title:'资费套餐',width:50,align:'center'},
                {field:'money',title:'费用(元)',width:50,align:'center'}
            ]]
        });
    }

    //账务日账单
    function month_day(){
        $('#tt').datagrid({
            url:'datagrid_data.json',
            columns:[[
                {field:'acc',title:'账务账户',width:50,align:'center'},
                {field:'ip',title:'服务器ip',width:50,align:'center'},
                {field:'startTime',title:'登入时间',width:50,align:'center'},
                {field:'endTime',title:'登出时间',width:50,align:'center'},
                {field:'dayTime',title:'时长（单位：秒）',width:50,align:'center'},
                {field:'ca',title:'资费套餐',width:50.,align:'center'},
                {field:'money',title:'费用(元)',width:50,align:'right'}
            ]]
        });
    }

    //根句年月查询账务账单
    $('#query').click(function(){
        month();
        console.info("fasdf");
        $('#tt').datagrid('reload', $('#startTime').val());
    });
})