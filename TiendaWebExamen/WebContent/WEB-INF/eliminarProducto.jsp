<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.ArrayList" %>
<%@page import="app.persistencia.ProductosDAO" %>
<%@page import="app.modelo.Producto" %>
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
	<form role="form" action="EliminarProducto" method="POST">
		<label>Vas a eliminar un producto</label> 
		<label>Selecciona el id del producto:</label> 
			<input type="number" name="id"
			autocomplete="off" required class="form-control"> 
			<select name="id" class="form-control">
			<%
				ArrayList<Producto> listaProductos = ProductosDAO.getInstance().extraerId();
				for(int i = 0; i < listaProductos.size(); i++) {
					int id = listaProductos.get(i).getId();
					out.println("<option value="+id+">"+id+"</option>");
				}
			
			%>
		</select>
		<button type="submit" id="boton" class="btn btn-primary btn-block">Insertar</button>
	</form>
</body>
</html>