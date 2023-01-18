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
		int numero1 = 10;
		int numero2 = 20;
		boolean boll1 = true;
		boolean boll2 = false;
		boolean compar1 = 10<18;
		System.out.println(10<20);
		System.out.println(compar1);
		// Condiciones de comparación <,>,<=,>=,==,!=,<>
		String cad1 = "Buenas";
		String cad2 = "Dias";
		String cad3 = "Buenas";
		String cad4 = "Dias";
		System.out.println(cad1.equals(cad2)); //false
		System.out.println(cad1.equals(cad3)); //true
		System.out.println(cad1.equals(cad4)); //false
		System.out.println(cad2.equals(cad4)); //true
		numero1 = 5;
		double numero3 = 5.0;
		double numero4 = 5.1;
		System.out.println(numero1==numero3); // true o false? -> true
		System.out.println(numero1==numero4); // true o false? -> false
		System.out.println((11/2)==numero1); // true o false? -> true
		System.out.println((11.0/2)==numero1); // true o false? -> false
		System.out.println((11%2)==1); // true o false? -> true
		System.out.println((11%2)==0); // true o false? -> false
		System.out.println(23%4); // el resto de la división es 3
	}
	
	public static void tablasVerdad() {
		int edad = 25;
		int anyosCarnet = 6;
		String sexo = "Masculino";
		String nombre = "Pepe";
		boolean esPepeMayor = edad >= 18 && nombre.equals("Pepe");  // true
		System.out.println(esPepeMayor); // true
									//    true             &&   false  -> false
		boolean tieneDescuento = (sexo.equals("Masculino") && anyosCarnet > 10) || 
				(sexo.equals("Femenino") && anyosCarnet > 5); // false || false
		System.out.println(tieneDescuento); // false
		
		boolean estoQueDa = sexo.equals("Masculino") || anyosCarnet>5 && nombre.equals("Fran");
		System.out.println(estoQueDa); // true
		int numero = 7+4*5; // 27
	}
	
	public static void ejemplosIncrementosDecrementos() {
		int numero = 10;
		// pre-incremento
		++numero;  // 11
		System.out.println(numero);  // 11
		// post-incremento
		numero++;  // 12
		System.out.println(numero);  // 12
		// pre-decremento
		--numero;  // 11
		System.out.println(numero);  // 11
		// post-decremento
		numero--;  // 10
		System.out.println(numero);  // 10
		
		//// LO IMPORTANTE ES EL MOMENTO EN QUE INCREMENTA O DECREMENTA
		System.out.println(++numero);  // 10 u 11 ? -> 11 y número = 11
		System.out.println(numero++);  // 11 y número = 12
		System.out.println(numero);  // 12
		
		//System.out.println(++numero+numero++); // 26 (13 + 13) y luego numero=14  // a+b = b+a
		System.out.println(numero+++ ++numero); // 26 (13+13) y luego numero=14  // a+b = b+a
		System.out.println(numero);  // 14
		int numero2 = ++numero;  // numero2 = 15; numero = 15;
		System.out.println("numero2 = " + numero2 + " numero = " + numero);
		int numero3 = numero++;  // numero3 = 15; numero = 16;
		System.out.println("numero2 = " + numero3 + " numero = " + numero);
	}
	
	public static void ejemplosConstantes() {
		final double IVA = 0.21;
		double precio = 50;
		System.out.println("El precio final es: " +(precio * (1+IVA)));
	}
	
	public static void conversionesNumerosCadenas() {
		int num = 10;
		String cadena = "11";
		// Cadena a numero
		System.out.println(Integer.parseInt(cadena) + num);
	}
	
	public static void main(String[] args) {
		ejemplosComentarios();
		ejemplosTipos();
		ejemplosString();
		ejemplosBoolean();
		tablasVerdad();
		ejemplosConstantes();
		conversionesNumerosCadenas();
	}

}
