<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg"
		data-setbg="img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>USER DETAIL</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>User detail</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h6>
						<!-- <span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click
							here</a> to enter your code -->
					</h6>
				</div>
			</div>
			<div class="checkout__form">
				<h4>User Detail</h4>
				<form action="UserServlet">
					<input name="command" hidden=true value="UpdateUserDetail"></input>

					<div class="row">
						<div class="col-lg-8 col-md-6">
							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											First Name<span>*</span>
										</p>
										<input type="text" name="firstName" value="${user.firstName}">
									</div>
								</div>
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Last Name<span>*</span>
										</p>
										<input type="text" name="lastName" value="${user.lastName}">
									</div>
								</div>
							</div>

							<div class="checkout__input">
								<p>
									Address<span>*</span>
								</p>
								<input type="text" placeholder="Street Address"
									class="checkout__input__add" name="address"
									value="${user.address}"> <input type="text"
									placeholder="Apartment, suite, unite ect (optional)">
							</div>
							<div class="checkout__input">
								<p>
									Suburb<span>*</span>
								</p>
								<input type="text" name="city" value="${user.city}">
							</div>
							<div class="checkout__input">
								<p>
									State<span>*</span>
								</p>
								<input type="text" name="state" value="${user.state}">
							</div>
							<div class="checkout__input">
								<p>
									Postcode <span>*</span>
								</p>
								<input type="text" name="postcode" value="${user.postcode}">
							</div>
							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Phone<span>*</span>
										</p>
										<input type="text" name="phone"
											value="${user.phoneNumber}">
									</div>
								</div>
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Email<span>*</span>
										</p>
										<input type="text" name="email" value="${user.email}">
									</div>
								</div>
							</div>
							<div class="checkout__order">

								<button type="submit" class="site-btn">SAVE</button>
							</div>




						</div>

					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- Checkout Section End -->

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