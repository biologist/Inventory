<%@page import="inventory.service.MyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>iShop</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">

</head>

<body>

	<div class="container" style="margin-top: 30px;">

		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a href="">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle" id="drop4"
					role="button" data-toggle="dropdown" href="#">Category <b
						class="caret"></b></a>
					<ul id="menu1" class="dropdown-menu" role="menu"
						aria-labelledby="drop4">

						<c:forEach var="category" items="${CategoryList}">
							<li><a tabindex="-1"
								href=category/${category.getCategoryName()}>${category.getCategoryName()}</a></li>
						</c:forEach>

					</ul></li>
				<li><a href="branch">Branch</a></li>
			</ul>
			<h3 class="muted">iShop</h3>
		</div>

		<hr>

		<div class="jumbotron">
			<div id="myCarousel" class="carousel slide">
				<div class="carousel-inner">
					<div class="item active">
						<img src="img/main1.jpg" alt="">

					</div>
					<div class="item">
						<img src="img/main2.jpg" alt="">

					</div>
					<div class="item">
						<img src="img/main3.jpg" alt="">

					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev">‹</a> <a class="right carousel-control"
					href="#myCarousel" data-slide="next">›</a>
			</div>
		</div>

		<hr>

		<div class="row-fluid marketing">
			<div class="span6">
				<h4>Subheading</h4>
				<p>Donec id elit non mi porta gravida at eget metus. Maecenas
					faucibus mollis interdum.</p>

				<h4>Subheading</h4>
				<p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
					Cras mattis consectetur purus sit amet fermentum.</p>

				<h4>Subheading</h4>
				<p>Maecenas sed diam eget risus varius blandit sit amet non
					magna.</p>
			</div>

			<div class="span6">
				<h4>Subheading</h4>
				<p>Donec id elit non mi porta gravida at eget metus. Maecenas
					faucibus mollis interdum.</p>

				<h4>Subheading</h4>
				<p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
					Cras mattis consectetur purus sit amet fermentum.</p>

				<h4>Subheading</h4>
				<p>Maecenas sed diam eget risus varius blandit sit amet non
					magna.</p>
			</div>
		</div>

		<hr>

		<div class="footer">
			<p>&copy; Company 2012</p>
		</div>

	</div>
	<!-- /container -->

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
