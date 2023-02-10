package poo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {

	private String nombre;
	private Estadio estadio;
	private List<Jugador> jugadores;
	private double presupuesto;
	
	public Equipo() {  // El constructor vacío que contenga objetos o listas de objetos debe asignar memoria para ellos.
		estadio = new Estadio();
		jugadores = new ArrayList<Jugador>(); // Creamos el objeto para poder meter elementos
	}

	public Equipo(String nombre, Estadio estadio, List<Jugador> jugadores, double presupuesto) {
		super();
		this.nombre = nombre;
		this.estadio = estadio;
		this.jugadores = jugadores;
		this.presupuesto = presupuesto;
	}
	
	public Equipo(Equipo e) {
		super();
		this.nombre = e.nombre;
		this.presupuesto = e.presupuesto;
		this.estadio = new Estadio(e.estadio);  // Forma correcta de copiar un objeto
		this.jugadores = new ArrayList<Jugador>();  // Creo la lista vacia
		e.getJugadores().forEach(j->this.jugadores.add(new Jugador(j))); // Voy rellenando la lista con copias jugador a jugador	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	@Override
	public String toString() {
		return  nombre + "\nPresupuesto=" + presupuesto + "\n" + estadio + "\n" + jugadores; 				 
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	/**
	 * Añadir el jugador a la lista de jugadores del equipo
	 * @param j
	 */
	public void addJugador(Jugador j) {
		jugadores.add(j);
	}
	
	/**
	 * Metodo avanzando de arriba
	 * @param j
	 * @return
	 */
	public boolean addJugadorImprove(Jugador j) {
		try {
			jugadores.add(j);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	/**
	 * Devuelve el numero total de jugadores.
	 * @param j
	 * @return
	 */
	public int getNumJugadores(Jugador j) {
		return jugadores.size();//Size devuelve el tamaño de la lista
		
	}
	/**
	 * Devuelve el jugador de una posicion si existiera , si no devuelve null.
	 * @param posicion
	 * @return
	 */
	public Jugador getJugadores(int posicion) {
		try {
			return jugadores.get(posicion);//get accede a una posicion de la lista.
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Borra el jugador de esa posicion si existe
	 * @param j
	 * @return
	 */
	public void deleteJugadores(int posicion) {
		 try {
			jugadores.remove(posicion);
			return;
		} catch (Exception e) {
			return;
		}
		
	}
	
	/**
	 * Devuelve el sueldo total de todos los jugadores de la lista.
	 * @param j
	 * @return
	 */
	public double totalSueldos() {
		//Estructurada
//		double sumaSueldos = 0;
//		for(Jugador jugador : jugadores)
//			sumaSueldos += jugador.getSueldo();
//		
//		return sumaSueldos;
		
		//Funcional A:
		
//		double[] sumaSueldos = new double[1];
//		jugadores.forEach(e->sumaSueldos[0]+=e.getSueldo());
//		return sumaSueldos[0];
		
		//Funcional B:
		
		return jugadores.stream().mapToDouble(e->e.getSueldo()).sum();//Nos quedamos solo con los sueldos y los sumamos todos.
	}
}
