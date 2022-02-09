<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		function check(){
			var username=$("#username").val();
			if(username.length<1||username.length>16){
				alert("请输入正确的用户名！");
				return false;
			}
			var password=$("#password").val();
			if(password.length==0){
				alert("请输入密码！");
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>
    
    <form action="auth.do" method="post" onsubmit="return check()">
    	用户名：<input type="text" name="username" id="username"><br/>
    	密码：<input type="password" name="password" id="password"><br/>
    	<input type="submit" value="登录" >
    </form>
    
  </body>
</html>
