package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LeerFicheroTextoCSV {
	//Lee fichero CSV cuyas lineas son datos de coches: Matricula;Marca;Precio
	// y muestra el valor total de los coches.
	

	public static void main(String[] args) throws IOException  {
		System.out.println("Directorio de trabajo :"+new File(".").getCanonicalPath());
		
		System.out.print("Ruta del archivo CSV a leer:");
		String ruta=Entrada.cadena();
		File f=new File(ruta); 
			
		//Abrimos fichero(si no existe se lanza un excepcion)
		BufferedReader br=new BufferedReader(new FileReader(f));
		String linea;
		
		
		//Leemos y mostramos linea a linea
		int cnt=0;
		int total=0;
		while ((linea=br.readLine())!=null){
			cnt++;
			if (cnt>1) {//No procesamos la primera línea
				String [] campos=linea.split("[;]");
				total+=Integer.valueOf(campos[2]);
			}
		}
		//Cerramos fichero
		br.close();
		
		System.out.println((cnt-1)+" coches suman este total: "+total);
	}

}
