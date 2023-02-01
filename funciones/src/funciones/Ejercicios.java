package funciones;

public class Ejercicios {

	public static double ej6(double...num) {
		double resultado = 0;
		for(double numeros : num) {
			resultado += numeros;
		}
		
		return resultado/num.length;
	}
	
	public static int ej8(int... numeros) {
		int maximo = Integer.MIN_VALUE;
		if(numeros.length == 0) {
			return 0;
		}
		for(int num : numeros) {
			if(num>maximo) {
				maximo = num;
			}
		}
		return maximo;
	}
	
	public static void main(String[] args) {
		System.out.println(ej6(12.45,14.18,25.94,56,78));
		int maximo = ej8(2,8,99,4,150,500,550,25,50,12,14);
		System.out.println(maximo);
		System.out.println(ej8());
	}

}
