package poo1;

public class Ejemplos {

	public static void main(String[] args) {
		Coche miCoche = new Coche();  // Me crea un coche sin datos. Usa el constructor vacío
		//miCoche.numeroRuedas = -4;
		//miCoche.marca = "Seat";
		//miCoche.modelo = "Altea";
		miCoche.setNumeroRuedas(6);
		miCoche.setMarca("Seat");
		miCoche.setModelo("Altea");
		miCoche.setPrecio(10000);
		miCoche.setMatricula("0000-AAA");
		System.out.println(miCoche);  // Estamos probando el toString
		System.out.println("Mi coche es un " + 
				miCoche.getMarca() + " " 
				+ miCoche.getModelo() + " Con matrícula: " + miCoche.getMatricula());
		
		// Vamos a probar el constructor con parámetros
		Coche z3 = new Coche(40, "Bmw", "Z3", "1111-BBB", -20000);
		System.out.println(z3);
		System.out.println("Mi nuevo coche es un " + 
				z3.getMarca() + " " 
				+ z3.getModelo() + " Con matrícula: " + z3.getMatricula());
		
		Coche tercero = new Coche(4, "Mercedes", "Clase A", 15000);
		System.out.println(tercero);
		
		// Vamos a probar el constructor de copia
		Coche clonZ3 = new Coche(z3);
		System.out.println("Imprimo Z3 clonado sin cambiar nada:");
		System.out.println(clonZ3);
		clonZ3.setMatricula("2222-CCC");
		System.out.println("Imprimo Z3 original:");
		System.out.println(z3);
		System.out.println("Imprimo Z3 clonado y cambiada la matrícula:");
		System.out.println(clonZ3);
		
		// Error tipico de un programador
		Coche intentoClon = z3;  // Esto no crea un nuevo coche, al coche existente ahora se le puede llamar de dos formas
		z3.setPrecio(5000);
		intentoClon.setNumeroRuedas(5);
		System.out.println("Voy a imprimir el intentoClon:");
		System.out.println(intentoClon);
		System.out.println(z3);
	}
}
