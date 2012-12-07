<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Branch List</title>
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
		<h1>Branch List</h1>

		<table border="1">
			<tr>
				<th>Branch Id</th>
				<th>Branch Name</th>
				<th>Location</th>
				<th>Telephone</th>
			</tr>

			<c:forEach var="branch" items="${StockBranchList}">
				<tr>
					<td>${branch.getBranchID()}</td>
					<td>${branch.getBranchName()}</td>
					<td>${branch.getLocation()}</td>
					<td>${branch.getTelephone()}</td>
					<td><a href="editbranch?id=${branch.getBranchID()}">Edit</a>
						<a href="viewitem?id=${branch.getBranchID()}">View</a></td>
				</tr>
			</c:forEach>
		</table>

		<p>
			<a href="addbranch">Add New Branch</a>
	</div>
</body>
</html>
