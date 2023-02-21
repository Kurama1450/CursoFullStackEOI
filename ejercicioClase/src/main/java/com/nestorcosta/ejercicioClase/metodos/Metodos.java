package com.nestorcosta.ejercicioClase.metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nestorcosta.ejercicioClase.clases.Cuenta;
import com.nestorcosta.ejercicioClase.clases.CuentaCaixa;
import com.nestorcosta.ejercicioClase.clases.CuentaSabadell;
import com.nestorcosta.ejercicioClase.clases.CuentaSantander;

public class Metodos {

	public static List<Cuenta> juntarListas(List<CuentaCaixa> datesCaixa, List<CuentaSabadell> datesSabadell, List<CuentaSantander> datesSantander){
		List<Cuenta> cuentasBancos = new ArrayList<Cuenta>();
		cuentasBancos.addAll(datesCaixa);
		cuentasBancos.addAll(datesSabadell);
		cuentasBancos.addAll(datesSantander);
		return cuentasBancos;
	}
	
	public static void visionListaUnida(List<Cuenta> cuentasBancos) {
		for(Cuenta cuenta:cuentasBancos) {
			if(cuenta instanceof CuentaCaixa) System.out.println("Cuenta de CaixaBank\n"+cuenta);
			else if(cuenta instanceof CuentaSabadell) System.out.println("Cuenta de Sabadell\n"+cuenta);
			else System.out.println("Cuenta de Santander\n"+cuenta);
		}
	}
	
	private static int numAleatorio(List<Cuenta> cuentasBancos) {
		return new Random().nextInt(cuentasBancos.size());
	}
	
	public static void eliminarCuenta(List<Cuenta> cuentasBancos) {
		cuentasBancos.remove(numAleatorio(cuentasBancos));
	}
	
	public static void visionCuentaBorrada(List<Cuenta> cuentasBancos,List<CuentaCaixa> cuentasCaixa,List<CuentaSabadell> cuentasSabadell,List<CuentaSantander> cuentasSantander) {
		if(!cuentasBancos.containsAll(cuentasCaixa)) {
			System.out.println("Se ha eliminado esta cuenta de CaixaBank: ");
			for(CuentaCaixa cuentaC:cuentasCaixa)
				if(!cuentasBancos.stream().filter(e->e instanceof CuentaCaixa).toList().contains(cuentaC))
					System.out.println(cuentaC);
		}
		else if(!cuentasBancos.containsAll(cuentasSabadell)) {
			System.out.println("Se ha eliminado esta cuenta de Sabadell: ");
			for(CuentaSabadell cuentaSB:cuentasSabadell)
				if(!cuentasBancos.stream().filter(e->e instanceof CuentaSabadell).toList().contains(cuentaSB))
					System.out.println(cuentaSB);
		}
		else {
			System.out.println("Se ha eliminado esta cuenta de Santander: ");
			for(CuentaSantander cuentaST:cuentasSantander)
				if(!cuentasBancos.stream().filter(e->e instanceof CuentaSantander).toList().contains(cuentaST))
					System.out.println(cuentaST);
		}
	}
}
