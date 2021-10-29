package aplicacionGestionPersonasEsqueleto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestionPersonas {

	private static Persona[] bd;
	private final static int MAX_PERSONAS = 100;

	public static void main(String[] args) throws ParseException {
		//Crea array bd don se almacenaran las personas. Contiene referencias a objetos de clase Persona
		//Estas referencias inicialmente estan con valor null
		bd=new Persona[MAX_PERSONAS];
				
		Menu1DAM m=new Menu1DAM("\n== Gestión de Personas ==", true);
		m.agregarOpcion("Altas");
		m.agregarOpcion("Bajas");
		m.agregarOpcion("Modificaciones");
		m.agregarOpcion("Consultas");
		m.agregarOpcion("Listado");
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
				listado();
				break;
			}
		}while(!op.equals("0"));
		System.out.println("ADIOS.");
	}
	
	private static void listado() {
		System.out.println("--> Listado de personas");
	}


	private static void consultas() {
		System.out.println("--> Consulta de persona");
	}

	private static void modificaciones()  {
		System.out.println("--> Modificacion de persona");
	}

	private static void bajas() {
		System.out.println("--> Baja de persona");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void altas()  {
		System.out.println("--> Alta de persona");
		String nombre=Entrada.cadenaVal("Nombre?", "El nombre debe comenzar por una letra", "[A-Za-z].*",true);
		Date fechaNac=Entrada.fechaVal("Fecha nacimiento (dd/mm/aaaa?", "Fecha incorrecta", "dd/MM/yyyy",false);
		try {
			double peso=Entrada.realVal("Peso?", "El peso debe ser positivo", 1.0, Double.MAX_VALUE,true);
		}
		catch (RuntimeException e) { 
			System.out.println("No se ha tecleado nada al pedir peso");
		}
	}
	
	
	
	

	//Devuelve persona del array donde se encuentra el dni. null si no existe
	private static Persona buscar(String dni) {
		
		
		return null;
	}
	
}