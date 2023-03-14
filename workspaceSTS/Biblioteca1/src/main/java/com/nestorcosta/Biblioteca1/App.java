package com.nestorcosta.Biblioteca1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        if(session!=null) {
        	System.out.println("Sesion abierta correctamente");
        }
        else {
        	System.out.println("Sesion fallida al abrir");
        }
    }
}
