package poo1;

public class Coche {

	//Propiedas o Atributos
	private int numeroRuedas;
	private String marca;
	private String modelo;
	private String matricula;
	private double precio;
	
	//Declaramos los constructores
	
	//Constructor vacio.Permite crear un objeto sin datos
	public Coche() {
		
	}

	//Constructor con todos los parametros
	public Coche(int numeroRuedas, String marca, String modelo, String matricula, double precio) {
		super();
		this.setNumeroRuedas(numeroRuedas);
		this.marca = marca;
		this.modelo = modelo;
		this.matricula=matricula;
		this.setPrecio(precio);
	}

	//Getters y Setters
	
	public int getNumeroRuedas() {//Obtener
		return numeroRuedas;
	}

	public void setNumeroRuedas(int numeroRuedas) {//Poner
		if(numeroRuedas == 4 || numeroRuedas ==5)
			this.numeroRuedas = Math.abs(numeroRuedas);//Si me ponen un numero negativo lo ponen en positivo.
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
		if(this.matricula==null)
			return "Sin matricula";
		else
			return matricula;
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
			this.precio=precio;
	}

	//ToString te permite decidir como quieres imprimir un objeto
	@Override
	public String toString() {
		return "Coche [numeroRuedas=" + numeroRuedas + ", marca=" + marca + ", modelo=" + modelo + ", matricula="
				+ this.getMatricula() + ", precio=" + precio + "]";
	}
	
	
	
	
}
