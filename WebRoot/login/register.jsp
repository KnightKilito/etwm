<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>饿团外卖-账号注册</title>
<link rel="stylesheet" href="css/style.css">
<body>

<div class="register-container">
	<h1>饿团外卖-账号注册</h1>
	<div class="connect">
		<p>识食物者为俊杰！ (。・ˍ・。)</p>
	</div>
	<form action="" method="post" id="registerForm">
		<div>
			<input type="text" name="username" class="username" placeholder="您的用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="重复密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="email" name="email" class="email" placeholder="真实姓名" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="text" name="phone_number" class="phone_number" placeholder="手机号" autocomplete="off" id="number"/>
		</div>
		<button id="submit" type="submit">注 册</button>
	</form>
	<a href="login.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>
</div>

</body>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>
</html>