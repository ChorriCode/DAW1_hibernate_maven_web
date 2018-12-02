<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login</title>
	</head>
	<body>
		<h1>LOGIN</h1>
		<form action="../../hibernate/ServletLogin" method="post">
			<p>usuario válido = janniel - password válido = 1234</p>
			nombre:
			<input type="text" name="user"/>
			password:
			<input type="password" name="password" />
			<input type="submit" value="login" />
		</form>
		<c:out value="${error}"/>
	</body>
</html>