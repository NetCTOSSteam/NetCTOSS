$(function () {

    var clickNum = 0;
    var flag = true;


    /**
     * 下拉框初始化
     *
     * 1：年初始化
     * 2：月初始化 需要传入是哪一年
     * 3：年月同时初识初始化
     * 4：日初始化 需要传入是那一月
     *
     *
     * @param num  1：年初始化 2：月初始化 3：年月同时初始化 4：日初始化
     * @param year
     * @param moth
     */
    function select(num,year,moth){
        switch (num){
            case 1:
                $('#year_y').combobox({
                    url:'',
                    valueField:'id',
                    textField:'text'
                });
                break;
            case 2:
                $('#year_moth_m').combobox({
                    url:'',
                    data:year,
                    valueField:'id',
                    textField:'text'
                });
                break;
            case 3:
                $('#moth_y').combobox({
                    url:'',
                    valueField:'id',
                    textField:'text'
                });
                $('#moth_m').combobox({
                    url:'',
                    valueField:'id',
                    textField:'text'
                });
                break;
            case 4:
                $('#day_y').combobox({
                    url:'',
                    data:moth,
                    valueField:'id',
                    textField:'text'
                });
                break;
        }
    }

    /**
     * 搜索框进行显示隐藏
     * @param num  1:年显示  2：年—月 显示 3：月显示  4：天显示
     */
    function showAndhide(num) {
       switch(num){
           case 1:
               $('#t_year').show();
               $('#t_y_moth').hide();
               $('#t_moth').hide();
               $('#t_day').hide();
               break;
           case 2:
               $('#t_year').hide();
               $('#t_y_moth').show();
               $('#t_moth').hide();
               $('#t_day').hide();
               break;
           case 3:
               $('#t_year').hide();
               $('#t_y_moth').hide();
               $('#t_moth').show();
               $('#t_day').hide();
               break;
           case 4:
               $('#t_year').hide();
               $('#t_y_moth').hide();
               $('#t_moth').hide();
               $('#t_day').show();
       }
    }

    /**
     * 点击操作和回退操作  需要对搜索框进行显示隐藏
     */

    //双击单行数据更改表格
    $('#tt').datagrid({
        onDblClickRow: function(rowIndex, rowData){
            clickNum+=1;

            if(flag){          // true:代表选择的是年为初始化查询模式    flase:true:代表选择的是月为初始化查询模式
                if(clickNum==1){
                    year_moth();
                    showAndhide(2);
                }else if(clickNum==2){
                    day();
                    showAndhide(4);
                }
                //进入这 clickNum 最大值只能为2；所以加上下面的判断
                if(clickNum>2){
                    clickNum=2;
                }

            }else{
                showAndhide(4);
                day();
                //进入这 clickNum 最大值只能为1；所以加上下面的判断
                if(clickNum>0){
                    clickNum=0;
                }
            }

        }
    });

    //back 回退函数
    $('#back').click(function () {
        clickNum-=1;
        if(flag){        // true:代表选择的是年为初始化查询模式    flase:true:代表选择的是月为初始化查询模式
            if(clickNum==1){
                showAndhide(2);
                year_moth();
            }else{
                showAndhide(1);
                year();
            }

            //进入这 clickNum 最小值只能为0；所以加上下面的判断
            if(clickNum<0){
                clickNum=0;
            }
        }else{
            showAndhide(3);
            moth();
            //进入这 clickNum 最大值只能为1；所以加上下面的判断
            if(clickNum<0){
                clickNum=0;
            }
        }
    });

    /**
     * 初始化数据显示  需要对搜索框进行显示隐藏
     */

    //初识数据按年查询
    $('#year').click(function () {
        flag = true;
        clickNum = 0;
        showAndhide(1);
        year();
    });

    //初识数据按月查询
    $('#moth').click(function () {
        flag = false;
        clickNum = 0;
        showAndhide(3);
        moth();
    });

    /**
     * 触发各个不同搜索按钮
     */
    // 年 - 年  year_query
    $('#year_query').click(function () {
        var data = year_data();
        year(data);
    });

    //年-月 year_moth_query
    $('#year_moth_query').click(function () {
        var data = year_moth_data();
        year(data);
    });

    // 月  moth_query
    $('#moth_query').click(function () {
        var data = moth_data();
        year(data);
    });

    // 日  day_query
    $('#day_query').click(function () {
        var data = day_data();
        year(data);
    });


    /**
     * 查询条件数据获取方式  年、月/年、月、日
     */

    // 年 - 年  year_query
    function year_data(){
        var year_acc = $('#year_acc').val();
        var year_name = $('#year_name').val();
        var year_y = $('#year_y').val();
        var data = {
            year_acc:year_acc,
            year_name:year_name,
            year_y:year_y
        };
        return data;
    }

    //年-月 year_moth_query
    function year_moth_data(){
        var year_moth_acc = $('#year_moth_acc').val();
        var year_moth_name = $('#year_moth_name').val();
        var year_moth_m = $('#year_moth_m').val();
        var data = {
            year_moth_acc:year_moth_acc,
            year_moth_name:year_moth_name,
            year_moth_m:year_moth_m
        };
        return data;
    }

    // 月  moth_query
    function moth_data(){
        var moth_acc = $('#moth_acc').val();
        var moth_name = $('#moth_name').val();
        var moth_y = $('#moth_y').val();
        var moth_m = $('#moth_m').val();

        var data = {
            moth_acc:moth_acc,
            moth_name:moth_name,
            moth_y:moth_y,
            moth_m:moth_m
        };
        return data;
    }

    // 日  day_query
    function day_data(){
        var day_acc = $('#day_acc').val();
        var day_name = $('#day_name').val();
        var day_y = $('#day_y').val();

        var data = {
            day_acc:day_acc,
            day_name:day_name,
            day_y:day_y
        }
        return data;
    }

    /**
     * 数据显示方式
     */
    //天数据显示
    function day(data) {
        $('#tt').datagrid({
            url:'',
            data:data,
            columns:[[
                //field数据对应的名称字段
                {field:'a',title:'实验室IP',width:80,align:'center'},
                {field:'b',title:'账务账号',width:80,align:'center'},
                {field:'d',title:'业务账号名',width:80,align:'center'},
                {field:'c',title:'每天使用时长（/小时）',width:80,align:'center'},
                {field:'e',title:'日',width:80,align:'center'}
            ]],
            toolbar:'#tb'
        });
        select(4,null,null);
    }

    //年--月数据显示
    function year_moth(data) {
        $('#tt').datagrid({
            url:'',
            data:data,
            columns:[[
                //field数据对应的名称字段
                {field:'a',title:'实验室IP',width:80,align:'center'},
                {field:'b',title:'账务账号',width:80,align:'center'},
                {field:'d',title:'业务账号名',width:80,align:'center'},
                {field:'c',title:'本月使用时长（/小时）',width:80,align:'center'},
                {field:'e',title:'月',width:80,align:'center'}
            ]],
            toolbar:'#tb'
        });
        select(2,null,null);
    }

    //年数据
    function year(data){
        $('#tt').datagrid({
            url:'',
            data:data,
            columns:[[
                //field数据对应的名称字段
                {field:'a',title:'账务账号',width:80,align:'center'},
                {field:'b',title:'真实姓名',width:80,align:'center'},
                {field:'d',title:'业务账号数量',width:80,align:'center'},
                {field:'c',title:'本年使用时长（/小时）',width:80,align:'center'},
                {field:'e',title:'年',width:80,align:'center'}
            ]],
            toolbar:'#tb'
        });
        select(1,null,null);
    }

    //月数据
    function moth(data){
        $('#tt').datagrid({
            url:'',
            data:data,
            columns:[[
                //field数据对应的名称字段
                {field:'a',title:'账务账号',width:80,align:'center'},
                {field:'b',title:'真实姓名',width:80,align:'center'},
                {field:'d',title:'业务账号数量',width:80,align:'center'},
                {field:'c',title:'本月使用时长（/小时）',width:80,align:'center'},
                {field:'e',title:'月',width:80,align:'center'}
            ]],
            toolbar:'#tb'
        });
        select(3,null,null);
    }
})
//初识数据
$(function () {

    $('#tt').datagrid({
        url:'',
        columns:[[
            //field数据对应的名称字段
            {field:'a',title:'账务账号',width:80,align:'center'},
            {field:'b',title:'真实姓名',width:80,align:'center'},
            {field:'d',title:'业务账号数量',width:80,align:'center'},
            {field:'c',title:'本年使用时长（/小时）',width:80,align:'center'},
            {field:'e',title:'年',width:80,align:'center'}
        ]],
        toolbar:'#tb'
    });

    $('#year_y').combobox({
        url:'',
        valueField:'id',
        textField:'text'
    });
})