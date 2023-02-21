package com.nestorcosta.ejercicioFicherosyFechas;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.nestorcosta.ejercicioFicherosyFechas.modelos.Cuenta;
import com.nestorcosta.ejercicioFicherosyFechas.usos.Usos;

/*
 * Somos una entidad financiera que trabaja con varios bancos y que quiere
 * ofrecer productos a sus clientes dependiendo de ciertas características del
 * mismo. Se pedirá por consola el dni-cif del cliente, a partir de ese momento
 * buscaremos en una ruta (que tendremos definida como una variable global)
 * todos los ficheros txt que recogen información de los clientes en los
 * diferentes bancos. Hemos conseguido que todos los bancos nos envíen toda la
 * información en un formato unificado de este tipo:
 * 
 * dni-cif;nombre_cliente;fecha_nacimiento(dd/mm/aaaa);código_país;saldo
 * 
 * El programa al recibir un dni-cif hará lo siguiente:
 * 
 * Sacar un mensaje de bienvenida en el idioma del cliente (en español para los
 * clientes de España y en inglés para el resto) donde incluya su nombre (puedes
 * coger el primero que encuentres).
 * 
 * La hora actual (en formato "largo", y poniendo el día antes que el mes para
 * los clientes españoles y el mes antes que el día para el resto)
 * 
 * Posteriormente, comprobará si el cliente tiene más de una fecha de nacimiento
 * en los ficheros, en cuyo caso, sacará por pantalla las mismas para que el
 * cliente seleccione cuál es la correcta (si solo hay una no preguntará).
 * 
 * Una vez confirmada la fecha de nacimiento, buscaremos en otro fichero de
 * productos (donde tenemos criterios de que productos ofrecer basándonos en el
 * saldo y la edad del cliente) acorde al siguiente formato:
 * 
 * edad_mínima;edad_maxima;saldo_mínimo;saldo_máximo;nombre_producto
 * 
 * (si el cliente puede acceder a más de un producto financiero, mostraremos
 * aquel cuyo saldo mínimo sea mayor). Para obtener el saldo del cliente deberás
 * sumar (puede haber saldos negativos), su saldo de todos los bancos.
 * 
 * Nota: Intenta estructurar en clases el proyecto Maven. Utiliza las clases ya
 * vistas en el curso hasta el momento.
 * 
 * Se adjuntan datos de 3 bancos (caixa, santander y sabadell) y el fichero de
 * productos (productosofertados)
 */
public class App 
{
	
	public static void gestionFicheros() {
		final String ficheroCaixa = "caixa.txt";
		final String ficheroSabadell = "sabadell.txt";
		final String ficheroSantander = "santander.txt";
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca su DNI-CIF: ");
		String dni = sc.nextLine();
		Map<String,Cuenta> datesCaixa = Usos.getMap(ficheroCaixa);
		Map<String,Cuenta> datesSabadell = Usos.getMap(ficheroSabadell);
		Map<String,Cuenta> datesSantander = Usos.getMap(ficheroSantander);
		if(datesCaixa.containsKey(dni)) {
			Usos.bienvenida(datesCaixa, dni);
			Set<LocalDate> fechasNaci = Usos.datesBirthday(datesCaixa, datesSabadell, datesSantander, dni);
			LocalDate fechaCierta = Usos.correctDay(fechasNaci, sc);
			int edad = Period.between(fechaCierta, LocalDate.now()).getYears();
			double sumaSaldos = Usos.addSaldos(datesCaixa, datesSabadell, datesSantander, dni);
			List<String> products = Usos.encontrarProduct("productosofertados.txt", edad, sumaSaldos);
			if(products != null) System.out.println(Usos.ofrecerProduct(products));
		}
		else System.err.println("No se reconoce el DNI introducido");
		sc.close();
	}
	
    public static void main( String[] args )
    {
        gestionFicheros();
    }
}
