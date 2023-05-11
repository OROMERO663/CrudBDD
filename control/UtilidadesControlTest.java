package control;

import static org.junit.Assert.*;

import org.junit.Test;

import baseDeDatos.Consultar;
import baseDeDatos.ContarFilas;
import baseDeDatos.InsertDelUpdate;
import modelo.Pokemon;

/**
 * Clase UtilidadesControlTest. Contiene los metodos necesarios para realizar
 * las pruebas con JUnit de la Clase UtilidadesControl.
 * 
 * @author Oscar
 * @version 1
 */
public class UtilidadesControlTest {
	/**
	 * El metodo testAddPokemon comprueba que se Inserta un Pokemon en la tabla
	 * correctamente. Para ello Inserta un nuevo Pokemon p1 y comprueba con una
	 * consulta COUNT que la tabla tiene 1 registro con el nombre del nuevo Pokemon
	 * 
	 * @author Oscar
	 */
	@Test
	public void testAddPokemon() {
		Pokemon p1 = new Pokemon("piplup", "agua", "shinnoh");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p1));

		assertEquals(ContarFilas.ConsultarSql(TransformarAsql.CountNombreAsql(p1.getNombre())), 1);
	}

	/**
	 * El metodo testModificarPokemon comprueba que se Modifica un Pokemon en la
	 * tabla correctamente. Para ello inserta un Pokemon (antiguo) que va a ser
	 * modificado con la sentencia UPDATE por otro p1. 
	 * La comporbacion se hace mediante un COUNT que arroja que el nombre del Pokemon modificado p1 se
	 * encuentra en la tabla.
	 * 
	 * @author Oscar
	 */
	@Test
	public void testModificarPokemon() {
		Pokemon p1 = new Pokemon("larvitar", "roca", "jhoto");
		Pokemon antiguo = new Pokemon("spinarak", "bicho", "jhoto");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(antiguo));

		InsertDelUpdate.ejecutarSql(TransformarAsql.UpdatePokemonAsql(p1, antiguo.getNombre()));

		assertEquals(ContarFilas.ConsultarSql(TransformarAsql.CountNombreAsql(p1.getNombre())), 1);

	}

	/**
	 * El metodo testLiberarPokemon comprueba que se Libera un Pokemon en la tabla
	 * correctamente. Para ello inserta un Pokemon (liberar) que va a ser eliminado
	 * con la sentencia DELETE.
	 * La comporbacion se hace mediante un COUNT que arroja
	 * que el nombre del Pokemon liberado NO se encuentra en la tabla.
	 * 
	 * @author Oscar
	 */
	@Test
	public void testLiberarPokemon() {
		Pokemon liberar = new Pokemon("fennekin", "fuego", "kalos");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(liberar));

		InsertDelUpdate.ejecutarSql(TransformarAsql.LiberaPokemonAsql(liberar.getNombre()));

		assertNotEquals(ContarFilas.ConsultarSql(TransformarAsql.CountNombreAsql(liberar.getNombre())), 1);
	}

	/**
	 * El metodo testPokedexCompleta comprueba que la consulta de todos los datos de
	 * la tabla funciona correctamente. Para ello inserta un Pokemon (p2) para
	 * asegurar que al menos haya un registro en la tabla.
	 * La comporbacion se hace mediante un COUNT que arroja que la tabla no esta vacia.
	 * 
	 * @author Oscar
	 */
	@Test
	public void testPokedexCompleta() {
		String Entrenador = "CazabichosCarlos";
		Pokemon p2 = new Pokemon("gengar", "fantasma", "kanto");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p2));

		Consultar.ConsultarSql(TransformarAsql.ConsultaTodoAsql(Entrenador),
				ContarFilas.ConsultarSql(TransformarAsql.CountAsql()));

		assertNotEquals(ContarFilas.ConsultarSql(TransformarAsql.CountAsql()), 0);
	}

	/**
	 * El metodo testConsultarRegion comprueba que la consulta de Pokemon por region
	 * funciona correctamente. Para ello inserta un Pokemon (p1) para asegurar que
	 * al menos haya un registro en la tabla. 
	 * La comporbacion se hace mediante un
	 * COUNT que arroja que la tabla no esta vacia para el atributo buscado.
	 * 
	 * @author Oscar
	 */
	@Test
	public void testConsultarRegion() {
		Pokemon p1 = new Pokemon("squirtle", "agua", "kanto");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p1));

		Consultar.ConsultarSql(TransformarAsql.ConsultaRegionAsql(p1.getRegion()),
				ContarFilas.ConsultarSql(TransformarAsql.CountRegionAsql(p1.getRegion())));

		assertNotEquals(ContarFilas.ConsultarSql(TransformarAsql.CountRegionAsql(p1.getRegion())), 0);
	}

	/**
	 * El metodo testConsultarTipo comprueba que la consulta de Pokemon por tipo
	 * funciona correctamente. Para ello inserta un Pokemon (p1) para asegurar que
	 * al menos haya un registro en la tabla. 
	 * La comporbacion se hace mediante un
	 * COUNT que arroja que la tabla no esta vacia para el atributo buscado.
	 * 
	 * @author Oscar
	 */
	@Test
	public void testConsultarTipo() {
		Pokemon p1 = new Pokemon("bulbasaur", "planta", "kanto");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p1));

		Consultar.ConsultarSql(TransformarAsql.ConsultaTipoAsql(p1.getTipo()),
				ContarFilas.ConsultarSql(TransformarAsql.CountTipoAsql(p1.getTipo())));

		assertNotEquals(ContarFilas.ConsultarSql(TransformarAsql.CountTipoAsql(p1.getTipo())), 0);
	}

	/**
	 * El metodo testConsultarNombre comprueba que la consulta de Pokemon por nombre
	 * funciona correctamente. Para ello inserta un Pokemon (p1) para asegurar que
	 * al menos haya un registro en la tabla. 
	 * La comporbacion se hace mediante un
	 * COUNT que arroja que la tabla no esta vacia para el atributo buscado.
	 * 
	 * @author Oscar
	 */
	@Test
	public void testConsultarNombre() {
		Pokemon p1 = new Pokemon("charmander", "fuego", "kanto");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p1));

		Consultar.ConsultarSql(TransformarAsql.ConsultaNombreAsql(p1.getNombre()),
				ContarFilas.ConsultarSql(TransformarAsql.CountNombreAsql(p1.getNombre())));

		assertNotEquals(ContarFilas.ConsultarSql(TransformarAsql.ConsultaNombreAsql(p1.getNombre())), 0);
	}

}
