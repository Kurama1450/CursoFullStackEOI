package com.nestorcosta.programacionFuncional;

import java.util.ArrayList;
import java.util.List;
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
	}
	
    public static void main( String[] args )
    {
    	poblar();//Dar datos iniciales
        //forEach();//Luego recorrerla
    	//filter();
    	//map();
    	//toSet();
    	//sumAVG();
    	find();
    }
    
    
}
