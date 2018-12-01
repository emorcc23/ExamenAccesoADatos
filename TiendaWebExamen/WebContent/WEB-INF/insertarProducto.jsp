<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.boorstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>
<body>
	<form role="form" action="InsertarProducto" method="POST">
		<label class="form-control">Vas a insertar un producto</label>
		<label class="form-control">Descripción:</label>
		<input class="form-control" type="text" name="descripcion" autocomplete="off" required>
		<label class="form-control">Precio:</label>
		<input class="form-control" type="number" name="precio" autocomplete="off" required>
		<button type="submit" id="boton" class="btn btn-primary btn-block">Insertar</button>
	</form>
</body>
</html>