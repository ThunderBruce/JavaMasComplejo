package fechaHora;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SumarDiasAFecha {

	public static void main(String[] args) throws ParseException {
		System.out.print("Introduzca fecha (DD/MM/AAAA):");
		String cadena=Entrada.cadena();
		//Creamos plantilla para analizar la cadena leida
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Date d=sdf.parse(cadena);
		System.out.print("Días a sumar(+/-):");
		int dias=Entrada.entero();
		
		imprimirDias(d,dias,"EEEE, dd 'de' MMMM 'de' yyyy");

	}

	private static void imprimirDias(Date inicio, int dias, String plantilla) {
		SimpleDateFormat sdf=new SimpleDateFormat(plantilla);
		
		boolean futuro=dias>=0;
		if (dias<0)
			dias=-dias;//Quitamos signo negativo
		for (int i = 0; i < dias; i++) {
			int despl=i;
			if (!futuro)
				despl=-i;
			System.out.println(sdf.format(desplazarDias(inicio, despl)));
		}
	}

	private static Date desplazarDias(Date inicio, int dias) {
		//Pasamos dias a ms
		long ms=(long)dias*24L*3600L*1000L;
		//Creamos un nyuevo objeto Date sumando los ms a los ms de la fecha de inicio
		Date nueva=new Date(inicio.getTime()+ms);
		
		return nueva;
	}

}
