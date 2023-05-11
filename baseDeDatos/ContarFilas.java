package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase ContarFilas. Contiene el metodo que permite lanzar una sentencia sql, del tipo Count con el objetivo de obtener el 
 * numero de filas que tiene la tabla objetivo de la consulta.
 * 
 * @author Oscar
 * @version 1
 */
public class ContarFilas {
	/**
	 * El metodo ConsultarSql recibe una sentencia sql de consulta, conecta con la base de datos y ejecuta la consulta.
	 * En esta ocasion se usa para lanzar una consulta del tipo COUNT con el objetivo de conseguir el numero de filas de la
	 * tabla obetivo, para dar soporte a otros metodos de consulta que necesitan esta informacion para recorrer la tabla.
	 * 
	 * @author Oscar
	 * @param sql Sentencia sql de consulta.
	 * @return filas Numero de filas que tiene la tabla.
	 */
	public static int ConsultarSql(String sql) {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs = null;
		int filas = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pokedex", "root", "");

			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(sql);

			if (rs.next()) {

				filas = rs.getInt(1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return filas;

	}
}
