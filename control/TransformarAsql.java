package control;


import modelo.Pokemon;

public class TransformarAsql {
	
	public static String AccederAlNombre(String nombre) {
		
		return nombre;
	}

	public static String InsertPokemonAsql(Pokemon miPokemon) {
		
		System.out.println("El Pokèmon " + miPokemon.getNombre() + " se ha añadido a tu Pokèdex");

		return "INSERT INTO registrados (nombre, tipo, region) VALUES ('" + miPokemon.getNombre() + "', '"
				+ miPokemon.getTipo() + "', '" + miPokemon.getRegion() + "');";
	}

	public static String UpdatePokemonAsql(Pokemon miPokemon, String antiguo) {

		return "UPDATE registrados SET nombre = '" + miPokemon.getNombre() + "', tipo='" + miPokemon.getTipo()
				+ "', region='" + miPokemon.getRegion() + "' WHERE nombre='" + antiguo + "';";
	}

	public static String LiberaPokemonAsql(String antiguo) {
	
		return "DELETE FROM registrados WHERE nombre='" + antiguo + "';";
	}

	public static String CountNombreAsql(String nombre) {
	
		return "SELECT count(*) FROM registrados WHERE nombre= '" + nombre + "';";
	}

	public static String CountTipoAsql(String tipo) {

		return "SELECT count(*) FROM registrados WHERE tipo= '" + tipo + "';";
	}

	public static String CountRegionAsql(String region) {

		return "SELECT count(*) FROM registrados WHERE region= '" + region + "';";
	}

	public static String CountAsql() {

		return "SELECT count(*) FROM registrados;";
	}

	public static String ConsultaTodoAsql(String entrenador) {

		System.out.println("Estos son los Pokèmon registrados en la Pokèdex de " + entrenador+ ": ");
		return "SELECT * FROM registrados;";
	}

	public static String ConsultaNombreAsql(String nombre) {

		return "SELECT * FROM registrados WHERE nombre='" + nombre + "';";
	}

	public static String ConsultaTipoAsql(String tipo) {

		System.out.println("Tienes los siguientes Pokèmon del tipo " + tipo + ":");

		return "SELECT * FROM registrados WHERE tipo='" + tipo + "';";
	}

	public static String ConsultaRegionAsql(String region) {

		System.out.println("Tienes los siguientes Pokèmon de la región " + region + ":");

		return "SELECT * FROM registrados WHERE region='" + region + "';";
	}

}
