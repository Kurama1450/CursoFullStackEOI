package funciones;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Ejemplos {

	public static void imprimirHola() {
		// public indica que la función es pública (private, protected, "nada")
		// static significa que es un método de clase ("nada" es non-static)
		// void significa que el método/función no devuelve nada (int, String, char, double, Coche, Moto...)
		System.out.println("Hola");
	}
	
	public static void imprimirCadena(String cadena) {
		System.out.println(cadena);
	}
	
	public static void imprimirDosCadenas(String cadena, String cadena2) {
		System.out.println(cadena + " " + cadena2);
	}
	
	public static void imprimirSuma(int numero1, int numero2) {
		System.out.println(numero1+numero2);
	}
	
	public static void imprimirSuma(int numero1) {
		System.out.println(numero1+10);
	}
	
	public static void imprimirSuma(double numero1, double numero2) {
		System.out.println(numero1+numero2);
	}
	
	public static void imprimirSuma(float numero1, float numero2) {
		System.out.println(numero1+numero2);
	}
	public static void imprimirSuma(String numero1, String numero2) {
		System.out.println(Integer.parseInt(numero1)+Integer.parseInt(numero2));
	}
	
	
	/**
	 * Imprime un menú con las diferentes opciones que le pasas como cadenas
	 * Añade una opción al final 0.Salir
	 * @param opciones Las cadenas que pasas como parámetros
	 */
	public static void imprimirMenu(String...opciones) {
		int numOpcion = 1;
		for(String opcion: opciones) {
			System.out.println(numOpcion++ + ". " + opcion);
		}
		System.out.println("0. Salir");
	}
	
	// Métodos que devuelve algo
	public static int devuelveSuma(int numero1, int numero2) {
		int resultado = 0;
		resultado = numero1+numero2;
		return resultado;
	}
	
	public static void parametrosReferencia(int[] valores) {
		valores[0]++;
	}
	
	public static void ejemplosMath() {
		double n1 = -23.40;
		double n2 = 2.449532;

		System.out.println(Math.abs(n1)); // 23.4 El número siempre en positivo
		System.out.println(Math.round(n2)); // 2
		System.out.println(Math.round(n1)); // -23
		System.out.println(Math.ceil(n2)); // 3 Redondea hacia arriba siempre
		System.out.println(Math.ceil(n1)); // -23
		System.out.println(Math.floor(n2)); // 2 Redondea hacia abajo siempre
		System.out.println(Math.floor(n1)); // -24
		System.out.println(Math.max(23, 43)); // 43
		System.out.println(Math.min(4, 5)); // 4
		System.out.println(Math.sqrt(25)); // 5
		System.out.println(Math.pow(3, 2)); // 9
		System.out.println(Math.pow(3, 3)); // 27

	}

	
	public static void ejemplosString() {
		String s1 = "abc";
		String s2 = "def";
		String s3 = "ghi";
		String concatenada = s1.concat(s2).concat(s3);
		String concatenada2 = s1 + s2 + s3;
		System.out.println(concatenada); // abcdefghi
		System.out.println(concatenada2); // abcdefghi
		s1.concat(s2).concat(s3);  // s1 => abcdefghi? NO
		System.out.println(s1);  // abc
		s1 = s1.concat(s2).concat(s3);  // s1 => abcdefghi? SI
		System.out.println(s1);  // abcdefghi
		
		String[] nombres = {"Paco", "Pepa", "Dani"};
		String nombresJuntos = String.join(", ", nombres);
		System.out.println(String.join(", ", nombres));
		System.out.println(nombresJuntos);
		
		String cad1 = "alicante";
		String cad2 = "dani";
		String cad3 = "Alava";
		System.out.println(cad1.compareTo(cad2)); // -3
		System.out.println(cad1.compareTo(cad3)); // 32
		System.out.println(cad1.compareToIgnoreCase(cad3)); // 8
		
		String s = "Mi perro se llama Comeniños";
		System.out.println(s.indexOf("perro")); // 3
		System.out.println(s.indexOf("gato")); // -1 Valores no encontrados
		
	}
	
	
	public static void buscarArrayInteger() {
		int[] numeros = {5,9,14,7,2};
		boolean encontrado = Arrays.stream(numeros).anyMatch(e->e==5);
		boolean encontrado2 = Arrays.stream(numeros).anyMatch(e->e==8);
		System.out.println(encontrado);
		System.out.println(encontrado2);
	}
	
	public static void ejemplosFechas() {
		Date noUsar = new Date();//No usar en proyecto java 8 o superior
		LocalDate fecha = LocalDate.now();
		System.out.println(fecha);
	}

	public static void main(String[] args) {
		if(args.length>0)
			System.out.println(args[0]);
		String cadena = "cadena del main";
		imprimirHola();  // hola
		imprimirHola();  // hola
		imprimirCadena("Esto es lo que quiero imprimir");
		imprimirCadena("Esto también");
		//imprimirCadena(5);  // No podemos pasarle un tipo de dato diferente al que espera
		imprimirCadena(cadena); // cadena del main
		System.out.println(cadena + " impresa desde el main");
		imprimirDosCadenas("Primera cadena","Segunda Cadena");
		cadena = "otro contenido";
		imprimirCadena(cadena); // otro contenido
		imprimirSuma(1234,4321);
		imprimirMenu("Guardar","Descargar","Copiar");
		imprimirMenu("Insertar","Listar","Actualizar","Borrar"); // CRUD -> Create, Read, Update, Delete
		imprimirSuma(5,7); // 12
		imprimirSuma(5);   // 15
		imprimirSuma("10","20");
		int numero = devuelveSuma(7, 4);  // int numero = 11;
		System.out.println(numero);
		System.out.println(devuelveSuma(10,15));  // Imprime 25
		if(devuelveSuma(4,3)>10) {
			System.out.println("La suma es mayor que 10");
		} else {
			System.out.println("La suma no es mayor que 10");
		}
	}

}
