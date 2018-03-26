$(function () {

    var flag = true;
    var onpay = true;

    //双击数据行
    $('#tt').datagrid({
        onDblClickRow:function () {
            if(flag){
                $('#table_noe').hide();
                $('#table_two').show();
                osacc();
            }else{
                $('#x_data').window('open');
            }
        }
    });

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
    function osacc(){
        $('#pay').hide();
        flag = false;
        $('#tt').datagrid({
            url:"",
            columns:[[
                {field:'aa',title:'OS账号',width:80,align:'center'},
                {field:'dd',title:'服务器信息',width:80,align:'center'},
                {field:'cc',title:'时长（单位：时分秒）',width:80,align:'center'},
                {field:'ee',title:'费用',width:80,align:'center'},
                {field:'rr',title:'资费套餐',width:80,align:'center'},
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
    function moth(){
        $('#pay').show();
        flag = true;
        $('#tt').datagrid({
            url:'',
            columns:[[
                {field:'a',title:'账务账号',width:80,align:'center'},
                {field:'b',title:'身份证',width:80,align:'center'},
                {field:'c',title:'用户姓名',width:80,align:'center'},
                {field:'d',title:'总费用',width:80,align:'center'},
                {field:'e',title:'年-月',width:80,align:'center'},
                {field:'f',title:'支付状态',width:80,align:'center'},
                {field:'g',title:'操作',width:80,align:'center'},
                {field:'h',title:'支付方式',width:80,align:'center'}
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
})

    //初始化加载
$(function () {
    $('#tt').datagrid({
        url:'',
        columns:[[
            {field:'a',title:'账务账号',width:12,align:'center'},
            {field:'b',title:'身份证',width:12,align:'center'},
            {field:'d',title:'用户姓名',width:12,align:'center'},
            {field:'c',title:'总费用',width:12,align:'center'},
            {field:'e',title:'年-月',width:12,align:'center'},
            {field:'f',title:'支付状态',width:12,align:'center'},
            {field:'h',title:'支付方式',width:12,align:'center'}
        ]],
        toolbar:'#tb'
    });
    $('#cc').combobox({
        url:'',
        valueField:'id',
        textField:'text'
    });
})