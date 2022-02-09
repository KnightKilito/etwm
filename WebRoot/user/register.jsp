<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function check(){
			//判断用户名
			var username=document.getElementById("username").value;
			if(username.length<6||username.length>16){
				alert("用户名必须是6-16位");
				return false;
			}
			//判断密码
			var password=document.getElementById("password").value;
			if(password.length<6||password.length>16){
				alert("密码必须是6-16位");
				return false;
			}
			//密码和确认密码一致
			var cpassword=document.getElementById("cpassword").value;
			if(password!=cpassword){
				alert("密码和确认密码不一致！");
				return false;
			}
			//判断真实姓名是否填写
			var realname=document.getElementById("realname").value;
			if(realname.length<1){
				alert("请输入真实姓名！");
				return false;
			}
		}
	</script>
  </head>
  
  <body>
	<form action="opreg.jsp" method="post" onsubmit="return check()">
		用户名：<input type="text" name="username" id="username"/><br/>
		密码：<input type="password" name="password" id="password"/><br/>
		确认密码：<input type="password" name="cpassword" id="cpassword" /><br/>
		真实姓名：<input type="text" name="realname" /><br/>
		电话号码：<input type="text" name="phone" /><br/>
		<input type="submit" value="注册" />
	</form>

  </body>
</html>
