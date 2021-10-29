//Lee un path por teclado, que debe exisir y ser un directorio
//Muestra el  tipo:Fich o Dir, nombre, tamaño y fecha-hora de modificación de cada elemento del path
package rutasFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;

public class BuscarPorNombre {

	public static void main(String[] args) throws IOException {
			System.out.print("Carpeta dónde buscar: ");
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
			System.out.print("Ficheros cuyo nombre contiene: ");
			String que=Entrada.cadena();
			ArrayList<File> res=buscarPorNombre(donde,que);
			System.out.println("Encontrados "+res.size()+" ficheros");
			for (File f:res) {
				System.out.println(f.getCanonicalPath()+" ("+f.length()+" bytes)");
			}
		
	}

	private static ArrayList<File> buscarPorNombre(File donde, String que) {
		ArrayList<File> encontrados = new ArrayList<File>();
		File[] lista = donde.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				encontrados.addAll(buscarPorNombre(lista[i], que));
			} else//Fichero
				if (lista[i].getName().toLowerCase().indexOf(que.toLowerCase())!=-1)//Encontrado:el nombre contiene que
					encontrados.add(lista[i]);
		}
		return encontrados;
	}
}
