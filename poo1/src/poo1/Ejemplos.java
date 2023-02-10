package poo1;

import java.util.ArrayList;
import java.util.List;

public class Ejemplos {

	public static void ejemplosCoches() {
		Coche miCoche = new Coche();  // Me crea un coche sin datos. Usa el constructor vacío
		//miCoche.numeroRuedas = -4;
		//miCoche.marca = "Seat";
		//miCoche.modelo = "Altea";
		miCoche.setNumeroRuedas(6);
		miCoche.setMarca("Seat");
		miCoche.setModelo("Altea");
		miCoche.setPrecio(10000);
		miCoche.setMatricula("0000-AAA");
		System.out.println(miCoche);  // Estamos probando el toString
		System.out.println("Mi coche es un " + 
				miCoche.getMarca() + " " 
				+ miCoche.getModelo() + " Con matrícula: " + miCoche.getMatricula());
		
		// Vamos a probar el constructor con parámetros
		Coche z3 = new Coche(40, "Bmw", "Z3", "1111-BBB", -20000);
		System.out.println(z3);
		System.out.println("Mi nuevo coche es un " + 
				z3.getMarca() + " " 
				+ z3.getModelo() + " Con matrícula: " + z3.getMatricula());
		
		Coche tercero = new Coche(4, "Mercedes", "Clase A", 40000);
		System.out.println(tercero);
		
		// Vamos a probar el constructor de copia
		Coche clonZ3 = new Coche(z3);
		System.out.println("Imprimo Z3 clonado sin cambiar nada:");
		System.out.println(clonZ3);
		clonZ3.setMatricula("2222-CCC");
		System.out.println("Imprimo Z3 original:");
		System.out.println(z3);
		System.out.println("Imprimo Z3 clonado y cambiada la matrícula:");
		System.out.println(clonZ3);
		
		// Error tipico de un programador
		Coche intentoClon = z3;  // Esto no crea un nuevo coche, al coche existente ahora se le puede llamar de dos formas
		z3.setPrecio(5000);
		intentoClon.setNumeroRuedas(5);
		System.out.println("Voy a imprimir el intentoClon:");
		System.out.println(intentoClon);
		System.out.println(z3);
		
		// Probar Equals
		
		if(z3.equals(intentoClon)) {
			System.out.println("Los coches son iguales");
		} else {
			System.out.println("Los coches son diferentes");
		}
		
		
		if(tercero.esCaro()) {
			System.out.println("Mi coche es caro");
		} else {
			System.out.println("Mi coche es barato");
		}
		
	}
	
	public static void ejercicio1() {
		//Scanner sc = new Scanner(System.in);
		Jugador jugador1 = new Jugador("Fran", 45, 50000);
		Jugador jugador2 = new Jugador("David", 20, 60000);
		Jugador jugador3 = new Jugador("Bárbara", 23, 70000);
		Jugador jugador4 = new Jugador("Camila", 22, 80000);
		Jugador jugador5 = new Jugador("José Luis", 18, 60000);
		Jugador jugador6 = new Jugador("Enrique", 15, 50000);
		Jugador jugador7 = new Jugador("Atenea", 20, 40000);
		Jugador jugador8 = new Jugador("Ángel", 22, 1000000);
		Jugador jugador9 = new Jugador();
		jugador9.setNombre("Néstor");
		jugador9.setEdad(-20);
		jugador9.setSueldo(-50000);
		Jugador jugador10 = new Jugador(jugador1);
		System.out.println(jugador1);
		System.out.println(jugador9);
		System.out.println(jugador10);
		/*int edad;
		do {
			System.out.println("Introduzca la edad (la edad debe ser mayor o igual a 0):");
			edad = Integer.parseInt(sc.nextLine());
		} while (edad<0);
		System.out.println("Salgo del bucle con edad = " + edad);
		if(edad>0) {
			Jugador jugador11 = new Jugador("Paco",edad,1000);
		} else {
			System.out.println("Ha introducido una edad errónea");
		}*/
	}
	
