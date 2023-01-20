package ejercicios;

import java.util.Scanner;

public class EjerciciosEstructuras {

	public static void main(String[] args) {
//		ej1();
//		ej2();
//		ej3();
//		ej4();
//		ej5();
//		ej6();
		ej8();
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
	
	public static void ej4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su palabra: ");
		
		String palabra = sc.nextLine();
		
		System.out.println("Introduzca su siguiente palabra: ");
		
		String palabra2 = sc.nextLine();
		
		if(palabra == palabra2) {
			System.out.println("Son iguales");
		}
		else {
			System.out.println("No son iguales");
		}
		
		sc.close();
	}
	
	public static void ej5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su numero: ");
		
		int num1 = sc.nextInt();
		
		System.out.println("Introduzca su segundo numero: ");
		
		int num2 = sc.nextInt();
		
		int result = num1/num2;
		
		if(result == 0) {
			System.out.println("Resultado negativo"+ result);
		}
		else {
			System.out.println("Resultado: "+ result);
		}
		
		sc.close();
	}
	
	public static void ej6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su numero: ");
		
		int num1 = sc.nextInt();
		
		System.out.println("Introduzca su segundo numero: ");
		
		int num2 = sc.nextInt();
		
		System.out.println("Introduzca su tercera numero: ");
		
		int num3 = sc.nextInt();
		
		if(num1>num2) {
			if(num1>num3) {
				System.out.println("El mayor es: " +num1);
			} else {
				System.out.println("El mayor es: " +num3);
			}
		} else if (num2>num3) {
			System.out.println("El mayor es: " +num2);
		} else {
			System.out.println("El mayor es: " +num3);
		}
		
		sc.close();
	}
	
	public static void ej7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca sus horas: ");
		
		int numHoras = sc.nextInt();
		
		System.out.println("Introduzca sus minutos: ");
		
		int numMin = sc.nextInt();
		
		System.out.println("Introduzca sus segundos: ");
		
		int numSeg = sc.nextInt();
		
		
	}
	
	public static void ej8() {
		int num = 38;
		
		System.out.println((num%2==0)?"Es impar":"Es par");
	}
	
	public static void ej9() {
		
	}
	
	public static void ej10() {
		
	}
	
	public static void ej11() {
		
	}
	
	public static void ej12() {
		
	}
}
