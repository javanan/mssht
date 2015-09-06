<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/adminlogin.css">
<title>管理员登录</title>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
	function formcheck() {

		var username = $("#username").val();

		var password = $("#password").val();

		if (username == "") {

			$("#error").html("用户名不能为空！");
			return false;
		}
		if (password == "") {
			$("#error").html("密码不能为空！");
			return false;
		}
		if (imageCode == "") {
			$("#error").html("验证码不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div id="head_content">
		<img src="${pageContext.request.contextPath}/images/logo.png" />
		<div id="system_name">
			<span>xx后端管理系统</span>
		</div>
	</div>
	<div id="head_bar"></div>

	<div id="body_content">
		<div id="login_info">
			<div id="manager_title">
				<h2>管理员登陆</h2>
			</div>
			<form action="${pageContext.request.contextPath}/example/Test_find.action" method="post" onsubmit="return formcheck()">
				<div id="username_div">
					用户名：<input type="text" id="username" name="testEntity.name"
						value="${testEntity.name }">
				</div>
				<div class="nullp"></div>
				<div>
					密&nbsp;码：<input type="password" id="password" name="testEntity.password">
				</div>
				<div class="nullp"></div>
				<div>
					验证码：<input type="text" name="imageCode" value="${imageCode }" id="imageCode">
				</div>
				<div id="code_image">1234</div>
				<div class="nullp"></div>
				<div class="ui-green">
					<input type="submit" name="submit" value="立即登录" class="submit" />
				</div>
				<font id="error" color="red"></font>
			</form>
		</div>
	</div>

	<div id="bottom_content">Copyright &copy; 2015 jamen.chen All
		Rights Reserved. http://www.jamen.chen.com</div>

</body>
</html>