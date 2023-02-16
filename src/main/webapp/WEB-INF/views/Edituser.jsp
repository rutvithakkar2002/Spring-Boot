<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit user</title>
</head>
<body>

<form action="updateuser" method="Post">
<input type="hidden" name="userId" value="${user.userId }"/>
FirstName:<input type="text" name="firstName" value="${user.firstName}"><br><br>
LastName:<input type="text" name="lastName" value="${user.lastName}"><br><br>
Email:<input type="text" name="email" value="${user.email}"><br><br>
Password:<input type="password" name="password" value="${user.password}"><br><br>
<input type="submit" value="Updateuser">
</form>

</body>
</html>