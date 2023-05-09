package control;

import baseDeDatos.AccesoDatos;
import baseDeDatos.Consultar;
import baseDeDatos.ContarFilas;
import baseDeDatos.InsertDelUpdate;
import modelo.Pokemon;
import usuario.Utilidades;

public class UtilidadesControl {

	public static void AddPokemon(String nombre, Pokemon miPokemon) {

		AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre));
		if (AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre)).equals(nombre)) {
			System.out.println("El Pokèmon " + nombre + " ya está registrado en tu Pokedex");
		} else {
			InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(miPokemon));
		}

	}

	public static void ModificarPokemon(String antiguo, Pokemon miPokemon) {
		AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(antiguo));

		// Si está, llama al metodo pedirPokemon y lanzas el Update
		if (AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(antiguo)).equals(antiguo)) {
			System.out.println("Vas a cambiar a " + antiguo + " por: ");
			miPokemon = Utilidades.PedirPokemon();
			InsertDelUpdate.ejecutarSql(TransformarAsql.UpdatePokemonAsql(miPokemon, antiguo));
			System.out.println("Tu Pokèmon ha sido modificado.");
			System.out.println("-----------------------------------------------");

		} else { // Si no está aviso de que no está registrado
			System.out.println("El Pokèmon " + antiguo + " no está registrado en tu Pokedex");
		}
	}

	public static void LiberarPokemon(String nombre) {
		AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre));
		if (AccesoDatos.AccesoNombre(TransformarAsql.ConsultaNombreAsql(nombre)).equals(nombre)) {
			InsertDelUpdate.ejecutarSql(TransformarAsql.LiberaPokemonAsql(nombre));
			System.out.println("El Pokèmon " + nombre + " ha sido liberado. ¡Buena suerte " + nombre + "!");
			System.out.println("-----------------------------------------------");
		} else {
			System.out.println("El Pokèmon " + nombre + " no está registrado en tu Pokedex");
		}

	}

	public static void PokedexCompleta(String Entrenador) {
		Consultar.ConsultarSql(TransformarAsql.ConsultaTodoAsql(Entrenador),
				ContarFilas.ConsultarSql(TransformarAsql.CountAsql()));
	}

	public static void ConsultarRegion(String region) {
		Consultar.ConsultarSql(TransformarAsql.ConsultaRegionAsql(region),
				ContarFilas.ConsultarSql(TransformarAsql.CountRegionAsql(region)));
	}

	public static void ConsultarTipo(String tipo) {
		Consultar.ConsultarSql(TransformarAsql.ConsultaTipoAsql(tipo),
				ContarFilas.ConsultarSql(TransformarAsql.CountTipoAsql(tipo)));

	}

	public static void ConsultarNombre(String nombre) {
		Consultar.ConsultarSql(TransformarAsql.ConsultaNombreAsql(nombre),
				ContarFilas.ConsultarSql(TransformarAsql.CountNombreAsql(nombre)));

	}

}
