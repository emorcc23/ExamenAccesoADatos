package app.modelo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import app.persistencia.*;

public class Producto implements Serializable {

	private static final long serialVersionUID = 8049435758618953119L;

	private int id;
	private String descripcion;
	private double precio;

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int id) {
		this.id = id;
	}

	public Producto(String descripcion, double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(int id, String descripcion, double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}

	/**
	 * Método que llama a la clase DAO y devulve una lista de productos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Producto> listar() throws SQLException {
		ArrayList<Producto> listaProductos = ProductosDAO.getInstance().consultarTodos();
		return listaProductos;
	}
	
	/**
	 * Método que llama a la clase dao y devuelve un producto
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Producto buscarPorId(int id) throws SQLException {
		Producto p = ProductosDAO.getInstance().buscarProducto(id);
		return p;
	}
	
	/**
	 * Método que inserta un producto
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		ProductosDAO.getInstance().insertar(this);
	}
	
	/**
	 * Método que elimina un producto
	 * @param p
	 * @throws SQLException
	 */
	public void eliminar(Producto p) throws SQLException {
		ProductosDAO.getInstance().eliminar(p);
	}
	
	/**
	 * Método que extrae el id de productos y retorna la lista de id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Producto> extraerId() throws SQLException {
		ArrayList<Producto> lista = ProductosDAO.getInstance().extraerId();
		return lista;
	}

}
