package cadenasYarrayList;

import java.util.ArrayList;
import java.util.Collections;

import ejemplos.Entrada;

public class OrdenarPalabrasArrayList {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();

		// Carga palabras en array
		int cnt = 0;
		boolean salir;
		do {
			System.out.print("Introduzca palabra (fin-para salir):");
			String pal = Entrada.cadena().toUpperCase();//Leemos y convertimos a mayúscula
			salir = pal.equals("FIN");
			if (!salir)
				al.add(pal);
		} while (!salir);
		//Copiar ArrayList al en al2
		ArrayList<String> al2 = new ArrayList<>(al);
		
		System.out.println("== Palabras desordenadas ==");
		mostrarArray(al);
		Collections.sort(al2);
		System.out.println("== Palabras ordenadas A-->Z ==");
		mostrarArray(al2);
		Collections.reverse(al2);
		System.out.println("== Palabras ordenadas Z-->A ==");
		mostrarArray(al2);
		System.out.println("== Palabras desordenadas ==");
		mostrarArray(al);
	}


	private static void mostrarArray(ArrayList<String> al) {
		for (int i = 0; i < al.size(); i++) {
				System.out.println(aCamello(al.get(i),false));
		}
	}


	//Devuelve un String alternando entre mayusculas y minusculas
	private static String aCamello(String cadena, boolean mayuscula) {
		String camello="";
		for (int i = 0; i < cadena.length(); i++) {
			char c=cadena.charAt(i);
			String car=String.valueOf(c);//Convierte char en String
			if (mayuscula)
				car=car.toUpperCase();
			else
				car=car.toLowerCase();
			camello=camello+car;
			mayuscula=!mayuscula;
		}
		return camello;
	}

}
