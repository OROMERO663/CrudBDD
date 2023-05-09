package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoDatos {
	
	public static String AccesoNombre(String sql) {
		
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String nombre=("");

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pokedex", "root", "");
			
			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(sql);

			//sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			//sql = "SELECT * FROM favoritas order by puntos desc";
			// System.out.println(sql); //Con esto podemos mostrar la sql para copiarla y pegarla en la BDD para ver si hay algun problema

			//rs = sentenciaSQL.executeQuery(sql);


			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			//Es un While porque no se cuantos registros nos va a devolver la consulta
			while (rs.next()) {
				nombre= rs.getString("nombre");
				// Si hay resultados obtengo el valor.
				//El metodo next a parte de moverme al siguiente registro, me devuelve True o False si realmente ahí 
				//hay un registro (fila) o no, si lo hay nos da True y ejecuta el bucle dandonos los resultados de los campos(columnas)
				//que hemos seleccionado
				
				//Accedemos a la base de datos con el nombre del campo que queremos, en vez de con el numero de columna
				//System.out.println("titulo: " + rs.getString("titulo") + " - puntos: " + rs.getInt("puntos"));
			}

			

		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		 catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
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

		//System.out.println("Conectado/desconectado");
		//System.out.println(nombre);
		return nombre;

	}

		
		
	}


