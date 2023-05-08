package modelo;

import java.util.ArrayList;

import baseDeDatos.InsertDelUpdate;
import control.TransformarAsql;
import modelo.Pokemon;
import usuario.Utilidades;


public class Pokedex {

	private String entrenador;
	private ArrayList<Pokemon> miPokedex = new ArrayList<Pokemon>();
	/**
	 * Metodo Constructor Entrenador
	 * 
	 * @author Oscar
	 * @param entrenador Nombre introducido por el usuario
	 */
	public Pokedex(String entrenador) {
		super();
		this.entrenador = entrenador;
	}
	/**
	 * Metodo Getter Entrenador
	 * 
	 * @author Oscar
	 * @return entrenador Nombre elegido por el usuario
	 */
	public String getEntrenador() {
		return entrenador;
	}
	/**
	 * Metodo Setter Pokedex
	 * 
	 * @author Oscar
	 * @param entrenador Nombre elegido por el usuario
	 */
	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}
	/**
	 * Metodo Getter miPokedex
	 * 
	 * @author Oscar
	 * @return miPokedex Contenido de la Lista miPokedex
	 */
	public ArrayList<Pokemon> getMiPokedex() {
		return miPokedex;
	}
	/**
	 * Metodo Setter miPokedex
	 * 
	 * @author Oscar
	 * @param miPokedex Contenido de la lsita miPokedex
	 */
	public void setMiPokedex(ArrayList<Pokemon> miPokedex) {
		this.miPokedex = miPokedex;
	}
	/**
	 * Metodo toString Pokedex
	 * 
	 * @author Oscar
	 * @return String devuelve miPokedex toString
	 */
	@Override
	public String toString() {
		return "Pokedex [entrenador=" + entrenador + ", miPokedex=" + miPokedex + "]";
	}

	/**
	 * El metodo addEntrenador guarda el nombre de entrenador elegido por el
	 * usuario.
	 * 
	 * @author Oscar
	 * @param nuevoEnt Es el parametro con el que fijamos el nombre del entrenador.
	 */
	public void addEntrenador(String nuevoEnt) {
		setEntrenador(nuevoEnt);
	}

	/**
	 * El metodo addPokemon guarda los atributos introducidos por el usuario de un
	 * nuevo Objeto de la Clase Pokemon en la Lista de la Clase Pokedex.
	 * Si la Lista esta vacia añade directamente el nuevo Pokemon.
	 * Si el nombre del Pokemon ya estaba guardado saca mensaje por consola
	 * diciendo que el Pokemon ya esta en la lista y no lo guarda
	 * Mensaje por consola: confirma que se ha guardado el Pokemon.
	 * Mensaje por consola: el Pokemon esta repetido y pide que se introduzca un nuevo Pokemon.
	 * 
	 * @author Oscar
	 * @param nuevo Es el parametro con el que introducimos los atributos del Pokemon.
	 */
	public void addPokemon(Pokemon nuevo) {
		String nombre = nuevo.getNombre();
		String tipo = nuevo.getTipo();
		String region = nuevo.getRegion();
		nuevo = new Pokemon(nombre, tipo, region);
		int longitud = miPokedex.size();
		boolean encontrado = false;
		int contador = 0;
		
		try {
			if (miPokedex.isEmpty()) {
				miPokedex.add(nuevo);
				System.out.println(nuevo.getNombre() + " ha sido añadido a tu Pokèdex");
				System.out.println("-----------------------------------------------");
			} else {
				do {
					if (miPokedex.get(contador).getNombre().equals(nombre)) {
						System.out.println("El Pokèmon " + nombre + " está en tu Pokèdex. Prueba a añadir otro Pokèmon");
						encontrado = true;
					}
					contador++;
					if (contador == longitud && !encontrado) {
						miPokedex.add(nuevo);
						System.out.println(nuevo.getNombre() + " Ha sido añadido a tu Pokèdex");
						System.out.println("-----------------------------------------------");
					}
				} while (contador < longitud && !encontrado);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * El metodo buscarNombre compara el atributo nombre de un Objeto de la clase
	 * Pokemon introducido por el usuario con los existentes en la Lista. 
	 * Si encuentra coincidencia muestra mensaje por consola con la informacion del
	 * Pokemon.
	 * Si no encuentra coincidencia muestra mensaje por consola diciendo
	 * que el Pokemon no aparece en la Lista.
	 * Mensajes por consola: muestra mensaje del Pokemon encontrado y sus atributos.
	 * Mensajes por consola: muestra mensaje de no haber encontrado el Pokemon buscado. 
	 * Mensajes por consola: muestra mensaje de Error si la Lista estaba vacia.
	 * 
	 * @author Oscar
	 * @param consultaNombre Es el parametro con el que introducimos el Objeto de la
	 *                       clase Pokemon que queremos buscar en la Lista.
	 */
	public void buscarNombre(Pokemon consultaNombre) {

		String nombre = consultaNombre.getNombre();
		int longitud = miPokedex.size();
		boolean encontrado = false;
		int contador = 0;

		try {
			if (miPokedex.isEmpty()) {
					System.out.println("Tu Pokèdex está vacía. Añade primero algún Pokèmon");
			} else {
				do {
					if (miPokedex.get(contador).getNombre().equals(nombre)) {
						System.out.println("El Pokèmon " + nombre + " está en tu Pokèdex. Es un Pokèmon de tipo "
								+ miPokedex.get(contador).getTipo() + " y pertenece a la región de "
								+ miPokedex.get(contador).getRegion());
						encontrado = true;
					}
					contador++;
					if (contador == longitud && !encontrado) {
						System.out.println(nombre + " no está en tu Pokèdex");
					}
				} while (contador < longitud && !encontrado);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------");

	}
	/**
	 * El metodo buscarTipo compara el atributo tipo de un Objeto de la clase
	 * Pokemon introducido por el usuario con los existentes en la Lista. 
	 * Si encuentra coincidencia muestra mensaje por consola con la informacion de
	 * todos los Pokemon del tipo buscado.
	 * Si no encuentra ningun Pokemon del tipo buscado muestra mensaje por consola 
	 * diciendo que no hay Pokemon de ese tipo en la Lista.
	 * Mensajes por consola: muestra mensaje de los Pokemon encontrados y sus atributos.
	 * Mensajes por consola: muestra mensaje de no haber encontrado el Pokemon del tipo buscado. 
	 * 
	 * @author Oscar
	 * @param consultaTipo Es el parametro con el que introducimos el Objeto de la
	 *                     clase Pokemon que queremos buscar en la Lista.
	 */
	public void buscarTipo(Pokemon consultaTipo) {
		String tipo = consultaTipo.getTipo();
		int longitud = miPokedex.size();
		boolean encontrado = false;

		System.out.println("Tienes los siguientes Pokèmon del tipo " + tipo + " en tu Pokèdex:");
		
		try {
			for (int i = 0; i < longitud; i++) {
				if (miPokedex.get(i).getTipo().equals(tipo)) {
					System.out.println("Pokèmon: " + miPokedex.get(i).getNombre() + ", Tipo: " + miPokedex.get(i).getTipo()
							+ ", Región: " + miPokedex.get(i).getRegion());
					encontrado = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (encontrado == false) {
				System.out.println("No hay Pokèmon del tipo " + tipo + " en tu Pokèdex");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------");
	}
	/**
	 * El metodo buscarRegion compara el atributo region de un Objeto de la clase
	 * Pokemon introducido por el usuario con los existentes en la Lista. 
	 * Si encuentra coincidencia muestra mensaje por consola con la informacion de
	 * todos los Pokemon de la region buscada.
	 * Si no encuentra ningun Pokemon de la region buscada, muestra mensaje por consola 
	 * diciendo que no hay Pokemon de ese tipo en la Lista.
	 * Mensajes por consola: muestra mensaje de los Pokemon encontrados y sus atributos.
	 * Mensajes por consola: muestra mensaje de no haber encontrado el Pokemon de la region buscada. 
	 * 
	 * @author Oscar
	 * @param consultaRegion Es el parametro con el que introducimos el Objeto de la
	 *                       clase Pokemon que queremos buscar en la Lista.
	 */
	public void buscarRegion(Pokemon consultaRegion) {
		String region = consultaRegion.getRegion();
		int longitud = miPokedex.size();
		boolean encontrado = false;

		System.out.println("Tienes los siguientes Pokèmon de la región " + region + " en tu Pokèdex:");
		try {
			for (int i = 0; i < longitud; i++) {
				if (miPokedex.get(i).getRegion().equals(region)) {
					System.out.println("Pokèmon: " + miPokedex.get(i).getNombre() + ", Tipo: " + miPokedex.get(i).getTipo()
							+ ", Región: " + miPokedex.get(i).getRegion());
					encontrado = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (encontrado == false) {
				System.out.println("No hay Pokèmon del tipo " + region + " en tu Pokèdex");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------");
	}
	/**
	 * El metodo pokedexCompleta recorre la Lista miPokedex al completo y saca por consola
	 * la información de los atributos de los Pokemon guardados. 
	 * Si la Pokedex esta vacia saca mensaje por consola informando.
	 * Mensajes por consola: muestra la Lista de Pokemon actualizada.
	 * Mensajes por consola: muestra mensaje de Pokedex vacia si la Lista miPokedex esta vacia. 
	 * 
	 * @author Oscar
	 */
	public void pokedexCompleta() {

		int longitud = miPokedex.size();

		System.out.println("La Pokèdex actual de " + getEntrenador() + ", contiene los siguientes Pokèmon:");
		try {
			if (miPokedex.isEmpty()) {
				System.out.println("Tu Pokèdex está vacía");
			} else {
				for (int i = 0; i < longitud; i++) {
					System.out.println("Pokèmon " + (i + 1) + ": " + miPokedex.get(i).getNombre() + ", Tipo: "
							+ miPokedex.get(i).getTipo() + ", Región: " + miPokedex.get(i).getRegion());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-----------------------------------------------");
	}

	/**
	 * El metodo modificar compara el atributo nombre de un Objeto de la clase
	 * Pokemon introducido por el usuario con los existentes en la Lista. 
	 * Si encuentra coincidencia pide por consola al usuario que modifique los
	 * atributos del Pokemon. 
	 * Si no encuentra coincidencia muestra mensaje por consola diciendo que el Pokemon no aparece en la Lista. 
	 * Mensajes por consola: muestra mensaje del Pokemon encontrado y pide al usuario los nuevos atributos. 
	 * Mensajes por consola: muestra mensaje de no haber encontrado el Pokemon buscado. 
	 * Mensajes por consola: muestra mensaje de Error si la Lista estaba vacia.
	 * 
	 * @author Oscar
	 * @param modifica Es el parametro con el que introducimos el Objeto de la clase
	 *                 Pokemon que queremos buscar en la Lista
	 */
	public void modificar(Pokemon modifica) {

		String nombre = modifica.getNombre();
		int longitud = miPokedex.size();
		boolean encontrado = false;
		int contador = 0;
		String sqlUpdate=("");
		String antiguo =("");
		Pokemon miPokemon = new Pokemon("", "", "");

		try {
			if (miPokedex.isEmpty()) {
				System.out.println("Tu Pokèdex está vacía. Añade primero algún Pokèmon");
			} else {
				do {
					if (miPokedex.get(contador).getNombre().equals(nombre)) {
						System.out.println("El Pokèmon " + nombre
								+ " está en tu Pokèdex. Introduce los nuevos datos para modificarlo: ");
						encontrado = true;
						antiguo = miPokedex.get(contador).getNombre(); //gaurda el nombre que ha encontrado
						modifica = Utilidades.PedirPokemon();
						//miPokedex.remove(contador);
						//miPokedex.add(contador, modifica);
						
						//modificamos el pokemon que hemos encontrado y lo guardamos en un objeto tipo Pokemon para pasarlo al sql
						miPokedex.get(contador).setNombre(modifica.getNombre());
						miPokedex.get(contador).setTipo(modifica.getTipo());
						miPokedex.get(contador).setRegion(modifica.getRegion());
						miPokemon= new Pokemon(miPokedex.get(contador).getNombre(),miPokedex.get(contador).getTipo(),miPokedex.get(contador).getRegion());
						
						//metemos en sqlupdate el transformar del pokemon y del nombre viejo
						sqlUpdate = TransformarAsql.UpdatePokemonAsql(miPokemon, antiguo);
						InsertDelUpdate.ejecutarSql(sqlUpdate);
						System.out.println("Tu Pokèmon ha sido modificado.");
						System.out.println("-----------------------------------------------");
					}
					contador++;
					if (contador == longitud && !encontrado) {
						System.out.println(nombre + " no está en tu Pokèdex");
					}
				} while (contador < longitud && !encontrado);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * El metodo liberar pide al usuario el atributo nombre de un Objeto de la clase
	 * Pokemon que quiere eliminar de la Lista y lo elimina. 
	 * Si encuentra coincidencia muestra mensaje por consola de haber liberado al Pokemon. 
	 * Si no encuentra coincidencia muestra mensaje por consola diciendo que el Pokemon no
	 * aparece en la Lista. 
	 * Mensajes por consola: muestra mensaje de Error si la Lista estaba vacia.
	 * 
	 * @author Oscar
	 * @param libera Es el parametro con el que introducimos el Objeto de la clase
	 *               Pokemon que queremos buscar en la Lista
	 */
	public void liberar(Pokemon libera) {

		String nombre = libera.getNombre();
		int longitud = miPokedex.size();
		boolean encontrado = false;
		int contador = 0;

		try {
			if (miPokedex.isEmpty()) {
				System.out.println("Tu Pokèdex está vacía. Añade primero algún Pokèmon");
			} else {
				do {
					if (miPokedex.get(contador).getNombre().equals(nombre)) {
						System.out.println("El Pokèmon " + nombre + " ha sido liberado. ¡Buena suerte " + nombre + "!");
						System.out.println("-----------------------------------------------");
						encontrado = true;
						miPokedex.remove(contador);
					}
					contador++;
					if (contador == longitud && !encontrado) {
						System.out.println("El Pokèmon " + nombre + " no está en tu Pokedex");
					}
				} while (contador < longitud && !encontrado);
			}


		}  catch (Exception e) {
			e.printStackTrace();
		}

	}

}
