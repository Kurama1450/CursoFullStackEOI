package poo1.ejercicio4h;

import java.util.Objects;

public class Direccion {

	private String nombre;
	private int numero;
	
	public Direccion() {
		
	}

	public Direccion(String nombre, int numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}
	
	public Direccion(Direccion d) {
		super();
		this.nombre = d.nombre;
		this.numero = d.numero;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Direccion [nombre=" + nombre + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(nombre, other.nombre) && numero == other.numero;
	}
	
	
}
