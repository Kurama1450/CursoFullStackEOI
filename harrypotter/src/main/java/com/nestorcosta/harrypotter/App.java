package com.nestorcosta.harrypotter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.nestorcosta.harrypotter.entidades.Personaje;
import com.nestorcosta.harrypotter.utilidades.JsonUtils;
import com.nestorcosta.harrypotter.utilidades.SerializacionUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	static List<Personaje> personajes = new ArrayList<Personaje>();
	final static String URI = "jdbc:mysql://localhost:3306/harry_potter";
	final static String USER = "root";
	final static String PASSWORD = "";
	public static Connection con;
	
	public static void ejemploSerializar() {
		//Serialización la probamos
        if(SerializacionUtils.serializarListaObjetos("personajes.dat", personajes)) {
        	System.out.println("La serialización fue satisfactoria");
        } else {
        	System.out.println("Ha fallado");
        }
	}
	
	public static void obtenerDatosApi() {
		//Obtener los datos de la API
        personajes = JsonUtils.devolverArrayGsonGenerico("https://hp-api.onrender.com/api/characters", Personaje[].class);
        personajes.stream()
        .filter(e->e.getName().equals("Harry Potter"))
        .forEach(e->System.out.println(e));
	}
	
	public static void rellenarFechaNacLD() {
		//Rellenar el campo dateOfBirthLD
        personajes.stream()
        .peek(e->{
        	if(e.getDateOfBirth()!=null) {
        		e.setDateOfBirthLD(LocalDate.parse(e.getDateOfBirth(),DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        	}
        })
        .filter(e->e.getName().equals("Harry Potter"))
        .forEach(e->System.out.println(e));
        
	}
	
	public static void ejemploDesSerializar() {
		personajes = SerializacionUtils.desSerializarListaObjetos("personajes.dat");
	}
	
	public static void mostrarPersonajes() {
		personajes.forEach(e->System.out.println(e));
	}
	
	public static void poblarConexion() {
		con = null;
		try {
			con = DriverManager.getConnection(URI, USER, PASSWORD);
			System.out.println("La conexión se realizo correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("La conexión ha fallado");
		}
	}
	
	public static void poblarBbdd() {
		
		Statement st;
		String sql;
		con = null;
		try {
			con = DriverManager.getConnection(URI, USER, PASSWORD);
			st = con.createStatement();
			
			for(Personaje personaje : personajes) {
				sql = "INSERT INTO personaje(id,name) VALUES('" +
						personaje.getId() + "','" +
						personaje.getName()+
						"');";
				System.out.println(sql);
				st.executeUpdate(sql);
			}
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("La conexión ha fallado");
		}
	}
	
    public static void main( String[] args )
    {
    	//Proceso de Serializacion
        //obtenerDatosApi();
        //rellenarFechaNacLD();
        //ejemploSerializar();
    	
    	//Proceso de Deserializacion
        //ejemploDesSerializar();
        //mostrarPersonajes();
    	
    	//Cargar la base de datos
    	poblarConexion();
    	obtenerDatosApi();
    	rellenarFechaNacLD();
    	poblarBbdd();
    }
}
