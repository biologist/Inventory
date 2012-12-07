<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css"
	rel="stylesheet">
<title>Add/Edit Item</title>
</head>
<body class="container">
	<div id="main">
		<h1>Add/Edit Item</h1>
		<p></p>
		<form method="POST">
			<table border="0">
				<c:if test="${not empty item.getItemID()}">
					<tr>
						<td align="right">Item Id</td>
						<td><b>${item.getItemID()}</b> <input type="hidden"
							name="itemID" value="${item.getItemID()}" /></td>
					</tr>
				</c:if>
				<tr>
					<td align="right">Category</td>
					<td><input width="24" name="category"
						value="${item.getCategory().getCategoryName()}" /></td>
				</tr>
				<tr>
					<td align="right">Item Name</td>
					<td><input width="12" name="itemName"
						value="${item.getItemName()}" /></td>
				</tr>
				<tr>
					<td align="right">Size</td>
					<td><input width="12" name="size" value="${item.getSize()}" />
					</td>
				</tr>
				<tr>
					<td align="right">Description</td>
					<td><input width="24" name="description"
						value="${item.getDescription()}" /></td>
				</tr>
				<tr>
					<td align="right">Price</td>
					<td><input width="12" name="price" value="${item.getPrice()}" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>
