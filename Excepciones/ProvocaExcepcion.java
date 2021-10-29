package Excepciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilidades.Entrada;
public class ProvocaExcepcion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Introduzca dividendo:");
		int a=Entrada.entero();
		System.out.print("Introduzca divisor:");
		int b=Entrada.entero();
		
		int cociente=dividir(a,b);
		System.out.println("El cociente es:"+cociente);
		
		System.out.print("Introduzca numero:");
		String t=Entrada.cadena();
		int n=Integer.valueOf(t);
		System.out.println("Numero leido:"+n);
		
		try {
			System.out.println("Voy a leer fecha");
			leerFecha();
			System.out.println("He leido una fecha correcta.");
		} catch (ParseException e) {
			//Manejador de la execpcion ParseException
			System.out.println("Fecha invalida");
			System.out.println(e.getMessage());
			
		}
		
		System.out.println("ADIOS.");
	}
	
	private static void leerFecha() throws ParseException {
		//Leemos fecha
				System.out.println("Introduzca fecha DD-MM-AAAA:");
				String fecha=Entrada.cadena();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				sdf.setLenient(false);
				Date d=sdf.parse(fecha);
				System.out.println("Fecha leida: "+sdf.format(d));
		
	}

	private static int dividir(int a, int b) {
		
		int coc= calcularDivision(a,b);
		System.out.println("dividir: Division calculada");
		return coc;
	}
	
	private static int calcularDivision(int a, int b) {
		int coc= a/b;
		System.out.println("calcularDivision: Division calculada");
		return coc;
	}
}
