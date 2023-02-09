package poo1;

import java.util.Objects;

public class Coche {

	// 1. propiedades o atributos
	private int numeroRuedas;
	private String marca;
	private String modelo;
	private String matricula;
	private double precio;
	
	// 2. Declaramos los constructores
	
	// 2.1 Constructor vacio. Permite crear un objeto sin datos
	public Coche() {
		
	}

	// 2.2 Constructor con todos los parámetros
	public Coche(int numeroRuedas, String marca, String modelo, String matricula, double precio) {
		this.setNumeroRuedas(numeroRuedas);
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.setPrecio(precio);
	}
	
	// 2.3 Crear más constructores si se desean
	
	public Coche(int numeroRuedas, String marca, String modelo, double precio) {
		super();  // Tiene sentido si heredas, si no, ni ayuda ni molesta.
		this.setNumeroRuedas(numeroRuedas);
		this.marca = marca;
		this.modelo = modelo;
		this.setPrecio(precio);
		this.matricula = "0000-AAA";  // puedo dar valores por defecto
	}

	
	// 2b. Constructor de copia (Optativo*). Crea un objeto igual al que te pasan
	public Coche(Coche c) {
		super();
		this.setNumeroRuedas(c.numeroRuedas);
		this.marca = c.marca;
		this.modelo = c.modelo;
		this.matricula = c.matricula;
		this.setPrecio(c.precio);
	}
	
	// 3. Generar Getters and Setters	


	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	public void setNumeroRuedas(int numeroRuedas) {
		if(numeroRuedas==4 || numeroRuedas==5)
			this.numeroRuedas = Math.abs(numeroRuedas);  // Si me ponen un número negativo lo pasa a positivo
		else
			this.numeroRuedas=4;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}  

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		if(this.matricula==null) {
			return "Sin matrícula";
		} else {
			return matricula;
		}		
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if(precio<0)
			this.precio = 0;
		else
			this.precio = precio;
	}

	//4. toString te permite decidir como quieres imprimir un objeto
	@Override
	public String toString() {
		return "Coche (numeroRuedas=" + numeroRuedas + ", marca=" + marca + ", modelo=" + modelo + ", matricula="
				+ this.getMatricula() + ", precio=" + precio + ")";
	}

	//5 hashCode and equals. Define el criterio de igualdad de dos objetos de la misma clase	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(matricula, other.matricula);
	}

	
	// 6. Métodos propios de la clase
	
	/**
	 * Devolvemos true si el coche supera los 30000 euros
	 * @return
	 */
	public boolean esCaro() {
		/*boolean resultado = false;
		if(precio>30000) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;*/
		//return precio>30000?true:false;
		return precio>30000;
	}
}
