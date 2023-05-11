package control;

import baseDeDatos.AccesoDatos;
import baseDeDatos.Consultar;
import baseDeDatos.ContarFilas;
import baseDeDatos.InsertDelUpdate;
import modelo.Pokemon;
import usuario.Utilidades;
/**
 * Clase UtilidadesControl. Contiene los metodos necesarios para realizar las funciones CRUD (incluir, modificar, eliminar y consultar)
 * 
 * @author Oscar
 * @version 1
 */
public class UtilidadesControl {
	/**
	 * El metodo AddPokemon recibe un String con el atributo nombre de un Pokemon y un objeto de la clase Pokemon
	 * introducidos por consola por el usuario.
	 * Se sirve de los metodos AccesoNombre y ConsultaNombreAsql para comprobar si el nombre introducido estaba ya registrado en la tabla registrados
	 * Si el nombre ya estaba registrado informa de ello al usuario.
	 * Si el nombre no estaba registrado ejecuta la sentencia INSERT con los atributos del Pokemon introducido.
	 * 
	 * Mensajes por consola: informa al usuario si el nombre ya estaba previamente registrado.
	 * 
	 * @author Oscar
	 * @param nombre Objeto de la clase Pokemon, contiene los atributos del Pokemon pedidos por consola.
	 * @param miPokemon Objeto de la clase Pokemon, contiene los atributos del Pokemon pedidos por consola.
	 */
	public static void AddPokemon(String nombre, Pokemon miPokemon) {

		try {
			AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre));
			if (AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre)).equals(nombre)) {
				System.out.println("El Pokèmon " + nombre + " ya está registrado en tu Pokedex");
			} else {
				InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(miPokemon));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * El metodo ModificarPokemon recibe un String con el atributo nombre de un Pokemon que el usuario quiere modificar
	 * y un objeto de la clase Pokemon con los atributos modificados por el usuario.
	 * 
	 * Se sirve de los metodos AccesoNombre y ConsultaNombreAsql para comprobar si el nombre introducido estaba ya registrado en la tabla registrados
	 * Si el nombre no estaba registrado informa de ello al usuario.
	 * Si el nombre estaba registrado pregunta al usuario por los nuevos atributos para modificarlos y ejecuta la sentencia UPDATE.
	 * 
	 * Mensajes por consola: informa al usuario si el nombre no estaba previamente registrado.
	 * Mensajes por consola: pide al usuario los nuevos atributos que quiere guardar.
	 * 
	 * @author Oscar
	 * @param antiguo Objeto de la clase Pokemon, contiene los atributos del Pokemon pedidos por consola.
	 * @param miPokemon Objeto de la clase Pokemon, contiene los atributos del Pokemon pedidos por consola.
	 */
	public static void ModificarPokemon(String antiguo, Pokemon miPokemon) {
		
		try {
			AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(antiguo));
			if (AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(antiguo)).equals(antiguo)) {
				System.out.println("Vas a cambiar a " + antiguo + " por: ");
				miPokemon = Utilidades.PedirPokemon();
				InsertDelUpdate.ejecutarSql(TransformarAsql.UpdatePokemonAsql(miPokemon, antiguo));
				System.out.println("Tu Pokèmon ha sido modificado.");
				System.out.println("-----------------------------------------------");
			} else {
				System.out.println("El Pokèmon " + antiguo + " no está registrado en tu Pokedex");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * El metodo LiberarPokemon recibe un String con el atributo nombre de un Pokemon que el usuario quiere eliminar.
	 * 
	 * Se sirve de los metodos AccesoNombre y ConsultaNombreAsql para comprobar si el nombre introducido estaba ya registrado en la tabla registrados
	 * Si el nombre no estaba registrado informa de ello al usuario.
	 * Si el nombre estaba registrado ejecuta la sentencia DELETE para liberar al Pokemon elegido.
	 * 
	 * Mensajes por consola: informa al usuario si el nombre no estaba previamente registrado.
	 * Mensajes por consola: informa al usuario que el Pokemon ha sido liberado.
	 * 
	 * @author Oscar
	 * @param nombre Nombre del Pokemon a liberar elegido por el usuario.
	 */
	public static void LiberarPokemon(String nombre) {
		
		try {
			AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre));
			if (AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre)).equals(nombre)) {
				InsertDelUpdate.ejecutarSql(TransformarAsql.LiberaPokemonAsql(nombre));
				System.out.println("El Pokèmon " + nombre + " ha sido liberado. ¡Buena suerte " + nombre + "!");
				System.out.println("-----------------------------------------------");
			} else {
				System.out.println("El Pokèmon " + nombre + " no está registrado en tu Pokedex");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * El metodo PokedexCompleta recibe un String con el nombre de entrenador elegido por el usuario.
	 * 
	 * Se sirve de los metodos necesarios del paquete baseDeDatos y la Clase TransformarAsql para ejecutar una consulta de todos los Pokemon registrados en la tabla.
	 * 
	 * @author Oscar
	 * @param Entrenador Nombre de entrenador elegido por el usuario.
	 */
	public static void PokedexCompleta(String Entrenador) {
		
		try {
			Consultar.ConsultarSql(TransformarAsql.ConsultaTodoAsql(Entrenador),
					ContarFilas.ConsultarSql(TransformarAsql.CountAsql()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * El metodo ConsultarRegion Recibe un String con el atributo region elegido por el usuario.
	 * 
	 * Se sirve de los metodos necesarios del paquete baseDeDatos y la Clase TransformarAsql 
	 * para ejecutar una consulta de todos los Pokemon registrados en la tabla que comparten el mismo atributo region.
	 * 
	 * @author Oscar
	 * @param region Region consultada por el usuario.
	 */
	public static void ConsultarRegion(String region) {
		
		try {
			Consultar.ConsultarSql(TransformarAsql.ConsultaRegionAsql(region),
					ContarFilas.ConsultarSql(TransformarAsql.CountRegionAsql(region)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * El metodo ConsultarTipo Recibe un String con el atributo tipo elegido por el usuario.
	 * 
	 * Se sirve de los metodos necesarios del paquete baseDeDatos y la Clase TransformarAsql 
	 * para ejecutar una consulta de todos los Pokemon registrados en la tabla que comparten el mismo atributo tipo.
	 * 
	 * @author Oscar
	 * @param tipo Tipo consultado por el usuario.
	 */
	public static void ConsultarTipo(String tipo) {
		
		try {
			Consultar.ConsultarSql(TransformarAsql.ConsultaTipoAsql(tipo),
					ContarFilas.ConsultarSql(TransformarAsql.CountTipoAsql(tipo)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * El metodo ConsultarNombre Recibe un String con el atributo nombre elegido por el usuario.
	 * 
	 * Se sirve de los metodos necesarios del paquete baseDeDatos y la Clase TransformarAsql 
	 * para ejecutar una consulta de todos los Pokemon registrados en la tabla que comparten el mismo atributo nombre.
	 * 
	 * @author Oscar
	 * @param nombre Nombre consultado por el usuario.
	 */
	public static void ConsultarNombre(String nombre) {
		
		try {
			Consultar.ConsultarSql(TransformarAsql.ConsultaNombreAsql(nombre),
					ContarFilas.ConsultarSql(TransformarAsql.CountNombreAsql(nombre)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
