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
<head>
	<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
//1.用户名
			$("#username").blur(function(){
				var username=$("#username").val();
				if(username.length==0){	
					$("#tip11").html("用户名不能为空！");
				}else{
					$("#tip11").html("");
				}
			});
//2.密码			
			$("#password").blur(function(){
				var password=$("#password").val();
				if(password.length==0){
					$("#tip22").html("密码不能为空！");
				}else{
					$("#tip22").html("");
				}
			});
	</script>
</head>

<body>

	<div class="login-container">
		<h1>饿团外卖-商家登陆</h1>

		<div class="connect">
			<p>今天吃喝不努力 明天努力找吃喝！(｡・`ω´･)</p>
		</div>
		<form action="chkuserlog.do" method="post" >
			<input type="text" name="username" id="username" placeholder="请输入用户名" /><span id="tip11" style="color:red"></span><br>
			<input type="password" name="password" id="password" placeholder="请输入密码"  /><span id="tip22" style="color:red"></span><br>
			<input type="hidden" name="type" value="shopkeeper">
			<button id="submit" type="submit">登 录</button>
			<input type="hidden" name="type" value="shopkeeper">
		</form>
		<form action="register-shopkeeper.jsp" method="post" >
		
			<input type="hidden" name="type" value="shopkeeper">
			<button type="submit" class="register-tis">还有没有账号？</button>
		
		</form>
		<br>
		
		<a href="login.jsp">
			<button type="button" class="register-tis">返回</button>
		</a> 
		
		
		
	</div>

	<script src="login/js/jquery.min.js"></script>
<!-- 	<script src="login/js/common.js"></script> -->
	<!--背景图片自动更换-->
	<script src="login/js/supersized.3.2.7.min.js"></script>
	<script src="login/js/supersized-init.js"></script>
	<!--表单验证-->
<!-- 	<script src="login/js/jquery.validate.min.js?var1.14.0"></script> -->

	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">
	</div>
</body>
</html>