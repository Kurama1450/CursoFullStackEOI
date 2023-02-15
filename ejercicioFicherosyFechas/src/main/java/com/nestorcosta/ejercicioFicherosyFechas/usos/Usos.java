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
import java.util.Collections;
import java.util.List;

public class Usos {

	final private static String route = "dates";
	
	private static Path getRouteFiles(String nameFichero) {//Creamos un metodo para obtener la ruta y los ficheros que tiene dentro.
		return Paths.get(route,nameFichero);
	}
	
	public static String[] buscarCliente(String nameFichero, String dni) {
		Path info = getRouteFiles(nameFichero);
		try {
			List<String> lines = Files.readAllLines(info);
			for(String line : lines) {
				String[] infoCliente = line.split(";");//Delimitamos el separador
				if(infoCliente[0].equals(dni)) return infoCliente;
			}
		} catch(NoSuchFileException e) {
			System.err.println("No se encuentra el archivo seleccionado " +e.getMessage());
		} catch (IOException e) {
			System.err.println("Ha habido un error al leer el archivo " + info);
		}
		return null;
	}
	
	public static void bienvenida(String[] dates) {
		String name_cliente = dates[1];
		String code_country = dates[3];
		if(code_country.equals("ES")) 
			System.out.println("Bienvenid@ " +name_cliente);
		else 
			System.out.println("Welcome " +name_cliente);
	}
	
	public static void dateFomat(String[] dates) {
		String code_country = dates[3];
		if(code_country.equals("ES"))
			System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		else 
			System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")));
		
		//Cambiamos para que la fecha sea la actual de lanzarse el programa.
		//Damos la vista con el formato de Ingles.
	}
	
	public static LocalDate dateBirthday(String[] dates) {
		return LocalDate.parse(dates[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public static boolean sameDate(LocalDate dateCaixa, LocalDate dateSabadell, LocalDate dateSantander) {
		if(dateCaixa.equals(dateSabadell) && dateCaixa.equals(dateSantander) && dateSabadell.equals(dateSantander))
			return true;
		else
			return false;
	}
	
	public static List<LocalDate> compareDates(LocalDate dateCaixa, LocalDate dateSabadell, LocalDate dateSantander) {
		List<LocalDate> fechasElegir = new ArrayList<LocalDate>();
		if(dateCaixa.equals(dateSabadell) || dateSantander.equals(dateSabadell))
			Collections.addAll(fechasElegir, dateCaixa, dateSantander);
		else if(dateCaixa.equals(dateSantander))
			Collections.addAll(fechasElegir, dateCaixa,dateSabadell);
		else 
			Collections.addAll(fechasElegir, dateCaixa,dateSabadell,dateSantander);
		
		return fechasElegir;
	}
	
	public static double sumarSaldos(String[] datesCaixa, String[] datesSabadell, String[] datesSantander) {
		return Double.parseDouble(datesCaixa[4])+Double.parseDouble(datesSabadell[4])+Double.parseDouble(datesSantander[4]);
	}
	
	public static List<String> buscarProducts(String nameFichero, int edad, double saldo){
		Path files = getRouteFiles(nameFichero);
		List<String> products = new ArrayList<String>();
		try {
			List<String> lines = Files.readAllLines(files);
			for(String line:lines) {
				String[] datesProduct = line.split(";");
				int dateMin = Integer.parseInt(datesProduct[0]);
				int dateMax = Integer.parseInt(datesProduct[1]);
				double soldMin = Double.parseDouble(datesProduct[2]);
				double soldMax = Double.parseDouble(datesProduct[3]);
				if(dateMin <= edad && edad <= dateMax && soldMin<=saldo && saldo<=soldMax) {
					products.add(datesProduct[2]);
					products.add(datesProduct[4]);
				}
			}
			return products;
			
		} catch(NoSuchFileException e) {
			System.err.println("No se encuentra el archivo seleccionado " +e.getMessage());
		} catch (IOException e) {
			System.err.println("Ha habido un error al leer el archivo " + files);
		}
		return null;
	}
	
	public static List<Double> listSaldosMini(List<String> products){
		List<Double> saldoMini = new ArrayList<Double>();
		for(int i = 0; i<products.size(); i++) {
			saldoMini.add(Double.parseDouble(products.get(i)));
			products.remove(i);
		}
		
		return saldoMini;
	}
	
	public static double saldoMiniMayor(List<Double> saldosMini) {
		return Collections.max(saldosMini);
	}
}
