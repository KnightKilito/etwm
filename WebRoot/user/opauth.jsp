<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录校验</title>
    
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
	
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false&useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPwd = "123456";
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{
		
			Class.forName(driver);
			connection=DriverManager.getConnection(url,dbUser,dbPwd);
			String sql="select * from tab_user where username=? and password=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				String realname=resultSet.getString("realname");
				String phone=resultSet.getString("phone");
				
				session.setAttribute("username", username);
				session.setAttribute("realname", realname);
				session.setAttribute("phone", phone);
				//成功
			%>
				<script type="text/javascript">
					alert("登录成功！");
					window.location.href="user/welcome.jsp";
				</script>
			<%
			}else{
				//登录失败！
				%>
				<script type="text/javascript">
					alert("用户名或者密码错误！");
					window.history.back();
				</script>
				<%
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(resultSet!=null)resultSet.close();
			if(preparedStatement!=null)preparedStatement.close();
			if(connection!=null)connection.close();
		}
		
	
	
	 %>

  </body>
</html>
