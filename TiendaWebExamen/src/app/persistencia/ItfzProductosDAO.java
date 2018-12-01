package app.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.modelo.Producto;

public interface ItfzProductosDAO {

	public List<Producto> consultarTodos();

	public Producto buscarProducto(int id);
	
	public void insertar(Producto p);
	
	public void eliminar(Producto p);
	
	public ArrayList<Producto> extraerId();

	// .....
}
