//初始化加载
$(function () {
    $('#tt').datagrid({
        url:'',
        columns:[[
            {field:'a',title:'管理员名称',width:12,align:'center'},
            {field:'b',title:'管理员账号',width:12,align:'center'},
            {field:'d',title:'联系电话',width:12,align:'center'},
            {field:'c',title:'邮箱',width:12,align:'center'},
            {field:'e',title:'角色',width:12,align:'center'}
        ]],
        toolbar:'#tb'
    });
    $('#c_year').combobox({
        url:'',
        valueField:'id',
        textField:'text'
    });
    $('#c_month').combobox({
        url:'',
        valueField:'id',
        textField:'text'
    });
})

$(function () {

    //模糊查询点击
    $('#query').click(function () {
        show_data();
    })

    // 查询过后 数据对应的更新
    function show_data() {
        $('#tt').datagrid({
            url:'',
            data:data(),
            columns:[[
                {field:'a',title:'管理员名称',width:12,align:'center'},
                {field:'b',title:'管理员账号',width:12,align:'center'},
                {field:'d',title:'联系电话',width:12,align:'center'},
                {field:'c',title:'邮箱',width:12,align:'center'},
                {field:'e',title:'角色',width:12,align:'center'}
            ]],
            toolbar:'#tb'
        });
    }

    //数据获取
    function data(){
       var admin_name = $('#admin_name').val();
       var admin_acc = $('#admin_acc').val();

       var json = {admin_name:admin_name,admin_acc:admin_acc}
       return json
    }

    /**
     * 添加
     */

    //添加需要的数据
    function add_data() {
        var add_admin_name = $('#add_admin_name').val();
        var add_admin_acc = $('#add_admin_acc').val();
        var add_admin_pwd = $('#add_admin_pwd').val();
        var add_admin_phone = $('#add_admin_phone').val();
        var add_admin_e = $('#add_admin_e').val();
        var data = {
            add_admin_name:add_admin_name,
            add_admin_acc:add_admin_acc,
            add_admin_pwd:add_admin_pwd,
            add_admin_phone:add_admin_phone,
            add_admin_e:add_admin_e
        };
        return data;
    }

    //添加
    $('#add').click(function () {
        $('#add_win').window('open');
    })

    //add_ok    确定  关闭窗口 提交数据
    $('#add_ok').click(function () {

        //先验证  密码相不相同 然后 邮箱格式验证

        $.post("",update_data(),function (msg) {
            var data = eval('(' + msg + ')');
            if(data){
                // 提示
                $.messager.show({
                    title : '消息提示',
                    msg : '添加成功！',
                    timeout : 3000,
                    showType : 'slide'
                });
                $('#add_win').window('close');
            }else{
                // 提示
                $.messager.show({
                    title : '消息提示',
                    msg : '抱歉！系统繁忙！',
                    timeout : 3000,
                    showType : 'slide'
                });
                $('#add_win').window('close');
            }
        });

        $('#add_win').window('close');
    })

    //add_not   取消  关闭窗口
    $('#add_not').click(function () {
        $('#add_win').window('close');
    })




    /**
     * 修改
     */
    //修改获取数据


    //修改
    $('#edit').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){
            $('#update_win').window('open');
        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要修改的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });

    //update_ok    确定  关闭窗口 提交数据
    $('#update_ok').click(function () {

        //先验证  密码相不相同 然后 邮箱格式验证

        $.post("",update_data(),function (msg) {
            var data = eval('(' + msg + ')');
            if(data){
                // 提示
                $.messager.show({
                    title : '消息提示',
                    msg : '添加成功！',
                    timeout : 3000,
                    showType : 'slide'
                });
                $('#update_win').window('close');
            }else{
                // 提示
                $.messager.show({
                    title : '消息提示',
                    msg : '抱歉！系统繁忙！',
                    timeout : 3000,
                    showType : 'slide'
                });
                $('#update_win').window('close');
            }
        });



        $('#add_win').window('close');
    })

    //update_not   取消  关闭窗口
    $('#update_not').click(function () {
        $('#update_win').window('close');
    })


    /**
     * 删除
     */
    //删除
    $('#delete').click(function () {
        var row = $('#tt').datagrid('getSelected');
        if(row!=null){

        }else{
            $.messager.show({
                title:'消息提示',
                msg:"请选择需要删除的行",
                timeout:5000,
                showType:'slide'
            });
        }
    });















})