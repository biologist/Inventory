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
<title>Add/Edit Branch</title>
</head>
<body class="container">
	<div id="main">
		<h1>Add/Edit Branch</h1>
		<p></p>
		<form method="POST">
			<table border="0">
				<c:if test="${not empty branch.getBranchID()}">
					<tr>
						<td align="right">Branch Id</td>
						<td><b>${branch.getBranchID()}</b> <input type="hidden"
							name="branchID" value="${branch.getBranchID()}" /></td>
					</tr>
				</c:if>
				<tr>
					<td align="right">Branch Name</td>
					<td><input width="24" name="branchName"
						value="${branch.getBranchName()}" /></td>
				</tr>
				<tr>
					<td align="right">Location</td>
					<td><input width="12" name="location"
						value="${branch.getLocation()}" /></td>
				</tr>
				<tr>
					<td align="right">Telephone</td>
					<td><input width="12" name="telephone"
						value="${branch.getTelephone()}" /></td>
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
