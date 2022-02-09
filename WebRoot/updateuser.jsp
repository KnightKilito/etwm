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
<link rel="stylesheet" href="login/css/style.css">
<head>
	<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
//1.用户名
			$("#username").blur(function(){
				var username=$("#username").val();
				if(username.length==0){	
					$("#tip1").html("用户名不能为空！");
				}else{
					$("#tip1").html("");
				}
				if(username.length>0){
				
					$.post("chkuserupdate.do",{
					"username":username
					},function(data,status){
						if(status=="success"){
							if(data==0 || data==1){
								$("#tip1").html("");
							}else{
								$("#tip1").html("该用户名已经被使用！");
							}
						}
					});
				}
			});
//2.密码			
			$("#password").blur(function(){
				var password=$("#password").val();
				if(password.length==0){
					$("#tip2").html("密码不能为空！");
				}else{
					$("#tip2").html("");
				}
			});
//3.确认密码				
			$("#cpassword").blur(function(){
				var password=$("#password").val();
				var cpassword=$("#cpassword").val();
				if(cpassword.length==0){
					$("#tip3").html("确认密码不能为空！");
				}else{
					$("#tip3").html("");
				}
				if(cpassword.length>0){
					$.post("authpd.do",{
					"password":password,
					"cpassword":cpassword
					},function(data,status){
						if(status=="success"){
							if(data=="100"){
								$("#tip3").html("");
							}else{
								$("#tip3").html("两次输入的密码不同");
							}
						}
					});
				}
			});
//4.真实姓名			
			$("#realname").blur(function(){
				var realname=$("#realname").val();
				if(realname.length==0){
					$.post()
					$("#tip4").html("真实姓名不能为空！");
				}else{
					$.post()
					$("#tip4").html("");
				}				
			});	
//5.电话号码			
			$("#phone").blur(function(){
				var phone=$("#phone").val();
				if(phone.length==0){
					$.post()
					$("#tip5").html("电话号码不能为空！");
				}else{
					$.post()
					$("#tip5").html("");
				}
				if(phone.length>0){
					$.post("chkphone.do",{
					"phone":phone
					},function(data,status){
						if(status=="success"){
							if(data==100){
								$("#tip5").html("");
							}else{
								$("#tip5").html("请填写正确的电话号码！");
							}
						}
					});
				}
			});
		});
		
	</script>
</head>
<body>

<div class="register-container">
	<h1>饿团外卖-修改信息</h1>
	<div class="connect">
		<p>识食物者为俊杰！ (。・ˍ・。)</p>
	</div>
	<form action="updateuser.ado" method="post" >
			<input type="text" name="username" id="username" placeholder="请输入用户名" value="${user.username }"/><span id="tip1" style="color:red"></span><br>
			<input type="password" name="password" id="password" placeholder="请输入密码"  value="${user.password}"/><span id="tip2" style="color:red"></span><br>
			<input type="password" name="cpassword" id="cpassword" placeholder="请再一次输入密码"/><span id="tip3" style="color:red"></span><br>
			<input type="text" name="realname" id="realname" placeholder="请输入真实姓名" value="${user.realname }"  /><span id="tip4" style="color:red"></span><br>
			<input type="text" name="phone" id="phone"placeholder="请输入电话号码" value="${user.phone }"/><span id="tip5" style="color:red"></span><br>
			<input type="text" name="address" id="address"placeholder="请输入收货地址" value="${user.address }"/><span id="tip5" style="color:red"></span><br>
			<input type="text" name="picFile" id="picFile"placeholder="请输入电话号码" value="${user.picFile }"/><span id="tip5" style="color:red"></span><br>
 			<input type="hidden" name="userId" value="${user.id }">
 			<button id="submit" type="submit">修 改</button>
	</form>	
	
	<br>
		<script type="text/javascript">
			var url =document.referrer;
			function back(){
				window.location.href=url;
			}
		</script>
		<a onclick="back()">
			<button type="button" class="register-tis">返回</button>
		</a> 
</div>

</body>
<script src="login/js/jquery.min.js"></script>
<!-- <script src="login/js/common.js"></script> -->
<!--背景图片自动更换-->
 <script src="login/js/supersized.3.2.7.min.js"></script> 
 <script src="login/js/supersized-init.js"></script> 
<!--表单验证-->
<!-- <script src="login/js/jquery.validate.min.js?var1.14.0"></script> -->
</html>