package poo1;

public class Ejemplos {

	public static void main(String[] args) {
		Coche miCoche = new Coche();//Coche sin datos
//		miCoche.numeroRuedas = 4;
//		miCoche.marca = "Seat";
//		miCoche.modelo = "Altea";
		miCoche.setNumeroRuedas(4);
		miCoche.setMarca("Seat");
		miCoche.setModelo("Altea");
		miCoche.setPrecio(-9999);
		miCoche.setMatricula("8967-POL");
		System.out.println(miCoche);
		System.out.println("Mi coche es un " + miCoche.getMarca() + " , " + miCoche.getModelo());
		
		//Vamos a probar el constructor con parámetros
		Coche z3 = new Coche(40, "Toyota", "Z3", "1234-BBN", 20000);
		System.out.println(z3);
	}

}
