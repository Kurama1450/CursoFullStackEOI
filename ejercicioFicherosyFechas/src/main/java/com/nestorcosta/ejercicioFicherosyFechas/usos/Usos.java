package com.nestorcosta.ejercicioFicherosyFechas.usos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.nestorcosta.ejercicioFicherosyFechas.modelos.Cuenta;

public class Usos {

	final private static String route = "ficheros";
	
	private static Path getRouteFiles(String nameFichero) {//Creamos un metodo para obtener la ruta y los ficheros que tiene dentro.
		return Paths.get(route,nameFichero);
	}
	
	public static Map<String,Cuenta>getMap(String nameFichero){
		Path archivo = getRouteFiles(nameFichero);
		Map<String,Cuenta> datesCliente = new HashMap<>();
		try {
			List<String> lines = Files.readAllLines(archivo);
			for(String line:lines) {
				List<String> datesLines = new ArrayList<>(Arrays.asList(line.split(";")));
				datesCliente.put(datesLines.get(0),
						new Cuenta(datesLines.get(1),
								LocalDate.parse(datesLines.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
								datesLines.get(3),
								Double.parseDouble(datesLines.get(4))));
			}
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo " +e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo " +archivo);
		}
		
		return datesCliente;
	}
	
	public static void bienvenida(Map<String,Cuenta> datesClientes,String dni) {
		String nameCliente = datesClientes.get(dni).getNombre_cliente();
		String countryCode = datesClientes.get(dni).getCodigo_pais();
		if(countryCode.equals("ES")) {
			System.out.println("Bienvenido/a " +nameCliente);
			String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("eeee',' dd 'de' MMMM 'de' yyyy\n'Hora: 'HH:mm:ss")).toString();
			System.out.println(fecha.toUpperCase().charAt(0)+ fecha.substring(1, fecha.length()));
		} 
		else {
			System.out.println("Welcome " +nameCliente);
			System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("eeee',' MMMM dd',' yyyy\n'Time: 'HH:mm:ss", Locale.UK)));
		}
	}
	
	private static LocalDate dateBirthday(Map<String,Cuenta> datesCliente, String dni) {
		return datesCliente.get(dni).getFechaNacimientoCliente();
	}
	
	public static Set<LocalDate> datesBirthday(Map<String,Cuenta> datesCaixa, Map<String,Cuenta> datesSabadell, Map<String,Cuenta> datesSantander, String dni){
		Set<LocalDate> naci = new HashSet<>();
		Collections.addAll(naci, dateBirthday(datesCaixa, dni), dateBirthday(datesSabadell, dni), dateBirthday(datesSantander, dni));
		return naci;
	}
	
	public static LocalDate correctDay(Set<LocalDate> datesBirthday, Scanner sc) {
		if(datesBirthday.size() != 1) {
			System.out.println("Se han encontrado diferentes fechas de nacimiento en sus cuentas:");
			datesBirthday.forEach(e->System.out.println(e.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			System.out.print("Eliga cuál de ellas es la correcta: ");
			return LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		else return ((LocalDate[]) datesBirthday.toArray(new LocalDate[0]))[0];
		
		
	}
	
	public static double addSaldos(Map<String,Cuenta> datesCaixa, Map<String,Cuenta> datesSabadell, Map<String,Cuenta> datesSantander, String dni) {
		return datesCaixa.get(dni).getSaldo()+datesSabadell.get(dni).getSaldo()+datesSantander.get(dni).getSaldo();
	}
	
	public static List<String> encontrarProduct(String nameFichero, int edad, double saldo){
		Path file = getRouteFiles(nameFichero);
		List<String> products = new ArrayList<String>();
		try {
			List<String> lines = Files.readAllLines(file);
			for(String line:lines) {
				List<String> datesProducts = new ArrayList<>(Arrays.asList(line.split(";")));
				int pMin = Integer.parseInt(datesProducts.get(0));
				int pMax = Integer.parseInt(datesProducts.get(1));
				double salMin = Double.parseDouble(datesProducts.get(2));
				double salMax = Double.parseDouble(datesProducts.get(3));
				if(pMin<=edad && edad<=pMax && salMin<=saldo && saldo<=salMax) {
					products.add(datesProducts.get(2));
					products.add(datesProducts.get(4));
					
				}
			}
			
			return products;
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo " +e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo " +file);
		}
		return null;
	}
	
	private static List<Double> listSaldosMin(List<String> products){
		List<Double> saldMin = new ArrayList<Double>();
		for(int i=0; i<products.size();i++) {
			saldMin.add(Double.parseDouble(products.get(i)));
			products.remove(i);
		}
		return saldMin;
	}
	
	private static double saldMinMasAlto(List<Double> saldMin) {
		return Collections.max(saldMin);
	}
	
	public static String ofrecerProduct(List<String> products) {
		if(products.size() != 0) {
			List<Double> saldMin = listSaldosMin(products);
			String product = products.get(0);
			if(products.size() != 1) product = products.get(saldMin.indexOf(saldMinMasAlto(saldMin)));
			return "¿Se encuentra interesado en "+product+"?";
		}
		else return "Lo sentimos. Actualmente no tenemos un producto que esta buscando";
	}
}
