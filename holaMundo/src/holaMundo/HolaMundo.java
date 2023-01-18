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
		long larg = 2000000000;
		long larg2 = 1000000000;
		System.out.println("La suma de dos largos bien hecho es: " + (larg+larg2));
		char letraA = 'a';
		char letraB = 'b';
		System.out.println("La suma de la letra A y la letra B es: " + letraA+letraB);
		System.out.println("La suma de la letra A y la letra B es: " + (letraA+letraB));
		System.out.println("La suma de la letra A y la letra B es: " + (letraA+3)); //100
		System.out.println("La suma de la letra A y la letra B es: " + (char)(letraA+3));

	}
	
	public static void ejemplosString() {
		String cadena1;
		cadena1 = "Néstor";
		String cadena2 = "Costa" , cadena3 = "Orts";
		String cadena4 = cadena1 + " " + cadena2 + " " + cadena3;
		String prefijo = "34";
		String telefono = "6666666666";
		int numero = 40;
		System.out.println(cadena4);
		System.out.println(prefijo + "-" + telefono);
		System.out.printf("%s tiene %d años",cadena1,numero);
		System.out.println();
	}
	
	public static void ejemplosBoolean() {
		boolean boll1 = true;
		boolean boll2 = false;
		boolean compar1 = 10<18;
		System.out.println(10<20);
		System.out.println(compar1);
		// Condiciones de comparación <,>,<=,>=,==,!=,<>
	}
	
	public static void algoritmoCesar() {
		
	}
	
	public static void main(String[] args) {
		ejemplosComentarios();
		ejemplosTipos();
		ejemplosString();
		ejemplosBoolean();
	}

}
