package poo1;

import java.util.ArrayList;
import java.util.List;

public class Ejemplos {

	static List<Jugador> jugadoresGlobal = new ArrayList<Jugador>();

	public static void ejemplosCoches() {
		Coche miCoche = new Coche(); // Me crea un coche sin datos. Usa el constructor vacío
		// miCoche.numeroRuedas = -4;
		// miCoche.marca = "Seat";
		// miCoche.modelo = "Altea";
		miCoche.setNumeroRuedas(6);
		miCoche.setMarca("Seat");
		miCoche.setModelo("Altea");
		miCoche.setPrecio(10000);
		miCoche.setMatricula("0000-AAA");
		System.out.println(miCoche); // Estamos probando el toString
		System.out.println("Mi coche es un " + miCoche.getMarca() + " " + miCoche.getModelo() + " Con matrícula: "
				+ miCoche.getMatricula());

		// Vamos a probar el constructor con parámetros
		Coche z3 = new Coche(40, "Bmw", "Z3", "1111-BBB", -20000);
		System.out.println(z3);
		System.out.println("Mi nuevo coche es un " + z3.getMarca() + " " + z3.getModelo() + " Con matrícula: "
				+ z3.getMatricula());

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
		Coche intentoClon = z3; // Esto no crea un nuevo coche, al coche existente ahora se le puede llamar de
								// dos formas
		z3.setPrecio(5000);
		intentoClon.setNumeroRuedas(5);
		System.out.println("Voy a imprimir el intentoClon:");
		System.out.println(intentoClon);
		System.out.println(z3);

		// Probar Equals

		if (z3.equals(intentoClon)) {
			System.out.println("Los coches son iguales");
		} else {
			System.out.println("Los coches son diferentes");
		}

		if (tercero.esCaro()) {
			System.out.println("Mi coche es caro");
		} else {
			System.out.println("Mi coche es barato");
		}

	}

	public static void ejercicio1() {
		Jugador jugador1 = new Jugador("Fran", 45, 50000);
		Jugador jugador2 = new Jugador("David", 20, 60000);
		System.out.println(jugador1.toString());
		System.out.println(jugador2);
	}

	public static void ejercicio2() {
		// Creo una lista vacía para almacenar los jugadores
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Jugador jugador1 = new Jugador("Fran", 45, 50000);
		Jugador jugador2 = new Jugador("David", 20, 60000);
		jugadores.add(jugador1); // jugador que ocupa la posición 0 de la lista
		jugadores.add(jugador2); // jugador que ocupa la posición 1 de la lista
		jugadores.add(null); // jugador que ocupa la posición 2 de la lista
		jugadores.add(null); // jugador que ocupa la posición 3 de la lista
		Jugador jugador4 = new Jugador("Paco", 45, 50000);
		Jugador jugador5 = new Jugador("Luis", 20, 60000);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		// System.out.println(jugadores);

		// Programación estructurada
		/*
		 * for(Jugador jugador : jugadores) { //System.out.println(jugador); try {
		 * System.out.println(jugador.getNombre()); } catch (Exception e) {
		 * System.out.println("Este jugador es un nulo"); } }
		 */
		// Programación estructurada
		/*
		 * for(Jugador jugador : jugadores) { //System.out.println(jugador);
		 * if(jugador!=null) System.out.println(jugador.getNombre()); }
		 */

		jugadores.stream().filter(e -> e != null) // filtro para no trabajar con los nulos
				.forEach(e -> System.out.println(e.getNombre())); // obtengo el nombre de los que quedan

		/*
		 * jugadores.stream() .forEach(e->{ if(e!=null)
		 * System.out.println(e.getNombre()); });
		 */
		/*
		 * jugadores.stream() .forEach(e->System.out.print((e!=null)?e.getNombre() +
		 * "\n":""));
		 */
	}

