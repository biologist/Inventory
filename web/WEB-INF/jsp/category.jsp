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
				<li><a href="../../">Home</a></li>
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

		<hr style="margin-bottom: 0px;">

		<div class="headContainer">
			<h2 class="topic">${categoryName}</h2>
			<p class="lead description">You can never have too many tops,
				especially with this collection of stylish essentials & iShop’s
				great value. From block colours to printed tees there’s something
				for you.</p>
		</div>
		<div class="headImage">
			<img src="../img/tops/top_main.jpg" alt="">
		</div>
		<div class="clear"></div>
		<hr style="margin-top: 0px;">

		<div class="lead" style="letter-spacing: 2px;">
			<div class="icon-home" style="margin-top: 5px;"></div>
			<a href="../" style="text-decoration: none;">Home</a>&nbsp;&nbsp;
			>&nbsp;&nbsp; <a href="" style="text-decoration: none;">Category</a>&nbsp;&nbsp;
			>&nbsp;&nbsp; ${categoryName}
		</div>
		<hr>
		<div class="row">

			<c:forEach var="item" items="${itemList}">
				<div class="span3 itemContainer">
					<div class="border">
						<img src="../img/tops/top_001.jpg" alt="">
						<div class="lead" style="font-size: 14px;">
							${item.getItemName()}<br /> Price : ${item.getPrice()} Bahts<br />
							<a href=${categoryName}/${item.getItemID()} style="float: right;">View
								detail..</a>
						</div>
					</div>
				</div>
			</c:forEach>



		</div>

		<hr>

		<div class="footer">
			<p>&copy; Company 2012</p>
		</div>

	</div>
	<!-- /container -->

	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>
