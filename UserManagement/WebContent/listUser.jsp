<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/project.css" />
<title>USER MANAGEMENT</title>
</head>
<body>
	<div id="wrapper">
		<h1>USER MANAGEMENT</h1>
		<table border=1 align=center>
			<thead>
				<tr>
					<th>User ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>DOB</th>
					<th>Email</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.userid}" /></td>
						<td><c:out value="${user.firstname}" /></td>
						<td><c:out value="${user.lastname}" /></td>
						<td><fmt:formatDate pattern="dd-MMM-yyyy" value="${user.dob}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><a
							href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
						<td><a
							href="UserController?action=delete&userId=<c:out value="${user.userid}"/>"
							onclick=return confirm('Do you want to deleteuser?')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<a href="UserController?action=insert">Add User</a>
	</div>
</body>
</html>














