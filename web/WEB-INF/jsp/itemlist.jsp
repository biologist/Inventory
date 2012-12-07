<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item List</title>
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="menuBar">
				<div class="menuItem"></div>
				<div class="menuItem"></div>
			</div>
			<!-- logo etc -->
		</div>
		<h1>Item List</h1>
		<c:if test="${not empty branch.getBranchID()}">
			<tr>
				<td align="right">Branch Name:</td>
				<td><b>${branch.getBranchName()}</b></td>
			</tr>
		</c:if>
		<table border="1">
			<tr>
				<th>item Id</th>
				<th>Category</th>
				<th>Item Name</th>
				<th>Size</th>
				<th>Description</th>
				<th>Price</th>
			</tr>

			<c:forEach var="item" items="${itemList}">
				<tr>
					<td>${item.getItemID()}</td>
					<td>${item.getCategory().getCategoryName()}</td>
					<td>${item.getItemName()}</td>
					<td>${item.getSize()}</td>
					<td>${item.getDescription()}</td>
					<td>${item.getPrice()}</td>
					<td><a href="edititem?id=${item.getItemID()}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>

		<p>
			<a href="additem">Add New Item</a>
	</div>
</body>
</html>
