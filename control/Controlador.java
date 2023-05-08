package control;

import java.util.InputMismatchException;
import java.util.Scanner;

import baseDeDatos.InsertDelUpdate;
import modelo.Pokedex;
import modelo.Pokemon;
import usuario.Utilidades;

public class Controlador {
	
	public static void main(String[] args) {

		int eleccion, eleccion2;
		boolean salir = false;
		Pokemon miPokemon = new Pokemon("", "", "");
		Pokedex Pokedex1 = new Pokedex("");
		String nombre;
		String nombreEntrenador = ("");
		String sql=("");
		String sqlUpdate=("");

		do {
			Utilidades.MensajeInicio();
			try {
				nombreEntrenador = Utilidades.PedirEntrenador();
				if (nombreEntrenador.equals("")) {
					System.out.println("Introduce un nombre de entrenador");
				} else {
					Pokedex1.addEntrenador(nombreEntrenador);
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
					Pokedex1.addPokemon(miPokemon);
					sql = TransformarAsql.InsertPokemonAsql(miPokemon);
					InsertDelUpdate.ejecutarSql(sql);
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
							Pokedex1.buscarNombre(miPokemon);
							break;
						case 2:
							miPokemon = Utilidades.PedirTipo();
							Pokedex1.buscarTipo(miPokemon);
							break;
						case 3:
							miPokemon = Utilidades.PedirRegion();
							Pokedex1.buscarRegion(miPokemon);
							break;
						case 4:
							Pokedex1.pokedexCompleta();
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
					Pokedex1.modificar(miPokemon);
					break;
				case 4:
					miPokemon = Utilidades.PedirNombre();
					Pokedex1.liberar(miPokemon);
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

