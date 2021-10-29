package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class EjemploGUIMapaPalabras extends JFrame {

	private JPanel contentPane;
	private JTextField textRuta;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploGUIMapaPalabras frame = new EjemploGUIMapaPalabras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EjemploGUIMapaPalabras() {
		setTitle("Estadistica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680,  354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSe = new JButton("Seleccionar Fichero");
		btnSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonSelecionarFichero();
			}
		});
		btnSe.setBounds(10, 53, 210, 23);
		contentPane.add(btnSe);
		
		textRuta = new JTextField();
		textRuta.setBounds(239, 54, 415, 20);
		contentPane.add(textRuta);
		textRuta.setColumns(10);
		
		JLabel lblRutaSeleccionada = new JLabel("Ruta Seleccionada");
		lblRutaSeleccionada.setBounds(239, 29, 104, 14);
		contentPane.add(lblRutaSeleccionada);
		
		JButton btnObtenerPalabras = new JButton("Obtener palabras");
		btnObtenerPalabras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonObtenerPalabras();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnObtenerPalabras.setBounds(10, 126, 203, 23);
		contentPane.add(btnObtenerPalabras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 125, 415, 146);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	protected void botonObtenerPalabras() throws IOException {
		Map<String,Integer> m=estadisticaPalabras(new File(textRuta.getText()), true);
		String texto="";
		for(String pal:m.keySet()) {
			texto+=pal+" "+m.get(pal)+"\n";
		}
		textArea.setText(texto);
	}

	protected void botonSelecionarFichero(){
		JFileChooser fc=new JFileChooser("/");
		fc.setDialogTitle("Seleccione fichero de texto");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION)
		{
			textRuta.setText(fc.getSelectedFile().getAbsolutePath());
		}
	}
	private static Map<String,Integer> estadisticaPalabras(File rutaFich, boolean ignorarMayMin) throws IOException {
		Map<String,Integer> mapa=new TreeMap<String,Integer>();
		BufferedReader bfr=new BufferedReader(new FileReader(rutaFich));
		String linea;
		while((linea=bfr.readLine())!=null){
			for (String pal:partirPalabras(linea)){
				if (ignorarMayMin)
					pal=pal.toUpperCase();
				//Añade palabra al mapa con contador 1 o incrementando si ya existe
				if (mapa.containsKey(pal))
					mapa.put(pal,mapa.get(pal)+1);
				else
					mapa.put(pal,1);
			}
		}
			
		bfr.close();
		return mapa;
	}
	
	private static String[] partirPalabras(String linea) {
		return linea.split("[ ,.:;()¡!¿?]+");
	}
}
