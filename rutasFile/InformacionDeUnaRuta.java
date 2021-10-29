//Lee un path por teclado, que debe exisir y ser un directorio
//Muestra el  tipo:Fich o Dir, nombre, tamaño y fecha-hora de modificación de cada elemento del path
package rutasFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class InformacionDeUnaRuta {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File dirTrabajo=new File(".");
		System.out.println("Directorio de trabajo: "+dirTrabajo.getCanonicalPath());
		System.out.print("Introduzca ruta:");
		String path = Entrada.cadena();
		File d = new File(path);
		if (!d.exists()) {
			System.out.println(d.getCanonicalPath()+" no existe");
		}
		else {
			if (d.isDirectory())
				System.out.println("Directorio");
			else 
				System.out.println("Fichero");
			System.out.println("Tamaño en bytes: "+d.length());
			Date t=new Date();
			t.setTime(d.lastModified());
			String fh = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(t);
			System.out.println("Fecha/hora ultima modificacion: " + fh);
			System.out.println("Ruta canónica: "+d.getCanonicalPath());
			System.out.println("Ruta absoluta: "+d.getAbsolutePath());
			System.out.println("Nombre: "+d.getName());
			System.out.println("Padre: "+d.getParent());
		}

		}
	};

