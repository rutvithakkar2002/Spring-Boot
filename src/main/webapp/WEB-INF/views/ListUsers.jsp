<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>

	<h2>User List</h2>


	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Password</th>
			<th>IsDelete</th>
			<th>Action</th>
		</tr>





		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td>${user.isdelete}</td>
				<td><a href="deleteuser?userId=${user.userId}">Delete</a>
				|<a href="edituser?userId=${user.userId}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>