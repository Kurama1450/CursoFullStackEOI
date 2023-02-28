package com.nestorcosta.json;

import java.util.ArrayList;
import java.util.List;

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
    	People Luke = JsonUtils.leerPersonaje("https://swapi.dev/api/people/1?format=json");
    	System.out.println(Luke);
    }
}
