package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MiArrays {

	public static void ejemplo1() {
		//Java es un lenguaje base 0 , siempre la primera posicion es la 0 
		// y la ultima será la numero -1.
		int [] numeros; // Declarar la variable
		numeros = new int[5]; // Asignar memoria para poder trabajar con ella
		int [] nums = new int[5];// Delcaracion y asignacion en la misma linea. Más habitual
		
	}
	
	public static void ejemploRecorrido() {
		int[] numeros = {12,23,53,5,92};
		
		for(int i = 0; i<numeros.length;i++) {
			System.out.println("El array numeros en su posicion " + i + " tiene valor " + numeros[i]);
		}
		
		for(int numero:numeros) {
			System.out.println(numero);
		}
	}
	
	public static void ejemplosdeBusqueda() {
		String[] nombres = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		boolean encontrado = false;
		String buscar = "Pedro";
		for(int i = 0; i < nombres.length && !encontrado; i++) {
			if(nombres[i].equals(buscar)) {
				encontrado = true;
			}
		}
		if(encontrado) {
			System.out.println("El nombre " + buscar + " está en el array");
		} else {
			System.out.println(buscar + " no encontrado ... ");
		}
	}
	
	public static void ejemploBusquedaFuncional() {
		String[] nombres = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		String buscar = "Pedro";
		if(Arrays.stream(nombres).anyMatch(n -> n.equals(buscar))) {
			System.out.println("El nombre " + buscar + " está en el array");
		} else {
			System.out.println(buscar + " no encontrado ... ");
		}
	}
	
	public static void ejemploRedimension() {
		String[] nombres = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		nombres = Arrays.copyOf(nombres, 10);
	}
	
	public static void ejemploAumentarUnoArray() {
		Scanner sc = new Scanner(System.in);
		String[] alumnos = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		System.out.println("Introduzca nuevo alumno: ");
		String alumno = sc.nextLine();
		alumnos = Arrays.copyOf(alumnos, alumnos.length+1); // Le da un tamaño de una unidad más al
		alumnos[alumnos.length-1] = alumno;//Mete el nuevo dato en la ultima posicion
		for(String alu : alumnos) { // foEach
			System.out.println(alu);
		}
		Arrays.stream(alumnos).forEach(e-> System.out.println(e));// Programacion funcional
		sc.close();
	}
	
	public static void ejemploStringJoin() {
		String[] alumnos = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		String cadenaAlum = String.join(",",alumnos);
		System.out.println(cadenaAlum);
	}
	
	public static void eliminarUnElemento() {
		String[] alumnos = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		alumnos = Arrays.copyOf(alumnos, alumnos.length-1); 
		for(String alu : alumnos) {
			System.out.println(alu);
		}
	}
	
	public static void ordenarArray() {
		String[] alumnos = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		
		Arrays.sort(alumnos);
		
		for(String alu : alumnos) {
			System.out.println(alu);
		}
		
		int [] nums = {11,2,4,5,3,21,80};
		Arrays.sort(nums);
		for(int num : nums) {
			System.out.println(num);
		}
	}
	
	public static void ordenarInverso() {
		String[] alumnos = {"Juan", "Ana", "Pedro","Eva", "Paco"};
		int [] nums = {11,2,4,5,3,21,80};
		Arrays.sort(alumnos);
		for( String alum : alumnos) {
			System.out.println(alum);
		}
		
		Collections.reverse(Arrays.asList(alumnos));
		for(String alu : alumnos) {
			System.out.println(alu);
		}
	}
	
	public static void main(String[] args) {
//		ejemplo1();
//		ejemploAumentarUnoArray();
//		ejemploStringJoin();
//		eliminarUnElemento();
//		ordenarArray();
		ordenarInverso();
	}

}
