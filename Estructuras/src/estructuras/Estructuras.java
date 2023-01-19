package estructuras;

import java.util.Scanner;

public class Estructuras {

	public static void ejemploIf() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre: ");
		
		String nombre = sc.nextLine();
		
		if(nombre.equals("Fran")) {
			System.out.println("Hola Fran , pasa un buen dia");
		}
			
		System.out.println("No eres Fran , pasa un buen dia");
		
		sc.close();
	}
	
	public static void ejemploIfElse() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre: ");
		
		String nombre = sc.nextLine();
		
		if(nombre.equals("Fran")) {
			System.out.println("Hola Fran , pasa un buen dia");
		} else {
			System.out.println("No eres Fran , pasa un buen dia");
		}
		
		sc.close();
	}
	
	public static void ejemploIfElseIfElse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tira un dado y escribe que número ha salido: ");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.println("Ha salido el numero 1");
		} else if(num == 2) {
			System.out.println("Ha salido el numero 2");
		}
		else if(num == 3) {
			System.out.println("Ha salido el numero 3");
		}
		else if(num == 4) {
			System.out.println("Ha salido el numero 4");
		}
		else if(num == 5) {
			System.out.println("Ha salido el numero 5");
		}
		else if(num == 6) {
			System.out.println("Ha salido el numero 6");
		} else {
			System.out.println("¿ Qué clase de dado tienes ?");
		}
		
		sc.close();
	}
	
	public static void IfElseIfSinElse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu equipo favorito");
		String equipo = sc.nextLine();
		String equiMayu = equipo.toUpperCase(); // Pasa la cadena a mayuscula y le asigna el valor a una variable
		
		if(equipo.toLowerCase().equals("barcelona")) { // Pasa a minuscula y compara
			System.out.println("Bisca el Barca");
		} else if(equipo.toUpperCase().equals("MADRID")) {// Pasa a mayuscula y compara
			System.out.println("Hala Madrid");
		}
		else if(equipo.equalsIgnoreCase("atletico")) {// Compara sin tener en cuenta mayusculas ni minusculas
			System.out.println("Aupa");
		}
		
		System.out.println("Bienvenido al programa de futbol");
		sc.close();
	}
	
	public static void main(String[] args) {
		
//		ejemploIf();
//		ejemploIfElse();
//		ejemploIfElseIfElse();
		IfElseIfSinElse();
	}

}
