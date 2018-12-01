<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="app.modelo.Producto"%>
<%@ page import="app.negocio.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.persistencia.ProductosDAO"%>
<%@page import="app.modelo.Producto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Carrito miCarro = (Carrito) session.getAttribute("miCarrito");
	%>
	<%
		Cookie[] todas = request.getCookies();

		for (Cookie c : todas) {
			if ("nombreUsuario".equals(c.getName())) {
				out.print("<h2>Usuario: " + c.getValue() + "</h2>");
				break;
			}
		}
	%>

	<!-- 
   				Información carrito, 
   				lista de productos en el carrito 
   				y boton de elimnar un producto
   
   -->
<form method="GET" action="EliminarProducto">
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
			out.println("<td><Button href='EliminarProducto?"+id+"'>Eliminar</Button></td>");
			out.println("</tr>");
		}
		%>

	</table>
</form>

</body>
</html>