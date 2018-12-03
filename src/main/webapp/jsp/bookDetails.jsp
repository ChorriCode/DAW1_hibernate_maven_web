<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Book details</title>
</head>
<body>
	<h1>Book details</h1>
	<div>
		<p>id: ${book.id}</p>
		<p>Título: ${book.titulo}</p>
		<p>Autor: ${book.autor}</p>
		<p>Precio: ${book.precio}</p>
	</div>
	<a href="./jsp/menu.jsp">principal</a>
</body>
</html>