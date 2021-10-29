//Lee un path por teclado, que debe exisir y ser un directorio
//Muestra el  tipo:Fich o Dir, nombre, tamaño y fecha-hora de modificación de cada elemento del path
package rutasFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.management.RuntimeErrorException;
import javax.swing.JFileChooser;

public class CrearEstructuraCarpetasFicheros {

	//Crear estructura de carpetas y ficheros(vacíos) dentro de una carpeta existente
	public static void main(String[] args) throws IOException {
			System.out.print("Carpeta dónde crear: ");
			String t=Entrada.cadena();
			File donde=new File(t);
			if (!donde.exists()) {
				System.out.println(donde.getCanonicalPath()+" no existe");
				return;//En main equivale a terminar el programa
			}
			if (!donde.isDirectory()) {
				System.out.println(donde.getCanonicalPath()+" no es una carpeta");
				return;//En main equivale a terminar el programa
			}
			crearCarpeta(new File(donde,"cfg"));
			crearFichero(new File(donde,"cfg/cfg.txt"));
			crearCarpeta(new File(donde,"bin/prog"));
			crearCarpeta(new File(donde,"bin/serv"));
			crearCarpeta(new File(donde,"datos/fotos"));
			crearFichero(new File(donde,"datos/fotos/f1.jpg"));
			crearFichero(new File(donde,"datos/fotos/f2.jpg"));
			crearCarpeta(new File(donde,"datos/html"));
			crearFichero(new File(donde,"datos/html/index.html"));
			crearCarpeta(new File(donde,"datos/css"));
			crearFichero(new File(donde,"datos/css/main.css"));
			
			System.out.println("Finalizado.");
		
	}

	private static void crearCarpeta(File rutaCarpeta) throws IOException {
		if (rutaCarpeta.exists()){
			if (rutaCarpeta.isFile())
				throw new RuntimeException("Error al crear carpeta. "+rutaCarpeta.getCanonicalPath()+" ya existe como fichero.");
			else
				return;//Ya está creada
		}
		if (!rutaCarpeta.mkdirs())
			throw new RuntimeException("Error al crear carpeta. "+rutaCarpeta.getCanonicalPath()+" fallo en mkdirs.");
	}

	private static void crearFichero(File rutaFichero) throws IOException {
		if (rutaFichero.exists()){
			if (rutaFichero.isDirectory())
				throw new RuntimeException("Error al crear fichero. "+rutaFichero.getCanonicalPath()+" ya existe como carpeta.");
			else
				return;//Ya está creado
		}
		if (!rutaFichero.createNewFile())
			throw new RuntimeException("Error al crear fichero. "+rutaFichero.getCanonicalPath()+" fallo en createNewFile.");
	}
	
}
