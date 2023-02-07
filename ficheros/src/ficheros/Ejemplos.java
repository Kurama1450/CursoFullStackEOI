package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Ejemplos {

	/**
	 * Función que nos lee todo el contenido de un fichero y nos imprime sus lineas por consola
	 * utilizando Java 5
	 * @param nombreFichero
	 */
	public static void leerFicheroJava5(String nombreFichero) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(nombreFichero);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * Función que nos lee todo el contenido de un fichero y nos imprime sus lineas por consola
	 * utilizando Java 8
	 * Files nos permite trabajar con el contenido de los ficheros
	 * Paths nos permite trabajar con las rutas del ordenador (ej: C:/ficheros/archivo.txt)
	 * @param nombreFichero Nombre del fichero en formato texto
	 * @throws IOException
	 * @author Fran
	 * @since 1.0
	 */
	public static void leerFicheroJava8(String nombreFichero) throws IOException {
		Files.readAllLines(Paths.get(nombreFichero)).forEach(l->System.out.println(l));
	}
	
	/**
	 * Función que nos lee todo el contenido de un fichero y nos imprime sus lineas por consola
	 * utilizando Java 8
	 * Files nos permite trabajar con el contenido de los ficheros
	 * @param ruta  Recibe una variable de tipo Path con la ruta del fichero
	 * @throws IOException
	 */
	public static void leerFicheroJava8(Path ruta) throws IOException {
		Files.readAllLines(ruta).forEach(l->System.out.println(l));
	}
	
	
	public static List<String> devolverLineasJava8(Path ruta){
		try {
			List<String> lineas = Files.readAllLines(ruta);
			return lineas;
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("No se puede acceder al fichero. Error en devolverLineasJava8");
			return null;
		}
	}
	
	public static int controlarDivisionEntera(int numerador,int denominador) {
		try {
			int resultado = numerador/denominador;
			return resultado;
		} catch (Exception e) {
			System.out.println("No se puede dividir por cero");
			return 0;
		}
	}
	
	public static void leerEImprimir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número");
		try {
			int numero = Integer.parseInt(sc.nextLine());  // Coge un número
			System.out.println(numero);
		} catch (NumberFormatException e) {
			System.out.println("No ha introducido un número correcto");
		}  // Imprime el número
		sc.close();
	}

	public static void main(String[] args) throws IOException  {
		//leerFicheroJava5("C:\\ficheros\\alumnos.txt");
		//leerFicheroJava8("C:\\ficheros\\alumnos.txt");
		//leerFicheroJava8(Paths.get("datos","alumnos.txt"));  // Llamada con ruta relativa independiente del Sistema Operativo		
		List<String> datosDevueltos = devolverLineasJava8(Paths.get("C:\\ficheros\\alumnos10.txt"));
		if(datosDevueltos!=null)
			datosDevueltos.forEach(e->System.out.println(e));
		System.out.println(controlarDivisionEntera(10, 0));
		leerEImprimir();
		System.out.println("Fin del programa");
	}
}
