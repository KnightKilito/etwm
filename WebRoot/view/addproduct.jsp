<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>输入产品信息</title>
    
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
  	<div class="container">
  	<h2>${shopName }</h2>
  	<h3>新增产品</h3>
  	<div class="row">
  	<div class="col-sm-2"></div>
  	<div class="col-sm-8">
	<form action="add.do" method="post" class="form-horizontal">
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
		<input type="submit" value="新增产品" class="btn btn-success"/>
	</form>
	</div>
	<div class="col-sm-2"></div>
	</div>
	</div>
  </body>
</html>
