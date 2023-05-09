package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pokedex;
import modelo.Pokemon;

public class Consultar {

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

						System.out.println("Pokèmon " + rs.getInt(1) + " " + rs.getString(2) + ". Es un Pokèmon de tipo "
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
