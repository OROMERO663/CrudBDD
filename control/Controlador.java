package control;

import java.util.InputMismatchException;
import java.util.Scanner;

import baseDeDatos.AccesoDatos;
import baseDeDatos.Consultar;
import baseDeDatos.ContarFilas;
import baseDeDatos.InsertDelUpdate;
import modelo.Pokedex;
import modelo.Pokemon;
import usuario.Utilidades;

public class Controlador {

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
