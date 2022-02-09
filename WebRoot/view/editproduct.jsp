<%@page import="com.etcxm.www.entity.ShopProduct"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editproduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
	<!-- 把request中的attribute->prodcut读取出来 -->
	<%-- <%
		Product product=(Product)request.getAttribute("product");
		//把product的数据放到表单中
	 %> --%>
	<div class="container">
  	<h3>修改产品</h3>
  	<div class="row">
  	<div class="col-sm-2"></div>
  	<div class="col-sm-8">
	<form action="upt.do" method="post" class="form-horizontal">
		<div class="form-group">
    		<label for="productName">产品名称</label>
    		<input type="text" class="form-control" id="productName" placeholder="请输入产品名称" name="productName">
  		</div>
  		<div class="form-group">
    		<label for="productName">产品价格</label>
    		<input type="text" class="form-control" id="productPrice" placeholder="请输入产品价格" name="productPrice">
  		</div>
  		<div class="form-group">
    		<label for="productIntroduction">产品描述</label>
    		<input type="text" class="form-control" id="productIntroduction" placeholder="请输入产品描述" name="productIntroduction">
  		</div>
  		<div class="form-group">
    		<label for="productPicFile">产品图片</label>
    		<input type="text" class="form-control" id="productPicFile" placeholder="请输入产品图片" name="productPicFile">
  		</div>
  		<div class="form-group">
    		<label for="productStar">产品星级</label>
    		<input type="text" class="form-control" id="productStar" placeholder="请输入产品星级" name="productStar">
  		</div>
  		
  		<input type="hidden" name="shopName" value="${shopName }">
  		<input type="hidden" name="id" value="${product.id }">
		<input type="submit" value="修改产品" class="btn btn-success"/>
	</form>
	</div>
	<div class="col-sm-2"></div>
	</div>
	</div>
  </body>
</html>
