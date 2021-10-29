package cadenasYarrayList;

import java.util.Arrays;

public class BuscarCadenas {

	public static void main(String[] args) {
		String [] pal= {"perro","gato","pez","rana"};
		int pos=buscarPalabra(pal,"rana");
		System.out.println("Posicion:"+pos);
		System.out.println(Arrays.toString(pal));
		pal=aniadirPalabra(pal,"casa");
		System.out.println("Tras añadir:"+Arrays.toString(pal));
		borrarPalabra(pal,"gato");
		System.out.println("Tras borrar:"+Arrays.toString(pal));
		borrarPalabra(pal,"rana");
		System.out.println("Tras borrar:"+Arrays.toString(pal));
		pal=eliminarPalabra(pal, "pez");
		System.out.println("Tras eliminar:"+Arrays.toString(pal));
	}

	public static String[] eliminarPalabra(String[] a, String borrar) {
		//Creamos nuevo array eliminando la celda si es que existe
		int pos=buscarPalabra(a, borrar);
		if (pos==-1)
			return a;
		String [] nuevo=new String[a.length-1];
		//Copias desde el array original
		int cnt=0;
		for (int i = 0; i < a.length; i++) {
			if (i!=pos) {//Copiamos todas las celdas excepto aquella donde estaba la palabra
				nuevo[cnt]=a[i];
				cnt++;
			}
		}
		return nuevo;
	}
	
	public static void borrarPalabra(String[] a, String borrar) {
		int pos=buscarPalabra(a, borrar);
		if (pos!=-1)
			a[pos]=null;
	}


	private static String[] aniadirPalabra(String[] pal, String nuevaPal) {
		String [] nuevo=new String[pal.length+1];
		//Copias desde el array original
		for (int i = 0; i < pal.length; i++) {
				nuevo[i]=pal[i];			
		}
		//Añadimos palabra a la utiltima posicion
		nuevo[nuevo.length-1]=nuevaPal;
		//devolvemos nuevo array
		return nuevo;
	}

	public static int buscarPalabra(String[] dondeBusco, String busco) {
		//Devuelve -1 si no encuentra la cadena
		for (int i = 0; i < dondeBusco.length; i++) {
			if (dondeBusco[i]!=null) {
				if (dondeBusco[i].equals(busco))
					return i;
			}
		}
		//Ha finalizado el bucle y no se ha encontrado
		return -1;
	}

}
