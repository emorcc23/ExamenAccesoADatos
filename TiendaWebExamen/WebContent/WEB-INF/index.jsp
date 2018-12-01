<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <marquee> <%= application.getAttribute("msgOferta") %>  </marquee>		

	<a href="listarProductos.jsp">Mostrar todos los productos</a>  <br>

	<a href="verProducto.jsp">Buscar un producto</a>  <br>
	
	<a href=insertarProducto.jsp>Insertar un producto</a>  <br>
	
	<a href="eliminarProducto.jsp">Eliminar un producto</a>  <br>

</body>
</html>