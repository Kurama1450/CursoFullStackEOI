package holaMundo;

/**
 * 
 * @author nesto
 *
 */

public class HolaMundo {

	// Función
	public static void ejemplosComentarios() {
		System.out.println("Hola Mundo!");
		System.out.println("Hola Néstor");				
		System.out.println("Hola Néstor Costa");				
		System.out.println("Hola Néstor Costa Orts");	
	}
	
	// Metodo
	private static void ejemplosTipos() {
		// Números enteros
		int num = 5;
		int num2 = 7;
		int sum = num + num2;
		int rest = num2 - num;
		System.out.println("El resultado de la suma es: "+ sum);
		System.out.println("El resultado de la resta es: "+ rest);
		
		// Números decimales
		double num3 = 14.50;
		double num4 = 3.14;
//		double prod = num3 * num4;
//		System.out.println("El resultado del producto es: "+ prod);
		System.out.println("El resultado del producto es: "+ num3*num4);
		System.out.println("El resultado de la suma decimal es: "+ (num3+num4));
		System.out.println("El resultado de la división es: "+ (num3/num4));
		
		// Enteros largos
		int maxINT = Integer.MAX_VALUE; // 2147483647
		int minINT = Integer.MIN_VALUE; // -2147483648
		System.out.println("El resultado de la suma es: " + (maxINT+minINT));

	}
	
	public static void main(String[] args) {
		ejemplosComentarios();
		ejemplosTipos();
	}

}
