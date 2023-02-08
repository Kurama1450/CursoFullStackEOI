package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios {

	public static void ej7_5(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero: ");
		String nombreFichero = sc.nextLine();
		List<String> lineas = Ejemplos.devolverLineasJava8(Paths.get(nombreFichero));
		if(lineas!=null) {//He podido acceder al fichero
			lineas.forEach(e->System.out.println(e));//Me muestra todas las lineas de un fichero.
			//String[] lineasArray = (String[]) lineas.toArray();//Me transforma una lista de String en un Array de String.
//			int elementosLista = lineas.size();//Devuelve el numero de elementos de la lista.
//			Random random = new Random();//Crea un objeto de tipo random para sacar numeros aleatorios
//			int azar = random.nextInt(elementosLista);//Saca un aleatorio entre 0 y elementosLista-1
			int numAzar = new Random().nextInt(lineas.size());
			System.out.println(lineas.get(numAzar));//El metodo get que coge una posicion de una lista
		}
		sc.close();
	}
	
	public static void ej2(String nombreFichero) {
		Scanner sc = new Scanner(System.in);
		String linea;
		try {
			Files.writeString(Paths.get(nombreFichero), " ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		do {
			System.out.println("Introduzca la linea que quiere insertar en el fichero(FIN para finalizar): ");
			linea = sc.nextLine();
			if(!linea.equalsIgnoreCase("fin")) {
				try {
					Files.writeString(
							Paths.get(nombreFichero),
							linea+"\n",
							StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}while(!linea.equalsIgnoreCase("fin"));
		
		sc.close();
	}
	
	public static void main(String[] args) {
//		ej7_5();
		ej2("C:/Ficheros/ej2.txt");
	}
}
