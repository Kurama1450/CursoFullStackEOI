package com.nestorcosta.anotaciones2.utilidades;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	static SessionFactory sessionFactory;
	static Session session;
	
	//Abre una conexion con la base de datos
	//Return True si la conexion se abre correctamente. Falso en caso contrario.
	public static boolean openSession() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        return (session!=null);
	}
	
	//Cierra la conexion con la base de datos.
	//Return 
	public static boolean closeSession() {		
		try {
			if(session!=null)
				session.close();
			if(sessionFactory!=null)
				sessionFactory.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//? no sabe de que tipo es , devolvere una lista de algo.
	//Metodo genérico Dado el nombre de una clase
	//Devuelve una lista con todos los elementos que tiene.
	//Usaremos este metodo en un proyecto < Hibernate 6.0
	@SuppressWarnings("deprecation")
	public static List<?> devolverListadeObjetos(String clase){
		return session.createQuery("from " + clase).list();
	}
	/**
	 * Dado el tipo de una clase , devuelve una lista con todos los elementos que tiene.
	 * @param <T> Tipo de la clase
	 * @param clase Clase pasada
	 * @return Lista con el equivalente a todas las filas de la tabla de ese nombre.
	 */
	public static <T> List<T> devolverListaObjetos(Class<T> clase){
		return session.createSelectionQuery("from " + clase.getSimpleName(),clase).list();
	}
	
	/**
	 * Metodo generico que inserta en su tabla correspondiente de la base de datod
	 * @param object Objeto de la clase que queremos insertar
	 * @return True si la insercion es correcta y False si falla.
	 */
	public static boolean save(Object object) {
		Transaction trans = null;
		try {
			trans = session.beginTransaction();//Abro la transaccion
			session.persist(object);//Antogua save. Persist es a partir de la version 6.0
			trans.commit();//Confirmo los cambios en la transaccion
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return false;
		}
	}
	/**
	 * Metodo que actualiza un/os registro de la base de datos mediante un patron que indica
	 * los campos que queremos actualizar siempre que no le pasemos null
	 * @param <T>
	 * @param clase
	 * @param where
	 * @param datos
	 * @return
	 */
	public static <T> boolean update(Class<T> clase, String where,T datos) {
		Transaction trans = null;
		try {
			List<T> resultados = session.createSelectionQuery("from " + clase.getSimpleName() + " WHERE " + where,clase).list();
			trans = session.beginTransaction();
			Arrays.asList(clase.getDeclaredFields()).forEach(atributo->{
				resultados.forEach(resultado ->{
					atributo.setAccessible(true);
					try {
						if(atributo.get(datos)!=null && !Modifier.isStatic(atributo.getModifiers())) {
							atributo.set(resultado, atributo.get(datos));
						}
					} catch (IllegalArgumentException e) {
						
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						
						e.printStackTrace();
					}
					atributo.setAccessible(false);
				});
			});
			resultados.forEach(e->session.merge(e));
			trans.commit();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return false;
		}
		
	}
	
	/**
	 * Borramos los objetos de la clase que cumplan la condición pasada en el where
	 * <br> HibernateUtils.delete(Autores.class, "cod='AAAAB'");
	 * @param <T> Clase con la que trabajamos 
	 * @param clase Objeto de la clase
	 * @param where Condición de borrado sin la palabra where
	 * @return Número de elementos borrados, 0 si no borra ninguno, -1 en caso de error.
	 */
	public static <T> int delete(Class<T> clase, String where) {
		Transaction trans = null;
		try {
			List<T> resultados = session.createSelectionQuery("FROM  " + clase.getSimpleName() + " WHERE " + where,clase).list();
			trans = session.beginTransaction();  // abro la transacción		
			resultados.forEach(e->session.remove(e)); // Hibernate <6.0 era delete
			trans.commit();  // confirmo los cambios en la transacción
			session.clear();
			return resultados.size();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return -1;
		}
	}
}
