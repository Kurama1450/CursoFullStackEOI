package com.nestorcosta.anotaciones2;

import java.util.HashSet;

import com.nestorcosta.anotaciones2.entidades.Autores;
import com.nestorcosta.anotaciones2.entidades.Libros;
import com.nestorcosta.anotaciones2.utilidades.HibernateUtils;

public class App 
{
	
	public static void mostrarLibros() {
		HibernateUtils.openSession();
		HibernateUtils.devolverListadeObjetos("Libros")
		.forEach(e->System.out.println(e));//Hibernate  < 6 6.0
		HibernateUtils.closeSession();
	}
	
	public static void mostrarAutores() {
		HibernateUtils.openSession();
		HibernateUtils.devolverListaObjetos(Autores.class)
		.forEach(e->System.out.println(e));//Hibernate >= 6 6.0
		HibernateUtils.closeSession();
	}
	
	public static void anyadirAutor() {
		if(HibernateUtils.save(new Autores("NC","Provi",new HashSet<Libros>(0)))) {
			System.out.println("Se ha añadido correctamente");
		} else {
			System.out.println("Ha fallado al añadir el nuevo autor");
		}
	}
	
	public static void modificarAutor() {
		HibernateUtils.update(Autores.class," nombre='Prove'", new Autores(null,"UpdateGeneric",null));
	}
	
	public static void modificarLibro() {
		HibernateUtils.update(Libros.class, "id=2", new Libros(2,"Manual EOI",null));
	}
	
	public static void borrarAutor() {
		int registrosBorrados = HibernateUtils.delete(Autores.class, "cod='AAAAB'");
		System.out.println("Se han borrado " + registrosBorrados + " registros");
	}
	
    public static void main( String[] args )
    {
    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
    	//mostrarLibros();
    	HibernateUtils.openSession();
    	//mostrarAutores();
    	//anyadirAutor();
    	//mostrarAutores();
    	//modificarAutor();
    	//mostrarAutores();
    	//modificarLibro();
    	//mostrarLibros();
    	borrarAutor();
    	mostrarAutores();
    	HibernateUtils.closeSession();
    }
}
