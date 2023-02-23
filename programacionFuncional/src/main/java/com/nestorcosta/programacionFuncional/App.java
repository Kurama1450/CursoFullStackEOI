package com.nestorcosta.programacionFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import com.nestorcosta.programacionFuncional.entidades.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
	static List<Usuario> usuarios = new ArrayList<Usuario>();//Creamos una lista de Usuarios para guardar a los usuarios.
	
	public static void poblar() {//tearUp (Meter datos)
		usuarios.clear();
		usuarios.add(new Usuario(1,"Fran",30000));
		usuarios.add(new Usuario(2,"Ángel",20000));
		usuarios.add(new Usuario(3,"Miguel Ángel",40000));
		usuarios.add(new Usuario(4,"David",30000));
		usuarios.add(new Usuario(5,"Enrique",50000));
		usuarios.add(new Usuario(6,"Naomi",-30000));
		usuarios.add(new Usuario(1,"Fran",30000));
		usuarios.add(new Usuario(7,"Francisco",100000));
	}
	
	public static void descargar() {//tearDown
		usuarios.clear();
	}
	
	public static void forEach() {//Metodo prueba de programacion funcinal del forEach
		//Metodo Final
		
		//if de toda la vida.Recorrer la lista
		for(int i = 0; i<usuarios.size();i++) {
			System.out.println(i + ". " + usuarios.get(i).toString());//Imprimimos los datos de la lista con sus elementos.
		}
		//Bucle for-each
		for(Usuario usuario:usuarios) {
			System.out.println(usuario);
		}
		
		//Programacion fucional
		usuarios.forEach(e->System.out.println(e));
		
		usuarios.forEach(System.out::println);
		
		usuarios.stream().forEach(e->System.out.println(e));
	}
	
	public static void filter() {//Permite filtrar los elementos de una lista
		//No final
		usuarios.stream().filter(e->e.getSueldo()>30000)
		.forEach(e->System.out.println(e));
		
		usuarios.stream().filter(e->e.getSueldo()>30000 && e.getSueldo()<50000)
		.forEach(e->System.out.println(e));
		
		//Creamos una sublista con los usuarios ricos
		List<Usuario> ricos = usuarios.stream()
				.filter(e->e.getSueldo()>=50000)
				.collect(Collectors.toList());
		System.out.println("Los ricos son: ");
		ricos.forEach(e->System.out.println(e));
	}
	
	public static void map() {//A partir de una lista nos quedamos con parte de los objetos.
		//No final
		//Crea una lista con los nombres de los usuarios
		List<String> nombres = usuarios.stream().map(e->e.getNombre())//Se queda solamente con los nombres
		.collect(Collectors.toList());
		
		nombres.forEach(e->System.out.println(e));
		
		//Crea una lista de los ids de los usuarios que ganen más de 40000.
		 usuarios.stream()
		.filter(e->e.getSueldo()>40000)
		.mapToInt(e->e.getId())//Me quedo con los ids
		.filter(e->e<6)//Aqui recorremos ids no usuarios
		.forEach(e->System.out.println(e));
		 
		 //Crea una lista de los nombres distintos
		 Set<String> nombresDistintos = usuarios.stream()
				 .map(e->e.getNombre())//Se queda solamente con los nombres
				 .collect(Collectors.toSet());
				System.out.println("Nombres distintos");
				nombresDistintos.forEach(e->System.out.println(e));
	}
	
	public static void toSet() {//Creacion de listas de elementos no duplicados
		//Final
		Set<Usuario> usuariosDistintos = usuarios.stream()
		.collect(Collectors.toSet());
		usuariosDistintos.forEach(e->System.out.println(e));
	}
	
	public static void sumAVG() {//Sum suma todos los valores, Average saca la media
		//Finales
		//Suma de todos los sueldos.
    	double sumaSueldos = usuarios.stream()
    	.mapToDouble(e->e.getSueldo())//Me quedo solo con los sueldos y los sumo
    	.sum();
    	System.out.println("La suma de todos los sueldos es: " +sumaSueldos);
    	
    	//Media de los sueldos
    	//Los Optinal son datos que pueden contener valor o no.
    	OptionalDouble mediaOpcional = usuarios.stream()
    	.mapToDouble(e->e.getSueldo())
    	.average();
    	System.out.println("La media de todos los sueldos es: " +mediaOpcional.getAsDouble());
    	
    	descargar();
    	OptionalDouble mediaOpcional2 = usuarios.stream()
    	    	.mapToDouble(e->e.getSueldo())
    	    	.average();
    			if(mediaOpcional2.isPresent())
    				System.out.println("La media de todos los sueldos es: " +mediaOpcional2.getAsDouble());
    			else
    				System.out.println("La lista esta vacia y por lo tanto no hay media");
    			
    			poblar();
    			double mediaSegura = usuarios.stream()
    					.mapToDouble(e->e.getSueldo())
    					.average().orElse(0);//Da valor por defecto en caso de estar la lista vacia
    			System.out.println("La media segura es: " + mediaSegura);
    			
    }
	
	public static void find() {//Busca dentro de la lista
		//Final
		//Quédate con el primer usuario que gane másde 45000 de sueldo
		//Con Optional
		Optional<Usuario> usuario = usuarios.stream()
		.filter(e->e.getSueldo()>45000)
		.findFirst();
		if(usuario.isPresent())
			System.out.println("El primer usuario que gana más de 45000 es: " +usuario.get().getNombre());
		else
			System.out.println("Nadie gana esa cantidad");
		
		//Sin optional
		Usuario usuario2 = usuarios.stream()
				.filter(e->e.getSueldo()>45000)
				.findFirst().orElse(null);
		if(usuario2!=null)
			System.out.println(usuario2.getNombre());
		
		Usuario usuario3 = usuarios.stream()
				.filter(e->e.getSueldo()>45000)
				.findFirst().orElse(new Usuario(1,"Sin datos",0));
		
			System.out.println(usuario3.getNombre());
			
		//findAny -> Te devuelve alguno , no sabemos cual
			Usuario usuario4 = usuarios.stream()
					.filter(e->e.getSueldo()>45000)
					.findAny().orElse(new Usuario(1,"Sin datos",0));
			
				System.out.println(usuario4.getNombre());
	}
	
	public static void flatMap() {//A partir de una lista de listas las juntas y las concatena en una única lista
		//No final
		List<String> clase1 = new ArrayList<String>(Arrays.asList("Fran","Dani"));
		List<String> clase2 = new ArrayList<String>(Arrays.asList("Paco","Pepe"));
		List<List<String>> todasClases = new ArrayList<List<String>>(Arrays.asList(clase1,clase2));
		
		List<String> todosAlumnos = todasClases.stream()
		.flatMap(e->e.stream())//Te permite unir todas las sublistas en una única lista.
		.collect(Collectors.toList());
		todosAlumnos.forEach(e->System.out.println(e));
	}
	
	public static void peek() {//Lo mismo que el forEach pero no final
		//No final
		
		//Aumenta todos los sueldos 1000 euros e imprime de nuevo los usuarios
		usuarios.stream()
		.peek(e->e.setSueldo(e.getSueldo()+1000))
		.forEach(e->System.out.println(e));
	}
	
	public static void partitioningBy() {//Parte la lista original en 2 sublistas.Una que cumple la condicion y otra que no.
		Map<Boolean,List<Usuario>> sublistas =usuarios.stream()
		.collect(Collectors.partitioningBy(e->e.getSueldo()>35000));
		
		//La sublista de los que ganan mas de 35000
		System.out.println("Ganan más de 35000: ");
		sublistas.get(true).forEach(e->System.out.println(e));
		
		//La sublista de los que no ganan mas de 35000
				System.out.println("Ganan menos de 35000: ");
				sublistas.get(false).forEach(e->System.out.println(e));
	}
	
	public static void groupingBy() {//Agrupar por la condición que le digamos . Tendremos tantas listas como posibilidades haya.
		Map<Character,List<Usuario>> agenda = usuarios.stream()
		.collect(Collectors.groupingBy(e->e.getNombre().charAt(0)));//Agrupame por la primera letra del nombre
		
		if(agenda.containsKey('F')) {
			agenda.get('F').forEach(e->System.out.println(e));
		}
		
		//Recorrer todas las sublistas de cada una de las letras.
		for(int i = (int)'A';i<=(int)'Z';i++) {//Recorrer las letras del abecedario
			if(agenda.containsKey((char)i)) {//Solo para las listas que existan
				System.out.println("Lista de la " + (char)i);
				agenda.get((char)i).forEach(e->System.out.println(e));
			}
		}
	}
	
	public static void count() {//Cuenta el numero de elementos.
		//Final
		Long numRicos = usuarios.stream()
				.filter(e->e.getSueldo()>40000)
				.count();
		System.out.println("El numero de ricos son: " +numRicos);
	}
	
	public static void skipYLimit() {//Skip sirve para saltar resultados y el limit para limitar el numero de resultados.
		//No son finales
		
		//Saca los usuarios 3,4 y 5 que más ganan de la empresa.
		usuarios.stream()
		.sorted(Comparator.comparingDouble(Usuario::getSueldo).reversed())//Ordeno los usuarios por sueldo en orden de mayor a menor.
		.skip(2) //Saltate los dos primeros
		.limit(3) //Limitate a devolverle solamente 3 usuarios
		.forEach(e->System.out.println(e));
	}
	
	public static void maxMin() {//Devolverian el maximo y el minimo en base a un criterio de comparacion
		//Queremos obtener el usuario con id más bajo y el de id más alto de la lista de usuarios.
		Optional<Usuario> masgana = usuarios.stream()
		.max(Comparator.comparingInt(Usuario::getId));
		if(masgana.isPresent())
			System.out.println("El usuario con ID más alto es: " +masgana.get().getNombre());
		
		Optional<Usuario> menosgana = usuarios.stream()
				.min(Comparator.comparingInt(Usuario::getId));
				if(menosgana.isPresent())
					System.out.println("El usuario con ID más bajo es: " +menosgana.get().getNombre());
	}
	
	public static void distinct() {//Saca elementos distintos de la lista
		//No final
		
		//¿Cuantos usuarios distintos hay?
		System.out.println("El numero de usuarios distintos es: " +usuarios.stream().distinct().count());
		
		//Obten una lista a partir de la original eliminando los duplicados.
		List<Usuario> usuariosDistintos = usuarios.stream()
		.distinct()
		.collect(Collectors.toList());
		
		//Dime los distintos sueldos que hay en la empresa.
		System.out.println("La lista de sueldos distintos es: ");
		usuarios.stream()
		.mapToDouble(Usuario::getSueldo)
		.sorted()
		.distinct()
		.forEach(e->System.out.println(e));
		
		//Dime los diferentes nombres de los empleados
		System.out.println("La lista de nombres distintos es: ");
		usuarios.stream()
		.map(e->e.getNombre())
		.distinct()
		.forEach(e->System.out.println(e));
	}
	/**
	 * Todos devuelven booleanos.
	 *  anyMatch . True si existe alguno que cumpla la condición.
	 *  allMatch.True si todos cumplen con la condicion.
	 *  noneMatch.True si ninguno cumple la condicion.
	 */
	public static void match() {
		//Finales
		
		//Existe algún usuario que gane más de 100000 Euros?
		boolean alguienSuperRico = usuarios.stream()
		.anyMatch(e->e.getSueldo()>100000);
		
		//Todos ganan un sueldo positivo
		boolean todosCobran = usuarios.stream()
				.allMatch(e->e.getSueldo()>0);
		
		//No hay nadie que gane menos de 0?
		boolean todosCobran2 = usuarios.stream()
				.noneMatch(e->e.getSueldo()<0);
		
		System.out.println(alguienSuperRico + " " + todosCobran + " " +todosCobran2);
	}
	
	public static void summarizingDouble() {//Saca valores estadísticos para campos numericos
		//Final
		DoubleSummaryStatistics estadisticas = usuarios.stream()
		.collect(Collectors.summarizingDouble(Usuario::getSueldo));
		
		System.out.println("Media: " +estadisticas.getAverage());
		System.out.println("Sueldo Máximo: " +estadisticas.getMax());
		System.out.println("Sueldo Mínimo: " +estadisticas.getMin());
		System.out.println("Suma: " +estadisticas.getSum());
		System.out.println("Número: " +estadisticas.getCount());
	}
	
	public static void reduce() {//Cuando quieres reducir los datos que tengamos a un UNICO valor.
		//Final
		
		//Multiplica todos los ids
		int idMultiplicados = usuarios.stream()
		.mapToInt(e->e.getId())
		.reduce(1, (a,b)->a*b);
		
		System.out.println("La multiplicación de los ids es: " + idMultiplicados);
		
		//Crea una variable con todos los nombres de los usuarios, uno en cada línea.
		String dosPrimerasLetras = usuarios.stream()
		.map(e->e.getNombre())
		.reduce("",(a,b)->a.concat(b).concat("\n"));
		System.out.println(dosPrimerasLetras);
	}
	
	public static void joining() {//Une elementos y le puedes poner un separador
		//Final
		String nombresDistintosMinusculasOrdenadosSeparadosComas = usuarios.stream()
				.map(e->e.getNombre().toLowerCase())
				.distinct()
				.sorted()
				.collect(Collectors.joining(", "));
		
		System.out.println(nombresDistintosMinusculasOrdenadosSeparadosComas);
	}
	/**
	 * Es igual a stream pero utilizando procesamiento paralelo. 
	 * Nos aprovechamos de los nucleos de nuestro ordeandor.
	 */
	public static void parallelStream() {
		long tiempoInicial = System.currentTimeMillis();
		usuarios.forEach(e->convertirMayusculas(e.getNombre()));
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("El tiempo de la operación ha sido: " +(tiempoFinal-tiempoInicial));
		
		//En paralelo
		tiempoInicial = System.currentTimeMillis();
		usuarios.parallelStream().forEach(e->convertirMayusculas(e.getNombre()));
		tiempoFinal = System.currentTimeMillis();
		System.out.println("El tiempo de la operación en paralelo ha sido: " +(tiempoFinal-tiempoInicial));
	}
	
	public static String convertirMayusculas(String nombre) {
		//Este metodo que simula una operacion que tarda un segundo y pico en realizarse.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
	
    public static void main( String[] args )
    {
    	poblar();//Dar datos iniciales
        //forEach();//Luego recorrerla
    	//filter();
    	//map();
    	//toSet();
    	//sumAVG();
    	//find();
    	//flatMap();
    	//peek();
    	//partitioningBy();
    	//groupingBy();
    	//count();
    	//skipYLimit();
    	//maxMin();
    	//distinct();
    	//match();
    	//summarizingDouble();
    	//reduce();
    	//joining();
    	parallelStream();
    }
    
    
}
