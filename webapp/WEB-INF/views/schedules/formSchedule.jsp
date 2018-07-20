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
		<meta name="author" content="">
		<title>Creacion de Horarios</title>
		<spring:url value="/resources" var="urlPublic"></spring:url>
		<spring:url value="/schedules/save" var="urlForm"></spring:url>
		<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	</head>

	<body>

		<!-- Fixed navbar -->
		<jsp:include page="../includes/menu.jsp"></jsp:include>

		<div class="container theme-showcase" role="main">

			<h3 class="blog-title"><span class="label label-success">Datos del Horario</span></h3>  
			<spring:hasBindErrors name="horario">
				<div class='alert alert-danger' role='alert'>
					Por favor corrija los siguientes errores:
					<ul>
						<c:forEach var="error" items="${errors.allErrors}">
							<li><spring:message message="${error}" /></li>
						</c:forEach>
					</ul>
				</div>
			</spring:hasBindErrors>
			
			<form:form action="${urlForm}" method="POST" modelAttribute="schedule">
				<div class="row">         
					<div class="col-sm-3">
						<div class="form-group">
							<label for="idPelicula" class="control-label">Pelicula</label>
							<form:hidden path="id"/>              
							<form:select id="idPelicula"  path="movie.id"  items="${ movies }" 
							itemValue="id"  itemLabel="title"  class="form-control" >
							</form:select>             
						</div> 
					</div>
				</div>
				<div class="row"> 
					<div class="col-sm-3">
						<div class="form-group">
							<label for="date">Fecha</label>             
							<form:input type="text" class="form-control" path="date" id="date" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="hour">Hora</label>
							<form:input type="text" class="form-control" path="hour" id="hour" placeholder="Formato: HH:mm Ejemplo 21:30" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="sala" class="control-label">Sala</label>              
							<form:select id="sala" path="cinemaRoom" class="form-control">
								<option value="Premium">Sala Premium</option>
								<option value="Sala 1">Sala 1</option>
								<option value="Sala 2">Sala 2</option>
								<option value="Sala 3">Sala 3</option>                
							</form:select>             
						</div> 
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="price">Precio</label>
							<form:input type="text" class="form-control" path="price" id="price" required="required"/>
						</div>  
					</div>

				</div>

				<button type="submit" class="btn btn-danger" >Guardar</button>
			</form:form> 

			<hr class="featurette-divider">

			<!-- FOOTER -->
			<jsp:include page="../includes/footer.jsp"></jsp:include>

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $(function () {
            $("#date").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
	</body>
</html>
