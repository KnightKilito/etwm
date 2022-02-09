<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理端首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link
	href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container-fluid">
			<div class="page-header">
				<h1>
					店铺管理 <small>${shop.shopName}</small>
				</h1>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-4">
					<ul class="nav nav-pills nav-stacked">
						<li role="presentation" class="active"><a href="allshopproducts.do?shopId=${shop.id }" target="content">预览客户视角</a></li>
						<li role="presentation"><a href="shopinfor.do?id=${shop.id }" target="content">店铺资料</a></li>
						<li role="presentation"><a href="allpage.do?shopName=${shop.shopName }" target="content">商品管理</a></li>
						<li role="presentation"><a href="showhistoryorder.ado?shopName=${shop.shopName }" target="content">订单管理</a></li>
					</ul>
				</div>
				<div class="col-md-10 col-sm-8" >
					<iframe frameborder="0" width="100%" height="100%" name="content"></iframe>
				</div>
			</div>
	</div>

</body>
</html>
