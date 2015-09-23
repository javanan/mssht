<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理端首页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	function openTab(text, url, icon) {
		if ($("#tabs").tabs("exists", text)) {
			$("#tabs").tabs("select", text);
		} else {
			var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"
					+ url + "'></iframe>";
			$("#tabs").tabs("add", {
				title : text,
				icon : icon,
				closable : true,
				content : content
			});
		}
	}

	function openModifiPasswordDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "修改密码");
		url="/wssht/example/user_modifyPassword?user.userid=${currUser.userid}";
	}

	function modifyPassword() {
		$("#fm").form("submit", {
			url : url,
			onSubmit : function() {
				var oldpassword = $("#oldpassword").val();
				var newpassword = $("#newpassword").val();
				var newpassword2 = $("#newpassword2").val();
				if (!$(this).form("validate")) {
					return false;
				}
				if (oldpassword != '${currUser.password }') {
					$.messager.alert("系统提示", "原始密码错误");
					return false;
				}
				if (newpassword != newpassword2) {
					$.messager.alert("系统提示", "两次密码不一样");
					return false;
				}
				return true;
			},
			success:function(result) {
				var result=eval('('+result+')');
				console.info(result);
				if(result.success){
					$.messager.alert("系统提示","密码修改成功，下次登陆生效");
					 closePasswordModifyDialog() ;
				}else{
					$.messager.alert("系统提示","密码修改失败");
					return;
				}
			}
		});
	}

	function closePasswordModifyDialog() {
		$("#dlg").dialog("close");
		$("#oldpassword").val("");
		$("#newpassword").val("");
		$("#newpassword2").val("");
	}
</script>
</head>

<body class="easyui-layout">
	<div region="north" style="height: 78px; background-color: #E0ECFF">
		<table style="padding: 5px" width="100%">
			<tr>
				<td width="50%"><img
					src="${pageContext.request.contextPath}/images/bglogo.png" /></td>
				<td valign="bottom" align="right" width="50%"><font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currUser.relname }</font>
				</td>
			</tr>
		</table>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" data-options="iconCls:'icon-home'">
				<div align="center" style="padding-top: 100px">
					<font color="red" size="10">欢迎使用xxx后台管理系统</font>
				</div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 200px" title="导航菜单" split="true">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="用户管理" data-options="selected:true,iconCls:'icon-user'"
				style="padding: 10px">
				<a href="javascript:openTab('用户管理','userManage.jsp','icon-user')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-manage'"
					style="width: 150px;">管理用户</a>
			</div>
			<div title="商品管理" data-options="selected:true,iconCls:'icon-product'"
				style="padding: 10px">
				<a
					href="javascript:openTab('商品管理','productManage.jsp','icon-product')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-product'"
					style="width: 150px;">商品管理</a> <a
					href="javascript:openTab('商品大类','dalei.jsp','icon-product')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-product'"
					style="width: 150px;">商品大类</a> <a
					href="javascript:openTab('商品小类','xiaolei.jsp','icon-product')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-product'"
					style="width: 150px;">商品小类</a>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-item'"
				style="padding: 10px">
				<a href="javascript:openModifiPasswordDialog()"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-modifyPassword'"
					style="width: 150px;">修改密码</a>
			</div>
		</div>
	</div>
	<div region="south" style="height: 25px; padding: 5px;" align="center">
		版权所有 2015 jamen.chen qq:122741482</div>


	<div class="easyui-dialog" closed="true"
		style="width: 400px; height: 220px; padding: 10px 20px" id="dlg"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>用户名：</td>
					<td><input type="text" id="lodname" name="user.lodname"
						value="${currUser.lodname}" readonly="readonly"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>原密码：</td>
					<td><input type="password" id="oldpassword" required="true"
						class="easyui-validatebox" style="width: 200px" /></td>
				</tr>
				<tr>
					<td>新密码：</td>
					<td><input type="password" id="newpassword" name="user.password"  required="true"
						class="easyui-validatebox" style="width: 200px" /></td>
				</tr>
				<tr>
					<td>确认新密码：</td>
					<td><input type="password" id="newpassword2" required="true"
						class="easyui-validatebox" style="width: 200px" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:modifyPassword()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a
			href="javascript:closePasswordModifyDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>