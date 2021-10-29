package ejemplos;

import utilidades.Entrada;

public class Bisiesto {

	public static void main(String[] args) {
		System.out.print("Introduzca año:");
		int anio=Entrada.entero();
		if (esBisiesto(anio))
			System.out.println(anio+" SI es bisiesto");
		else
			System.out.println(anio+" NO es bisiesto");
	}

	private static boolean esBisiesto(int anio) {
		return anio%4==0 && anio%100!=0 || anio%400==0;
	}

}
