package fechaHora;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Entrada {
	static String inicializar() {
		String buzon = "";
		InputStreamReader flujo = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(flujo);
		try {
			buzon = teclado.readLine();
		} catch (Exception e) {
			System.out.append("Entrada incorrecta)");
		}
		return buzon;
	}

	public static Integer entero() {
		int valor = Integer.parseInt(inicializar());
		return valor;
	}

	public static double real() {
		double valor = Double.parseDouble(inicializar());
		return valor;
	}

	public static String cadena() {
		String valor = inicializar();
		return valor;
	}

	public static char caracter() {
		String valor = inicializar();
		return valor.charAt(0);
	}
	
	public static GregorianCalendar fecha(String plantilla) throws ParseException {
		String t=cadena();
		SimpleDateFormat sdf=new SimpleDateFormat(plantilla);
		sdf.setLenient(false);
		Date d=sdf.parse(t);
		GregorianCalendar gc=new GregorianCalendar();
		
		gc.setTime(d);
		return gc;
	}
	
	public static Integer enteroVal(String mensajeSolicitud,String mensajeError,String plantilla) {
		String dato;
		
		boolean bien;
		do {
			bien=true;
			if (mensajeSolicitud!=null)
				System.out.print(mensajeSolicitud);
			dato=cadena();//Leemos String
			bien=enteroEsValido(dato,plantilla);
			if (!bien)
				mostrarError(mensajeError);			
		} while (!bien);
		//Devolvemos el entero validado
		return Integer.valueOf(dato);
	}
	
	private static boolean enteroEsValido(String dato, String plantilla) {
		if (!dato.matches(plantilla))
			return false;
		try {
			int valor=Integer.valueOf(dato); //Hacemos una conversion para ver si se lanza excepcion
		} catch (NumberFormatException e) { 
			return false;
		}
		return true;
	}

	public static int enteroVal(String mensajeSolicitud,String mensajeError,int min,int max) {
		String dato;
		
		boolean bien;
		do {
			bien=true;
			if (mensajeSolicitud!=null)
				System.out.print(mensajeSolicitud);
			dato=cadena();//Leemos String
			bien=enteroEsValido(dato,min, max);
			if (!bien)
				mostrarError(mensajeError);			
		} while (!bien);
		//Devolvemos el entero validado
		return Integer.valueOf(dato);
	}

	public static boolean enteroEsValido(String dato, int min, int max) {
		int valor;
		try {
			valor=Integer.valueOf(dato); //Hacemos una conversion para ver si se lanza excepcion
		} catch (NumberFormatException e) { 
			return false;
		}
		return valor>=min && valor<=max;
	}

	public static void mostrarError(String mensajeError) {
		if (mensajeError!=null)
			System.out.println(mensajeError);
		
	}
	
}