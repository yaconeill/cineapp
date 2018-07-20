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
<title>Creacion de imagenes del Banner</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/banners/save" var="urlForm"></spring:url>
<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la imagen</span>
		</h3>

		<form:form action="${ urlForm }" method="post"
			enctype="multipart/form-data" modelAttribute="banner">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="title">Titulo</label>
						<form:hidden path="id"/>
						<form:input type="text" class="form-control" path="title"
							id="title" required="required" />
					</div>
				</div>


				<div class="col-sm-3">
					<div class="form-group">
						<label for="image">Imagen</label>
						<c:choose>
							<c:when test="${banner.id == 0}">
								<input type="file" id="imageFile" name="imageFile"
									required="required" />
							</c:when>
							<c:otherwise>
								<input type="file" id="imageFile" name="imageFile" />
							</c:otherwise>
						</c:choose>
						<form:hidden path="file" />
						<p class="help-block">Tamaño recomendado: 1140 x 250</p>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="status">Estatus</label>
						<form:select id="status" path="status" class="form-control">
							<form:option value="Active">Activo</form:option>
							<form:option value="Inactive">Inactivo</form:option>
						</form:select>
					</div>
				</div>
			</div>

			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
      ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
