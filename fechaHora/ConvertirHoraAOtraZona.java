package fechaHora;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ConvertirHoraAOtraZona {

	public static void main(String[] args) {
		
		System.out.println("=== Nombres de zona horaria ===");
		for (String idZona:TimeZone.getAvailableIDs())
			System.out.println(idZona);
		GregorianCalendar gc=new GregorianCalendar();
		System.out.println("\nHora actual:"+gc.get(Calendar.HOUR_OF_DAY)+":"+gc.get(Calendar.MINUTE)+" "+gc.getTimeZone().getID());
		System.out.print("Nueva zona?");
		String nuevaStr=Entrada.cadena();
		TimeZone nueva=TimeZone.getTimeZone(nuevaStr);
		gc.setTimeZone(nueva);
		System.out.println("Hora actual(nueva zona):"+gc.get(Calendar.HOUR_OF_DAY)+":"+gc.get(Calendar.MINUTE)+" "+gc.getTimeZone().getID());
	}

}
