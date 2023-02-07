package ficheros;

import java.io.IOException;
import java.nio.file.Paths;
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
	
	public static void main(String[] args) {
		ej7_5();
	}
}
