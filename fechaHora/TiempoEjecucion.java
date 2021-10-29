package fechaHora;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class TiempoEjecucion {


	public static void main(String[] args) {
		//Reloj del sistema en milisegundos
		long inicio=System.currentTimeMillis();
		System.out.println(inicio);
		
		//Bucle para consumir tiempo 
		for (int i = 1; i <= 1000000000; i++) {
			for (int j=1;j<=1000000000;j++)
				Math.sqrt(j);
		}
		//Reloj del sistema en milisegundos
		long fin=System.currentTimeMillis();
		System.out.println(fin);
		
		//Mostramos tiempo transcurrido restando
		System.out.println("Ha tardado "+(fin-inicio)+" milisegundos");

	}

}
