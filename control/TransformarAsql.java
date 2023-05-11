package control;

import modelo.Pokemon;
/**
 * Clase TransformarAsql. Contiene los metodos necesarios para convertir la informacion pedida al usuario por consola
 * en sentencias sql utilizables por los metodos de baseDeDatos.
 * 
 * 
 * @author Oscar
 * @version 1
 */
public class TransformarAsql {
	/**
	 * El metodo InsertPokemonAsql recibe un objeto de la clase Pokemon y devuelve un String con la sentencia sql
	 * para insertar los atributos del Pokemon en la base de datos
	 * 
	 * @author Oscar
	 * @param miPokemon Objeto de la clase Pokemon, contiene los atributos del Pokemon pedidos por consola.
	 * @return String sentencia sql de insercion.
	 */
	public static String InsertPokemonAsql(Pokemon miPokemon) {

		System.out.println("El Pokèmon " + miPokemon.getNombre() + " se ha añadido a tu Pokèdex");

		return "INSERT INTO registrados (nombre, tipo, region) VALUES ('" + miPokemon.getNombre() + "', '"
				+ miPokemon.getTipo() + "', '" + miPokemon.getRegion() + "');";
	}
	/**
	 * El metodo UpdatePokemonAsql recibe un objeto de la clase Pokemon, con los atributos modificados por el usuario
	 * y un String con el atributo nombre del que se quiere modificar.
	 * Devuelve un String con la sentencia sql para insertar los atributos del Pokemon en la base de datos.
	 * 
	 * @author Oscar
	 * @param miPokemon Objeto de la clase Pokemon, contiene los atributos del Pokemon pedidos por consola.
	 * @param antiguo Nombre del Pokemon que el usuario quiere modificar.
	 * @return String sentencia sql de modificacion.
	 */
	public static String UpdatePokemonAsql(Pokemon miPokemon, String antiguo) {

		return "UPDATE registrados SET nombre = '" + miPokemon.getNombre() + "', tipo='" + miPokemon.getTipo()
				+ "', region='" + miPokemon.getRegion() + "' WHERE nombre='" + antiguo + "';";
	}
	/**
	 * El metodo LiberaPokemonAsql recibe un String con el atributo nombre del Pokemon a liberar elegido por el usuario.
	 * 
	 * @author Oscar
	 * @param antiguo Nombre del Pokemon que el usuario quiere liberar.
	 * @return String sentencia sql de eliminacion.
	 */
	public static String LiberaPokemonAsql(String antiguo) {

		return "DELETE FROM registrados WHERE nombre='" + antiguo + "';";
	}
	/**
	 * El metodo CountNombreAsql recibe un String con el atributo nombre del Pokemon elegido por el usuario.
	 * Devuelve una consulta sql del tipo COUNT para obtener la cantidad de filas que hay en la tabla con este atributo.
	 * Sirve de soporte para el metodo ContarFilas.
	 * 
	 * @author Oscar
	 * @param nombre Nombre del Pokemon que el usuario quiere modificar.
	 * @return String consulta sql de tipo COUNT.
	 */
	public static String CountNombreAsql(String nombre) {

		return "SELECT count(*) FROM registrados WHERE nombre= '" + nombre + "';";
	}
	/**
	 * El metodo CountTipoAsql recibe un String con el atributo tipo del Pokemon elegido por el usuario.
	 * Devuelve una consulta sql del tipo COUNT para obtener la cantidad de filas que hay en la tabla con este atributo.
	 * Sirve de soporte para el metodo ContarFilas.
	 * 
	 * @author Oscar
	 * @param tipo Nombre del Pokemon que el usuario quiere modificar.
	 * @return String consulta sql de tipo COUNT.
	 */
	public static String CountTipoAsql(String tipo) {

		return "SELECT count(*) FROM registrados WHERE tipo= '" + tipo + "';";
	}
	/**
	 * El metodo CountRegionAsql recibe un String con el atributo region del Pokemon elegido por el usuario.
	 * Devuelve una consulta sql del tipo COUNT para obtener la cantidad de filas que hay en la tabla con este atributo.
	 * Sirve de soporte para el metodo ContarFilas.
	 * 
	 * @author Oscar
	 * @param region Nombre del Pokemon que el usuario quiere modificar.
	 * @return String consulta sql de tipo COUNT.
	 */
	public static String CountRegionAsql(String region) {

		return "SELECT count(*) FROM registrados WHERE region= '" + region + "';";
	}
	/**
	 * El metodo CountAsql Devuelve una consulta sql del tipo COUNT para obtener la cantidad de filas que hay en la tabla.
	 * Sirve de soporte para el metodo ContarFilas.
	 * 
	 * @author Oscar
	 * @return String consulta sql de tipo COUNT.
	 */
	public static String CountAsql() {

		return "SELECT count(*) FROM registrados;";
	}
	/**
	 * El metodo CountTodoAsql recibe un String con el nombre del entrenador elegido por el usuario.
	 * Devuelve una consulta sql del tipo SELECT para obtener la lista de todos los pokemon registrados en la tabla.
	 * 
	 *Mensajes por consola: Informa de los Pokemon registrados por el usuario.
	 * 
	 * @author Oscar
	 * @param entrenador Nombre del entrenador elegido por el usuario.
	 * @return String consulta sql de tipo SELECT.
	 */
	public static String ConsultaTodoAsql(String entrenador) {

		System.out.println("Estos son los Pokèmon registrados en la Pokèdex de " + entrenador + ": ");
		return "SELECT * FROM registrados;";
	}
	/**
	 * El metodo CosultaNombreAsql recibe un String con el nombre del Pokemon elegido por el usuario.
	 * Devuelve una consulta sql del tipo SELECT para obtener la lista de todos los pokemon registrados en la tabla con ese nombre.
	 * 
	 *Mensajes por consola: Informa de los Pokemon registrados por el usuario.
	 * 
	 * @author Oscar
	 * @param nombre Nombre del entrenador elegido por el usuario.
	 * @return String consulta sql de tipo SELECT.
	 */
	public static String ConsultaNombreAsql(String nombre) {

		return "SELECT * FROM registrados WHERE nombre='" + nombre + "';";
	}
	/**
	 * El metodo CosultaTipoAsql recibe un String con el tipo del Pokemon elegido por el usuario.
	 * Devuelve una consulta sql del tipo SELECT para obtener la lista de todos los pokemon registrados en la tabla con ese tipo.
	 * 
	 *Mensajes por consola: Informa de los Pokemon registrados por el usuario con el atributo buscado.
	 * 
	 * @author Oscar
	 * @param tipo Nombre del entrenador elegido por el usuario.
	 * @return String consulta sql de tipo SELECT.
	 */
	public static String ConsultaTipoAsql(String tipo) {

		System.out.println("Tienes los siguientes Pokèmon del tipo " + tipo + ":");

		return "SELECT * FROM registrados WHERE tipo='" + tipo + "';";
	}
	/**
	 * El metodo CosultaRegionAsql recibe un String con la region del Pokemon elegido por el usuario.
	 * Devuelve una consulta sql del tipo SELECT para obtener la lista de todos los pokemon registrados en la tabla de esa region.
	 * 
	 *Mensajes por consola: Informa de los Pokemon registrados por el usuario con el atributo buscado.
	 * 
	 * @author Oscar
	 * @param region Nombre del entrenador elegido por el usuario.
	 * @return String consulta sql de tipo SELECT.
	 */
	public static String ConsultaRegionAsql(String region) {

		System.out.println("Tienes los siguientes Pokèmon de la región " + region + ":");

		return "SELECT * FROM registrados WHERE region='" + region + "';";
	}

}
