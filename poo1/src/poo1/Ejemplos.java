package poo1;

import java.util.ArrayList;
import java.util.List;

public class Ejemplos {

	public static void ejemplosCoches() {
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
		
		//Probar equals
		
		if(z3.equals(clonZ3)) {
			System.out.println("Los coches son iguales");
		} else {
			System.out.println("Los coches son diferentes");
		}
	}
	
	public static void ejercicio1() {
		Jugador juga1 = new Jugador("Victor", 5, 999);
		System.out.println("Nuestro primer jugador es: "+ juga1.getNombre() + " con " + juga1.getEdad() + " años y cobra " + juga1.getSueldo());
		
		Jugador clonjuga1 = new Jugador(juga1);
		System.out.println(clonjuga1);
	}

	public static void ejemloListaJugadores() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		
		Jugador juga1 = new Jugador("Victor", 19, 9999);
		Jugador juga2 = new Jugador("Hector", 25, 10999);
		Jugador juga3 = new Jugador("Hugo", 22, 9990);
		Jugador juga4 = new Jugador("Robert", 20, 20000);
		
		//Meter jugadores en lalista
		jugadores.add(juga1);
		jugadores.add(juga2);
		jugadores.add(juga3);
		jugadores.add(juga4);
		
		//Imprimir todos los jugadores
		jugadores.forEach(e->System.out.println(e));
		//Filtra e imprime
		System.out.println("Jugadores que ganan más de 10000 euros");
		jugadores.stream()
			.filter(e->e.getSueldo()>10000)
			.forEach(e->System.out.println(e));
		//Filtra e imprime
				System.out.println("Jugadores que ganan entre 10000 y 20000 euros y su nombre tenga ");
				jugadores.stream()
					.filter(e->e.getSueldo()>=10000)
					.filter(e->e.getSueldo()<=20000)
					.filter(e->e.getNombre().length()>4)
					.forEach(e->System.out.println(e));
				// Filtra e imprime:
				System.out.println("Jugadores que tengan una 'N' en su nombre");
				jugadores.stream()
					.filter(e->e.getNombre().toLowerCase().contains("n"))
					.forEach(e->System.out.println(e));		
	}
	
	public static void main(String[] args) {
//		ejemplosCoches();
		ejercicio1();
	}
}
