
$(function () {

    //双击数据行
    $('#tt').datagrid({
        onDblClickRow:function () {
            $('#x_data').window('open');
        }
    });
    //详细信息的返回按钮
    $('#x_back').click(function () {
        $('#x_data').window('close');
    });

    //添加
    $('#not').click(function () {
        $('#add_win').window('close');
    });

    //修改
    $('#not_2').click(function () {
        $('#update_win').window('close');
    });

    /**
     * 工具按钮的功能
     */
    //改变状态  开通或者暂停
    $('#openOrClose').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){

        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //删除按钮
    $('#delete').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){

        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //修改按钮 控制弹窗
    $('#update').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
            $('#update_win').window('open');
            //资费数据
            $('#update_zifei').combobox({
                url:'',
                valueField:'id',
                textField:'text'
            });
            //服务器数据
            $('#update_server_ip').combobox({
                url:'',
                valueField:'id',
                textField:'text'
            });
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //添加按钮 控制弹窗
    $('#add').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
            $('#add_win').window('open');
            //资费数据
            $('#zi_fei').combobox({
                url:'',
                valueField:'id',
                textField:'text'
            });


        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要支付的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });
})



/**
 * 初始化数据显示
 */
$(function () {
    $('#tt').datagrid({
        url:'',
        columns:[[
            {field:'a',title:'业务账号',width:12,align:'center'},
            {field:'b',title:'资费类型',width:12,align:'center'},
            {field:'d',title:'状态',width:12,align:'center'},
            {field:'c',title:'服务器IP',width:12,align:'center'},
            {field:'e',title:'账务账号',width:12,align:'center'}
        ]],
        toolbar:'#tb'
    });
})