package fechaHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalcularEdad {
	private static int calcularEdad(Date fechaNac) {
        GregorianCalendar hoy = new GregorianCalendar();
        GregorianCalendar nac = new GregorianCalendar();
        nac.setTime(fechaNac);//Transformamos Date en GregorianCalendar
        
        int difAnios = hoy.get(Calendar.YEAR) -  nac.get(Calendar.YEAR);
        int difMeses = hoy.get(Calendar.MONTH) - nac.get(Calendar.MONTH);
        int difDias = hoy.get(Calendar.DAY_OF_MONTH) - nac.get(Calendar.DAY_OF_MONTH);
        
        if (difAnios<0) //Error anio de nac posterior al actual
        	return 0;
        //Si está en ese año pero todavía no los ha cumplido
        if (difMeses < 0 || (difMeses == 0 && difDias < 0)) {
            difAnios = difAnios - 1; 
        }
        return difAnios;
    }	
	public static void main(String[] args) throws ParseException {
		System.out.println("Fecha nacimiento (dd-mm-aaaa)?");
		String t=Entrada.cadena();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		Date fechaNac=sdf.parse(t);
		int edad=calcularEdad(fechaNac);
		System.out.println("Edad:"+edad);

	}

}
