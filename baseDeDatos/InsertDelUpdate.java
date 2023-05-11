package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clase InsertDelUpdate. Contiene el metodo que permite lanzar una sentencia sql, del tipo INSERT/DELETE/UPDATE.
 * 
 * @author Oscar
 * @version 1
 */
public class InsertDelUpdate {
	/**
	 * El metodo ejecutarSql recibe una sentencia sql de insercion, conecta con la base de datos y la ejecuta.
	 * Se usa como herramienta para insertar, modificar o eliminar un Pokemon de la base de datos.
	 * Sirve de soporte a los metodos que necesitan lanzar este tipo de sentencias contra la base de datos.
	 * 
	 * @author Oscar
	 * @param sql Sentencia sql de insercion.
	 */
	public static void ejecutarSql(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pokedex", "root", "");

			sentenciaSQL = conexion.createStatement();

			sentenciaSQL.executeUpdate(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
