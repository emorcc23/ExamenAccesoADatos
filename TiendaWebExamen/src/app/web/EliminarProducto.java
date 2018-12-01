package app.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.modelo.Producto;
import app.persistencia.ProductosDAO;

/**
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		try {
			ArrayList<Producto> lista = ProductosDAO.getInstance().consultarTodos();
			for (int i = 0; i < lista.size(); i++) {
				int ideliminar = lista.get(i).getId();
				Producto nuevoProducto = ProductosDAO.getInstance().buscarProducto(ideliminar);
				ProductosDAO.getInstance().eliminar(nuevoProducto);
			}
			System.out.println("Se ha eliminado correctamente");
			response.getWriter().append("Insertado con éxito");
			response.getWriter().append("<a href='eliminarProducto.jsp'>Volver al menú principal del producto</a>");
		} catch (Exception e) {
			response.getWriter().append("No se ha podido eliminar");
			response.getWriter().append("<a href='eliminarProducto.jsp'>Volver al menú principal del producto</a>");
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
