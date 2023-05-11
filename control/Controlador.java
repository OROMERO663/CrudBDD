package control;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Pokemon;
import usuario.Utilidades;
/**
 * Clase Controlador. Programa Principal, ejecuta los metodos necesarios para
 * poder incluir, consultar, modificar o liberar Pokemon de una Pokedex usando
 * POO y una base de datos MySQL en servidor local.
 * 
 * @author Oscar
 * @version 1
 */
public class Controlador {
	/**
	 * Metodo Principal muestra el menu de opciones y llama al metodo
	 * correspondiente para ejecutar la opcion elegida. 
	 * Interaccion por consola: pide al usuario elegir un nombre de entrenador y posteriormente una opcion del menu. 
	 * Mensajes por consola: saca un mensaje de bienvenida al juego y pregunta el nombre al usuario.
	 * Mensajes por consola: saca un mensaje con la lista acciones que el usuario puede realizar.
	 * Mensajes por consola: saca un mensaje de error si el dato introducido no es valido.
	 * 
	 * @author Oscar
	 * @param args Dato de entrada
	 */
	public static void main(String[] args) {

		int eleccion, eleccion2;
		boolean salir = false;
		Pokemon miPokemon = new Pokemon("", "", "");
		String nombreEntrenador = ("");

		do {
			Utilidades.MensajeInicio();
			try {
				nombreEntrenador = Utilidades.PedirEntrenador();
				if (nombreEntrenador.equals("")) {
					System.out.println("Introduce un nombre de entrenador");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (nombreEntrenador == "");

		do {
			Utilidades.MenuPrincipal();

			try {
				Scanner lector = new Scanner(System.in);
				eleccion = lector.nextInt();
				lector.nextLine();

				switch (eleccion) {
				case 1:
					miPokemon = Utilidades.PedirPokemon();
					UtilidadesControl.AddPokemon(miPokemon.getNombre(), miPokemon);
					break;
				case 2:
					Utilidades.MenuConsular();
					try {
						Scanner lector2 = new Scanner(System.in);
						eleccion2 = lector.nextInt();
						lector.nextLine();
						switch (eleccion2) {
						case 1:
							miPokemon = Utilidades.PedirNombre();
							UtilidadesControl.ConsultarNombre(miPokemon.getNombre());

							break;
						case 2:
							miPokemon = Utilidades.PedirTipo();
							UtilidadesControl.ConsultarTipo(miPokemon.getTipo());
							break;
						case 3:
							miPokemon = Utilidades.PedirRegion();
							UtilidadesControl.ConsultarRegion(miPokemon.getRegion());
							break;
						case 4:
							UtilidadesControl.PokedexCompleta(nombreEntrenador);
							break;

						default:
							System.out.println("No has elegido una opción válida");
							break;
						}

					} catch (InputMismatchException e) {
						System.out.println("Debes elegir una opción entre 1 y 4");
					}

					break;
				case 3:
					miPokemon = Utilidades.PedirNombre();
					UtilidadesControl.ModificarPokemon(miPokemon.getNombre(), miPokemon);
					break;
				case 4:
					miPokemon = Utilidades.PedirNombre();
					UtilidadesControl.LiberarPokemon(miPokemon.getNombre());
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("No has elegido una opción válida");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes elegir una opción entre 1 y 5");
			}
		} while (!salir);

	}

}
