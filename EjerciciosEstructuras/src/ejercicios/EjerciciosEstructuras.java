package ejercicios;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjerciciosEstructuras {

	public static void main(String[] args) {
//		ej1();
//		ej2();
//		ej3();
//		ej4();
//		ej5();
//		ej6();
//		ej8();
//		ej13();
//		ej12();
//		ej18();
//		ej19();
//		ej21();
//		ej23();
//		ej25();
//		ej26();
		ej27();
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
		
		String cadena = sc.nextLine();
		
		if(cadena.charAt(0)>='A' && cadena.charAt(0)<='Z') {
			System.out.println("Es mayuscula");
		} else {
			System.out.println("Es minúscula");
		}
		// Otra opción correcta
//		if(Character.isUpperCase(cadena)) {
//			System.out.println("Es mayuscula");
//		} else {
//			System.out.println("Es minúscula");
//		}
		
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
		
		if(num2 != 0) {
			System.out.println("Resultado: "+ result);
		}
		else {
			System.out.println("No se puede dividir entre cero");
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
		
		System.out.println("Introduzca sus horas(0-23): ");
		int numHoras = Integer.parseInt(sc.nextLine());
		
		
		System.out.println("Introduzca sus minutos(0-59): ");
		int numMin = Integer.parseInt(sc.nextLine());
		
		
		System.out.println("Introduzca sus segundos(0-59): ");
		int numSeg = Integer.parseInt(sc.nextLine());
		
		if(numHoras<0 || numHoras>23 || numMin<0 || numMin>59 || numSeg<0 || numSeg>59) {
			System.out.println("Ha introducido valores erroneos");
		} else {
			System.out.printf("Hora es: %02d/%02d/%02d\n",numHoras,numMin,numSeg);
		}
		sc.close();
	}
	
	public static void ej7bErroresPersonalizados() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca sus horas(0-23): ");
		int numHoras = Integer.parseInt(sc.nextLine());
		
		
		System.out.println("Introduzca sus minutos(0-59): ");
		int numMin = Integer.parseInt(sc.nextLine());
		
		
		System.out.println("Introduzca sus segundos(0-59): ");
		int numSeg = Integer.parseInt(sc.nextLine());
		
		if(numHoras<0 || numHoras>23)  {
			System.out.println("Ha introducido una hora erronea");
		} else if(numMin<0 || numMin>59) {
			System.out.println("Ha introducido los minutos erroneos");
			
		} else if(numSeg<0 || numSeg>59) {
			System.out.println("Ha introducido los segundos erroneos");
		} else {
			System.out.printf("Hora es: %02d/%02d/%02d\n",numHoras,numMin,numSeg);
		}
		sc.close();
	}
	
	public static void ej8() {
		int numero = 37;
		
		System.out.println((numero%2==0)?"El número es par":"El número es impar");
	}
	
	public static void ej9() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero entre 1 y 12: ");
		int mes = sc.nextInt();
		switch(mes) {
		case 1:
			System.out.println("Es el mes de enero tiene 30 dias");
			break;
			
		case 2:
			System.out.println("Es el mes de febrero tiene 28 dias");
			break;
			
		case 3:
			System.out.println("Es el mes de marzo tiene 30 dias");
			break;
			
		case 4:
			System.out.println("Es el mes de abril tiene 31 dias");
			break;
			
		case 5:
			System.out.println("Es el mes de mayo tiene 30 dias");
			break;
			
		case 6:
			System.out.println("Es el mes de junio tiene 31 dias");
			break;
			
		case 7:
			System.out.println("Es el mes de julio tiene 30 dias");
			break;
			
		case 8:
			System.out.println("Es el mes de agosto tiene 31 dias");
			break;
			
		case 9:
			System.out.println("Es el mes de septiembre tiene 30 dias");
			break;
			
		case 10:
			System.out.println("Es el mes de octubre tiene 31 dias");
			break;
			
		case 11:
			System.out.println("Es el mes de noviembre tiene 30 dias");
			break;
			
		case 12:
			System.out.println("Es el mes de diciembre tiene 28 dias");
			break;
			
		default:
			System.out.println("Este numero no corresponde a ningún mes");
			break;
		}
		
		sc.close();
		
	}
	
	public static void ej10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una letra: ");
		char letra = sc.nextLine().charAt(0);
		if(Character.isDigit(letra)) {
			System.out.println("La letra es una cifra numerica");
		} else if(letra == '.' || letra==',' || letra==';' || letra==':') {
			System.out.println("La letra es un signo de puntuación");
		} else {
			System.out.println("Es otro caracter");
		}
		
		sc.close();
	}
	
	public static void ej11() {
		
	}
	
	public static void ej12() {
		final double MENOR_EDAD = 0.25;
		final double DESCUENTO_SOCIO = 0.40;
		final double DESCUENTO_JUBILADO = 0.75;
		Scanner sc = new Scanner (System.in);  // Para leer datos por pantalla
		double precioEntrada = 50;
		System.out.println("Introduzca su edad:");
		int edad = sc.nextInt();
		sc.nextLine();
		if(edad<18) {
			precioEntrada = precioEntrada * (1-MENOR_EDAD);  // precio * 0,75
		} else if(edad>=18 && edad<65) {
			System.out.println("Es usted socio (sí/no):");
			String respuesta = sc.nextLine();
			// Solución con expresión regular		
			Pattern regex = Pattern.compile("^s[iíÍ]?$", Pattern.CASE_INSENSITIVE);			
			Matcher m = regex.matcher(respuesta);
			if(m.matches()) {
				precioEntrada = precioEntrada * (1 - DESCUENTO_SOCIO);
			}
		} else {
			precioEntrada = precioEntrada * (1-DESCUENTO_JUBILADO);
		}
		System.out.println("Su precio es: " + precioEntrada);
		sc.close();
	}
	
	public static void ej12Grupo() {
		final double MENOR_EDAD = 0.25;
		final double DESCUENTO_SOCIO = 0.40;
		final double DESCUENTO_JUBILADO = 0.75;
		Scanner sc = new Scanner (System.in);  // Para leer datos por pantalla
		double precioEntrada = 50;
		double precioTotalGrupo = 0;
		System.out.println("¿Cuantos sois?");
		int personas = sc.nextInt();
		sc.nextLine();
		int personasAtendidas = 0;
		while(personasAtendidas<personas) {
			System.out.println("Datos de la persona " + personasAtendidas+1);
			System.out.println("Introduzca su edad:");
			int edad = sc.nextInt();
			sc.nextLine();
			if(edad<18) {
				precioEntrada = precioEntrada * (1-MENOR_EDAD);  // precio * 0,75
			} else if(edad>=18 && edad<65) {
				System.out.println("Es usted socio (sí/no):");
				String respuesta = sc.nextLine();
				// Solución con expresión regular		
				Pattern regex = Pattern.compile("^s[iíÍ]?$", Pattern.CASE_INSENSITIVE);			
				Matcher m = regex.matcher(respuesta);
				if(m.matches()) {
					precioEntrada = precioEntrada * (1 - DESCUENTO_SOCIO);
				}
			} else {
				precioEntrada = precioEntrada * (1-DESCUENTO_JUBILADO);
			}
			precioTotalGrupo += precioEntrada;
			personasAtendidas++;
		}
		System.out.println("El precio del grupo es: " + precioTotalGrupo);
		sc.close();
	}
	
	public static void ej13() {
		int val1 = 20;
		
		while(val1 >= 1) {
			System.out.println(val1--);
			
		}
	}
	
	public static void ej18() {
		for(int i = 0; i<= 100; i+=5) {

			System.out.println("Los siguientes numeros son: " + i);
		}
	}
	
	public static void ej18b() {
		for(int i = 0; i<= 100; i++) {
			if(i%5==0) {
				System.out.println("Los siguientes numeros son: " + i);
			}
		}
	}
	
	public static void ej19() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		for (int i=1; i<=num; i++) {

			 System.out.print(i + ((i != num) ? ", " : ""));

			 }
		sc.close();
	}
	
	public static void ej19b() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		for (int i=1; i<=num; i++) {
			if(i!=num) {
				System.out.print(i+",");
			} else {
				System.out.println(i);
			}
		}
		sc.close();
	}
	
	public static void ej21() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i<=num ;i++) {
			if(num%i == 0) {
				System.out.println("El numero " + i + " es divisor de " + num);
			}
		}
		
		sc.close();
	}
	
	public static void ej21b() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		int i = 1;
		while(i<num) {
			if(num%i == 0) {
				System.out.println("El numero " + i + " es divisor de " + num);
			}
			i++;
		}
		
		sc.close();
	}
	
	public static void ej23() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = num; i >= 1; i--) {
			for(int j = 0; j <(num-i); j++) {
				System.out.print("\t");
			}
			for(int z = num; z >= num-i+1; z--) {
				System.out.print(i+"\t");
			}
			System.out.print("\n");
		}
		sc.close();
	}
	
	public static void ej25() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static void ej26() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = num; i>= 1; i--) {
			for(int j = 1; j<i; j++) {
				System.out.print(" ");
			}
			
			for(int k = num; k>=i;k--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		sc.close();
	}
	
	public static void ej27() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indiqueme el ancho del rectángulo: ");
		int ancho = sc.nextInt();
		
		System.out.println("Indiqueme el alto del rectángulo: ");
		int alto = sc.nextInt();
		
		//Primera fila
		for(int columna =1; columna <=ancho; columna++)
			System.out.print("*");
		System.out.println();
		
		//Filas Intermedias
		for(int fila =1; fila <=alto-2; fila++)
		{
			System.out.print("*");
			for(int columna = 1; columna <= ancho-2; columna++)
			{
				System.out.print(" ");
			}
			System.out.println("*");
		}
				
		//Última fila	
		for(int columna =1; columna <=ancho; columna++)
			System.out.print("*");
		System.out.println();
		
		sc.close();
	}
}
