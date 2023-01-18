package ejercicio6;

public class ejercicio6 {

	public static void main(String[] args) {
		int numA = 13, numB = 9 , numC = 5 , numD = 3;

		final int AUXB = numB;//Constante para mantener el valor original de numB.
		
		System.out.println("Valores iniciales: " + "A: " + numA + " B: " + numB + " C: " + numC + " D: " + numD);
		numB = numC;
		System.out.println("B toma el valor de C -> B = " + numB);
		numC = numA;
		System.out.println("C toma el valor de A -> C = " + numC);
		numA = numD;
		System.out.println("A toma el valor de D -> A = " + numA);
		numD = AUXB;
		System.out.println("D toma el valor de B -> D = " + numD);
	}

}
