<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link href="../../css/bootstrap.css" rel="stylesheet">
<link href="../../css/style.css" rel="stylesheet">

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
							<li><a tabindex="-1" href=../${category.getCategoryName()}>${category.getCategoryName()}</a></li>
						</c:forEach>
					</ul></li>
				<li><a href="../../branch/">Branch</a></li>
			</ul>
			<h3 class="muted">iShop</h3>
		</div>


		<div class="clear"></div>
		<hr style="margin-top: 0px;">

		<div class="lead" style="letter-spacing: 2px;">
			<div class="icon-home" style="margin-top: 5px;"></div>
			<a href="../../" style="text-decoration: none;">Home</a>&nbsp;&nbsp;
			>&nbsp;&nbsp; <a href="../" style="text-decoration: none;">Category</a>&nbsp;&nbsp;
			>&nbsp;&nbsp; <a href=../${item.getCategory().getCategoryName()}
				style="text-decoration: none;">${item.getCategory().getCategoryName()}</a>&nbsp;&nbsp;
			> &nbsp;&nbsp;${item.getItemName()}
		</div>
		<hr>
		<div class="row">
			<div class="span3 largeImgContainer">
				<div class="border">
					<img src="../../img/tops/top_001_large.jpg">
				</div>
			</div>

			<div class="span3 detailContainer">
				<div class="lead border">
					<table border="0" cellpadding="10">
						<tr>
							<td width="100px">Item ID :</td>
							<td>${item.getItemID()}</td>
						</tr>
						<tr>
							<td>Item Name :</td>
							<td>${item.getItemName()}</td>
						</tr>
						<tr>
							<td valign="top">Description :</td>
							<td>${item.getDescription()}</td>
						</tr>
						<tr>
							<td>Price :</td>
							<td>${item.getPrice()}</td>
						</tr>
						<tr>
							<td>Availability :</td>
							<td></td>
						</tr>

						<table class="table"
							style="width: 400px; margin-left: 150px; margin-top: -30px;">
							<thread>
							<th>Branch</th>
							<th>Quantity</th>
							</thread>

							<c:forEach var="branch" items="${branchList}">

								<tr>
									<td>${branch[0]}</td>
									<td>${branch[1]}</td>
								</tr>
							</c:forEach>


						</table>
					</table>
				</div>
			</div>



		</div>

		<hr>

		<div class="footer">
			<p>&copy; Company 2012</p>
		</div>

	</div>
	<!-- /container -->

	<script src="../../js/jquery.js"></script>
	<script src="../../js/bootstrap.js"></script>
</body>
</html>

