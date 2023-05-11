package baseDeDatos;

import static org.junit.Assert.*;

import org.junit.Test;
import control.TransformarAsql;
import modelo.Pokemon;

/**
 * Clase ContarFilasTest. Contiene el metodo necesario para realizar las pruebas
 * sobre las consultas COUNT que se usan de soporte por otros metodos
 * 
 * @author Oscar
 * @version 1
 */
public class ContarFilasTest {

	/**
	 * El metodo testConsultarSql comprueba que la consulta COUNT ha arrojado algún
	 * resultado.
	 * 
	 * Para ello Inserta dos nuevos Pokemon p1 y p2 genera una consulta general y
	 * comprueba que dicha consulta ha arrojado algun dato.
	 * 
	 * @author Oscar
	 */
	@Test
	public void testConsultarSql() {
		Pokemon p1 = new Pokemon("magenmite", "electrico", "kanto");
		Pokemon p2 = new Pokemon("gible", "tierra", "tesselia");
		String entrenador = "CazabichosCarlos";

		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p1));
		InsertDelUpdate.ejecutarSql(TransformarAsql.InsertPokemonAsql(p2));

		Consultar.ConsultarSql(TransformarAsql.ConsultaTodoAsql(entrenador), 2);

		assertNotEquals(ContarFilas.ConsultarSql(TransformarAsql.ConsultaTodoAsql(entrenador)), 0);

	}

}
