package rutasFile;

import java.io.File;

import javax.swing.JFileChooser;

public class SeleccionarFicheros {

	public static void main(String[] args) {
		JFileChooser fc=new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Seleccione fichero origen");
		int opcion=fc.showOpenDialog(null);
		if (opcion==JFileChooser.APPROVE_OPTION){
			File ruta=fc.getSelectedFile();
			System.out.println(ruta.getAbsolutePath());
		}
	}

}
