<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.persistencia.ProductosDAO"%>
<%@page import="app.modelo.Producto"%>
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
	<table class="table">

		<tr>
			<th>Id</th>
			<th>Descripcion</th>
			<th>Precio</th>
		</tr>
		<%
		ArrayList<Producto> lista = ProductosDAO.getInstance().consultarTodos();
		for(int i = 0; i < lista.size(); i++) {
			int id = lista.get(i).getId();
			String descripcion = lista.get(i).getDescripcion();
			double precio = lista.get(i).getPrecio();
			out.println("<tr>");
			out.println("<td>"+id+"</td>");
			out.println("<td>"+descripcion+"</td>");
			out.println("<td>"+precio+"</td>");
			out.println("</tr>");
		}
		%>

	</table>
</body>
</html>