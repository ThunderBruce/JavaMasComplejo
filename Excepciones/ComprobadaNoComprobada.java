package Excepciones;

import utilidades.Entrada;

public class ComprobadaNoComprobada {

	public static void main(String[] args) throws Exception {
		System.out.print("Cadena 1:");
		String t=leer();
		System.out.println(t);
		
		System.out.print("Cadena 2:");
		String t2=null;
		try {
			t2 = leer2();
			System.out.println(t2);
		} catch (RuntimeException e) {
			System.out.println("ENTER");
			System.out.println(e.getMessage());
		}
		
	}

	private static String leer2() {
		String t=Entrada.cadena();
		if (t.length()==0)
			throw new RuntimeException("Cadena vacía(NO COMPROBADA)");
		return t;
	}

	private static String leer() throws Exception {
		String t=Entrada.cadena();
		if (t.length()==0)
			throw new Exception("Cadena vacía(NO COMPROBADA)");
		return t;
	}

}
