<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html  lang="en">

<head>

</head>

<body>

            <div class="container">
  				<h3>个人信息：</h3>
  				<p>真实姓名：${shopkeeper.realname}<br>
  				<p>联系方式：${shopkeeper.phone}<br>
  			</div>
			
</body>

</html>