	public static void ejercicio3() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Jugador jugador1 = new Jugador("Fran", 45, 50000);
		Jugador jugador2 = new Jugador("David", 20, 60000);
		jugadores.add(jugador1); // jugador que ocupa la posición 0 de la lista
		jugadores.add(jugador2); // jugador que ocupa la posición 1 de la lista
		jugadores.add(null); // jugador que ocupa la posición 2 de la lista
		jugadores.add(null); // jugador que ocupa la posición 3 de la lista
		Jugador jugador4 = new Jugador("Paco", 45, 50000);
		Jugador jugador5 = new Jugador("Luis", 20, 60000);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		List<Jugador> jugadores2 = new ArrayList<Jugador>(); // La segunda lista inicialmente está vacía
		// Copiar una lista a partir de otra con programación estructurada
		for (Jugador jugador : jugadores) {
			if (jugador != null)
				jugadores2.add(new Jugador(jugador));
			else
				jugadores2.add(null);
		}
		/*
		 * jugadores.stream().forEach(e->{ if(e!=null) jugadores2.add(new Jugador(e));
		 * else jugadores2.add(null); });
		 */
		jugadores2.get(0).setNombre("Posición 0");
		System.out.println(jugadores);
		System.out.println(jugadores2);
	}

	/**
	 * Crea una clase llamada Equipo que tenga una lista (private) con los
	 * jugadores. Crea los métodos en la clase Equipo: constructor vacío →
	 * Inicializa la lista addJugador(Jugador) → Añade el jugador a la lista interna
	 * getNumJugadores() → Devuelve la cantidad de jugadores que hay getJugador(pos)
	 * → Devuelve el jugador de esa posición de la lista. Si no existe devuelve null
	 * deleteJugador(pos) → Borra el jugador de esa posición (si existe)
	 * totalSueldos() → Devuelve la suma de los sueldos de los jugadores del equipo
	 */
	public static void ejercicio4() {
		Equipo equipo = new Equipo();
		equipo.setNombre("Equipo EOI");
		equipo.addJugador(new Jugador("Fran", 25, 100000)); // añade jugadores a la lista
		equipo.addJugador(new Jugador("Paco", 25, 100000));
		equipo.addJugador(new Jugador("Luis", 25, 100000));
		equipo.addJugador(new Jugador("Jose", 25, 100000));
//		equipo.deleteJugador(0); // borra el primer elemento
		equipo.getJugadores().forEach(e -> System.out.println(e)); // Muestra todos los jugadores de la lista
		System.out.println("El sueldo de todos los jugadores es: " + equipo.totalSueldos());
	}

	/*
	 * public static void ejercicio4ampliacionConceptoNoVoid() { Equipo equipo = new
	 * Equipo(); equipo.setNombre("Equipo EOI"); //equipo.setJugadores(null);
	 * if(equipo.addJugador(new Jugador("Fran",25,100000)))
	 * System.out.println(equipo); else
	 * System.out.println("No se ha podido añadir el jugador"); }
	 */

	public static void ejercicio1Ampliado() {
		// Scanner sc = new Scanner(System.in);
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
		/*
		 * int edad; do {
		 * System.out.println("Introduzca la edad (la edad debe ser mayor o igual a 0):"
		 * ); edad = Integer.parseInt(sc.nextLine()); } while (edad<0);
		 * System.out.println("Salgo del bucle con edad = " + edad); if(edad>0) {
		 * Jugador jugador11 = new Jugador("Paco",edad,1000); } else {
		 * System.out.println("Ha introducido una edad errónea"); }
		 */
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
		jugadores.add(new Jugador("Naomi", 20, 80000));

		// Imprmir todos los jugadores
		jugadores.forEach(e -> System.out.println(e));
		jugadores.forEach(e -> System.out.println(e.nombreOculto() + " gana " + e.getSueldo()));
		// Filtra e imprime:
		System.out.println("Jugadores que ganan más de 60000 euros");
		jugadores.stream().filter(e -> e.getSueldo() > 60000).forEach(e -> System.out.println(e));
		// Filtra e imprime:
		System.out.println("Jugadores que ganan entre 50000 y 70000 euros y su nombre tenga más de 5 letras");
		jugadores.stream().filter(e -> e.getSueldo() >= 50000 && e.getSueldo() <= 70000)
				.filter(e -> e.getNombre().length() > 5).forEach(e -> System.out.println(e));
		// Filtra e imprime:
		System.out.println("Jugadores que tengan una 'N' en su nombre");
		jugadores.stream().filter(e -> e.getNombre().toLowerCase().contains("n")).forEach(e -> System.out.println(e));
	}

	public static void ejemploEquipos() {
		Equipo barsa = new Equipo();
		barsa.setNombre("F.C. Barcelona");
		barsa.setPresupuesto(400000000);
		Estadio campNou = new Estadio(); // Creo el estadio y le doy datos
		campNou.setNombre("Spotify Camp Nou");
		campNou.setCapacidad(100000);
		barsa.setEstadio(campNou); // asigno el estadio al equipo
		List<Jugador> jugadoresBarsa = new ArrayList<Jugador>(); // Creo la lista y le meto jugadores
		jugadoresBarsa.add(new Jugador("Fran", 45, 100000));
		jugadoresBarsa.add(new Jugador("Paco", 70, 200000));
		jugadoresBarsa.add(new Jugador("Dani", 42, 300000));
		jugadoresBarsa.add(new Jugador("Consu", 39, 400000));
		barsa.setJugadores(jugadoresBarsa);
		System.out.println("Fin de la creación del equipo");
		// Imprimpo el equipo
		// System.out.println(barsa);

		// Probamos el constructor de copia
		Equipo madrid = new Equipo(barsa);
		madrid.setNombre("Real Madrid");
		madrid.setPresupuesto(100000);
		barsa.getEstadio().setNombre("Nuevo Campo"); // Le cambio el nombre del estadio del barsa
		madrid.getEstadio().setNombre("Santiago Bernabeu");
		madrid.getEstadio().setCapacidad(80000);
		// Accede al equipo, luego a su lista de jugadores, luego a su primer elemento
		// de la lista y luego le cambia el nombre
		barsa.getJugadores().get(0).setNombre("Francisco");
		madrid.getJugadores().get(1).setNombre("Ate");

		// Impresión de los equipos
		System.out.println(barsa); // Imprimo el Barsa
		System.out.println(madrid); // Imprimo el Madrid
	}

	public static void falloSiNoSeCorrige() {
		Equipo equipo = new Equipo();
		Jugador fran = new Jugador("Fran", 45, 50000);
		equipo.getJugadores().add(fran);
		equipo.getEstadio().setNombre("Mi estadio");
		System.out.println("Fin del programa");
	}

	public static void ejemploNaomi() {
		// Lista original
		List<Jugador> players = new ArrayList<Jugador>();
		Jugador naomi = new Jugador("Naomi", 20, 48050);
		Jugador luna = new Jugador("Luna", 20, 90050);
		Jugador jake = new Jugador("Jake", 20, 100050);
		Jugador dominique = new Jugador("Dominique", 20, 60050);
		players.add(naomi);
		players.add(luna);
		players.add(jake);
		players.add(dominique); // La lista con los 4 jugadores dentro
		System.out.println("Por el momento hay " + Jugador.getContador() + " jugadores");
		// Lista copia -> Esto no
		/*
		 * List<Jugador> clonedJugadors = new ArrayList<Jugador>(players); // No hace
		 * una lista de datos independientes clonedJugadors.get(0).setNombre("Fran");
		 * System.out.println("El clon tiene:");
		 * clonedJugadors.forEach(e->System.out.println(e));
		 * System.out.println("El original tiene:");
		 * players.forEach(e->System.out.println(e));
		 */
		// Segundo intento, crear una lista clonada a partir de la original -> Fallo de
		// nuevo
		/*
		 * List<Jugador> clonedJugadors2 = new ArrayList<Jugador>();
		 * clonedJugadors2.addAll(players); clonedJugadors2.get(0).setNombre("Fran");
		 * System.out.println("El clon tiene:");
		 * clonedJugadors2.forEach(e->System.out.println(e));
		 * System.out.println("El original tiene:");
		 * players.forEach(e->System.out.println(e));
		 */
		List<Jugador> clonedJugadors3 = new ArrayList<Jugador>();

		// players.forEach(e->clonedJugadors3.add(new Jugador(e))); // Funcional

		for (Jugador e : players) { // Estructurada
			clonedJugadors3.add(new Jugador(e));
		}

		clonedJugadors3.get(0).setNombre("Fran");
		System.out.println("El clon tiene:");
		clonedJugadors3.forEach(e -> System.out.println(e));
		System.out.println("El original tiene:");
		players.forEach(e -> System.out.println(e));
		System.out.println("Por el momento hay " + Jugador.getContador() + " jugadores");

		/*
		 * clonedJugadors.addAll(players); Jugador clonNaomi = new Jugador(naomi);
		 * Jugador clonLuna = new Jugador(luna); Jugador clonJake = new Jugador(jake);
		 * Jugador clonDominique = new Jugador(dominique); clonJake.setNombre("Nick");
		 * players.add(clonNaomi); players.add(clonLuna); players.add(clonJake);
		 * players.add(clonDominique); players.stream()
		 * .forEach(e->System.out.println(e));
		 */
	}

	public static void global1() {
		jugadoresGlobal.add(new Jugador("Fran", 25, 10000));
	}

	public static void global2() {
		jugadoresGlobal.add(new Jugador("Otro", 30, 10000));
	}

	public static void ejemplosHerencias() {
		//Animal animal = new Animal("Mi animal",10);  // Falla al ser clase Abstracta
		
		Ave pajaro = new Ave(true);
		Ave gallina = new Ave("Animal desconocido", 1, false);

		
		
		//animal.comer();
		
		//pajaro.comer();
		pajaro.ponerHuevos();

		System.out.println("El pájaro se llama : " + pajaro.getNombre());
		
		Mamifero leon = new Mamifero("León", 210, true);
		
		leon.comer();
		System.out.println(pajaro.toString());
		System.out.println(leon.toString());
		Mamifero gato = new Mamifero("Animal desconocido",1,true);
		
		if(pajaro.equals(gallina)) {
			System.out.println("El pájaro es igual a la gallina");
		} else {
			System.out.println("El pájaro y la gallina no son iguales");
		}
		
		// Aquí aunque se llaman igual y pesan lo mismo y son animales
		// los detecta diferente porque son de distinta clase.
		if(pajaro.equals(gato)) {
			System.out.println("El pájaro es igual al gato");
		} else {
			System.out.println("El pájaro y el gato no son iguales");
		}
			
		List<Animal> animales = new ArrayList<Animal>();
		animales.add(gallina);
		animales.add(pajaro);
		animales.add(leon);
		animales.forEach(e->System.out.println(e.toString()));  // Aquí hay polimorfismo.
		animales.forEach(e->System.out.println(e.rugido())); // Aquí también.
		
		System.out.println("Ejemplo instanceof:");
		for(Animal animal : animales) {
			// La siguiente línea fallaría en los animales que no fuesen Ave. Debe ponerse dentro de un if con el instanceof
			//System.out.println("El número de pollitos es: " + ((Ave)animal).pollitos(animal.getNombre()));
			if(animal instanceof Ave) {
				System.out.println("El número de pollitos es: " + ((Ave)animal).pollitos(animal.getNombre()));
				System.out.println(animal.rugido());
			} else if(animal instanceof Mamifero) {
				System.out.println(animal.rugido());
			}		
		}
			
		
	}

	public static void ej1y2deHerencia() {
		TiendaLicores tiendaLicores = new TiendaLicores();
		tiendaLicores.bienvenida();
	}
	
	public static void main(String[] args) {
		// ejemplosCoches();
		// ejercicio1Ampliado();
		// ejemploListaJugadores();
		// ejemploEquipos();
		// ejercicio1();
		// ejercicio2();
		// ejercicio3();
		// falloSiNoSeCorrige();
		// ejemploNaomi();

		// global1();
		// global2();
		// jugadoresGlobal.forEach(e->System.out.println(e));
		// ejercicio4();
//		ejemplosHerencias();
		ej1y2deHerencia();
	}

}
