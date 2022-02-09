<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>结算cece</title>
<link rel="apple-touch-icon" sizes="180x180"
	href="assets/images/favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="assets/images/favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/images/favicons/favicon-16x16.png">
<link rel="manifest" href="assets/images/favicons/site.webmanifest">

<!-- Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Sacramento&display=swap"
	rel="stylesheet">

<!-- Css-->
<link rel="stylesheet" href="assets/css/animate.min.css">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/owl.theme.default.min.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="assets/css/swiper.min.css">
<link rel="stylesheet" href="assets/css/bootstrap-select.min.css">

<link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css">
<link rel="stylesheet" href="assets/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="assets/css/vegas.min.css">
<link rel="stylesheet" href="assets/css/nouislider.min.css">
<link rel="stylesheet" href="assets/css/nouislider.pips.css">
<link rel="stylesheet" href="assets/css/ziston-icon.css">
<link rel="stylesheet" href="assets/css/ziston-new-icons.css">
<!-- Template styles -->
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/responsive.css">
<link
	href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="preloader">
		<img src="assets/images/loader.png" class="preloader__image" alt="">
	</div>
	<!-- /.preloader -->

	<div class="page-wrapper">


		<div class="site-header__header-one-wrap header_three_wrap clearfix">



			<header class="main-nav__header-one">
				<nav class="header-navigation three stricky">
					<div class="container-box clearfix">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="main-nav__left main-nav__left_one float-left">
							<div class="logo_one">
								<c:if test="${username==null }">
									<a href="allShop.do" class="main-nav__logo"> <img
										src="assets/images/resources/logo-2.png" class="main-logo"
										alt="Awesome Image">
									</a>
								</c:if>
								<c:if test="${username!=null }">
									<a href="allShop.do?username=${username }"
										class="main-nav__logo"> <img
										src="assets/images/resources/logo-2.png" class="main-logo"
										alt="Awesome Image">
									</a>
								</c:if>
							</div>
							<a href="#" class="side-menu__toggler"> <i class="fa fa-bars"></i>
							</a>
						</div>

						<div class="main-nav__main-navigation three float-left">
							<ul class=" main-nav__navigation-box">
								<c:if test="${username==null }">
									<li><a href="allShop.do">Home</a></li>
								</c:if>
								<c:if test="${username!=null }">
									<li><a href="allShop.do?username=${username }">Home</a></li>
								</c:if>
								<li class="dropdown"><a href="#">Quick Access</a>
									<ul>
										<li><a href="listings2.jsp">今★日★推★荐</a></li>
										<li><a href="listings2.jsp">周★榜★店★铺</a></li>
										<li><a href="listings3.jsp">用★户★评★价</a></li>
									</ul> <!-- /.sub-menu --></li>

								<li class="dropdown"><a href="#">About</a>
									<ul>
										<li><a href="about-us.jsp">关于我们</a></li>
										<li><a href="donate-us.jsp">赞助我们</a></li>
										<li><a href="https://blog.zhelovechun.top/">团队博客</a></li>
										<li><a href="#">点了没用</a>
											<ul>
												<li><a href="#">就是放着</a></li>
												<li><a href="#">诶就是玩</a></li>
											</ul></li>
									</ul> <!-- /.sub-menu --></li>

							</ul>
						</div>
						<!-- /.navbar-collapse -->

						<div class="main-nav__right main-nav__right_one three float-right">

							<div class="header_btn_1">
								<c:if test="${username==null }">
									<a href="login.jsp" class="login"><span class="fas fa-user"></span>Login
										or Register</a>
								</c:if>
								<c:if test="${username!=null }">
									<a href="myaccount.ado" class="login"><span
										class="fas fa-user"></span>${username }</a>
								</c:if>
							</div>
							<div class="icon_cart_box">
								<a href="allshopcar.ado?username=${username }"> <span
									class="icon-shopping-cart"></span>
								</a>
							</div>
							<div class="icon-search-box">
								<a href="#" class="main-nav__search search-popup__toggler">
									<i class="icon-magnifying-glass"></i>
								</a>
							</div>


						</div>

					</div>
				</nav>
			</header>
		</div>

		<!--Banner Three Start-->


		<!--Four Boxes Two Start-->


		<!--Brand Three Start-->


		<!--Latest Listings Three Start-->


		<!--Why Choose Start-->


		<!--Two Section Start-->


		<!--Weekly Start-->



		<!--Testimonials One Start-->
		
		
		<section class="food_lovers_two"
			style="background-image: url(assets/images/backgrounds/food-lovers-2_bg.jpg)">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="food_lovers_two_inner">
							<p>Food lovers</p>
							<h2>
								<c:if test="${msg1!=null }">${msg1 }<br></c:if>
								<c:if test="${msg2!=null }">${msg2 }<br></c:if>
								<c:if test="${msg3!=null }">${msg3 }<br></c:if>
							</h2>
							<div class="food_lovers_two_btn">
								<a href="countshopcar.ado?shopName=${shopName }" class="thm-btn">返回填写</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>


		<!--Blog One Start-->

		<!--CTA Two Start-->


		<!--Site Footer Start-->
		<footer class="site-footer">
			<div class="site_footer_shape-1"
				style="background-image: url(assets/images/resources/footer-shape-1.png)">
			</div>
			<div class="site_footer_map"
				style="background-image: url(assets/images/resources/footer-map.png)"></div>
			<div class="container">
				<div class="row">
					<div class="col-xl-4 col-lg-4 col-md-6">
						<div
							class="footer-widget__column footer-widget__about wow fadeInUp"
							data-wow-delay="100ms">
							<div class="footer-widget__logo">
								<a href="#"><img
									src="assets/images/resources/footer-logo.png" alt=""></a>
							</div>
							<div class="footer-widget_about_text">
								<p>人生苦短 再吃一碗！◐ω◑</p>
							</div>
							<div class="footer_contact_info">
								<div class="footer_contact_icon">
									<span class="icon-calling"></span>
								</div>
								<div class="footer_contact_number">
									<p>Phone</p>
									<h4>
										<a href="tel:+123456789">120 3018 4201</a>
									</h4>
								</div>
							</div>

						</div>

					</div>
					<div class="col-xl-2 col-lg-2 col-md-6">
						<div
							class="footer-widget__column footer-widget__explore wow fadeInUp"
							data-wow-delay="200ms">
							<div class="footer-widget__title">
								<h3>我的</h3>
							</div>
							<ul class="footer-widget__explore-list list-unstyled">
								<li><a href="#">我的账户</a></li>
								<li><a href="#">我的车车</a></li>
								<li><a href="#">同性网站</a></li>
								<li><a href="#">点了没用</a></li>
								<li><a href="#">就是放着</a></li>
								<li><a href="#">诶就是玩</a></li>
							</ul>
						</div>
					</div>
					<div class="col-xl-2 col-lg-2 col-md-6">
						<div
							class="footer-widget__column footer-widget__categories wow fadeInUp"
							data-wow-delay="300ms">
							<div class="footer-widget__title">
								<h3>探索</h3>
							</div>
							<ul class="footer-widget__categories_list list-unstyled">
								<li><a href="#">关于我们</a></li>
								<li><a href="#">赞助我们</a></li>
								<li><a href="#">团队博客</a></li>
								<li><a href="#">点了没用</a></li>
								<li><a href="#">就是放着</a></li>
								<li><a href="#">诶就是玩</a></li>
							</ul>
						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-6">
						<div
							class="footer-widget__column footer-widget__newsletter wow fadeInUp"
							data-wow-delay="400ms">
							<div class="footer-widget__title">
								<h3>订阅服务</h3>
							</div>
							<ul class="footer-widget_newsletter_address list-unstyled">
								<li>想要我们给您发广告就在下方提交您的邮箱地址吧！</li>

							</ul>
							<form>
								<div class="footer_input-box">
									<input type="Email" placeholder="Enter email address">
									<button type="submit" class="button">
										<i class="fas fa-paper-plane"></i>Subscribe
									</button>
								</div>
							</form>
							<!-- <ul class="footer-widget_newsletter_address list-unstyled">
								
								<li>技术支持：</li>
								<li><a href="mailto:KnightKilito@163.com">KnightKilito@163.com</a></li>
								
							</ul> -->
						</div>
					</div>
				</div>
			</div>
		</footer>

		<div class="site-footer_bottom">
			<div class="container">
				<div class="site-footer_bottom_copyright">
					<p>Copyright &copy; 2021.Java Knights All rights reserved.</p>
				</div>
				<div class="site-footer__social">
					<a href="#"><i class="fab fa-twitter"></i></a> <a href="#"><i
						class="fab fa-facebook-square"></i></a> <a href="#"><i
						class="fab fa-youtube"></i></a> <a href="#"><i
						class="fab fa-instagram"></i></a>
				</div>
			</div>
		</div>





	</div>
	<!-- /.page-wrapper -->

	<a href="#" data-target="html" class="scroll-to-target scroll-to-top"><i
		class="fa fa-angle-up"></i></a>

	<div class="side-menu__block">
		<div class="side-menu__block-overlay custom-cursor__overlay">
			<div class="cursor"></div>
			<div class="cursor-follower"></div>
		</div>
		<!-- /.side-menu__block-overlay -->
		<div class="side-menu__block-inner ">
			<div class="side-menu__top justify-content-end">
				<a href="#" class="side-menu__toggler side-menu__close-btn"><img
					src="assets/images/shapes/close-1-1.png" alt=""></a>
			</div>
			<!-- /.side-menu__top -->

			<nav class="mobile-nav__container">
				<!-- content is loading via js -->
			</nav>

			<div class="side-menu__sep"></div>
			<!-- /.side-menu__sep -->

			<div class="side-menu__content">
				<p>
					<a href="mailto:KnightKilito@163.com">KnightKilito@163.com</a> <br>
					<a href="tel:12030184201">120 3018 4201</a>
				</p>
				<div class="side-menu__social">
					<a href="#"><i class="fab fa-facebook-square"></i></a> <a href="#"><i
						class="fab fa-twitter"></i></a> <a href="#"><i
						class="fab fa-instagram"></i></a> <a href="#"><i
						class="fab fa-pinterest-p"></i></a>
				</div>
			</div>
		</div>
	</div>

	<div class="search-popup">
		<div class="search-popup__overlay custom-cursor__overlay">
			<div class="cursor"></div>
			<div class="cursor-follower"></div>
		</div>
		<!-- /.search-popup__overlay -->
		<div class="search-popup__inner">
			<form action="searchShop.do?" class="search-popup__form">
				<input type="hidden" name="pageNum" value="1"> <input
					type="hidden" name="pageSize" value="8"> <input
					type="hidden" name="username" value="${username}"> <input
					type="text" name="search" placeholder="Type here to Search....">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>



	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/owl.carousel.min.js"></script>
	<script src="assets/js/waypoints.min.js"></script>
	<script src="assets/js/jquery.counterup.min.js"></script>
	<script src="assets/js/TweenMax.min.js"></script>
	<script src="assets/js/wow.js"></script>
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<script src="assets/js/jquery.ajaxchimp.min.js"></script>
	<script src="assets/js/swiper.min.js"></script>
	<script src="assets/js/typed-2.0.11.js"></script>
	<script src="assets/js/vegas.min.js"></script>
	<script src="assets/js/jquery.validate.min.js"></script>
	<script src="assets/js/bootstrap-select.min.js"></script>
	<script src="assets/js/countdown.min.js"></script>
	<script src="assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="assets/js/bootstrap-datepicker.min.js"></script>
	<script src="assets/js/nouislider.min.js"></script>
	<script src="assets/js/isotope.js"></script>
	<script src="assets/js/appear.js"></script>


	<!-- template scripts -->
	<script src="assets/js/theme.js"></script>


</body>

</html>