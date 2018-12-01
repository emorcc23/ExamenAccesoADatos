package app.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import app.modelo.Producto;

public class ProductosDAO implements ItfzProductosDAO {

	private Connection conexion;

	private void abrirConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
		} catch (Exception ex) {
			System.out.println("Error al abrir la bbdd");
			ex.printStackTrace();
		}

	}

	private void cerrarConexion() {
		try {
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}

	private static ProductosDAO instance = null;

	public static ProductosDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new ProductosDAO();
		}
		return instance;
	}

	@Override
	public ArrayList<Producto> consultarTodos() {

		ArrayList<Producto> lista = new ArrayList<Producto>();

		try {
			abrirConexion();
			PreparedStatement pstm = conexion.prepareStatement("select * from PRODUCTOS");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				lista.add(new Producto(rs.getInt("ID"), rs.getString("DESCRIPCION"), rs.getDouble("PRECIO")));
			}

		} catch (Exception e) {
			System.out.println("Error al consultar todos");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return lista;
	}

	@Override
	public Producto buscarProducto(int id) {
		Producto producto = new Producto();

		try {
			abrirConexion();
			PreparedStatement pstm = conexion.prepareStatement("select * from PRODUCTOS where ID = ?");
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				producto = new Producto(rs.getInt("ID"), rs.getString("DESCRIPCION"), rs.getDouble("PRECIO"));
			}

		} catch (Exception e) {
			System.out.println("Error al buscar el producto con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return producto;
	}

	/**
	 * Método que recibe un producto para insertarlo en la base de datos
	 */
	@Override
	public void insertar(Producto p) {

		try {
			abrirConexion();
			PreparedStatement ps = conexion
					.prepareStatement("INSERT INTO productos (descripcion, precio) VALUES (?,?);");
			ps.setString(2, p.getDescripcion());
			ps.setDouble(3, p.getPrecio());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al insertar el producto");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

	}

	/**
	 * Método al cual se le pasa un producto para ser eliminado.
	 */
	@Override
	public void eliminar(Producto p) {

		try {
			abrirConexion();
			if (p.getId() <= 0) {
				return;
			}
			PreparedStatement ps = conexion.prepareStatement("DELETE FROM productos WHERE id = ?;");
			ps.setInt(1, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al eliminar el producto con id: " + p.getId());
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

	}

	/**
	 * Método que extrae los ids de los productos para listarlos
	 */
	@Override
	public ArrayList<Producto> extraerId() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		try {
			abrirConexion();
			PreparedStatement pstm = conexion.prepareStatement("select id from productos");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				lista.add(new Producto(rs.getInt("ID"), rs.getString("DESCRIPCION"), rs.getDouble("PRECIO")));
			}
		} catch (Exception e) {
			System.out.println("Error al extraer el id del producto");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;

	}

}
