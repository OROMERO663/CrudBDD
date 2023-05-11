package modelo;
/**
 * Clase Pokemon. Contiene los atributos que forman el Objeto Pokemon y los metodos necesarios (Constructor, Getters/Setters) 
 * para poder ser utilizado por el resto de Clases.
 * 
 * @author Oscar
 * @version 1
 */
public class Pokemon {

	private String nombre;
	private String tipo;
	private String region;

	/**
	 * Metodo Constructor Pokemon
	 * 
	 * @author Oscar
	 * @param nombre Atributo nombre del Pokemon
	 * @param tipo   Atributo tipo del Pokemon
	 * @param region Atributo region del Pokemon
	 */
	public Pokemon(String nombre, String tipo, String region) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.region = region;
	}

	/**
	 * Metodo Getter Nombre
	 * 
	 * @author Oscar
	 * @return nombre Atributo nombre del Pokemon
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo Setter Nombre
	 * 
	 * @author Oscar
	 * @param nombre Nombre del Pokemon
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo Getter Tipo
	 * 
	 * @author Oscar
	 * @return tipo Atributo tipo del Pokemon
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo Setter Tipo
	 * 
	 * @author Oscar
	 * @param tipo Tipo del Pokemon
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo Getter Region
	 * 
	 * @author Oscar
	 * @return region Atributo region del Pokemon
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Metodo Setter Region
	 * 
	 * @author Oscar
	 * @param region Region del Pokemon
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Metodo toString Pokemon
	 * 
	 * @author Oscar
	 * @return String ToString del Objeto de la clase Pokemon
	 */
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", tipo=" + tipo + ", region=" + region + "]";
	}

}
