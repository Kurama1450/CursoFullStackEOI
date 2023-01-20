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
		String equiMayu = equipo.toUpperCase(); // Pasa la cadena a mayuscula y le asigna el valor a una variable nueva
		
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
	
	public static void ejswitch() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Tira un dado y escribe que número ha salido: ");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			System.out.println("Ha salido el uno");
			break;
			
		case 2:
			System.out.println("Ha salido el dos");
			break;
		
		case 3:
			System.out.println("Ha salido el tres");
			break;
			
		case 4:
			System.out.println("Ha salido el cuatro");
			break;
			
		case 5:
			System.out.println("Ha salido el cinco");
			break;
			
		case 6:
			System.out.println("Ha salido el seis");
			break;
			
		default:
			System.out.println("¿ Qué clase de dado tienes ?");
			break;
		}
		
		sc.close();
	}
	
	public static void ejemploTernarias() {
		int edad = 27;
//		if(edad>=18) {
//			System.out.println("Eres mayor de edad");
//		} else {
//			System.out.println("Eres menor de edad");
//		}
		
		System.out.println(edad>=18?"Eres mayor de edad":"Eres menor de edad");
		
//		int descuento = edad>=18?5:20;
//		System.out.println(descuento);
//		
//		int tresValores;
//		if(edad<18) {
//			tresValores=1;
//		} else if(edad<= 18 && edad<=65) {
//			tresValores=2;
//		} else {
//			tresValores = 3;
//		}
		
		int tresValores = edad<18?1:(edad>=18 && edad<=65)?2:3;
		
		System.out.println("TresValores vale " + tresValores);
		
		int euros = 10;
		System.out.println("Cuesta " + euros + " euro" + (euros!=1?"s":""));
		System.out.println("Cuesta " + euros + " euro" + (euros!=1?"euros":"euro"));
	}
	
	public static void ejemploAmbito() {
		int num = 5;
		
		int edad = 20;
		
		if(edad > 18) {
			// int num = 6; En Java da error
			int valor = 4;
			System.out.println(num);
		}
		// System.out.println(valor); Da error porque la varialbe no existe en el Ambito general del metodo
	}
	
	public static void ejemploWhile1() {
		Scanner sc = new Scanner(System.in);
		
		String password = "1234";
		boolean adivina = false;
		while(adivina == false) {
			System.out.println("Introduzca la contraseña");
			String respuesta = sc.nextLine();
			if(respuesta.equals(password)) {
				adivina = true;
			}
		}
		System.out.println("Ehnorabuena! Has entrado");
		sc.close();
	}
	
	public static void ejemploWhile2() {
		Scanner sc = new Scanner(System.in);
		
		String password = "1234";
		int intentos = 0;
		boolean adivina = false;
		while(!adivina && intentos < 3) {
			intentos++;
			System.out.println("Introduzca la contraseña");
			String respuesta = sc.nextLine();
			if(respuesta.equals(password)) {
				adivina = true;
			} else {
				System.out.println("Has fallado , vuelve a intentarlo");
			}
		}
		if(adivina) {
			System.out.println("Acertastes");
		} else {
			System.out.println("Fallastes");
		}
		
		sc.close();
	}
	
	public static void main(String[] args) {
		
//		ejemploIf();
//		ejemploIfElse();
//		ejemploIfElseIfElse();
//		IfElseIfSinElse();
//		ejswitch();
		ejemploTernarias();
	}

}
