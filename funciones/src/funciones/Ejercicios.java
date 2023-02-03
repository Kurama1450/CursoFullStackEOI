package funciones;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios {

	public static double ej6(double...num) {
		double resultado = 0;
		for(double numeros : num) {
			resultado += numeros;
		}
		
		return resultado/num.length;
	}
	
	public static int ej8(int... numeros) {
		int maximo = Integer.MIN_VALUE;
		if(numeros.length == 0) {
			return 0;
		}
		for(int num : numeros) {
			if(num>maximo) {
				maximo = num;
			}
		}
		return maximo;
	}
	
	public static String devolverAzar(String[] cadenas) {
		//new Random().nextInt(array.length)
		return cadenas[new Random().nextInt(cadenas.length)];
	}
	
	public static void mostrarElementos(String[] cadenas) {
//		for(String cadena:cadenas) {
//			System.out.println(cadena);
//		}
		Arrays.stream(cadenas).forEach(e->System.out.println(e));//Programacion funcional
	}
	
	public static void ej7() {
		Scanner sc = new Scanner(System.in);
		final int MAXIMO_INTENTOS = 3;
		boolean acierto = false;
		String[] palabras = {"hola", "adios","mundo","eoi","elche","html","css"};
		String palabraAleatoria = devolverAzar(palabras);
		int intentos = 0;
		do {
			System.out.println("Introduzca un palabra (le quedan " + (MAXIMO_INTENTOS-intentos) + "intento");
			mostrarElementos(palabras);
			String palabra = sc.nextLine();
			if(palabra.equals(palabraAleatoria)) {
				acierto = true;
			}
			intentos++;
		}while(intentos <MAXIMO_INTENTOS && !acierto);
		if(acierto) {//He salido del bucle acertando
			System.out.println("Has acertado");
		} else {
			System.out.println("Has gastado todos tus intentos. La palabra era " + palabraAleatoria);
		}
		sc.close();
	}
	
	public static int ej9(String cadena, String subcadena) {
		
		int posiBusca = 0; //Variable que almacena a partir de que posicion buscar la subcadena.
		int resultado = 0; //Veces que encuentra la subcadena
		while((posiBusca = cadena.indexOf(subcadena,posiBusca))!=-1) {//Lo encuentra
			resultado++;
			posiBusca++;
		}
		return resultado;
	}
	
	
	public static void ej12(String[] cadenas) {
		Arrays.sort(cadenas);
	}
	
	public static LocalDate convertirFechaSubString(String fechaCadena) {
//		String dia = fechaCadena.substring(0, 2);
//		String mes = fechaCadena.substring(3, 5);
//		String anyo = fechaCadena.substring(6, 10);
//		LocalDate resultado = LocalDate.of(Integer.parseInt(anyo), Integer.parseInt(mes), Integer.parseInt(dia));
//		return resultado;
		return LocalDate.of(Integer.parseInt(fechaCadena.substring(6, 10)), 
				Integer.parseInt(fechaCadena.substring(3, 5)), 
				Integer.parseInt(fechaCadena.substring(0, 2)));
		
	}
	
	public static LocalDate sumarTiempos(LocalDate fechaInicio, int dias, int meses, int anyos) {
		return fechaInicio.plusYears(anyos).plusMonths(meses).plusDays(dias);
	}
	
	public static LocalDate ej15(String fechaCadena) {
		//Convertir el String en LocalDate
		LocalDate fecha = convertirFechaSubString(fechaCadena);
		
		//Sumar tiempos a un LocalDate
//		fecha.plusYears(2).plusMonths(3).plusDays(5);
		fecha = sumarTiempos(fecha,5,3,2);
		//Devolver el resultado
		return fecha;
	}
	
	public static void main(String[] args) {
		System.out.println(ej6(12.45,14.18,25.94,56,78));
		int maximo = ej8(2,8,99,4,150,500,550,25,50,12,14);
		System.out.println(maximo);
		System.out.println(ej8());
	}

}
