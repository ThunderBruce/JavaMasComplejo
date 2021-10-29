package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ContarPalabrasLetrasFicheroTexto {
	//Lee fichero CSV cuyas lineas son datos de coches: Matricula;Marca;Precio
	// y muestra el valor total de los coches.
	

	public static void main(String[] args) throws IOException  {
		
		System.out.println("Directorio de trabajo :"+new File(".").getCanonicalPath());
		
		System.out.print("Ruta del archivo de texto a leer:");
		String ruta=Entrada.cadena();
		File f=new File(ruta); 
			
		//Abrimos fichero(si no existe se lanza un excepcion)
		BufferedReader br=new BufferedReader(new FileReader(f));
		String linea;

		int cntLineas=0,cntPalabras=0,cntVocales=0,cntConsonantes=0;
		//Leemos linea a linea
		while ((linea=br.readLine())!=null){
			cntLineas++;
			cntPalabras+=contarPalabras(linea);
			cntVocales+=contarVocales(linea);
			cntConsonantes+=contarConsonantes(linea);
		}
		//Cerramos fichero
		br.close();
		//Mostramos estadística
		System.out.println("Líneas: "+cntLineas);
		System.out.println("Palabras: "+cntPalabras);
		System.out.println("Vocales: "+cntVocales);
		System.out.println("Consonantes: "+cntConsonantes);
	}

	private static int contarConsonantes(String linea) {
		int cnt=0;
		for (int i = 0; i < linea.length(); i++) {
			if (esConsonante(linea.charAt(i)))
				cnt++;
		}
		return cnt;
	}

	private static boolean esConsonante(char c) {
		String t=String.valueOf(c).toLowerCase();
		return t.matches("[bcdfghjklmnñpqrstvwxyz]");
	}

	private static int contarVocales(String linea) {
		int cnt=0;
		for (int i = 0; i < linea.length(); i++) {
			if (esVocal(linea.charAt(i)))
				cnt++;
		}
		return cnt;
	}

	private static boolean esVocal(char c) {
		String t=String.valueOf(c).toLowerCase();
		return t.matches("[aeiouáéíóúü]");
	}

	private static int contarPalabras(String linea) {
		String [] pals=linea.split("[ ,.:;()¡!¿?]+");
		int cnt=0;
		//No cuenta los trozos vacios "" que pueda haber al principio
		for(String p:pals)
			if (p.length()>0)
				cnt++;
		return cnt;
	}

}
