package funciones;

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
