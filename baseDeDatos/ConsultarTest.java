package baseDeDatos;

import static org.junit.Assert.*;

import org.junit.Test;

import control.TransformarAsql;
import modelo.Pokemon;
/**
 * Clase ConsultarTest. Contiene el metodo necesario para realizar pruebas sobre las consultas por atributo.
 * 
 * @author Oscar
 * @version 1
 */
public class ConsultarTest {
	/**
	 * El metodo testConsultarSql comprueba que la consulta ha arrojado algún resultado.
	 * 
	 * Para ello Inserta un nuevo Pokemon p1 y comprueba con un COUNT
	 * que la tabla ha arrojado algun resultado comparandolo con que la cuenta obtenida no es cero
	 * 
	 * @author Oscar
	 */
	@Test
	public void testConsultarSql() {
		Pokemon p1 =new Pokemon("likitung", "normal", "kanto");

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p1));
		
		Consultar.ConsultarSql(TransformarAsql.ConsultaNombreAsql(p1.getNombre()), 1);
		
		assertNotEquals(ContarFilas.ConsultarSql(TransformarAsql.ConsultaNombreAsql(p1.getNombre())),0);
		
	}

}