	public static void ejemploListaJugadores() {
		
		// Creo una lista vacía para almacenar los jugadores
		List<Jugador> jugadores = new ArrayList<Jugador>();
		
		Jugador fran = new Jugador("Fran", 45, 50000);
		Jugador david = new Jugador("David", 20, 60000);
		Jugador barbara = new Jugador("Bárbara", 23, 70000);
		Jugador camila = new Jugador("Camila", 22, 80000);
		Jugador joseLuis = new Jugador("José Luis", 18, 60000);
		Jugador enrique = new Jugador("Enrique", 15, 50000);
		Jugador atenea = new Jugador("Atenea", 20, 40000);
		Jugador angel = new Jugador("Ángel", 22, 1000000);
		Jugador nestor = new Jugador();
		nestor.setNombre("Néstor");
		nestor.setEdad(-20);
		nestor.setSueldo(-50000);
		Jugador francisco = new Jugador(fran);
		
		// Meter jugadores en la lista
		jugadores.add(fran);
		jugadores.add(david);
		jugadores.add(barbara);
		jugadores.add(camila);
		jugadores.add(joseLuis);
		jugadores.add(enrique);
		jugadores.add(atenea);
		jugadores.add(angel);
		jugadores.add(nestor);		
		jugadores.add(francisco);
		jugadores.add(new Jugador("Naomi",20,80000));
		
		// Imprmir todos los jugadores
		jugadores.forEach(e->System.out.println(e));
		jugadores.forEach(e->System.out.println(e.nombreOculto() + " gana " + e.getSueldo()));
		// Filtra e imprime:
		System.out.println("Jugadores que ganan más de 60000 euros");
		jugadores.stream()
			.filter(e->e.getSueldo()>60000)
			.forEach(e->System.out.println(e));
		// Filtra e imprime:
		System.out.println("Jugadores que ganan entre 50000 y 70000 euros y su nombre tenga más de 5 letras");
		jugadores.stream()
			.filter(e->e.getSueldo()>=50000 && e.getSueldo()<=70000)
			.filter(e->e.getNombre().length()>5)
			.forEach(e->System.out.println(e));
		// Filtra e imprime:
		System.out.println("Jugadores que tengan una 'N' en su nombre");
		jugadores.stream()
			.filter(e->e.getNombre().toLowerCase().contains("n"))
			.forEach(e->System.out.println(e));		
	}
	
	public static void ejemploEquipos() {
		Equipo barsa = new Equipo();
		barsa.setNombre("F.C. Barcelona");
		barsa.setPresupuesto(400000000);
		Estadio campNou = new Estadio();  // Creo el estadio y le doy datos
		campNou.setNombre("Spotify Camp Nou");
		campNou.setCapacidad(100000);
		barsa.setEstadio(campNou);	// asigno el estadio al equipo
		List<Jugador> jugadoresBarsa = new ArrayList<Jugador>();  // Creo la lista y le meto jugadores
		jugadoresBarsa.add(new Jugador("Fran",45,100000));
		jugadoresBarsa.add(new Jugador("Paco",70,200000));
		jugadoresBarsa.add(new Jugador("Dani",42,300000));
		jugadoresBarsa.add(new Jugador("Consu",39,400000));
		barsa.setJugadores(jugadoresBarsa);
		System.out.println("Fin de la creación del equipo");
		// Imprimpo el equipo
		//System.out.println(barsa);
		
		// Probamos el constructor de copia
		Equipo madrid = new Equipo(barsa);
		madrid.setNombre("Real Madrid");
		madrid.setPresupuesto(100000);
		barsa.getEstadio().setNombre("Nuevo Campo");  // Le cambio el nombre del estadio del barsa
		madrid.getEstadio().setNombre("Santiago Bernabeu");
		madrid.getEstadio().setCapacidad(80000);
		// Accede al equipo, luego a su lista de jugadores, luego a su primer elemento de la lista y luego le cambia el nombre
		barsa.getJugadores().get(0).setNombre("Francisco");  
		madrid.getJugadores().get(1).setNombre("Ate");
		
		// Impresión de los equipos
		System.out.println(barsa);  // Imprimo el Barsa
		System.out.println(madrid);	// Imprimo el Madrid	
	}
	
