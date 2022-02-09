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
    
    <title>输入店铺信息</title>
    
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
  	<h3>新增店铺</h3>
  	<div class="row">
  	<div class="col-sm-2"></div>
  	<div class="col-sm-8">
	<form action="addshops.do" method="post" class="form-horizontal">
		<div class="form-group">
    		<label for="shopName">店铺名称</label>
    		<input type="text" class="form-control" id="shopName" placeholder="请输入店铺名称" name="shopName">
  		</div>
  		<%String username=request.getParameter("username"); %>
  		<div class="form-group">
    		<label for="shopKeeper">店主</label>
    		<input type="text" class="form-control" id="shopKeeper" placeholder="请输入店主名" name="shopKeeper"  readonly unselectable="on" value="${param.username }">
  		</div>
  		<div class="form-group">
    		<label for="address">店铺地址</label>
    		<input type="text" class="form-control" id="address" placeholder="请输入店铺地址" name="address">
  		</div>
  		<div class="form-group">
    		<label for="connectPhone">联系方式</label>
    		<input type="text" class="form-control" id="connectPhone" placeholder="请输入联系方式" name="connectPhone">
  		</div>
  		<div class="form-group">
    		<label for="avgPrice">人均消费</label>
    		<input type="text" class="form-control" id="avgPrice" placeholder="请输入人均消费价格" name="avgPrice">
  		</div>
  		<div class="form-group">
    		<label for="shopPicFile"> 店铺图片</label>
    		<input type="text" class="form-control" id="shopPicFile" placeholder="请上传图片 " name="shopPicFile">
  		</div>
  		<div class="form-group">
    		<label for="shopStar">店铺星级</label>
    		<input type="text" class="form-control" id="shopStar" placeholder="请输入店铺星级" name="shopStar">
  		</div>
		<input type="submit" value="新增店铺" class="btn btn-success"/>
	</form>
	</div>
	<div class="col-sm-2"></div>
	</div>
	</div>
  </body>
</html>
