<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>饿团外卖，饿了就买！</title>
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
								<a href="allShop.do?username=${username }" class="main-nav__logo"> <img
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
								<c:set var="kon" value=""></c:set>
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
		<section class="banner_three">
			<img src="assets/images/main-slider/slide_v3_bg-1.png" alt=""
				class="banner-three-vector-img"> <img
				src="assets/images/shapes/slider-3-cloud.png" alt=""
				class="banner-three-cloud-img animate-left-right"> <img
				src="assets/images/shapes/slider-3-line.png" alt=""
				class="banner-three-line-img"> <img
				src="assets/images/shapes/slider-3-shape-1.png" alt=""
				class="banner_three_shape_1"> <img
				src="assets/images/shapes/slider-3-shape-2.png" alt=""
				class="banner_three_shape_2">
			<div class="container">
				<div class="row">
					<div class="col-xl-6 col-lg-6">
						<div class="banner_three_top-title">
							<h1>
								Discover the Best Food<span>ETuanWaiMai.</span>
							</h1>
							<p>Find the greatest food to eat in ETuanWaiMai.</p>
						</div>

						<!-- <div class="banner_three_form_btn">
							<button class="thm-btn" type="submit">
								<span class=""></span>Register
							</button>
							<button class="thm-btn" type="submit">
								<span></span>Login
							</button>
						</div> -->
					</div>
				</div>
			</div>
		</section>

		<!--Four Boxes Two Start-->
		<section class="four_boxes-two">
			<div class="four_boxes_tow_map_bg"
				style="background-image: url(assets/images/backgrounds/four_boxes_two_bg.png)"></div>
			<div class="container">
				<div class="row">
					<div class="col-xl-3 col-lg-6 col-md-6">
						<!--Four Boxes Two Single-->
						<div class="four_boxes-two_single wow fadeInUp"
							data-wow-delay="0ms" data-wow-duration="1200ms">
							<div class="four_boxes-two_image">
								<img src="assets/images/resources/4-boxes-2-img-1.jpg" alt="">
								<div class="four_boxes-two_content">
									<h3>吴鸿哲</h3>
								</div>
								<div class="four_boxes_two_hover_content">
									<p>
										Knight Kilito<br>Leader
									</p>
									<div class="four_boxes_two_hover_content_btn">
										<a href="https://blog.zhelovechun.top/">His Blog</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-6 col-md-6">
						<!--Four Boxes Two Single-->
						<div class="four_boxes-two_single wow fadeInUp"
							data-wow-delay="300ms" data-wow-duration="1200ms">
							<div class="four_boxes-two_image">
								<img src="assets/images/resources/4-boxes-2-img-2.jpg" alt="">
								<div class="four_boxes-two_content">
									<h3>吴俊炫</h3>
								</div>
								<div class="four_boxes_two_hover_content">
									<p>
										Sunny<br>Member
									</p>
									<div class="four_boxes_two_hover_content_btn">
										<a href="#">His QQ</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-6 col-md-6">
						<!--Four Boxes Two Single-->
						<div class="four_boxes-two_single wow fadeInUp"
							data-wow-delay="600ms" data-wow-duration="1200ms">
							<div class="four_boxes-two_image">
								<img src="assets/images/resources/4-boxes-2-img-3.jpg" alt="">
								<div class="four_boxes-two_content">
									<h3>谢源树</h3>
								</div>
								<div class="four_boxes_two_hover_content">
									<p>
										Glasscomet<br>Member
									</p>
									<div class="four_boxes_two_hover_content_btn">
										<a href="#">His QQ</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-6 col-md-6">
						<!--Four Boxes Two Single-->
						<div class="four_boxes-two_single wow fadeInUp"
							data-wow-delay="900ms" data-wow-duration="1200ms">
							<div class="four_boxes-two_image">
								<img src="assets/images/resources/4-boxes-2-img-4.jpg" alt="">
								<div class="four_boxes-two_content">
									<h3>Java骑士团</h3>
								</div>
								<div class="four_boxes_two_hover_content">
									<p>
										Java Knights<br>NIU BI
									</p>
									<div class="four_boxes_two_hover_content_btn">
										<a href="#">Team Blog</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!--Brand Three Start-->
		<section class="brand-one">
			<div class="container">
				<div
					class="brand-one__carousel owl-carousel thm__owl-carousel owl-theme"
					data-options='{"loop": true, "autoplay": true, "autoplayHoverPause": true, "autoplayTimeout": 5000, "items": 5, "dots": false, "nav": false, "margin": 139, "smartSpeed": 700, "responsive": { "0": {"items": 2, "margin": 30}, "480": {"items": 3, "margin": 30}, "991": {"items": 4, "margin": 50}, "1199": {"items": 5, "margin": 139}}}'>
					<div class="item">
						<img src="assets/images/brand/brand-1-1.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-2.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-3.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-4.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-5.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-1.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-2.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-3.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-4.png" alt="">
					</div>
					<!-- /.item -->
					<div class="item">
						<img src="assets/images/brand/brand-1-5.png" alt="">
					</div>
					<!-- /.item -->
				</div>
			</div>
		</section>

		<section class="food_lovers_two"
			style="background-image: url(assets/images/backgrounds/food-lovers-2_bg.jpg)">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="food_lovers_two_inner">
							<p>Food lovers</p>
							<h2>
								Visit the Amazing Food <br>Points in ETuanWaiMai
							</h2>
							<!-- <div class="food_lovers_two_btn">
								<a href="#" class="thm-btn"><span
									class="icon-magnifying-glass"></span>Search</a>
							</div> -->
						</div>
					</div>
				</div>
			</div>
		</section>


		<!--Latest Listings Three Start-->
		<section class="latest_listings_three" id="latest_listings">
			<div class="container">
				<div class="block-title text-center">
					<h4>Today's Recommendation</h4>
					<h2>今 日 推 荐</h2>
					<p>大难不死,必有锅粥。</p>
				</div>
				<div class="row">
					<c:forEach items="${list }" var="shop">

						<div class="col-xl-3 col-lg-4 col-md-6">
							<!--Latest Listings Single-->
							<div class="latest_listings_three_single wow fadeInUp"
								data-wow-delay="0ms" data-wow-duration="1200ms">
								<div class="latest_listings_three_image">
									<img src="assets/images/resources/shops/${shop.shopPicFile }" alt="">
									<div class="open">
										<p>Open</p>
									</div>
									<div class="heart_icon">
										<i class="icon-heart"></i>
									</div>
									<div class="author_img">
										<img
											src="assets/images/resources/latest_listings-3_au-img-1.png"
											alt="">
									</div>
									<div class="shopping_circle">
										<span class="icon-shopping-bags"></span>
									</div>
								</div>
								<div class="latest_listings_three_content">
									<div class="title">
										<h3>
											<a
												href="allshopproducts.do?shopId=${shop.id }&username=${username}">${shop.shopName }<span
												class="fa fa-check"></span></a>
										</h3>
									</div>
									<ul class="list-unstyled latest_listings_three_contact_info">
										<li><i class="fas fa-map-marker-alt"></i>${shop.address }</li>
										<li><a href="tel:+13456789"><i class="fa fa-phone"></i>${shop.connectPhone }</a></li>
									</ul>
									<div class="latest_listings_three_content_bottom">
										<div class="left">
											<h6>¥ ${shop.avgPrice }</h6>
										</div>
										<div class="rating">
											<a href="#" class="clr-black">${shop.shopStar }</a>
											<c:forEach begin="1" end="${Math.floor(shop.shopStar) }">
												<a href="#"><i class="fa fa-star"></i></a>
											</c:forEach>

											<c:forEach begin="1" end="${5-Math.floor(shop.shopStar) }">
												<a href="#" class="clr-gray"><i class="fa fa-star"></i></a>
											</c:forEach>

										</div>
									</div>
								</div>
							</div>

						</div>

					</c:forEach>
				</div>
			</div>
			<center>
				<a
					href="allShop.do?pageNum=1&pageSize=${pageSize}&search=${searchName}"
					class="btn btn-default">第一页 </a>
				<c:if test="${currPage!=1 }">
					<a
						href="allShop.do?pageNum=${currPage-1 }&pageSize=${pageSize}&search=${searchName}"
						class="btn btn-default">上一页</a>
				</c:if>
				共 ${allCount } 条，共 ${allPage } 页 ，当前在 ${currPage } 页
				<c:if test="${currPage!=allPage }">
					<a
						href="allShop.do?pageNum=${currPage+1 }&pageSize=${pageSize}&search=${searchName}"
						class="btn btn-default">下一页</a>
				</c:if>
				<a
					href="allShop.do?pageNum=${allPage}&pageSize=${pageSize}&search=${searchName}"
					class="btn btn-default">最后一页 </a>
			</center>
		</section>

		<!--Why Choose Start-->


		<!--Two Section Start-->


		<!--Weekly Start-->
		<section class="weekly">
			<div class="container">
				<div class="block-title text-center">
					<h4>Weekly Star</h4>
					<h2>周 榜 之 星</h2>
					<p>两情若是长久时~又岂在猪猪肉肉！</p>
				</div>
			</div>
			<div class="container-full-width">
				<div class="row">
					<div class="col-xl-12">
						<div class="weekly_carousel owl-theme owl-carousel">
							<c:forEach items="${list }" begin="1" end="12" var="shop">
								<!--Weekly Single-->
								<div class="weekly_single">
									<div class="weekly_image">
										<div class="image_inner">
											<img src="assets/images/resources/weekly-img-4.jpg" alt="">
										</div>
										<div class="weekly_content">
											<h3>
												<a
													href="allshopproducts.do?shopId=${shop.id }&username=${username}">${shop.shopName }</a>
											</h3>
											<p>好吃</p>
											<div class="shopping_rating">
												<div class="weekly_content_shopping">
													<div class="weekly_content_shopping_icon">
														<span class="ziston-new-icon-restaurant"></span>
													</div>
													<div class="weekly_hover_content_restuarant_text">
														<h5>Restuarant</h5>
													</div>
												</div>
												<div class="weekly_content_rating">

													<a href="#" class="clr-black">${shop.shopStar }</a>
													<c:forEach begin="1" end="${Math.floor(shop.shopStar) }">
														<a href="#"><i class="fa fa-star"></i></a>
													</c:forEach>

													<c:forEach begin="1" end="${5-Math.floor(shop.shopStar) }">
														<a href="#" class="clr-gray"><i class="fa fa-star"></i></a>
													</c:forEach>


												</div>
											</div>
										</div>
										<div class="weekly_hover_content">
											<h3>
												<a
													href="allshopproducts.do?shopId=${shop.id }&username=${username}">${shop.shopName }</a>
											</h3>
											<p>非常推荐</p>
											<ul class="list-unstyled weekly_hover_content_list">
												<li><i class="fas fa-map-marker-alt"></i>${shop.address }</li>
												<li><a href="tel:+13456789"><i class="fa fa-phone"></i>${shop.connectPhone }</a></li>
											</ul>
											<div class="weekly_hover_content_restuarant_rating">
												<div class="weekly_hover_content_restuarant">
													<div class="weekly_hover_content_restuarant_icon">
														<span class="icon-cutlery"></span>
													</div>
													<div class="weekly_hover_content_restuarant_text">
														<h5>Restuarant</h5>
													</div>
												</div>
												<div class="weekly_hover_content_rating">
													<a href="#" class="clr-blc">${shop.shopStar }</a>
													<c:forEach begin="1" end="${shop.shopStar }">
														<a href="#"><i class="fa fa-star"></i></a>
													</c:forEach>

													<c:forEach begin="1" end="${5-shop.shopStar }">
														<a href="#" class="clr-gray"><i class="fa fa-star"></i></a>
													</c:forEach>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</section>

		<!--Testimonials One Start-->
		<section class="testimonials_one three">
			<div class="testimonial_one_map"
				style="background-image: url(assets/images/shapes/testimonial-one-map.png)"></div>
			<div class="container-box">
				<div class="block-title text-center">
					<h4>Our testimonials</h4>
					<h2>What They Say</h2>
					<p>顾客评价</p>
				</div>
				<div class="row">
					<div class="col-xl-12">
						<div class="testimonials_one_carousel owl-theme owl-carousel">
							<!--Testimonials One Single-->
							<div class="testimonials_one_single">
								<div class="shadow-box"></div>
								<div class="testimonials_one_image">
									<img src="assets/images/testimonials/testimonials-1-img-1.png"
										alt="">
								</div>
								<div class="testimonials_one_text">
									<div class="testimonials_one_rating_box">
										<a href="#"><i class="fa fa-star"></i></a> <a href="#"><i
											class="fa fa-star"></i></a> <a href="#"><i class="fa fa-star"></i></a>
										<a href="#"><i class="fa fa-star"></i></a> <a href="#"><i
											class="fa fa-star"></i></a>
									</div>
									<div class="testimonials_one_text_box">
										<p>厦门的小炒，不行！东东的小炒，彳亍！ლ(´ڡ`ლ)好次！我对这家店狠系环！ I really love it！</p>
									</div>
									<div class="testimonials_quote_icon">
										<span class="icon-quote"></span>
									</div>
									<div class="customer_info">
										<h3>
											Kevin Martin,<span>Customer</span>
										</h3>
									</div>
								</div>
							</div>
							<!--Testimonials One Single-->
							<div class="testimonials_one_single">
								<div class="shadow-box"></div>
								<div class="testimonials_one_image">
									<img src="assets/images/testimonials/testimonials-1-img-2.png"
										alt="">
								</div>
								<div class="testimonials_one_text">
									<div class="testimonials_one_rating_box">
										<a href="#"><i class="fa fa-star"></i></a> <a href="#"><i
											class="fa fa-star"></i></a> <a href="#"><i class="fa fa-star"></i></a>
										<a href="#"><i class="fa fa-star"></i></a> <a href="#"><i
											class="fa fa-star"></i></a>
									</div>
									<div class="testimonials_one_text_box">
										<p>I was very impresed by 斌哥骚尻, I've never eat something
											so delicious! I think I might fall in love with him ... his
											BBQ !</p>
									</div>
									<div class="testimonials_quote_icon">
										<span class="icon-quote"></span>
									</div>
									<div class="customer_info">
										<h3>
											Jessica Brown,<span>Customer</span>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!--Blog One Start-->

		<!--CTA Two Start-->
		<c:if test="${username==null }">
			<section class="cta_tow"
				style="background-image: url(assets/images/backgrounds/cta-2-bg.jpg)">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="cta_two_inner">
								<div class="cta_two_content">
									<p>Sign up to get</p>
									<h2>Special Foods Every Day</h2>
								</div>
								<div class="cta_two_btn">
									<a href="login.jsp" class="thm-btn">Show more</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</c:if>

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
					<a href="tel:120 3018 4201">120 3018 4201</a>
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
					type="hidden" name="pageSize" value="8"> <input type="text"
					name="search" placeholder="Type here to Search....">
					<!-- 如果username为空就不传参了，免得无法判断为""的情况 -->
					<c:if test="${username!=null }">
						<input type="hidden" name="username" value="${username}"> 
					</c:if>
					
					
					
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>

	<div class="login-register"></div>

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