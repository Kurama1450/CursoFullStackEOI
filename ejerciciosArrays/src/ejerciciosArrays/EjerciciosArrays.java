package ejerciciosArrays;

import java.util.Scanner;

public class EjerciciosArrays {

	public static void ej1() {
		String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero (0-11):");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println(meses[num-1]);
		sc.close();
	}
	
	public static void ej2() {
		int total = 0;
		int[] num = {12,34,50,65,79,80,79,90,43,14};
		for(int nums : num) {
			System.out.println(nums);
		}
		
		for(int nums : num) {
			total =total + nums;
		}
		System.out.println("El total es: " + total);
		
		System.out.println("La media es: " + (double)total/num.length);
		
		int mayorProvi = num[0];
		int menorProvi = num[0];
		for(int numero : num) {
			if(numero > mayorProvi) 
				mayorProvi = numero;
				
			if(numero<menorProvi)
				menorProvi = numero;
		}
		System.out.println("El numero mayor es: " + mayorProvi);
		System.out.println("El numero menor es: " + menorProvi);
	}
	
	public static void main(String[] args) {
//		ej1();
		ej2();
	}

}
