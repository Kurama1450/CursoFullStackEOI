package poo1.ejercicio4h;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		empresa.getEmpleados().add(new Empleado("Fran",10000));//Creamos y Añadimos un empleado a la empresa
		empresa.getEmpleados().add(new Empleado("Dani",20000));//Creamos y Añadimos un empleado a la empresa
		empresa.getEmpleados().add(new Empleado("Pepe",10000));//Creamos y Añadimos un empleado a la empresa
		
		Empresa copia = new Empresa(empresa);//Copiar una empresa a partir de otra.
		copia.getEmpleados().get(0).setNombre("Francisco");//Cambio el nombre al primer empleado.
		copia.getDireccion().setNumero(10);//Cambiar el numero de la calle de la direccion de la empresa copia.
		copia.getEmpleados().add(new Empleado("Nuevo",30000));//Añado un nuevo empleado en la copia.

		//Mostramos los valores de la empresa original y de la copia.
		System.out.println("Empresa original");
		System.out.println(empresa);
		System.out.println("La empresa original tiene + " + empresa.getEmpleados().size());
		System.out.println("Empresa copia");
		System.out.println(copia);
		System.out.println("La empresa copia tiene + " + copia.getEmpleados().size());
		
	}

}
