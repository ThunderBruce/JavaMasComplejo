package cadenasYarrayList;

import java.util.Arrays;

import ejemplos.Entrada;

public class PartirConSplit {

	public static void main(String[] args) {
		for(;;) {
			System.out.print("Introduzca cadena:");
			String t=Entrada.cadena();
			String [] partes=t.split("[ ,]+");//El + hace que varios espacios o comas seguidos se consideran un unico delemitador
			System.out.println("Partes: "+partes.length);
			for(String p:partes) {
				System.out.println("["+p+"]");
			}
		}
	}

}
