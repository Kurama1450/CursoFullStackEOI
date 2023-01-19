package ejercicios;

import java.util.Scanner;

public class EjerciciosEstructuras {

	public static void main(String[] args) {
//		ej1();
//		ej2();
		ej3();
	}

	public static void ej1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca un numero entero: ");
		int num = sc.nextInt();
		
		int rest = num%2;
		
		if(rest == 0) {
			System.out.println("Es par");
		} else {
			System.out.println("Es impar");
		}
		
		sc.close();
	}
	
	public static void ej2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca un numero entero: ");
		int num = sc.nextInt();
		
		int rest= num%10;
		
		if(rest == 0) {
			System.out.println("Es multiplo de 10");
		} 
		else {
			System.out.println("No es multiplo de 10");
		}
		
		sc.close();
	}
	
	public static void ej3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su palabra: ");
		
		char cadena = sc.nextLine().charAt(0);
		
		if(Character.isUpperCase(cadena)) {
			System.out.println("Es mayuscula");
		} else {
			System.out.println("Es minúscula");
		}
		
		sc.close();
	}
}
