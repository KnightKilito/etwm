<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html  lang="en">

<head>

</head>

<body>

	
    	<div class="container">
  			<h3>店铺信息</h3>
  			<p>店铺名：${shop.shopName}<br>
  			<p>联系方式：${shop.connectPhone}<br>
  			<p>店铺地址：${shop.address}<br>
  			<p>平均消费：${shop.avgPrice}<br>
  			<p>店铺星级：${shop.shopStar}<br>
  		</div>
  	
</body>

</html>
