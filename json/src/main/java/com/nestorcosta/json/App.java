package com.nestorcosta.json;

import java.util.ArrayList;
import java.util.List;

import com.nestorcosta.json.entidades.Films;
import com.nestorcosta.json.entidades.People;
import com.nestorcosta.json.entidades.Posts;
import com.nestorcosta.json.utilidades.JsonUtils;

/**
 * 
 *
 */
public class App 
{
	static List<Posts> publicaciones = new ArrayList<Posts>();
	
    public static void main( String[] args )
    {
        //JsonUtils.leerJsonDesdeFichero("C:/Ficheros/profesor.json");
        //publicaciones = JsonUtils.leerPostsInternet("https://jsonplaceholder.typicode.com/posts");
        //publicaciones.stream()
        //.filter(e->e.getId()%2==0)//publicaciones pares
        //.forEach(e->System.out.println(e));
    	
    	//Leer personaje con gson
    	//People Luke = JsonUtils.leerPersonaje("https://swapi.dev/api/people/1?format=json");
    	//System.out.println(Luke);
    	
    	//Leer lista de Personajes
    	//List<People> personajes1al10=JsonUtils.leerPersonajes("https://swapi.dev/api/people/", 1, 10, "?format=json");
    	//personajes1al10.forEach(e->System.out.println(e));
    	//Devolver pelicula
    	/*
    	Films pelicula = JsonUtils.leerFilm("https://swapi.dev/api/films/1?format=json");
    	System.out.println(pelicula);*/
    	
    	/*People Luke = JsonUtils.leerObjeto("https://swapi.dev/api/people/1?format=json", People.class);
    	Films pelicula = JsonUtils.leerObjeto("https://swapi.dev/api/films/1?format=json", Films.class);
    	System.out.println(Luke);
    	System.out.println(pelicula);*/
    	
    	//Leer lista de peliculas utilizando genérico
    	List<Films> peliculas = JsonUtils.leerObjetos("https://swapi.dev/api/films/", 1, 5, "?format=json", Films.class);
    	peliculas.forEach(e->System.out.println(e));
    	//Leer lista de personajes utilizando genérico
    	List<People> personajes = JsonUtils.leerObjetos("https://swapi.dev/api/people/", 8, 14, "?format=json", People.class);
    	personajes.forEach(e->System.out.println(e));
    	//Leer lista de publicaciones utilizando genérico
        publicaciones = JsonUtils.devolverArrayGenerico("https://jsonplaceholder.typicode.com/posts",Posts[].class);
        publicaciones.stream()
        .filter(e->e.getId()%2==0)//publicaciones pares
        .forEach(e->System.out.println(e));
    }
}
