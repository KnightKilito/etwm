
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

<link rel="stylesheet" href="css/style.css">

<body>

	<div class="login-container">

		<h1>您的身份是？</h1>
		<div class="connect">
			<p>欢迎来到饿团外卖！ヾ(≧▽≦*)</p>
		</div>
		
		
		
		<a href="login-guest.jsp">
			<button id="submit" type="submit">我是顾客</button>
		</a>
		<br>
		<a href="login-shopkeeper.jsp">
			<button id="submit" type="submit">我是商家</button>
		</a>
		
		<br>
		
		<a href="allShop.do">
			<button type="button" class="register-tis">返回</button>
		</a>
		
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/common.js"></script>
	<!--背景图片自动更换-->
	<script src="login/js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<!--表单验证-->
	<script src="js/jquery.validate.min.js?var1.14.0"></script>

	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">
	</div>
</body>
</html>