package com.nestorcosta.ejercicioClase.clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CuentaSantander extends Cuenta{

	private static double sumaSaldos;
	private boolean residenteSantander;
	private static int numCuentas = 0; // Contador interno en la clase que almacena el número de cuentas que se crean del banco
	{
		numCuentas++;
	}

	public static double getSumaSaldos(List<CuentaSantander> cuentasSantander) {
		cuentasSantander.forEach(e->sumaSaldos+=e.getSaldo());
		return sumaSaldos;
	}

	public boolean isResidenteSantander() {
		return residenteSantander;
	}

	public void setResidenteSantander(boolean residenteSantander) {
		this.residenteSantander = residenteSantander;
	}

	public static int getNumCuentas() {
		return numCuentas;
	}
	
	public CuentaSantander() {
		super();
	}
	
	public CuentaSantander(String dni_cif, String nombre_cliente, LocalDate fechaNacimientoCliente, String codigo_pais,
			double saldo) {
		super(dni_cif, nombre_cliente, fechaNacimientoCliente, codigo_pais, saldo);
		this.residenteSantander = false;
	}

	public CuentaSantander(String dni_cif, String nombre_cliente, LocalDate fechaNacimientoCliente, String codigo_pais,
			double saldo, boolean residenteSantander) {
		super(dni_cif, nombre_cliente, fechaNacimientoCliente, codigo_pais, saldo);
		this.residenteSantander = residenteSantander;
	}

	public static List<CuentaSantander> getListCuentaSantander(String nombreFichero) {
		Path archivo = getRutaFichero(nombreFichero);
		List<CuentaSantander> datosBanco = new ArrayList<>();
		try {
			List<String> lineas = Files.readAllLines(archivo);
			for (String linea:lineas) {
				List<String> datosLinea = new ArrayList<>(Arrays.asList(linea.split(";")));
				datosBanco.add(new CuentaSantander(
						datosLinea.get(0), // dni_cif
						datosLinea.get(1), //nombre_cliente
						LocalDate.parse(datosLinea.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")), // fechaNacimiento
						datosLinea.get(3), // codigo_pais
						Double.parseDouble(datosLinea.get(4)))); // nivelCatalan
			}
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
		return datosBanco;
	}
	
	private static double saldoMaxMasAlto(List<CuentaSantander> cuentasSantander) {
		List<Double> saldosMax = new ArrayList<Double>();
		cuentasSantander.forEach(e->saldosMax.add(e.getSaldo()));
		return Collections.max(saldosMax);
	}
	
	public static void cuentaConSaldoMax(List<CuentaSantander> cuentasSantander) {
		if (cuentasSantander.stream().filter(e->e.getSaldo() == saldoMaxMasAlto(cuentasSantander)).toList().size()==1) System.out.println("Cuenta del banco Santander con el saldo más alto:");
		else System.out.println("Cuentas del banco Santander con el saldo más alto:");
		cuentasSantander.stream().filter(e->e.getSaldo() == saldoMaxMasAlto(cuentasSantander)).forEach(e->System.out.println(e));
	}


	@Override
	public String toString() {
		return "DNI-CIF: "+getDni_cif()
				+ "\nNombre del cliente: "+getNombre_cliente()
				+ "\nFecha de nacimiento del cliente: "+getFechaNacimientoCliente().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "\nCódigo del país: "+getCodigo_pais()
				+ "\nSaldo: "+String.format("%.2f", getSaldo())+"€"
				+ "\n¿Residente en Santander? "+(residenteSantander?"Sí":"No")+"\n";
	}
	
}
