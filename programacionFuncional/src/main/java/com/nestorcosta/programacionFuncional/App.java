package com.nestorcosta.programacionFuncional;

import java.util.ArrayList;
import java.util.List;
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
	
    public static void main( String[] args )
    {
    	poblar();//Dar datos iniciales
        //forEach();//Luego recorrerla
    	filter();
    }
}
