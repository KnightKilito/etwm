<%-- <%@page import="com.etcxm.www.entity.Product"%> --%>
<%-- <%@page import="java.sql.ResultSet"%> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allproducts.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8" >
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
  	<div class="container">
  	<h3>所有店铺</h3>
  	<a href="view/addshop.jsp?username=${username }" class="btn btn-success">新增店铺</a>
  	<table class="table table-hover">
  		<c:forEach items="${list }" var="shop">
  			<tr>
  				<td>${shop.id }</td>
  				<td>${shop.shopName }</td>
  				<td>${shop.shopStar }</td>
  				<td><a href="shopmain.do?id=${shop.id }" class="btn btn-success">进入店铺</a></td>
  				<td><a href="edtshop.do?id=${shop.id }" class="btn btn-warning">编辑</a></td>
  				<td><a href="delshop.do?id=${shop.id }" class="btn btn-success">删除</a></td>
  			</tr>
  		</c:forEach>
  	</table>
  	<a href="allshopspage.do?pageNum=1&pageSize=${pageSize}" class="btn btn-default">第一页 </a>
  	<c:if test="${currPage!=1 }"><a href="allshopspage.do?pageNum=${currPage-1 }&pageSize=${pageSize}" class="btn btn-default">上一页</a></c:if> 
  	共  ${allCount } 条，共  ${allPage } 页 ，当前在 ${currPage } 页
  	<c:if test="${currPage!=allPage }"><a href="allshopspage.do?pageNum=${currPage+1 }&pageSize=${pageSize}" class="btn btn-default">下一页</a></c:if>
  	<a href="allshopspage.do?pageNum=${allPage}&pageSize=${pageSize}" class="btn btn-default">最后一页 </a>
  	</div>
  </body>
</html>
