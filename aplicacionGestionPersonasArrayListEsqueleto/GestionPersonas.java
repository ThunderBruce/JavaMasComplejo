package aplicacionGestionPersonasArrayListEsqueleto;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class GestionPersonas {
	//Parametros de configuracion. Se inicializan a valores por defecto por si no se pueden obtener del archivo CFG.INI
	private static String rutaArchivo="Personas";
	private static String plantillaFecha="dd-MM-yyyy";
	
	//ArrayList donde se realizan altas, bajas, listados, ....
	private static ArrayList<Persona> bd;

	public static void main(String[] args) throws ParseException {
		System.out.println("Ruta archivo: "+rutaArchivo+"\nPlantilla para fecha: "+plantillaFecha);
		//Crea array list bd donde se almacenaran las personas. Contiene referencias a objetos de clase Persona
		bd=new ArrayList<Persona>(); //Inicialmente no contiene ningún elemento. bd.size()==0
		Menu1DAM m=new Menu1DAM("\n== Gestión de Personas ==", true);
		m.agregarOpcion("Altas");
		m.agregarOpcion("Bajas");
		m.agregarOpcion("Modificaciones");
		m.agregarOpcion("Consultas");
		m.agregarOpcion("Listado (ordenado por Nombre)");
		m.agregarOpcion("Listado (ordenado por Edad)");
		m.agregarOpcion("Listado (ordenado por Altura)");
		m.agregarOpcion("Listado (ordenado por DNI)");
		m.agregarOpcion("Guardar en archivo "+rutaArchivo+".txt");
		m.agregarOpcion("Cargar desde archivo "+rutaArchivo+".txt");
		m.agregarOpcion("Salir");
		String op;
		do {
			m.mostrar();
			op=m.leerOpcion();
			switch(op) {
			case "1":
				altas();
				break;
			case "2":
				bajas();
				break;
			case "3":
				modificaciones();
				break;
			case "4":
				consultas();
				break;
			case "5":
				listadoPorNombre();
				break;
			case "6":
				listadoPorEdad();
				break;
			case "7":
				listadoPorAltura();
				break;
			case "8":
				listadoPorDNI();
				break;
			case "9":
				guardarEnArchivoTXT();
				break;
			case "10":
				cargarDesdeArchivoTXT();
				break;
			}
		}while(!op.equals("0"));
		System.out.println("ADIOS.");
	}


	private static void cargarDesdeArchivoTXT() {
		System.out.println("--> Cargar desde archivo TXT");
		String rutaTXT=rutaArchivo+".txt";
		File ruta=new File(rutaTXT);
		if (!ruta.exists()){
			System.out.println(rutaTXT+" NO EXISTE!!");
			return;
		}
		try {
			BufferedReader br=new BufferedReader(new FileReader(rutaTXT));
			String linea;
			bd.clear();//Borra todos los elementos del ArrayList
			while ((linea=br.readLine())!=null){
				Persona p=convertirCadenaEnPersona(linea);
				if (p!=null)
					bd.add(p);
			}
			br.close();
			System.out.println(bd.size()+" personas cargadas desde "+rutaTXT);
		} catch (IOException e) {
			System.out.println("Error al cargar desde "+rutaTXT+"!!");
			System.out.println(e.getMessage());
		}
	}

	private static Persona convertirCadenaEnPersona(String cad) {
		// cad es un String compuesto de campos separados por ;
		String [] campos=cad.split(";");  
		if (campos.length!=6) //Esperamos 6 campos: DNI;nombre;fecha;sexo;altura;peso
			return null;
		Persona per=new Persona();
		per.setDni(campos[0]);
		per.setNombre(campos[1]);
		SimpleDateFormat sdf=new SimpleDateFormat(plantillaFecha);
		sdf.setLenient(false);
		Date d;
		try {
			d = sdf.parse(campos[2]);
		} catch (ParseException e) {
			return null;
		}
		per.setFechaNac(d);
		per.setSexo(campos[3].charAt(0));
		try {
			per.setAltura(Double.valueOf(campos[4]));
			per.setPeso(Double.valueOf(campos[5]));
		} catch (NumberFormatException e) {
			return null;
		}
		
		return per;
	}

	private static void guardarEnArchivoTXT() {
		System.out.println("--> Guardar en archivo TXT");
		File rutaTXT=new File(rutaArchivo+".txt");
		if (rutaTXT.exists()){//Si existe ruta pedimos confirmacion de sobreescritura
			if (Entrada.cadenaVal("¿Sobrescribir "+rutaTXT.getName()+"? (S/N)", "S o N", "[SN]",false).equals("N")){
				System.out.println("Personas no guardadas en "+rutaTXT+"!!");
				return;
			}
		}
		try {
			PrintWriter pw=new PrintWriter(rutaTXT); //Abrimos para escritura(creando o sobreescribiendo si ya existiese)
			for (int i=0;i<bd.size();i++){
				String linea=convertirPersonaEnCadena(bd.get(i));
				pw.println(linea);
			}
			pw.close();
			System.out.println(bd.size()+" personas guardadas en "+rutaTXT);
		} catch (FileNotFoundException e) {
			System.out.println("Error al guardar en "+rutaTXT+"!!");
			System.out.println(e.getMessage());
		}
	}

	private static String convertirPersonaEnCadena(Persona p) {
		//Convierte un objeto Persona en un String: DNI;nombre;fechaNaccim(segun plantilla);sexo;altura;peso
		String cad=p.getDni()+";";
		cad+=p.getNombre()+";";
		SimpleDateFormat sdf=new SimpleDateFormat(plantillaFecha);
		cad+=sdf.format(p.getFechaNac())+";";
		cad+=p.getSexo()+";";
		cad+=p.getAltura()+";";
		cad+=p.getPeso();
		return cad;
	}

	private static void listadoPorDNI() {
		System.out.println("--> Listado de personas por DNI");
		//Ordena por Edad(Comparator)
		Collections.sort(bd,new OrdenacionPorDNI());
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
		
	}

	private static void listadoPorAltura() {
		System.out.println("--> Listado de personas por altura (descentente)");
		//Ordena por Altura(Comparator)
		Collections.sort(bd,new OrdenacionPorAltura());
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
		
	}

	private static void listadoPorEdad() {
		System.out.println("--> Listado de personas por edad (descentente)");
		//Ordena por Edad(Comparator)
		Collections.sort(bd,new OrdenacionPorEdad());
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
		
	}


	private static void listadoPorNombre() {
		System.out.println("--> Listado de personas por nombre");
		//Ordena con criterio por defecto(Comparable)
		Collections.sort(bd);
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
	}

	private static void consultas() {
		System.out.println("--> Consulta de persona");
		String dni=Entrada.cadenaVal("DNI a consultar?","8 digitos+letra!!","[0-9]{8}[A-Z]",false);
		int pos=buscar(dni);
		if (pos==-1)
			System.out.println("El dni "+dni+" no existe!!");
		else
			System.out.println(bd.get(pos));
	}

	private static void modificaciones() throws ParseException {
		System.out.println("--> Modificacion de persona");
		System.out.print("DNI a modificar?");
		String dni=Entrada.cadena();
		int pos=buscar(dni);
		if (pos==-1)
			System.out.println("El dni "+dni+" no existe!!");
		else 
		{
				String nuevo;
				Persona p=bd.get(pos);
				//Muestra datos de la persona que se va a modificar
				System.out.println(p);
				//Da opcion a modificar cada campo. Si se pulsa ENTER se mantiene el valor sin modificarlo
				try {
					nuevo=Entrada.cadenaVal("Nombre ["+p.getNombre()+"]?", "Nombre debe contener al menos dos caracteres!!", ".{2,}", true);
					p.setNombre(nuevo); //Modificamos nombre
				} catch (RuntimeException e) {
					//Se ha pulsado ENTER, no hacemos nada
				}
				try {
					char s=Entrada.cadenaVal("Sexo ["+p.getSexo()+"]?", "H o M!!", "[HM]", true).charAt(0);
					p.setSexo(s); //Modificamos sexo
				} catch (RuntimeException e) {
					//Se ha pulsado ENTER, no hacemos nada
				}
				try {
					SimpleDateFormat sdf=new SimpleDateFormat(plantillaFecha);
					Date d=Entrada.fechaVal("Fecha nacimiento ["+sdf.format(p.getFechaNac())+"]?", "Fecha incorrecta!!", plantillaFecha, true);
					p.setFechaNac(d); //Modificamos fecha
				} catch (RuntimeException e) {
					//Se ha pulsado ENTER, no hacemos nada
				}
				try {
					Double peso=Entrada.realVal("Peso ["+p.getPeso()+"]?","Peso incorrecto!!", 0, 500, true);
					p.setPeso(peso); //Modificamos peso
				} catch (RuntimeException e) {
					//Se ha pulsado ENTER, no hacemos nada
				}
				try {
					Double altura=Entrada.realVal("Altura ["+p.getAltura()+"]?","Altura incorrecta!!", 0, 400, true);
					p.setAltura(altura); //Modificamos altura
				} catch (RuntimeException e) {
					//Se ha pulsado ENTER, no hacemos nada
				}

				System.out.println("==> La persona con DNI "+dni+" ha sido MODIFICADA");
		}

	}

	private static void bajas() {
		System.out.println("--> Baja de persona");
		String dni=Entrada.cadenaVal("DNI a dar de baja?","8 digitos+letra!!","[0-9]{8}[A-Z]",false);
		int pos=buscar(dni);
		if (pos==-1)
			System.out.println("El dni "+dni+" no existe!!");
		else
		{
			bd.remove(pos);
			System.out.println("==> La persona con DNI "+dni+" ha sido dada de BAJA");
		}
	}

	private static void altas() throws ParseException {
		System.out.println("--> Alta de persona");
		
		//Muestra DNIs aleatorios para probar
		System.out.print("DNIs de prueba:");
		for (int i=1;i<=3;i++)
			System.out.print(Persona.generarDni()+" ");
		System.out.println();
		
		String dni=Entrada.cadenaVal("DNI?","8 digitos+letra!!","[0-9]{8}[A-Z]",false);
		// Comprueba que DNI sea un DNI con letra correcta
		if (!Persona.dniCorrecto(dni)){
			System.out.println("DNI incorrecto!!");
			return;
		}
		if (buscar(dni)!=-1){
			System.out.println("Este DNI "+dni+" ya existe!!");
			return;
		}
		//Una vez comprobado lo anterior podemos pedir el resto de los datos para finalizar el alta
		Persona p;
		p = new Persona(); //Creamos objeto persona con constructor por defecto
		//El constructor genera un DNI aleatorio. Le asignamos el DNI leido
		p.setDni(dni);
		//Le asignamos atrinutos
		p.setNombre(Entrada.cadenaVal("Nombre?", "Nombre debe contener al menos dos caracteres!!", ".{2,}",false));
		p.setSexo(Entrada.cadenaVal("Sexo?", "H o M!!", "[HM]",false).charAt(0));
		p.setFechaNac(Entrada.fechaVal("Fecha nacimiento?", "Fecha incorrecta!!", plantillaFecha,false)); 
		p.setPeso(Entrada.realVal("Peso?","Peso incorrecto!!", 0, 500,false)); 
		p.setAltura(Entrada.realVal("Altura?","Altura incorrecta!!", 0, 400,false)); 

		//Añadimos el objeto Persona al arrayList
		bd.add(p);
		System.out.println("==> La persona con DNI "+dni+" ha sido dada de ALTA");
	}

	//Devuelve la posicion del array donde se encuentra el dni. -1 si no existe
	private static int buscar(String dni) {
		for (int i=0;i<bd.size();i++)
		{
				if (bd.get(i).getDni().equals(dni))
					return i;
		}
		return -1;
	}
	
	
}