

<%@page import="coding.ecommerceproject.service.ProductService"%>
<%@page import="coding.ecommerceproject.entity.Product"%>
<%@page import="coding.ecommerceproject.entity.Category"%>
<%@page import="coding.ecommerceproject.service.CategoryService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.DecimalFormat"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ogani | Template</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<script type="text/javascript">
	document.getElementById('paging').itemsPerPage.onchange = function() {
		var newaction = document.getElementById('paging').action + this.value;
		document.getElementById('itemsPerPage').action = newaction;
	};
</script>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
	<div class="humberger__menu__wrapper">
		<div class="humberger__menu__logo">
			<a href="#"><img src="img/logo.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
				<li><a href="CartServlet?command=VIEW_CART"><i
						class="fa fa-shopping-bag"></i> <span>Cart(${empty sessionScope.cart? 0 : sessionScope.cart.size()})</span></a></li>
			</ul>
			<div class="header__cart__price">
				item: <span>$<c:if test="${empty sessionScope.cart}"></c:if>${sessionScope.totalPrice}</span>
			</div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img src="img/language.png" alt="">
				<div>English</div>
				<span class="arrow_carrot-down"></span>
				<ul>
					<li><a href="#">Spanis</a></li>
					<li><a href="#">English</a></li>
				</ul>
			</div>
			<c:if test="${sessionScope.name != null }">
				<div class="header__top__right__auth">
					<div>
					<a href="#"><i class="fa fa-user"></i>${sessionScope.name} /</a> <i><a href="logout"> Logout</a></i>
					</div>
					
				</div>
			</c:if>
			<c:if test="${sessionScope.name == null }">
				<div class="header__top__right__auth">
					<a href="login.jsp"><i class="fa fa-user"></i> Login</a>
				</div>
			</c:if>

		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li class="active"><a href="./Home">Home</a></li>
				<li><a href="./shop-grid.jsp">Shop</a></li>
				<c:if test="${sessionScope.name != null }">

					<li><a href="UserServlet?command=GET_USER_DETAIL">USER</a>
						<ul class="header__menu__dropdown">
							<li><a href="CartServlet?command=VIEW_CART">Shoping Cart</a></li>
							<c:if test="${sessionScope.name != null }">
								<li><a href="CartServlet?command=VIEW_ORDER_HISTORY">Order
										History</a></li>
							</c:if>


						</ul></li>
				</c:if>
				<!-- <li><a href="./blog.html">Blog</a></li>
				<li><a href="./contact.html">Contact</a></li> -->
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-pinterest-p"></i></a>
		</div>
		<div class="humberger__menu__contact">
			<ul>
				<li><i class="fa fa-envelope"></i></li>
				<li>Free Shipping for all Order of $99</li>
			</ul>
		</div>
	</div>
	<!-- Humberger End -->

	<!-- Header Section Begin -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>
								<li><i class="fa fa-envelope"></i></li>
								<li>Free Shipping for all Order of $99</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-linkedin"></i></a> <a href="#"><i
									class="fa fa-pinterest-p"></i></a>
							</div>
							<div class="header__top__right__language">
								<img src="img/language.png" alt="">
								<div>English</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">Spanish</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>

							<c:if test="${sessionScope.name != null }">
								<div class="header__top__right__auth">
									<div>
														<a href="#"><i class="fa fa-user"></i>${sessionScope.name} /</a> <i><a href="logout"> Logout</a></i>

									</div>
									

								</div>
							</c:if>
							<c:if test="${sessionScope.name == null }">
								<div class="header__top__right__auth">
									<a href="login.jsp"><i class="fa fa-user"></i> Login</a>
								</div>
							</c:if>


						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="./Home"><img src="img/logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="./Home">Home</a></li>
							<li><a href="./ProductList">Shop</a></li>
							<c:if test="${sessionScope.name != null }">

								<li><a href="UserServlet?command=GET_USER_DETAIL">USER</a>
									<ul class="header__menu__dropdown">
										<li><a href="CartServlet?command=VIEW_CART">Shoping
												Cart</a></li>
										<c:if test="${sessionScope.name != null }">
											<li><a href="CartServlet?command=VIEW_ORDER_HISTORY">Order
													History</a></li>
										</c:if>


									</ul></li>
							</c:if>

							<!-- 							<li><a href="./blog.html">Blog</a></li> -->
							<!-- 							<li><a href="./contact.html">Contact</a></li> -->
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li><a href="#"><i class="fa fa-heart"></i> <span>0</span></a></li>
							<li><a href="CartServlet?command=VIEW_CART"><i
									class="fa fa-shopping-bag"></i> <span>${empty sessionScope.cart? 0 : sessionScope.cart.size()}</span></a></li>
						</ul>
						<div class="header__cart__price">
							item: <span>$<c:if test="${sessionScope.totalPrice == 0 }"></c:if>${sessionScope.totalPrice}</span>
						</div>

					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- Header Section End -->

	<!-- Hero Section Begin -->
	<section class="hero hero-normal">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>All departments</span>
						</div>
						<ul>

							<c:forEach var="category" items="${categoryList}">
								<li><a
									href="ProductList?command=GET_PRODUCTS_BY_CATEGORY_ID&categoryId=${category.categoryId}">${category.categoryName}</a></li>
							</c:forEach>

						</ul>
					</div>
				</div>

				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="ProductList?command=SEARCH">

								<div class="searchInput">
									<input name="command" hidden=true value="SEARCH"></input> <input
										type="text" name="keyword" id="searchTxt"
										placeholder="What do you need?" value="${keyword}">

									<div class="resultBox">
										<!-- here list are inserted from javascript -->
									</div>
									<div class="icon">
										<i class="fas fa-search"></i>
									</div>
								</div>
								<button type="submit" class="site-btn">SEARCH</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>+61 402 502 880</h5>
								<span>support 24/7 time</span>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- bat dau body -->
	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg"
		data-setbg="img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Organi Shop</h2>
						<div class="breadcrumb__option">
							<a href="./home">Home</a> <span>Shop</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-5">
					<div class="sidebar">
						<div class="sidebar__item">
							<h4>Department</h4>
							<ul>
								<c:forEach var="category" items="${categoryList}">
									<li><a
										href="ProductList?command=GET_PRODUCTS_BY_CATEGORY_ID&categoryId=${category.categoryId}">${category.categoryName}</a></li>
								</c:forEach>
							</ul>
						</div>
						<div class="sidebar__item">
							<h4>Price</h4>
							<div class="price-range-wrap">
								<div
									class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
									data-min="1" data-max="10">
									<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
								</div>
								<div class="range-slider">
									<div class="price-input">
										<input type="text" id="minValue"
											onclick="window.location.href='ProductList?maxValue=${maxValue}&minValue=${minValue}'">
										<input type="text" id="maxValue"
											onclick="window.location.href='ProductList?maxValue=${maxValue}&minValue=${minValue}'">
									</div>
								</div>
							</div>
						</div>

						<div class="sidebar__item">
							<div class="latest-product__text">
								<h4>Latest Products</h4>
								<div class="latest-product__slider owl-carousel">

									<div class="latest-prdouct__slider__item">
										<c:forEach var="product" items="${lastest10ProductList}"
											begin="0" end="2">
											<a href="ProductDetailServlet?productId=${product.productId}"
												class="latest-product__item">
												<div class="latest-product__item__pic">
													<img src="${product.imageUrl}" alt=""
														style="width: 110px; height: 110px;">
												</div>
												<div class="latest-product__item__text">
													<h6>${product.productName}</h6>
													<span>$${product.price}</span>
												</div>
											</a>
										</c:forEach>

									</div>
									<div class="latest-prdouct__slider__item">
										<c:forEach var="product" items="${lastest10ProductList}"
											begin="3" end="5">
											<a href="ProductDetailServlet?productId=${product.productId}"
												class="latest-product__item">
												<div class="latest-product__item__pic">
													<img src="${product.imageUrl}" alt=""
														style="width: 110px; height: 110px;">
												</div>
												<div class="latest-product__item__text">
													<h6>${product.productName}</h6>
													<span>$${product.price}</span>
												</div>
											</a>
										</c:forEach>

									</div>

									<div class="latest-prdouct__slider__item">
										<c:forEach var="product" items="${lastest10ProductList}"
											begin="6" end="8">
											<a href="ProductDetailServlet?productId=${product.productId}"
												class="latest-product__item">
												<div class="latest-product__item__pic">
													<img src="${product.imageUrl}" alt=""
														style="width: 110px; height: 110px;">
												</div>
												<div class="latest-product__item__text">
													<h6>${product.productName}</h6>
													<span>$${product.price}</span>
												</div>
											</a>
										</c:forEach>

									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-md-7">
					<div class="product__discount">
						<div class="section-title product__discount__title">
							<h2>Sale Off</h2>
						</div>
						<div class="row">
							<div class="product__discount__slider owl-carousel">
								<c:forEach var="product" items="${productListByDiscount}">
									<div class="col-lg-4">
										<div class="product__discount__item">
											<div class="product__discount__item__pic set-bg"
												data-setbg="${product.imageUrl}">
												<c:set var="discount"
													value="${product.discountPrice div product.price}*100-100}" />

												<%-- 													<div class="product__discount__percent">${discount}%</div> --%>
												<div class="product__discount__percent">-10%</div>

												<ul class="product__item__pic__hover">
													<li><a href="#"><i class="fa fa-heart"></i></a></li>
													<li><a href="#"><i class="fa fa-retweet"></i></a></li>
													<li><a
														href="CartServlet?command=ADD_TO_CART&productId=${product.productId}"><i
															class="fa fa-shopping-cart"></i></a></li>
												</ul>
											</div>
											<div class="product__discount__item__text">
												<span>${product.categoryName}</span>
												<h5>
													<a
														href="ProductDetailServlet?productId=${product.productId}">${product.productName}</a>
												</h5>
												<div class="product__item__price">
													$${product.discountPrice} <span>$${product.price}</span>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>



							</div>
						</div>
					</div>
					<div class="filter__item">
						<div class="row">
							<div class="col-lg-4 col-md-5">
								<div class="filter__sort">
									<span>Sort By</span> <select>
										<option value="0">Default</option>
										<option value="0">Default</option>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-4">
								<div class="filter__found">
									<h6>
										<span>${productList.size()}</span> Products found

									</h6>
								</div>
							</div>
							<form name="paging" id="paging" action="Paging?itemsPerPage=">
								<div class="filter__sort">
									<span>Items per page : </span> <select id="itemsPerPage">
										<option value="9">9</option>
										<option value="18">18</option>
										<option value="27">27</option>
									</select>
								</div>
							</form>


						</div>
					</div>
					<div class="row">


						<c:forEach var="product" items="${productList}">
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="${product.imageUrl}">
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a
												href="CartServlet?command=ADD_TO_CART&productId=${product.productId}"><i
													class="fa fa-shopping-cart"></i></a></li>

										</ul>
									</div>
									<div class="product__item__text">
										<h6>
											<a href="#">${product.productName}</a>
										</h6>
										<h5>$${product.price}</h5>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="product__pagination">
						<div class="list-page">
							<p>Items</p>
						</div>
						<div class="page-number">
							<c:forEach var="pageNumber" begin="1" end="${totalPage}">
								<a href="ProductList?page=${pageNumber}" class="btn"${pageNumber == currentPage ? 'btn-success' : '' }">
									${pageNumber}</a>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Section End -->

	<!-- Footer Section Begin -->
	<jsp:include page="footer.jsp">
		<jsp:param name="userId" value="${sessionScope.userId}" />

	</jsp:include>
	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>



</body>

</html>