<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  	<%
  		Object username=session.getAttribute("username");
  		if(username==null){		//没登录，session没有username的记录，所以不让访问页面
  			%>
  			<script type="text/javascript">
  				alert("请登录！");
  				window.location.href="<%=basePath%>user/login.jsp";
  			</script>
  			<%
  		}
  	 %>
  
	欢迎你，<%=session.getAttribute("realname") %>(<%=session.getAttribute("phone") %>)

  </body>
</html>
