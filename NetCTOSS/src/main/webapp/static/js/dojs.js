$(function () {
	$('#tb').datagrid({
        url:'/NetCTOSS/doLog/findAll',
        method:'GET',
        columns:[[
            //field数据对应的名称字段
            {field:'admName',title:'管理员的名字',width:80,align:'center'},
            {field:'loginName',title:'管理员的账号',width:80,align:'center'},
            {field:'IP',title:'登录地IP',width:80,align:'center'},
            {field:'place',title:'操作模块',width:80,align:'center'},
            {field:'data',title:'操作数据',width:80,align:'center'},
            {field:'action',title:'什么操作',width:80,align:'center'}
        ]],
        
    });
})

