<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>饿团外卖-账号登录</title>

<link rel="stylesheet" href="login/css/style.css">

<body>

	<div class="login-container">
		<h1>饿团外卖-账号登陆</h1>

		<div class="connect">
			<p>今天吃喝不努力 明天努力找吃喝！(｡・`ω´･)</p>
		</div>
		<form action="" method="post" id="loginForm">
			<div>
				<input type="text" name="username" class="username"
					placeholder="用户名" autocomplete="off" />
			</div>
			<div>
				<input type="password" name="password" class="password"
					placeholder="密码" oncontextmenu="return false"
					onpaste="return false" />
			</div>
			<button id="submit" type="submit">登 陆</button>
		</form>
		<a href="register.jsp">
			<button type="button" class="register-tis">还有没有账号？</button>
		</a>
	</div>

	<script src="login/js/jquery.min.js"></script>
	<script src="login/js/common.js"></script>
	<!--背景图片自动更换-->
	<script src="login/js/supersized.3.2.7.min.js"></script>
	<script src="login/js/supersized-init.js"></script>
	<!--表单验证-->
	<script src="login/js/jquery.validate.min.js?var1.14.0"></script>

	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">
	</div>
</body>
</html>

