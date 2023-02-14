package ejercicioFicheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MainEj {

	final private static String route = "dates";//Creamos esta constante de ruta relativa para decir donde se encuentran los ficheros.
	
	public static Path getRutaDatos(String nameFicheros) {//Creamos este metodo de rutas para que nos devuelva la ruta y los nombre de los ficheros.
		return Paths.get(route,nameFicheros);//Decimos que nos devuelva la ruta y la varaible que le pasamos.
	}
	
	public static void readFicheros(String nameFicheros) {//Creamos este metodo void para que nos realize la lectura de los ficheros.
		try {
			Files.readAllLines(getRutaDatos(nameFicheros)).forEach(l->System.out.println(l));//Decimos que lea los ficheros que son cogidos por la ruta dada.
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca su DNI: ");
		String dni = sc.nextLine();
		Path archivo = getRutaDatos("sabadell.txt");
		try {
			List<String> lines = Files.readAllLines(archivo);
			for(String lineas : lines) {
				String[] dates = lineas.split(";");
				String dni_cif = dates[0];
				String name_cliente = dates[1];
				LocalDate fechaNaci = LocalDate.parse(dates[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));//Aqui lo que hacemos es especificar el formato de la fecha.
				String codigo_country = dates[3];
				Double cuenta = Double.parseDouble(dates[4]);
				if(dni_cif.equals(dni)) {
					if(codigo_country.equals("ES")) {
						System.out.println("Bienvenido de nuevo " +name_cliente);
						System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
					} else {
						System.out.println("Welcome again " +name_cliente);
						System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")));
					}
				}
			}
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}

		sc.close();
	}

}
