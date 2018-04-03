$(function () {
	$('#tb').datagrid({
        url:'/NetCTOSS/doLog/findAll',
        method:'GET',
        /*columns:[[
            //field数据对应的名称字段
            {field:'admName',title:'管理员的名字',width:80,align:'center'},
            {field:'loginName',title:'管理员的账号',width:80,align:'center'},
            {field:'IP',title:'登录地IP',width:80,align:'center'},
            {field:'place',title:'操作模块',width:80,align:'center'},
            {field:'data',title:'操作数据',width:80,align:'center'},
            {field:'action',title:'什么操作',width:80,align:'center'}
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
			url : '/NetCTOSS/doLog/find',
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
		var admName = $('#admName').val();
		var loginName = $('#loginName').val();
		var IP = $('#l_IP').val();
		var json = {
			admName : admName,
			loginName : loginName,
			IP:IP
		}
		return json
	}

