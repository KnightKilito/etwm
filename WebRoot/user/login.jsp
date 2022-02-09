<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.css" rel="stylesheet">
  </head>
  
  <body>
  	<h1 class="text-center">用戶登錄</h1>
	<div class="container">
	
		<form action="user/opauth.jsp" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">用戶名</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Email" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密碼</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
  </div>
  
  <input type="submit" class="btn btn-success" >
</form>
	</div>


  </body>
</html>
