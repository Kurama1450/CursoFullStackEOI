package poo1;

import java.util.Random;

public class Ave extends Animal {
	private boolean puedeVolar;

	public Ave(boolean puedeVolar) {
		super();  // Cojo el constructor de mi padre
		//this.setNombre("Ave desconocida");  // Si quiero ponerle yo mis propios valores
		//this.setPeso(5);
		this.puedeVolar = puedeVolar;
	}
	
	public Ave(String nombre, double peso, boolean puedeVolar) {
		 super(nombre, peso);  // Esta llamando al constructor de Animal con esos dos parámetros
		 this.puedeVolar = puedeVolar;
	}

	public boolean getPuedeVolar() {
		return puedeVolar;
	}

	public void ponerHuevos() {
		int numHuevos = new Random().nextInt(6) + 1;
		// System.out.printf("He puesto %d huevos\n", numHuevos);
		System.out.printf("He puesto %d huevos y peso %.2f kilos\n", numHuevos, getPeso());

	}

	@Override
	public void comer() {
		// Definimos que un ave aumenta su peso un 5% siempre al comer
		setPeso(getPeso() * 1.05);
		System.out.printf("Pio pio. He comido y ahora peso %.2f kilos", getPeso());
	}
}
