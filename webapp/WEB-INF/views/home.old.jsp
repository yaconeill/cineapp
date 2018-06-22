<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bienvenido a Cinepp</title>
		<spring:url value="/resources" var="urlPublic"></spring:url>
		<link rel="stylesheet" href="${urlPublic }/bootstrap/css/bootstrap.min.css">
	</head>
	<body>
	<!--
		<h1>Lista de Películas</h1>
	
		 <ol>
			<c:forEach items="${ movies }" var="movie">
				<li>${ movie }</li>
			</c:forEach>
		</ol>-->
	
		<div class="panel panel-default">
			<div class="panel-heading">Lista de Películas</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Título</th>
							<th>Duración</th>
							<th>Clasificación</th>
							<th>Género</th>
							<th>Imagen</th>
							<th>Fecha Estreno</th>
							<th>Estatus</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ movies }" var="movie">
							<tr>
								<td>${ movie.id }</td>
								<td>${ movie.title }</td>
								<td>${ movie.duration} min</td>
								<td>${ movie.rating }</td>
								<td>${ movie.genre }</td>
								<td><img src="${ urlPublic }/images/${ movie.image }" width="80" height="100"></td>
								<td><fmt:formatDate value="${ movie.releaseDate }" pattern="dd-MM-yyyy"/></td>
								<td>
									<c:choose>
										<c:when test="${ movie.status == 'Active' }">
											<span class="label label-success">ACTIVA</span>
										</c:when>
										<c:otherwise>
											<span class="label label-danger">INACTIVA</span>
										</c:otherwise>
									</c:choose>							
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		-->
	</body>
</html>