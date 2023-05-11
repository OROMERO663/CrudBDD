package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clase AccesoDatos. Contiene el metodo que permite para acceder a la base de datos buscando por nombre.
 * 
 * @author Oscar
 * @version 1
 */
public class AccesoDatos {
	
	/**
	 * El metodo AccesoNombre recibe una sentencia sql de consulta por nombre, conecta con la base de datos y ejecuta la consulta
	 * hasta que el resultado de esta coincida con el nombre del Pokemon consultado.
	 * Si encuentra coincidencia devuelve el nombre.
	 * Si no encuentra coincidencia devuelve vacio.
	 * Esta informacion es usada como soporte para los otros metodos para comprobar si el Pokemon a insertar, modificar o eliminar se encuentra en la base de datos
	 * 
	 * @author Oscar
	 * @param sql Sentencia sql de busqueda por nombre.
	 * @return nombre Nombre del Pokemno consultado.
	 */
	public static String AccesoNombre(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String nombre = ("");

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pokedex", "root", "");

			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(sql);

			while (rs.next()) {
				nombre = rs.getString("nombre");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return nombre;

	}

}
