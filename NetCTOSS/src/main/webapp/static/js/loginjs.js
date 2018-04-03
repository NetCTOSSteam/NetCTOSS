$(function () {
	$('#tb').datagrid({
        url:'/NetCTOSS/login/findAll',
        method:'GET',
        /*columns:[[
            //field数据对应的名称字段
            {field:'name',title:'登录人的名字',width:80,align:'center'},
            {field:'accNumber',title:'登录人的账号',width:80,align:'center'},
            {field:'IP',title:'登录的地址',width:80,align:'center'},
            {field:'loginTime',title:'登录系统的时间',width:80,align:'center'},
            {field:'quitTime',title:'退出系统的时间',width:80,align:'center'}
        ]],*/
        
    });

})

$(function() {
	// 模糊查询点击
	$('#query').click(function() {
		var json = data();
		show_data(json);
	})

	// 查询过后 数据对应的更新
	function show_data(json) {
		$('#tb').datagrid({
			url : '/NetCTOSS/login/find',
			method : "GET",
			queryParams : json,
			/*columns:[[
	            //field数据对应的名称字段
	            {field:'admName',title:'管理员的名字',width:80,align:'center'},
	            {field:'loginName',title:'管理员的账号',width:80,align:'center'},
	            {field:'IP',title:'登录地IP',width:80,align:'center'},
	            {field:'place',title:'操作模块',width:80,align:'center'},
	            {field:'data',title:'操作数据',width:80,align:'center'},
	            {field:'action',title:'什么操作',width:80,align:'center'}
	        ]],
	        */
	    });
	}
})

	// 数据获取
	function data() {
		var name = $('#name').val();
		var accNumber = $('#accNumber').val();
		var IP = $('#l_IP').val();
		var json = {
				name : name,
				accNumber : accNumber,
				IP:IP
		}
		return json
	}

