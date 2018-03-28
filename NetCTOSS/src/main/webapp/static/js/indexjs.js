
$(function () {
    $('#tt').tree({
        onClick: function(node) {
            var str='';
            if(node.text=="查看用户账单"){
                str='../html/selfservice/111.html';
            }if(node.text=="账务账号管理"){
                str='../html/usermag/221.html';
            }if(node.text=="业务账号管理"){
                str='../html/usermag/222.html';
            }if(node.text=="管理员管理"){
                str='../html/admin/Administrator.html';
            }if(node.text=="资费管理"){
                str='../html/rates/Tariff.html';
            }if(node.text=="账单查询"){
                str='../html/billmag/Bill.html';
            }if(node.text=="查询"){
                str='../html/accountsmag/Accounting.html';
            }if(node.text=="角色管理"){
                str='../html/authoritymag/711.html';
            }if(node.text=="权限管理"){
                str='../html/authoritymag/712.html';
            }if(node.text=="登录服务日志"){
                str='../html/logmag/loginlog.html';
            }if(node.text=="操作日志"){
                str='../html/logmag/dolog.html';
            }if(node.text=="账务账单报表查询"){
                str='../html/reportforms/912.html';
            }if(node.text=="业务账单报表查询"){
                str='../html/reportforms/911.html';
            }
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+str+'" style="width:100%;height:100%;"></iframe>';
            if(str!=""){
                $('#center').tabs('close', node.text);
                $('#center').tabs('add',{
                    title:node.text,
                    content:content,
                    width:'100%',
                    height:'100%',
                    closable:true,
                });
            }

        }
    });

})
function addone() {
    var str = "../html/selfservice/112.html";
    var content = '<iframe scrolling="auto" frameborder="0"  src="'+str+'" style="width:100%;height:100%;"></iframe>'
    $('#center').tabs('close',"个人信息");
    $('#center').tabs('add',{
        title:"个人信息",
        content:content,
        closable:true
    });
}