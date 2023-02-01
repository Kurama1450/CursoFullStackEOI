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
	
	public static void ej13() {
		Scanner sc = new Scanner(System.in);
		String[][] productos = new String[10][3];  // Podemos almacenar hasta 10 productos con 3 campos
		//String[][] productos = {{"mesa","99,50","3"},{"silla","14,95","4"}};  // 2 productos con 3 campos
		
		// Obtener los datos de productos
		System.out.println("¿Cuántos productos desea almacenar? (máximo 10)");
		int numProductos = Integer.parseInt(sc.nextLine());
		if(numProductos>10 || numProductos<0) {
			System.out.println("No se pueden almacenar más de 10 productos o números negativos");
			sc.close();  // cierro el scanner porque el programa no va a llegar al final de la función
			return;  // salgo de la función
		} else {  // número entre 0 y 10
			for(int i=0;i<numProductos;i++) {
				System.out.println("Introduzca el nombre del producto " + (i+1));
				productos[i][0]=sc.nextLine();
				System.out.println("Introduzca el precio del producto " + (i+1));
				productos[i][1]=sc.nextLine();
				System.out.println("Introduzca la cantidad del producto " + (i+1));
				productos[i][2]=sc.nextLine();
			}
		}
		
		// Mostrar los datos
		System.out.printf("%-17s%10s%10s%10s\n","NOMBRE","PRECIO","CANTIDAD","TOTAL");
		/*for(int i=0; i<42;i++) {
			System.out.print("-");
		}*/		
		System.out.println(String.valueOf('-').repeat(47));
		for(int i=0;i<numProductos;i++) {  // Si usaramos datos fijos seria productos.length
			double precio = Double.parseDouble(productos[i][1].replace(',', '.'));
			int cantidad = Integer.parseInt(productos[i][2]);
			double total = precio * cantidad;
			System.out.printf("%-17s%9.2f€%10d%9.2f€\n",productos[i][0],precio,cantidad,total);
		}
		
		
		sc.close();
	}
	
	public static void main(String[] args) {
//		ej1();
		ej2();
	}

}
