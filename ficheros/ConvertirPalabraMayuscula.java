package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ConvertirPalabraMayuscula {
	//Lee fichero CSV cuyas lineas son datos de coches: Matricula;Marca;Precio
	// y muestra el valor total de los coches.
	

	public static void main(String[] args) throws IOException  {
		System.out.println("Directorio de trabajo :"+new File(".").getCanonicalPath());
		
		System.out.print("Ruta del archivo de texto:");
		String t=Entrada.cadena();
		File ruta=new File(t); 
		System.out.print("Palabra que se convierte a mayúscula:");
		String pal=Entrada.cadena();
		
		int veces=convertirAMayusculaFichero(ruta,pal);
		System.out.println("Ocurrencias convertidas:"+veces);
	}

	private static int convertirAMayusculaFichero(File ruta, String pal) throws IOException {
		int veces=0;
		
		//Fichero a leer
		BufferedReader bfr=new BufferedReader(new FileReader(ruta));
		//Creamos fichero temporal donde escribir
		File rutaTmp=new File(ruta.getAbsolutePath()+".tmp");
		PrintWriter pw=new PrintWriter(new FileWriter(rutaTmp));
		
		String linea;
		while ((linea=bfr.readLine())!=null){
			//Buscamos cuantas veces aparece la palabra en la linea
			int n=numeroApariciones(linea,pal);
			if (n>0) {
				//Sustituye todas las ocurrencias de pal (ignorando mayus minus) por pal en mayuscula
				linea=linea.replaceAll("(?i)"+pal, pal.toUpperCase());
				veces+=n;
			}
			pw.println(linea);
		}
		//Cerramos ficheros
		bfr.close();
		pw.close();
		
		if (!ruta.delete())
			throw new RuntimeException("Error al borrar "+ruta.getCanonicalPath());
		if (!rutaTmp.renameTo(ruta))
			throw new RuntimeException("Error al renombrar "+rutaTmp.getCanonicalPath());
		
		return veces; //Devuelve el numero de sustituciones realizadas
	}

	private static int numeroApariciones(String linea, String pal) {
		int cnt=0;
		
		String dondeBuscar=linea.toLowerCase();
		String buscado=pal.toLowerCase();
		int pos=dondeBuscar.indexOf(buscado);
		while (pos > -1) {
			cnt++; 
			pos=dondeBuscar.indexOf(buscado,pos+buscado.length());
		}
		return cnt;
	}
}
