package fechaHora;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AdivinarDiaDeLaSemana {

	public static void main(String[] args) throws ParseException {
		System.out.print("Introduzca fecha (DD/MM/AAAA):");
		String cadena=Entrada.cadena();
		//Creamos plantilla para analizar la cadena leida
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Date d=sdf.parse(cadena);
		System.out.println(d);
		//Creamos plantilla para mostrar dia de la semana
		sdf=new SimpleDateFormat("EEEE");
		System.out.println(sdf.format(d));
		sdf=new SimpleDateFormat("u");
		System.out.println(diaSemana(sdf.format(d)));

	}

	private static String diaSemana(String dia) {
		String t=null;
		
		switch(dia) { 
		case "1":t= "Lunes";
		break;
		case "2":t= "Martes";
		break;
		case "3":t= "Miércoles";
		break;
		case "4":t= "Jueves";
		break;
		case "5":t= "Viernes";
		break;
		case "6":t= "Sábado";
		break;
		case "7":t= "Domingo";
		break;
		}
		return t;
	}

}
