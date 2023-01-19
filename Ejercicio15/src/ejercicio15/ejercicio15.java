package ejercicio15;

import java.util.Scanner;

public class ejercicio15 {

	public static void main(String[] args) {
		final double IVA = 0.21;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del producto numero 1: ");
		String nameProduct = sc.nextLine();
		System.out.println("Introduzca el precio del producto 1: ");
		double precio = Double.parseDouble(sc.next().replace(',', '.'));
		sc.nextLine();
		System.out.println("Introduzca el nombre del producto numero 2: ");
		String nameProduct2 = sc.nextLine();
		System.out.println("Introduzca el precio del producto 2: ");
		double precio2 = Double.parseDouble(sc.next().replace(',', '.'));
		sc.nextLine();
		System.out.println("Introduzca el nombre del producto numero 3: ");
		String nameProduct3 = sc.nextLine();
		System.out.println("Introduzca el precio del producto 3: ");
		double precio3 = Double.parseDouble(sc.next().replace(',', '.'));
		sc.nextLine();
		
		System.out.printf("-------------------------\n");
		System.out.printf("%-15s%12s%12s\n","Nombre","Precio","IVA");
		System.out.printf("%-15s%11.2f$%11.2f$\n",nameProduct,precio,precio*(1+IVA));
		System.out.printf("%-15s%11.2f$%11.2f$\n",nameProduct2,precio2,precio2*(1+IVA));
		System.out.printf("%-15s%11.2f$%11.2f$\n",nameProduct3,precio3,precio3*(1+IVA));
		
		sc.close();
	}

}
