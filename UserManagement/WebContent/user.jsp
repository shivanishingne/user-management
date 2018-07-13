<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/project.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<title>USER MANAGEMENT::Add User</title>

<script>
	$(function() {
		$('input[name=dob]').datepicker();
	});
</script>
</head>

<body>
	<div id="wrapper">

		<h1>USER MANAGEMENT::ADD USER</h1>
		<br> <br>
		<form method="POST" action='UserController' name="frmAddUser">
			<table style="width: 500px">
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"
						value="<c:out value="${user.email}"/>" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="${label}"}"></td>
				</tr>
			</table>

		</form>

	</div>
</body>
</html>