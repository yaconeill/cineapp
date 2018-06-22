<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Noticias</title>    
	<spring:url value="/resources" var="urlPublic"></spring:url>
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">   
    <link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">

  </head>

  <body>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3 class="blog-title"><span class="label label-success">Datos de la Noticia</span></h3>

		<spring:url value="/noticias/save" var="urlForm"></spring:url>
      <form action="${ urlForm }" method="post">
        <div class="row">         
          <div class="col-sm-6">
            <div class="form-group">
              <label for="title">Titulo</label>             
              <input type="text" class="form-control" name="title" id="title" required="required"/>
            </div>
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="status">Estatus</label>             
              <select id="status" name="status" class="form-control">
                <option value="Active">Activa</option>
                <option value="Inactive">Inactiva</option>                
              </select>  
            </div>
          </div>
        </div>
        <div class="row"> 
          <div class="col-sm-12">
            <div class="form-group">
              <label for="details">Detalles</label>             
              <textarea class="form-control" name="details" id="details" rows="10"></textarea>
            </div>  
          </div>
        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form> 

      <hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
    <script src="${ urlPublic }/tinymce/tinymce.min.js"></script>
    <script>
      tinymce.init({
          selector: '#details',
          plugins: "textcolor, table lists code",
          toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
      });
    </script>
  </body>
</html>
