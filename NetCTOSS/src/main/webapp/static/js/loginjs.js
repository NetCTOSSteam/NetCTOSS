$(function () {
	$('#tb').datagrid({
        url:'/NetCTOSS/login/findAll',
        method:'GET',
        columns:[[
            //field数据对应的名称字段
            {field:'name',title:'登录人的名字',width:80,align:'center'},
            {field:'accNumber',title:'登录人的账号',width:80,align:'center'},
            {field:'IP',title:'登录的地址',width:80,align:'center'},
            {field:'loginTime',title:'登录系统的时间',width:80,align:'center'},
            {field:'quitTime',title:'退出系统的时间',width:80,align:'center'}
        ]],
        
    });

})

