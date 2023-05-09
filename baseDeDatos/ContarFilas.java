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
