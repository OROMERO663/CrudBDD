package usuario;

import java.util.Scanner;

import modelo.Pokemon;
/**
 * Clase Utilidades. Contiene metodos publicos para cumplir las funciones de
 * interacion con el usuario.
 * 
 * @author Oscar
 * @version 1
 */
public class Utilidades {

	/**
	 * El metodo MenuPrincipal provee del texto necesario para lanzar el menu de
	 * opciones Mensaje por consola: Menu principal
	 * 
	 * @author Oscar
	 */
	public static void MenuPrincipal() {

		System.out.println("¿Qué quieres hacer con tu Pokèdex?");
		System.out.println("1 - Añadir un Pokèmon");
		System.out.println("2 - Consultar mis Pokèmon");
		System.out.println("3 - Modificar un Pokèmon");
		System.out.println("4 - Liberar un Pokèmon");
		System.out.println("5 - Salir");

	}

	/**
	 * El metodo MenuConsultar provee del texto necesario para lanzar el menu de
	 * opciones del apartado Consultar. Mensaje por consola: Menu consultar.
	 * 
	 * @author Oscar
	 */
	public static void MenuConsular() {

		System.out.println("¿Qué quieres consultar en tu Pokèdex?");
		System.out.println("1 - Consultar un Pokèmon por nombre");
		System.out.println("2 - Consultar un Pokèmon por tipo");
		System.out.println("3 - Consultar un Pokèmon por región");
		System.out.println("4 - Consulta la Pokèdex completa");

	}

	/**
	 * El metodo MensajeInicio provee del texto necesario para lanzar el mensaje de
	 * bienvenida. Mensaje por consola: Mensaje de bienvenida.
	 * 
	 * @author Oscar
	 */
	public static void MensajeInicio() {
		System.out.println("Bienvenido entrenador");
	}

	/**
	 * El metodo PedirEntrenador pide al usuario por consola un nombre de entrenador
	 * y lo almacena. Mensaje por consola: Pregunta por el nombre a elegir. Devuelve
	 * un nombre de Entrenador para usarlo en el Programa Principal.
	 * 
	 * @author Oscar
	 * @return nombreEntrenador Devuelve el nombre de entrenador elegido por el
	 *         usuario.
	 */
	public static String PedirEntrenador() {
		System.out.println("¿Cuál es tu nombre?");
		String nombreEntrenador = "";
		try {
			Scanner lector = new Scanner(System.in);
			nombreEntrenador = lector.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombreEntrenador;
	}

	/**
	 * El metodo PedirPokemon pide al usuario por consola los atributos de un Objeto
	 * de la clase Pokemon y lo almacena como un nuevo Pokemon. Mensaje por consola:
	 * pide al usuario cada uno de los atributos a insertar. Devuelve un Objeto de
	 * la clase Pokemon para usarlo en el Programa Principal.
	 * 
	 * @author Oscar
	 * @return Pokemon Devueleve un nuevo Objeto de la clase Pokemon
	 */
	public static Pokemon PedirPokemon() {

		Scanner lector = new Scanner(System.in);
		String nombre = " ";
		String tipo = " ";
		String region = " ";

		try {
			System.out.println("Introduce el nombre del Pokèmon:");
			nombre = lector.nextLine();
			System.out.println("Introduce el tipo de " + nombre + ":");
			tipo = lector.nextLine();
			System.out.println("Introduce la región a la que pertenece " + nombre + ":");
			region = lector.nextLine();
			lector.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Pokemon(nombre, tipo, region);
	}

	/**
	 * El metodo PedirNombre pide al usuario por consola el atributo nombre de un
	 * Objeto de la clase Pokemon y lo almacena como un nuevo Pokemon. Mensaje por
	 * consola: pide al usuario el atributo nombre. Devuelve un Objeto de la clase
	 * Pokemon para usarlo en el Programa Principal.
	 * 
	 * @author Oscar
	 * @return Pokemon Devueleve un nuevo Objeto de la clase Pokemon
	 */
	public static Pokemon PedirNombre() {
		Scanner lector = new Scanner(System.in);
		String nombre = " ";
		String tipo = " ";
		String region = " ";

		try {
			System.out.println("Introduce el nombre del Pokèmon:");
			nombre = lector.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Pokemon(nombre, tipo, region);

	}

	/**
	 * El metodo PedirTipo pide al usuario por consola el atributo tipo de un Objeto
	 * de la clase Pokemon y lo almacena como un nuevo Pokemon. Mensaje por consola:
	 * pide al usuario el atributo tipo. Devuelve un Objeto de la clase Pokemon para
	 * usarlo en el Programa Principal.
	 * 
	 * @author Oscar
	 * @return Pokemon Devueleve un nuevo Objeto de la clase Pokemon
	 */
	public static Pokemon PedirTipo() {
		Scanner lector = new Scanner(System.in);
		String nombre = " ";
		String tipo = " ";
		String region = " ";

		try {
			System.out.println("Introduce el tipo del Pokèmon:");
			tipo = lector.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Pokemon(nombre, tipo, region);

	}

	/**
	 * El metodo PedirRegion pide al usuario por consola el atributo region de un
	 * Objeto de la clase Pokemon y lo almacena como un nuevo Pokemon. Mensaje por
	 * consola: pide al usuario el atributo region. Devuelve un Objeto de la clase
	 * Pokemon para usarlo en el Programa Principal.
	 * 
	 * @author Oscar
	 * @return Pokemon Devueleve un nuevo Objeto de la clase Pokemon
	 */
	public static Pokemon PedirRegion() {
		Scanner lector = new Scanner(System.in);
		String nombre = " ";
		String tipo = " ";
		String region = " ";

		try {
			System.out.println("Introduce la región del Pokèmon:");
			region = lector.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Pokemon(nombre, tipo, region);

	}

}
