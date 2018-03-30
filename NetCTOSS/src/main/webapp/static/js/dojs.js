$(function () {
    $('#tb').datagrid({
    	url : "doLog/findAll",
		method : "GET",
		queryParams : queryParams()
    });

    /**
	 * 查询参数的封装
	 */
	function queryParams() {

		var name = $('#admName').val();
		var loginName = $('#loginName').val();
		var ip = $('#IP').val();
		var place = $('#place').val();
		var data = $('#data').val();
		var action= $('#action').val();
		
		var data = {
			name : name,
			loginName : loginName,
			ip : ip,
			place : place,
			data : data,
			action: action,
		};
		return data;
	};
})

