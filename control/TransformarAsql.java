package control;

import modelo.Pokemon;

public class TransformarAsql {

	// Vamos a crear un metodo que reciba el Objeto Pokemon desde Utilidades y
	// lo vamos a pasar a una sentencia SQL

	public static String InsertPokemonAsql(Pokemon miPokemon) {
		// recibe un Objeto de la clase miPokemon y devuelve un String de insercion

		// INSERT INTO registrados (nombre, tipo, region) VALUES ('"++"', '"++"', "++");

		return "INSERT INTO registrados (nombre, tipo, region) VALUES ('" + miPokemon.getNombre() + "', '"
				+ miPokemon.getTipo() + "', '" + miPokemon.getRegion() + "');";
	}

	public static String UpdatePokemonAsql(Pokemon miPokemon, String antiguo) {
		// recibe un Objeto de la clase miPokemon y el nombre del pokemon a modificar y devuelve un String de modificacion
		/*
		 * UPDATE registrados SET nombre = 'bulbasaur', tipo= 'planta', region='kanto'
		 * WHERE nombre='charmander';
		 */

		return "UPDATE registrados SET nombre = '" + miPokemon.getNombre() + "', tipo='" + miPokemon.getTipo() + "', region='"
				+ miPokemon.getRegion() + "' WHERE nombre='"+ antiguo +"';";
	}
	public static String LiberaPokemonAsql(String antiguo) {
		// recibe el nombre del pokemon a liberar y devuelve un String de eliminacion
		/*
		 * DELETE FROM registrados WHERE nombre='bulbasaur'
		 */

		return "DELETE FROM registrados WHERE nombre='"+ antiguo +"';";
	}
	public static String CountAsql() {
		/*
		 * "SELECT count(*) FROM registrados"
		 */
		return "SELECT count(*) FROM registrados";
	}
	public static String ConsultaTodoAsql() {
		/*
		 * SELECT * FROM registrados;
		 */
		System.out.println("Estos son los Pokèmon registrados en tu Pokèdex:");
		return "SELECT * FROM registrados;";
	}
	public static String ConsultaNombreAsql(String nombre) {
		/*
		 * SELECT * FROM `registrados` WHERE nombre='charmander';
		 */

		return "SELECT * FROM registrados WHERE nombre='"+ nombre +"';";
	}
	public static String ConsultaTipoAsql(String tipo) {
		/*
		 * SELECT * FROM `registrados` WHERE nombre='charmander';
		 */
		System.out.println("Tienes los siguientes Pokèmon del tipo " + tipo + ":");

		return "SELECT * FROM registrados WHERE tipo='"+ tipo +"';";
	}
	public static String ConsultaRegionAsql(String region) {
		/*
		 * SELECT * FROM `registrados` WHERE nombre='charmander';
		 */
		System.out.println("Tienes los siguientes Pokèmon de la región " + region + ":");

		return "SELECT * FROM registrados WHERE tipo='"+ region +"';";
	}


}
