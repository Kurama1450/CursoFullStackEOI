package com.nestorcosta.jdbc.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nestorcosta.jdbc.entidades.Tabla1;

public class JdbcUtils {

	final static String URI = "jdbc:mysql://localhost:3306/tabla_jdbc";

	final static String USER = "root";
	final static String PASSWORD = "";
	
	public static Connection con;
	public static Statement st;
	public static ResultSet rs;
	
	/**
	 * Método que conecta con la base de datos.
	 * @return True si conecta correctamente, False si falla la conexión
	 */
	public static boolean conexion() {
		con = null;
		try {
			con = DriverManager.getConnection(URI, USER, PASSWORD);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Método que desconecta con la base de datos.
	 * @return True si desconecta correctamente, False si falla la desconexión
	 */
	public static boolean desconexion() {
		try {
			if(!con.isClosed()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public static void selectBasica() {
		String sql = "SELECT * FROM tabla1";
		int registros = 0; //  en esta variable iremos llevando el contador del número de resultados
		try {
			st = con.createStatement();  // Poder hacer una consulta sobre la conexión
			rs = st.executeQuery(sql);   // Ejecuta la consulta y devuelve los resultados
			while(rs.next()) {  		 // mientras hay resultados, los vamos recorriendo
				registros++;
				System.out.println("ID: " + rs.getInt("id") + " Nombre: " + rs.getString("nombre"));
				//System.out.println("ID: " + rs.getInt(1) + " Nombre: " + rs.getString(2));
			}
			System.out.println("El número de resultados es: " + registros);
			rs.close();  // Cerramos ResultSet
			st.close();	 // Cerramos Statement
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Tabla1> devolverRegistrosTabla1() {
		List<Tabla1> resultado = new ArrayList<Tabla1>();
		String sql = "SELECT * FROM tabla1";
		try {
			st = con.createStatement();  // Poder hacer una consulta sobre la conexión
			rs = st.executeQuery(sql);   // Ejecuta la consulta y devuelve los resultados
			while(rs.next()) {  		 // mientras hay resultados, los vamos recorriendo
				resultado.add(new Tabla1(rs.getInt("id"),rs.getString("nombre")));  // Metería en la lista un elemento por cada registro que devuelve la consulta
			}
			rs.close();  // Cerramos ResultSet
			st.close();	 // Cerramos Statement
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	/**
	 * Dada una sentencia sql devuelve un ResultSet con el contenido de los datos solicitados
	 * @param sql. Sentencia SELECT que solicita información
	 * @return ResultSet con los resultados o NULL si la sql es incorrecta
	 */
	public static ResultSet devolverResultSet(String sql) {
		try {
			st = con.createStatement();  
			return st.executeQuery(sql);   			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/**
	 * Dada una sentencia de modificación de datos (Insert, Update o Delete)
	 * la ejecuta sobre la Base de Datos y me devuelve el número de registros afectados
	 * @param sql Sentencia de modificación
	 * @return Número de registros afectados. En caso de error devolveré -1.
	 */
	public static int statementDML(String sql) {
		try {
			st = con.createStatement();  
			return st.executeUpdate(sql);   			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
