package com.nestorcosta.Biblioteca2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nestorcosta.Biblioteca2.entidades.Autores;
import com.nestorcosta.Biblioteca2.entidades.Libros;

public class App 
{
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void openSession() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        if(session!=null) {
        	System.out.println("Sesion abierta correctamente");
        }
        else {
        	System.out.println("Sesion fallida al abrir");
        }
	}
	
	public static void mostrarLibros() {
		List<Libros> libros = session.createSelectionQuery("from Libros ",Libros.class).list();
		libros.forEach(e->System.out.println("Nombre del libro: " + e.getTitulo() + " Nombre del autor: " + e.getAutores().getNombre()));
	}
	
	public static void mostrarAutores() {
		List<Autores> autores = session.createSelectionQuery("from Autores ",Autores.class).list();
		autores.forEach(e->System.out.println(e));
	}
	
	public static void ayadirAutor(String codigo, String nombre, Set<Libros> libros) {
		Transaction trans = session.beginTransaction();//Abrimos la transaccion
		Autores autor = new Autores(codigo,nombre,libros);
		session.persist(autor);//Antiguo save.
		trans.commit();//Confirmo los cambios en la transacción.
		session.clear();//Para que coja los datos de los set en tiempo real.
	}
	
	public static void ayadirLibro(int id, Autores autor,String nombre) {
		Transaction trans = session.beginTransaction();
		session.persist(new Libros(id,autor,nombre));
		trans.commit();
	}
	
    public static void main( String[] args )
    {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
    	openSession();
    	//mostrarLibros();
    	//mostrarAutores();
    	//ayadirAutor("AAAA", "Prueba", new HashSet<Libros>(0));
    	//ayadirLibro(6,new Autores("WSHAK"),"Libro Prueba");
    	mostrarLibros();
    }
}
