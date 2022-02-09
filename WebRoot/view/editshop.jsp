<%@page import="com.etcxm.www.entity.Shop"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">

		<title>Insert title here</title>

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
  		<h3>修改店铺信息</h3>
  		<div class="row">
  		<div class="col-sm-2"></div>
  		<div class="col-sm-8">
		<form action="uptshop.do" method="post" class="form-horizontal">
			<div class="form-group">
    			<label for="shopName">店铺名称</label>
    			<input type="text" class="form-control" id="shopName" placeholder="请输入店铺名称" name="shopName" value="${shop.shopName}">
  			</div>
  			<div class="form-group">
    			<label for="shopKeeper">店主</label>
    			<input type="text" class="form-control" id="shopKeeper" placeholder="请输入店主名" name="shopKeeper" value="${shop.shopKeeper}">
  			</div>
  			<div class="form-group">
    			<label for="address">店铺地址</label>
    			<input type="text" class="form-control" id="address" placeholder="请输入店铺地址" name="address" value="${shop.address}">
  			</div>
  			<div class="form-group">
    			<label for="connectPhone">联系方式</label>
    			<input type="text" class="form-control" id="connectPhone" placeholder="请输入联系方式" name="connectPhone" value="${shop.connectPhone}">
  			</div>
  			<div class="form-group">
    			<label for="avgPrice">人均消费</label>
    			<input type="text" class="form-control" id="avgPrice" placeholder="请输入人均消费价格" name="avgPrice" value="${shop.avgPrice}">
  			</div>
  			<div class="form-group">
    			<label for="shopPicFile"> 店铺图片</label>
    			<input type="text" class="form-control" id="shopPicFile" placeholder="请上传图片 " name="shopPicFile" value="${shop.shopPicFile}">
  			</div>
  			<div class="form-group">
    			<label for="shopStar">店铺星级</label>
    			<input type="text" class="form-control" id="shopStar" placeholder="请输入店铺星级" name="shopStar" value="${shop.shopStar}">
    			<input type="hidden" name="id" value="${shop.id}">
    			<input type="hidden" name="shopName" value="${shopName }">
  			</div>
			<input type="submit" value="修改" class="btn btn-success"/>
		</form>
		</div>
		<div class="col-sm-2"></div>
	</body>
</html>