<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="../jQuery-easyui/jquery.min.js"></script>
    <!-- 引入EasyUI -->
    <script type="text/javascript" src="../jQuery-easyui/jquery.easyui.min.js"></script>
    <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
    <script type="text/javascript" src="../jQuery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/date.js"></script>
    <script type="text/javascript" src="../js/demo.js"></script>
    <script type="text/javascript" src="../js/jquery.json-2.4.js"></script>
    <script type="text/javascript" src="../js/indexjs.js"></script>
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="../jQuery-easyui/themes/default/easyui.css" type="text/css" />
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="../jQuery-easyui/themes/icon.css" type="text/css" />
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false"
     style="height: 80px; background: white; padding: 10px; font-size: 25px">
    <img src="../img/timg.jpg" style="height: 50px"/>
    <span style="font-size: 20px;color:red;font-family: 华文楷体">欢迎用户[<shiro:principal/>]登录</span>
   <span style="margin-left: 20px;font-size: 40px;font-family: 华文楷体"> 电信服务器NetCTOSS计费系统 </span>
    <span id="clock" style="font-size: 15px;font-family: 华文楷体;margin-top: 20px; float: right"></span>
    <a href="javascript:void(0)" onclick="addone()" style="font-size: 15px;text-decoration:none;color: #0052A3;font-family: 华文楷体;margin-left: 30px;">个人信息</a>
    <a href="#" style="font-size: 15px;text-decoration:none;color: #0052A3; font-family: 华文楷体;">退出</a>
</div>
<div data-options="region:'west',split:true,title:'菜单项'"
     style="width: 200px; height: 100%; padding: 0px;">
    <div style="margin: 0px;"></div>
    <div class="easyui-panel" style="width: 100%; height: 100%;">
        <ul id="tt"  class="easyui-tree">
            <shiro:hasPermission name="*:前台用户管理权限">  
		    	具有前台用户管理权限
		    </shiro:hasPermission>   
            <li data-options="state:'closed'"><span>前台用户系统</span>
                <ul>
                    <li><span>查看用户账单</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>用户管理系统</span>
                <ul>
                    <li><span>账务账号管理</span></li>
                    <li><span>业务账号管理</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>管理员管理系统</span>
                <ul>
                    <li><span>管理员管理</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>资费管理系统</span>
                <ul>
                    <li><span>资费管理</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>账单查询系统</span>
                <ul>
                    <li><span>账单查询</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>账务查询系统</span>
                <ul>
                    <li><span>查询</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>权限管理系统</span>
                <ul>
                    <li><span>角色管理</span></li>
                    <li><span>权限管理</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>前台日志系统</span>
                <ul>
                    <li><span>登录服务日志</span></li>
                    <li><span>操作日志</span></li>
                </ul>
            </li>
            <li data-options="state:'closed'"><span>报表查询系统</span>
                <ul>
                    <li><span>账务账单报表查询</span></li>
                    <li><span>业务账单报表查询</span></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div data-options="region:'south',border:false" style="height: 50px;text-align: center; background: #A9FACD; padding: 10px;">
    2018-&copy;CopyRight by First-Group
</div>
<div id="center" class="easyui-tabs" data-options="region:'center'"  style="height: 90%;width: 100%">
    <div title="主页">
        <img alt="" src="../img/6.jpg" style="height:100%;width:100%">
    </div>
</div>
</body>
</html>