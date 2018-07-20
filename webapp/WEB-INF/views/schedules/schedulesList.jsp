<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Horarios</title>
    <spring:url value="/" var="urlRoot"></spring:url>
	<spring:url value="/resources" var="urlPublic"></spring:url>
	<spring:url value="/schedules/create" var="urlCreate"></spring:url>
	<spring:url value="/schedules/edit" var="urlEdit" />
	<spring:url value="/schedules/delete" var="urlDelete" />
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Horarios</h3>
      
      <a href="${ urlCreate }" class="btn btn-success" role="button" title="Nueva Horario" >Nuevo</a><br><br>
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Pelicula</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Sala</th>
                <th>Precio</th>
                <th class="text-center">Opciones</th>
            </tr>
            <c:forEach var="schedule" items="${ schedules.content }">
            	<tr>
                <td>${ schedule.movie.title }</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${schedule.date}" /></td>
                <td>${ schedule.hour }</td>
                <td>${ schedule.cinemaRoom }</td>
                <td>${ schedule.price} €</td>              
                <td class="text-center">
					<a href="${ urlEdit }/${ schedule.id }" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
					<a href="${ urlDelete }/${ schedule.id }" onclick="return confirm('¿Está seguro que desea eliminar la película?')" class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a>
				</td>
            </tr>
            </c:forEach>            
        </table>
        
        <nav aria-label="">
			<ul class="pager">
				<li><a href="${urlRoot}schedules/indexPaginate?page=${schedules.number - 1 }">Anterior</a></li>
				<li><a href="${urlRoot}schedules/indexPaginate?page=${schedules.number + 1 }">Siguiente</a></li>
			</ul>
		</nav>
      </div>
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic}/bootstrap/js/bootstrap.min.js"></script> 

  </body>
</html>
