package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pokemon;

public class ContarFilas {

	public static int ConsultarSql(String sql) {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		// Objeto de la clase sentencia
		ResultSet rs = null;
		int numero = 0;
		int filas=0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pokedex", "root", "");

			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(sql);
			
				if (rs.next()) {
					// Si hay resultados obtengo el valor.
					//numero = rs.getInt(1);//accedemos a la columna 1 del resultset, si queremos acceder a otra le ponemos el nº de la columna 
					filas= rs.getInt(1);
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

		System.out.println("Conectado/desconectado");
		return filas;
		
	}
}
