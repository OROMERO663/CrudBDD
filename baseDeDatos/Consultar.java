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
		// Objeto de la clase sentencia
		ResultSet rs = null;
		int numero = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pokedex", "root", "");

			// creamos sentencias ejecutables sobre esa conexión con un objeto de la clase
			// Statement
			sentenciaSQL = conexion.createStatement();
			
			// almaceno el resultado de la sql en un resulset (conjunto de registros)

			rs = sentenciaSQL.executeQuery(sql);
			//"SELECT * FROM registrados"
			//esta nos va a dar 4 columnas
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			if (filas==0) {
				System.out.println("No hay Pokèmon con los datos buscados en tu Pokèdex");
				System.out.println("-----------------------------------------------");
			} else {			
				for (int i = 1; i <= filas; i++) {
				
				if (rs.next()) {
					// Si hay resultados obtengo el valor.
					//numero = rs.getInt(1);//accedemos a la columna 1 del resultset, si queremos acceder a otra le ponemos el nº de la columna 
					
					//System.out.println(numero);
					
					//Nos va a mostrar los Strings que hay dentro de la columna 1 2 3 y 4 
					//Si son int lo que hay guardado en la columna, hay que poner rs.getInt(nº de la columna), si es date pues getDate...
					System.out.println("Pokèmon ID: "+ rs.getInt(1) + " - Nombre: " + rs.getString(2) + ". Es un Pokèmon de tipo " + rs.getString(3) + " y pertenece a la región de " +  rs.getString(4));

					/*
					System.out.println("Pokemon ID: "+rs.getInt(1));
					System.out.println("Pokemon: "+rs.getString(2));
					System.out.println("Tipo: "+rs.getString(3));
					System.out.println("Región: "+rs.getString(4));
					*/
				}
				
			}

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
		
	}

}
