<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de Peliculas</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/movies/save" var="urlForm"></spring:url>
<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Datos de la Pelicula</span>
			</h3>
		</div>

		<spring:hasBindErrors name="movie">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${ urlForm }" method="post"
			enctype="multipart/form-data" modelAttribute="movie">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<img class="img-rounded"
							src="${urlPublic }/images/${ movie.image }"
							title="Imagen actual de la película" width="150" height="200">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="title">Título</label>
						<form:hidden path="id" />
						<form:hidden path="detail.id" />
						<form:input type="text" class="form-control" path="title"
							id="title" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="duration">Duracion</label>
						<form:input type="text" class="form-control" path="duration"
							id="duration" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="rating" class="control-label">Clasificacion</label>
						<form:select id="rating" path="rating" class="form-control">
							<form:option value="A">Clasificacion A</form:option>
							<form:option value="B">Clasificacion B</form:option>
							<form:option value="C">Clasificacion C</form:option>
						</form:select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="genre" class="control-label">Genero</label>
						<form:select id="genre" path="genre" class="form-control"
							items="${ genres }">
						</form:select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="status" class="control-label">Estatus</label>
						<form:select id="status" path="status" class="form-control">
							<form:option value="Active">Activa</form:option>
							<form:option value="Inactive">Inactiva</form:option>
						</form:select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="releaseDate">Fecha Estreno</label>
						<form:input type="text" class="form-control" path="releaseDate"
							id="releaseDate" required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="imageFile">Imagen</label> <input type="file"
							id="imageFile" name="imageFile" />
						<form:hidden path="image"/>
						<p class="help-block">Imagen de la pelicula</p>
					</div>
				</div>
			</div>

			<div class="page-header">
				<h3 class="blog-title">
					<span class="label label-success">Detalles</span>
				</h3>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="director">Director</label>
						<form:input type="text" class="form-control"
							path="detail.director" id="director" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="actors">Actores</label>
						<form:input type="text" class="form-control" path="detail.actors"
							id="actors" required="required" />
					</div>
				</div>

				<div class="col-sm-6">
					<div class="form-group">
						<label for="trailer">URL del Trailer (Youtube)</label>
						<form:input type="text" class="form-control" path="detail.trailer"
							id="trailer" placeholder="URL completa del video de YOUTUBE"
							required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="synopsis">Sinopsis</label>
						<form:textarea class="form-control" rows="5"
							path="detail.synopsis" id="synopsis"></form:textarea>
					</div>
				</div>
			</div>

			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>


	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#releaseDate").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
