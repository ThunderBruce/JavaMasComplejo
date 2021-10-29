//Lee un path por teclado, que debe exisir y ser un directorio
//Añade(renombra) .bk a todos los ficheros que cuelguen del path
package rutasFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BorrarFicherosRecursivo {

	public static void main(String[] args) throws IOException {
		System.out.print("Carpeta dónde están los ficheros a borrar: ");
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
		borrarFicheros(donde,true);
		System.out.println("Finalizado.");
	}

	private static void borrarFicheros(File donde, boolean confirmacionUsuario) throws IOException {
		File[] lista = donde.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				borrarFicheros(lista[i],confirmacionUsuario);
			} else{//Fichero
				boolean borrar=true;
				if (confirmacionUsuario){//Muestra diálogo para confirmar borrado
					int opcion=JOptionPane.showConfirmDialog(null, "Quiere borrar "+lista[i].getCanonicalPath()+"?","Confirmación de borrado",JOptionPane.OK_CANCEL_OPTION);
					switch(opcion)
					{
					case JOptionPane.CANCEL_OPTION:
					case JOptionPane.CLOSED_OPTION:
						borrar=false;
						break;
					}
					
				}
				if (borrar){
					if (!lista[i].delete())
						throw new RuntimeException("Error al borrar fichero. "+lista[i].getCanonicalPath());
				}
			}
		}
	}
}
