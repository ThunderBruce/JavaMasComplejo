package cadenasYarrayList;

import java.util.Random;

import ejemplos.Entrada;

public class ValidarConExpresionesRegulares {

	public static void main(String[] args) {
		for(int i=1;i<=100;i++) {
			System.out.println(generarNIFAleatorio(false));
		}
		for(;;) {
			System.out.print("Introduzca cadena:");
			String t=Entrada.cadena();
			if (esNumero(t))
				System.out.println("Es un NUMERO");
			if (esMatricula(t))
					System.out.println("Es una MATRÍCULA");
			if (esTelefono(t))
				System.out.println("Es un TELÉFONO");
			if (esEmail(t))
				System.out.println("Es un EMAIL");
			if (esHora(t))
				System.out.println("Es una HORA");
			if (esNIF(t))
				System.out.println("Es un NIF");
		}
	}

	public static boolean esEmail(String t) {
		return t.matches("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})");
	}

	public static boolean esTelefono(String t) {
		//prefijo internacional seguido de guion: opcional. Seguido de 9 dígitos
		return t.matches("([+][0-9]{1,4}+[-])?[0-9]{9}");
	}

	public static boolean esMatricula(String t) {
		//Espacio o gion opcional entre digitos y letras
		return t.matches("[0-9]{4}[ -]?[B-DF-HJ-NPR-TV-Z]{3}");
	}

	public static boolean esNumero(String t) {
		//El signo inicial es opcional y el punto más los decimales también
		return t.matches("[-+]?[0-9]+([.][0-9]+)?");
	}
	
	public static boolean esHora(String t) {
		if (!t.matches("[0-2][0-9]:[0-5][0-9]:[0-5][0-9]"))
			return false;
		//Validamos que la hora no sea superior a 23
		int h=Integer.valueOf(t.substring(0, 2));
		if (h>23)
			return false;
		return true;
	}
	
	//Calcula la letra que corresponde a los 8 dígitos de un DNI
	public static char calcularLetraDni(String digitosDni){
		if (!digitosDni.matches("[0-9]{1,8}"))
				return '?'; //Devuelve ? si no llegan entre 1 y 8 digitos 
		char letras[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y',
		          'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
		          'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

		return letras[Integer.valueOf(digitosDni)%23];
	}
	
	public static boolean esNIF(String t) {
		if (!t.matches("[0-9]{1,8}[A-Z]"))
			return false;
		String digitos=t.substring(0, t.length()-1);
		char letra=t.charAt(t.length()-1);//La letra es el ultimo caracter de t
				
		return letra==calcularLetraDni(digitos);
	}
		
	public static String generarNIFAleatorio(boolean conCeros) {
		Random r=new Random();
		int n=r.nextInt(100000000);
		String t;
		if (conCeros)
			t=String.format("%08d", n);
		else
			t=String.valueOf(n);
			
		t=t+calcularLetraDni(t);
		
		return t;
	}
}

