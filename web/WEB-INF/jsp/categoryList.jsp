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
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">

</head>

<body>

	<div class="container" style="margin-top: 30px;">

		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li><a href="../">Home</a></li>
				<li class="dropdown active"><a class="dropdown-toggle"
					id="drop4" role="button" data-toggle="dropdown" href="#">Category
						<b class="caret"></b>
				</a>
					<ul id="menu1" class="dropdown-menu" role="menu"
						aria-labelledby="drop4">
						<c:forEach var="category" items="${CategoryList}">
							<li><a tabindex="-1" href=${category.getCategoryName()}>${category.getCategoryName()}</a></li>
						</c:forEach>
					</ul></li>
				<li><a href="../branch">Branch</a></li>
			</ul>
			<h3 class="muted">iShop</h3>
		</div>

		<hr>

		<div class="lead" style="letter-spacing: 2px;">
			<div class="icon-home" style="margin-top: 5px;"></div>
			<a href="../" style="text-decoration: none;">Home</a>&nbsp;&nbsp;
			>&nbsp;&nbsp; Category
		</div>
		<hr style="margin-bottom: 0px;">

		<c:forEach var="category" items="${CategoryList}">
			<div class="desContainer">
				<h2 class="topic">
					<a href=${category.getCategoryName()
						} style="text-decoration: none;">${category.getCategoryName()}</a></h2>
				<p class="lead description">
					<a href=${category.getCategoryName()
						} style="text-decoration: none;">See items</a></p>
			</div>
			<div class="imgContainer">
				<img src="../img/tops/top_main.jpg" alt="">
			</div>

			<div class="clear"></div>
			<hr class="line">
		</c:forEach>



		<hr style="margin-top: 0px;">

		<div class="footer">
			<p>&copy; Company 2012</p>
		</div>

	</div>
	<!-- /container -->

	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>
