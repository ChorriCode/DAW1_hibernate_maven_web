<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="author" content="Javier Hernández">
		<title>CRUD Java JPA Hiberante</title>
	</head>
	<body>
		<header>
				<h1>CRUD Java + JPA + Hibernate + MySQL</h1>
				<span id="autor">Fco. Javier Hernández</span>
		</header>
		<nav>
			<ul>
				<li><a href="ControllerServletMain">Listar Libros</a></li>
				<li>Buscar Pedido</li>
				<li></li>
			</ul>
		</nav>
		<main>
			<section>
				<table>
					<tr>
						<th>Título</th>
						<th>Autor</th>
						<th>Precio</th>
					</tr>
					
					<c:forEach var="libro" items="${listadoLibros}">
						<tr>
							<td>${libro.titulo}<a href="ServletLibro?option=findId&libroId=${libro.id}">detail</a></td>
							<td>${libro.autor}</td>
							<td>${libro.precio}</td>
						</tr>
					</c:forEach>
					
				</table>
			</section>
		</main>
	</body>
</html>