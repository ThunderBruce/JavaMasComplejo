/* Mantenimiento(ABMC): Altas, Bajas, Modificaciones y Consultas de la tabla persona creada con SQL:
CREATE TABLE persona (
  dni VARCHAR(9),
  nombre VARCHAR(255),
  fechaNac DATE,
  sexo CHAR(1),
  altura FLOAT(3,2),
  peso FLOAT(5,2),
  PRIMARY KEY (dni)
 )
*/

package jdbcPersonaABMC;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIPersonaABMC extends JFrame {
	//Parametros cargados de4sde CFG.INI
	private static String tipoBD;
	private static String nombreBaseDatos;
	private static String ipServidor;
	private static String usuario;
	private static String password;
	private static String plantillaFecha;
	
	//Modos del formulario 
	final static int INICIAL=0; //Formulario vacío
	final static int ALTA=1; //El usuario esta dando de alta a una persona
	final static int BAJA_MODIF=2; //El usuario esta viendo los datos de una persona y tiene opcion de modificar o dar de baja
	int modo=INICIAL;//El boton Guardar hara INSERT o UPDATE en funcion de este modo
	//Objeto para manejar la bases de datos
	static BaseDeDatos bd;
	
	private JPanel contentPane;
	private JTextField textDni;
	private JFrame ventanaPrincipal=this; //Almacenamos una referencia a la ventana que se crea
	private JTextField textNombre;
	private JTextField textFechaNac;
	private JTextField textAltura;
	private JTextField textPeso;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JTextField textPruebas;
	private JButton btnLimpiar;
	private JButton btnBorrar;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Cargamos configuracion y conectamos con la BD antes de mostrar la ventana
		cargarConfiguracion();//Carga CFG.INI que contiene los datos de conexión a la BD y la plantilla a utilizar al leer o mostrar fechas 
		try {
			bd=new BaseDeDatos(tipoBD);
		} catch (Exception e) {
			notificaError(null, "Error al conectar con base de datos", e, null);
			System.exit(-1);
		}
		try {
			bd.conectar(ipServidor,nombreBaseDatos,usuario,password);
		} catch (Exception e) {
			notificaError(null, "Error al conectar con base de datos", e, null);
			System.exit(-1);
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPersonaABMC frame = new GUIPersonaABMC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void notificaError(JFrame padre, String titulo,	Exception e, String mensaje) {
		String contenido="";
		if (e!=null)
			contenido+=e.getClass().getName()+"\n"+e.getMessage(); //Nombre de la excepcion y mensaje de la excep.
		if (mensaje!=null)
			contenido+=mensaje; 
		JOptionPane.showMessageDialog(padre,contenido,titulo, JOptionPane.ERROR_MESSAGE);		
	}
	
	private boolean preguntaUsuario(JFrame padre, String titulo, String mensaje){
		///Mensaje de confirmacion. Devuelve true si el usuario pulsa SI
		return JOptionPane.showConfirmDialog(padre, mensaje,titulo,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;
	}


	/**
	 * Create the frame.
	 */
	public GUIPersonaABMC() {
		setTitle("Persona (ABMC/CRUD)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 11, 46, 14);
		contentPane.add(lblDni);
		
		textDni = new JTextField();
		textDni.setBounds(92, 8, 89, 20);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(212, 7, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 50, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(92, 47, 209, 20);
		contentPane.add(textNombre);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setBounds(10, 86, 72, 14);
		contentPane.add(lblFechaNac);
		
		textFechaNac = new JTextField();
		textFechaNac.setEditable(false);
		textFechaNac.setColumns(10);
		textFechaNac.setBounds(92, 83, 89, 20);
		contentPane.add(textFechaNac);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 127, 46, 14);
		contentPane.add(lblAltura);
		
		textAltura = new JTextField();
		textAltura.setEditable(false);
		textAltura.setColumns(10);
		textAltura.setBounds(92, 124, 89, 20);
		contentPane.add(textAltura);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 168, 46, 14);
		contentPane.add(lblPeso);
		
		textPeso = new JTextField();
		textPeso.setEditable(false);
		textPeso.setColumns(10);
		textPeso.setBounds(92, 165, 89, 20);
		contentPane.add(textPeso);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(191, 96, 110, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setEnabled(false);
		buttonGroup.add(rdbtnHombre);
		rdbtnHombre.setBounds(6, 16, 98, 23);
		panel.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setEnabled(false);
		buttonGroup.add(rdbtnMujer);
		rdbtnMujer.setBounds(6, 45, 98, 23);
		panel.add(rdbtnMujer);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setVisible(false);
		btnGuardar.setBounds(10, 219, 89, 23);
		contentPane.add(btnGuardar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnBorrar.setVisible(false);
		btnBorrar.setBounds(120, 219, 89, 23);
		contentPane.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setVisible(false);
		btnLimpiar.setBounds(230, 219, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel lblParaPruebas = new JLabel("Pruebas");
		lblParaPruebas.setBounds(10, 275, 66, 14);
		contentPane.add(lblParaPruebas);
		
		textPruebas = new JTextField();
		textPruebas.setEditable(false);
		textPruebas.setBounds(71, 273, 248, 17);
		contentPane.add(textPruebas);
		textPruebas.setColumns(10);
		
		//Genera DNIs para probar
		String t="";
		for (int i=1;i<=3;i++)
			t+=Persona.generarDni()+" ";
		textPruebas.setText(t);
	}

	private void borrar() {
		String dni=textDni.getText();
		if (preguntaUsuario(ventanaPrincipal, "Borrar", "Desea dar de baja el DNI: "+dni)){
			try {
				bd.bajaPersona(dni);
				JOptionPane.showMessageDialog(ventanaPrincipal, "Se ha dado de baja la persona con DNI: "+dni);
				limpiar();
			} catch (SQLException e) {
				notificaError(ventanaPrincipal, "Error al borrar Persona", e,null);
			}
		}
	}

	private void guardar() {
		Persona p=personaDesdeFormulario();
		if (p!=null){ //Se ha creado objeto persona (no hay errores)
			try {
				if (modo==ALTA){
					bd.altaPersona(p);
					modoBajaModificacion();
				}
				else
					bd.modificaPersona(p);
				JOptionPane.showMessageDialog(ventanaPrincipal, "Datos guardados correctamente");
			} catch (SQLException e) {
				notificaError(ventanaPrincipal, "Error al guardar persona", e, null);
			}
		}
	}

	private Persona personaDesdeFormulario() {
		// Valida los campos del formulario y crea un objeto persona
		Persona p=new Persona();
		String dni=textDni.getText().trim();
		if (!Persona.dniCorrecto(dni)){
			notificaError(ventanaPrincipal, "DNI incorrecto", null, "DNI: "+dni+" incorrecto");
			return null;
		}
		p.setDni(dni);
		
		String nombre=textNombre.getText().trim();
		if (nombre.length()==0){
			notificaError(ventanaPrincipal, "Nombre incorrecto", null, "El nombre no puede estar vacio");
			return null;
		}
		p.setNombre(nombre);
		
		SimpleDateFormat sdf=new SimpleDateFormat(plantillaFecha);
		sdf.setLenient(false);
		Date d;
		try {
			d = sdf.parse(textFechaNac.getText().trim());
		} catch (ParseException e) {
			notificaError(ventanaPrincipal, "Fecha incorrecta", null, "La fecha debe ser "+plantillaFecha);
			return null;
		}
		p.setFechaNac(d);

		if (!rdbtnHombre.isSelected() && !rdbtnMujer.isSelected()){
			notificaError(ventanaPrincipal, "Sexo incorrecto", null, "Debe marcar un sexo");
			return null;
		}
		p.setSexo(rdbtnHombre.isSelected()?'H':'M');
		
		String altura=textAltura.getText().trim();
		if (altura.length()==0){
			notificaError(ventanaPrincipal, "Altura incorrecta", null, "La altura no puede estar vacia");
			return null;
		}
		try {
			p.setAltura(Double.valueOf(altura));
		} catch (NumberFormatException e) {
			notificaError(ventanaPrincipal, "Altura incorrecta", null, "Indique un altura en metros. Ejemplo: 1.74");
			return null;
		}
		
		String peso=textPeso.getText().trim();
		if (peso.length()==0){
			notificaError(ventanaPrincipal, "Peso incorrecto", null, "El peso no puede estar vacio");
			return null;
		}
		try {
			p.setPeso(Double.valueOf(peso));
		} catch (NumberFormatException e) {
			notificaError(ventanaPrincipal, "Peso incorrecto", null, "Indique un peso en Kg. Ejemplo: 90.5");
			return null;
		}
		
		return p;
	}

	private void limpiar() {
		modo=INICIAL;
		//Oculta botones y limpia cajas de texto
		btnGuardar.setVisible(false);
		btnBorrar.setVisible(false);
		btnLimpiar.setVisible(false);
		textDni.setText("");
		textNombre.setText("");
		textFechaNac.setText("");
		//Desmarca los radio buttons de sexo
		buttonGroup.clearSelection();
		textAltura.setText("");
		textPeso.setText("");
		
		textDni.setEditable(true);
		textNombre.setEditable(false);
		textFechaNac.setEditable(false);
		rdbtnHombre.setEnabled(false);
		rdbtnMujer.setEnabled(false);
		textAltura.setEditable(false);
		textPeso.setEditable(false);
	}

	private void consultar() {
		String dni=textDni.getText();
		if (!Persona.dniCorrecto(dni)){
			notificaError(ventanaPrincipal, "DNI incorrecto", null, "DNI: "+dni+" incorrecto");
			return;
		}
		try {
			jdbcPersonaABMC.Persona p=bd.consultaPersona(dni);
			if (p==null){
				if (preguntaUsuario(ventanaPrincipal, "DNI no existe", "Desea dar de alta el DNI: "+dni))
					modoAlta();
			}
			else{
				mostrarPersona(p);
				modoBajaModificacion();
			}
		} catch (SQLException e) {
			notificaError(ventanaPrincipal, "Error al consultar Persona", e,null);
		}
		
	}

	private void modoBajaModificacion() {
		modo=BAJA_MODIF;
		btnGuardar.setVisible(true);
		btnBorrar.setVisible(true);
		btnLimpiar.setVisible(true);
		textDni.setEditable(false);
		textNombre.setEditable(true);
		textFechaNac.setEditable(true);
		rdbtnHombre.setEnabled(true);
		rdbtnMujer.setEnabled(true);
		textAltura.setEditable(true);
		textPeso.setEditable(true);
	}

	private void modoAlta() {
		modo=ALTA;
		btnGuardar.setVisible(true);
		btnBorrar.setVisible(false);
		btnLimpiar.setVisible(true);
		textDni.setEditable(false);
		textNombre.setEditable(true);
		textFechaNac.setEditable(true);
		rdbtnHombre.setEnabled(true);
		rdbtnMujer.setEnabled(true);
		textAltura.setEditable(true);
		textPeso.setEditable(true);
	}
	
	

	private void mostrarPersona(Persona p) {
			//Muestra un objeto Persona en los campos del formulario
			textDni.setText(p.getDni());
			textNombre.setText(p.getNombre());
			SimpleDateFormat sdf=new SimpleDateFormat(plantillaFecha);
			textFechaNac.setText(sdf.format(p.getFechaNac()));
			if (p.getSexo()=='H')
				rdbtnHombre.setSelected(true);
			else
				rdbtnMujer.setSelected(true);
			textAltura.setText(String.valueOf(p.getAltura()));
			textPeso.setText(String.valueOf(p.getPeso()));
	}

	private static void cargarConfiguracion() {
		//Lee CFG.INI, Archivo de configuracion compuesto de lineas de la forma NombrePararmetro=valor
		//Si falla la carga desde CFG.INI se toman estos valores por defecto
		tipoBD="";
		nombreBaseDatos="";
		ipServidor="";
		usuario="";
		password="";
		plantillaFecha="";
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File("CFG.INI")));
			String linea;
			while ((linea=br.readLine())!=null){
				if (linea.matches(".+=.+")){//Solo se analizan lineas que contengan un = en medio
					linea=linea.replace(" ", "");//Quita los espacios en blanco
					String [] partes=linea.split("=");
					switch (partes[0]){
						case "TipoBD":
							tipoBD=partes[1];;
							break;
						case "NombreBaseDatos":
							nombreBaseDatos=partes[1];;
							break;
						case "IPServidor":
							ipServidor=partes[1];;
							break;
						case "Usuario":
							usuario=partes[1];;
							break;
						case "Password":
							password=partes[1];;
							break;
						case "PlantillaFecha":
							plantillaFecha=partes[1];
							break;
					}
				}
			}
			br.close();
		} catch (IOException e) {

		}
	}
}
