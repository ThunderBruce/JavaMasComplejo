package ejemplos;

import aplicacionGestionPersonasArrayListValicadiones.Entrada;

public class OrdenarPalabrasBurbuja {

	public static void main(String[] args) {
		int maxPalabras = 100;
		String[] palabras = new String[maxPalabras];

		// Carga palabras en array
		int cnt = 0;
		boolean salir;
		do {
			System.out.print("Introduzca palabra (fin-para salir):");
			String pal = Entrada.cadena();
			salir = pal.equals("fin");
			if (!salir) {
				palabras[cnt] = pal;
				cnt++;
			}
		} while (!salir && cnt < maxPalabras);
		System.out.println("== Palabras desordenadas ==");
		mostrarArray(palabras);
		String[] ordenadas = ordenarArray(palabras, cnt);
		System.out.println("== Palabras ordenadas ==");
		mostrarArray(ordenadas);
	}

	private static String[] ordenarArray(String[] palabras, int cnt) {
		String[] ordenadas = new String[cnt];
		// Copiamos array palabras a array ordenadas
		for (int i = 0; i < ordenadas.length; i++) {
			ordenadas[i] = palabras[i];
		}
		// Ordenamos por burbuja el array ordenadas
		boolean flota;
		do {
			flota = false;
			for (int i = 0; i < cnt - 1; i++) {
				if (ordenadas[i].compareTo(ordenadas[i+1]) > 0) {
					String aux = ordenadas[i];
					ordenadas[i]=ordenadas[i+1];
					ordenadas[i+1]=aux;
					flota = true;
				}
			}
		} while (flota);

		return ordenadas;
	}

	private static void mostrarArray(String[] p) {
		for (int i = 0; i < p.length; i++) {
			if (p[i]!=null)
				System.out.println(p[i]);
		}
	}

}