	public static void ejercicio2() {
		// Creo una lista vacía para almacenar los jugadores
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Jugador jugador1 = new Jugador("Fran", 45, 50000);
		Jugador jugador2 = new Jugador("David", 20, 60000);
		jugadores.add(jugador1);  // jugador que ocupa la posición 0 de la lista
		jugadores.add(jugador2); // jugador que ocupa la posición 1 de la lista
		jugadores.add(null);     // jugador que ocupa la posición 2 de la lista
		jugadores.add(null);	 // jugador que ocupa la posición 3 de la lista
		Jugador jugador4 = new Jugador("Paco", 45, 50000);
		Jugador jugador5 = new Jugador("Luis", 20, 60000);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		//System.out.println(jugadores);
		
		// Programación estructurada
		/*for(Jugador jugador : jugadores) {
			//System.out.println(jugador);
			try {
				System.out.println(jugador.getNombre());
			} catch (Exception e) {
				System.out.println("Este jugador es un nulo");
			}
		}*/
		// Programación estructurada
		/*for(Jugador jugador : jugadores) {
			//System.out.println(jugador);
			if(jugador!=null)
				System.out.println(jugador.getNombre());			
		}*/

		jugadores.stream()
			.filter(e->e!=null)  // filtro para no trabajar con los nulos
			.forEach(e->System.out.println(e.getNombre()));  // obtengo el nombre de los que quedan

		/*
		jugadores.stream()
			.forEach(e->{
				if(e!=null)
					System.out.println(e.getNombre());
			}); */
		/*
		jugadores.stream()
			.forEach(e->System.out.print((e!=null)?e.getNombre() + "\n":""));
		*/
	}
	
	public static void falloSiNoSeCorrige() {
		Equipo equipo = new Equipo();
		Jugador fran = new Jugador("Fran", 45, 50000);
		equipo.getJugadores().add(fran);
		equipo.getEstadio().setNombre("Mi estadio");
		System.out.println("Fin del programa");
	}
	
	public static void ejercicio3() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Jugador jugador1 = new Jugador("Fran", 45, 50000);
		Jugador jugador2 = new Jugador("David", 20, 60000);
		jugadores.add(jugador1);  // jugador que ocupa la posición 0 de la lista
		jugadores.add(jugador2); // jugador que ocupa la posición 1 de la lista
		jugadores.add(null);     // jugador que ocupa la posición 2 de la lista
		jugadores.add(null);	 // jugador que ocupa la posición 3 de la lista
		Jugador jugador4 = new Jugador("Paco", 45, 50000);
		Jugador jugador5 = new Jugador("Luis", 20, 60000);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		List<Jugador> jugadores2 = new ArrayList<Jugador>();//La segunda lista inicialmente esta vacia.
		//Copiar una lista a partir de otroa con programacion estructurada
		for(Jugador jugador : jugadores){
			if(jugador!=null)
				jugadores2.add(new Jugador(jugador));
			else
				jugadores2.add(null);
		}
		jugadores2.get(0).setNombre("Posicion 0");
		System.out.println(jugadores);
		System.out.println(jugadores2);
	}
	
	public static void ejercicio4() {
		Equipo equipo = new Equipo();
		equipo.setNombre("Equipo Coast");
//		equipo.setJugadores(null);
		equipo.addJugador(new Jugador("Jorge",23,100000));
		System.out.println(equipo);
	}
	
	public static void main(String[] args) {
		//ejemplosCoches();
		//ejercicio1();	
		//ejemploListaJugadores();
//		ejercicio2();
//		ejemploEquipos();
//		ejercicio3();
		ejercicio4();
	}
}
