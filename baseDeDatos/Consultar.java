package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clase Consultar. Contiene el metodo que permite lanzar sentencias sql a modo de consultas a la base de datos
 * 
 * @author Oscar
 * @version 1
 */
public class Consultar {
	
	/**
	 * El metodo ConsultarSql recibe una sentencia sql de consulta, conecta con la base de datos y ejecuta la consulta.
	 * Recibe del metodo ContarFilas el numero de filas que tiene la tabla a consultar y las recorre para dar los resultados
	 * buscados a lo largo de la tabla.
	 * 
	 * Si recibe 0 filas lanza mensaje de que la tabla esta vacia.
	 * Si recibe al menos una fila saca la informacion consultada por consola.
	 * Mensajes por consola: saca un mensaje informando si la consulta no ha arrojado datos.
	 * Mensajes por consola: saca un mensaje con los datos de la  consulta realizada, si esta los ha arrojado.

	 * @author Oscar
	 * @param sql Sentencia sql de consulta.
	 * @param filas numero de filas que tiene la tabla a recorrer.
	 */
	public static void ConsultarSql(String sql, int filas) {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pokedex", "root", "");

			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(sql);

			if (filas == 0) {
				System.out.println("No hay Pokèmon con los datos buscados en tu Pokèdex");
				System.out.println("-----------------------------------------------");
			} else {
				for (int i = 1; i <= filas; i++) {

					if (rs.next()) {

						System.out
								.println("Pokèmon " + rs.getInt(1) + " " + rs.getString(2) + ". Es un Pokèmon de tipo "
										+ rs.getString(3) + " y pertenece a la región de " + rs.getString(4));

					}

				}
				System.out.println("-----------------------------------------------");
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

	}

}
