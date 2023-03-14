package com.nestorcosta.ejJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.nestorcosta.ejJDBC.entidades.Categorias;
import com.nestorcosta.ejJDBC.entidades.Departamentos;
import com.nestorcosta.ejJDBC.entidades.Empleados;
import com.nestorcosta.ejJDBC.utilidades.JdbcUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner sc;
	
	static List<Categorias> categorias = new ArrayList<Categorias>();
	static List<Empleados> empleados = new ArrayList<Empleados>();
	static List<Departamentos> departamentos = new ArrayList<Departamentos>();
	
	public static void cargarCategorias() {
		ResultSet rs = JdbcUtils.devolverResultSet("SELECT * FROM categorias");
		if(rs!=null) {
			try {
				while(rs.next()) categorias.add(new Categorias(rs.getInt("categoria"), rs.getString("titulo"),
						rs.getInt("salario"), rs.getInt("trienio")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Listamos las categorias
	public static void ap1() {
		if(!categorias.isEmpty()) categorias.clear();
		cargarCategorias();
		categorias.forEach(System.out::println);
	}
	
	public static void cargarEmplePreparedStatement() {
		String sql = "SELECT * FROM empleados";
		List<Object> parametros = new ArrayList<>();
		ResultSet rs = JdbcUtils.devolverResultSetPreparedStatement(sql, parametros);
		try {
			while(rs.next()) empleados.add(new Empleados(rs.getInt("num"), rs.getString("nombre"),
					rs.getInt("edad"), rs.getInt("departamento"),rs.getInt("categoria"), rs.getDate("contrato").toLocalDate()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Listar los empleados que tengan al menos 40 años contratados antes del 1 de enero de 1998 (usa PreparedStatement)
	public static void ap2() {
		if(!empleados.isEmpty()) empleados.clear();
		cargarEmplePreparedStatement();
		empleados.stream().filter(e->e.getEdad()>=40).filter(e->e.getContrato().isBefore(LocalDate.of(1998, 1, 1))).forEach(System.out::println);
	}
	
	public static Departamentos insertDeparta() {
		System.out.print("Introduzca el nombre del departamento: ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca el número del departamento: ");
		int deptno = Integer.parseInt(sc.nextLine());
		List<Object> parametros = new ArrayList<>();
		Collections.addAll(parametros, deptno, nombre);
		int registros = JdbcUtils.preparedStatementDML("INSERT INTO departamentos (deptno, nombre) VALUES(?, ?)", parametros);
		System.out.println("Se ha insertado "+registros+" registro");
		return registros!=-1 ? new Departamentos(deptno, nombre) : null;
	}
	
	public static void loadDepartPreparedStatement() {
		String sql = "SELECT * FROM departamentos";
		List<Object> parametros = new ArrayList<>();
		ResultSet rs = JdbcUtils.devolverResultSetPreparedStatement(sql, parametros);
    	try {
			while(rs.next()) departamentos.add(new Departamentos(rs.getInt("deptno"), rs.getString("nombre")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteDeparta(Departamentos depart) {
		List<Object> parametros = new ArrayList<>();
		Collections.addAll(parametros, depart.getDeptno(), depart.getNombre());
		int registros = JdbcUtils.preparedStatementDML("DELETE FROM departamentos WHERE deptno=? AND nombre=?", parametros);
		System.out.println("Se ha borrado " +registros+" registro");
	}
	
	/* Inserta un departamento (pregunta al usuario usando la consola por un nombre de departamento
	 * y un número). Lista los departamentos para comprobar que se ha insertado. A continuación borra el
	 * departamento que acabas de insertar */
	public static void ap3() {
		Departamentos newDept = insertDeparta();
		if(!departamentos.isEmpty()) departamentos.clear();
		loadDepartPreparedStatement();
    	departamentos.stream().forEach(System.out::println);
    	if(newDept!=null) {
    		System.out.println("El departamento se ha insertado correctamente, por lo que ahora se procederá a borrarlo");
    		deleteDeparta(newDept);
    	}
    	else System.out.println("El departamento no se ha insertado correctamente");
	}
	
	public static void menu() {
		int option;
		do {
			System.out.println("MENU");
			System.out.println("1. Listar categorías"
					+"\n2. Listar empleados que tengan al menos 40 años contratados antes del 1 de enero de 1998"
					+"\n3. Insertar un departamento. Listar departamentos y eliminar el departamento insertado previamente"
					+"\n4. Salir");
			System.out.println("Introduzca su opción");
			try {
				option = Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {
				option = 0;
			}
			switch(option) {
			case 1 -> ap1();
			case 2 -> ap2();
			case 3 -> ap3();
			case 4 -> System.out.println("Adios");
			default -> System.err.println("Su valor introducido no es valido");
			}
			if(option > 0 && option <4) System.out.println();
		}while(option != 4);
	}
	
    public static void main( String[] args )
    {
        if(JdbcUtils.conexion()) {
        	sc = new Scanner(System.in);
        	menu();
        	sc.close();
        	JdbcUtils.desconexion();
        }
    }
}
