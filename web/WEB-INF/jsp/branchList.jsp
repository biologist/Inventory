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
<link href="css/style.css" rel="stylesheet">

</head>

<body>

	<div class="container" style="margin-top: 30px;">

		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li><a href="">Home</a></li>
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
				<li class="active"><a href="#">Branch</a></li>
			</ul>
			<h3 class="muted">iShop</h3>
		</div>

		<hr>


		<legend>Our branch</legend>

		<table class="table">
			<thead>
				<tr>
					<th>Branch</th>
					<th>Location</th>
					<th>Contact</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="branch" items="${branchList}">
					<tr>

						<td class="tdPadding"><img src="img/branch/paragon_logo.png"
							width="130px">
						</div></td>
						<td class="lead tdPadding info">${branch.getBranchName()}<br />
							${branch.getLocation()}
						</td>
						<td class="lead tdPadding info">${branch.getTelephone()}</td>

					</tr>
				</c:forEach>




			</tbody>
		</table>

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
