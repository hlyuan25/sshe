<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/icon.css" type="text/css"></link>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:100px;">
    	
    </div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>
    <div data-options="region:'west',split:true" style="width:100px;">
    	<div class="easyui-panel" data-options="title:'sss',border:false,fit:true"></div>
    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
	<div class="easyui-dialog" data-options="title:'登录',modal:true,closable:false,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#index_regDialog').dialog('open');
				}
			},{
				text:'登录',
				iconCls:'icon-help',
				handler:function(){alert('help')}
			}]">
		<table>
			<tr>
				<th>登录名</th>
				<td><input /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input/></td>
			</tr>
		</table>
		
	</div>
	<div id="index_regDialog" style="width:250px;" class="easyui-dialog" data-options="title:'注册',closed:true,modal:true,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){alert('edit')}
			}]">
		<table>
			<tr>
				<th>登录名</th>
				<td><input /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input/></td>
			</tr>
			<tr>
				<th>重复密码</th>
				<td><input/></td>
			</tr>
		</table>
		
	</div>
</body>


</html>
