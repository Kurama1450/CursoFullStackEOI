package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ejemplos {

	public static void leerFicheroJava5(String nombreFichero) {
		      File archivo = null;
		      FileReader fr = null;
		      BufferedReader br = null;

		      try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File (nombreFichero);
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);

		         // Lectura del fichero
		         String linea;
		         while((linea=br.readLine())!=null)
		            System.out.println(linea);
		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }
		 }
	//Files nos permite trabajar con el contenido de los ficheros
	//Path nos permite trabajar con las rutas del ordenador (ej:C/ficheros/archivo.txt)
	public static void leerFicheroJava8(String nombreFichero) throws IOException {
		Files.readAllLines(Paths.get(nombreFichero)).forEach(l->System.out.println(l));

	}
	
	public static void main(String[] args) throws IOException {
		leerFicheroJava5("C:\\Ficheros\\archivo.txt");
		leerFicheroJava8("C:\\Ficheros\\archivo.txt");

	}

}
