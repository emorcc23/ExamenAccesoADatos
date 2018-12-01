package app.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.modelo.Producto;
import app.persistencia.ItfzProductosDAO;
import app.persistencia.ProductosDAO;

public class NegocioProductos implements ItfzProductosDAO{
	
	ItfzProductosDAO dao = new ProductosDAO();

	private static NegocioProductos instance = null;

	public static NegocioProductos getInstance() throws SQLException {
		if (instance == null) {
			instance = new NegocioProductos();
		}
		return instance;
	}
	
	@Override
	public List<Producto> consultarTodos() {
		// TODO Auto-generated method stub
		return dao.consultarTodos();
	}

	@Override
	public Producto buscarProducto(int id) {
		// TODO Auto-generated method stub
		return dao.buscarProducto(id);
	}

	@Override
	public void insertar(Producto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Producto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Producto> extraerId() {
		// TODO Auto-generated method stub
		return null;
	}
}
