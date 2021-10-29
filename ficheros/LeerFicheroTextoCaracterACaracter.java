package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LeerFicheroTextoCaracterACaracter {
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
		
		
		//Leemos y mostramos linea a linea
		int cnt=0;
		int c;
		while ((c=br.read())!=-1){
			System.out.print("Código Unicode:"+c+" ");
			cnt++;
			switch(c) {
			case '\n':System.out.println("Caracter: "+"\\n");
			break;
			case '\r':System.out.println("Caracter: "+"\\r");
			break;
			case '\t':System.out.println("Caracter: "+"\\t");
			break;
			case ' ':System.out.println("Caracter: espacio");
			break;
			default:System.out.println("Caracter: "+(char)c);
			}
		}
		//Cerramos fichero
		br.close();
		
		System.out.println("Se han leido "+cnt+" caracteres");
	}

}
