package com.nestorcosta.anotaciones1;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nestorcosta.anotaciones1.entidades.Autores;
import com.nestorcosta.anotaciones1.entidades.Libros;

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
	
	public static void closeSession() {
		sessionFactory.close();
		session.close();
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
	
	public static void updateAutor(String nombreAntiguo, String nombreNuevo) {
		// Busco que quiero actualizar
		List<Autores> autores = session.createSelectionQuery("from Autores where nombre='" + nombreAntiguo + "'",Autores.class).list();
		Transaction trans = session.beginTransaction();
		autores.forEach(e->{
			e.setNombre(nombreNuevo);
			session.merge(e);  // Hibernate <6.0 era update
		});  // Me actualiza los nombres en todos los resultados		
		trans.commit();
		session.clear();
	}
	
	public static void deleteLibro(int id) {
		List<Libros> libros = session.createSelectionQuery("from Libros where id=" + id ,Libros.class).list();
		if(libros.size()>0) {  // Ha encontrado el libro con esa ID
			Transaction trans = session.beginTransaction();
			session.remove(libros.get(0));  // Hibernate <6.0 era delete
			trans.commit();
			session.clear();
		} else {
			System.out.println("No existe ese id a borrar");
		}
	}
	
    public static void main( String[] args )
    {
    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
    	openSession();
    	//mostrarLibros();
    	mostrarAutores();
    	//ayadirAutor("AAAA", "Prueba", new HashSet<Libros>(0));
    	//ayadirLibro(6,new Autores("WSHAK"),"Libro Prueba");
    	mostrarLibros();
    	//updateAutor("Prueba", "Nombre Actualizado");
    	closeSession();
    }
}
