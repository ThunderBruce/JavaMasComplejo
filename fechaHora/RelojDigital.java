package fechaHora;


import java.text.SimpleDateFormat;
import java.util.Date;

public class RelojDigital {

	public static void main(String[] args) throws InterruptedException {
		for(;;) {
			//Miramos el reloj
			Date d=new Date();
			//Formateamos a HH:MM:SS
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			String t=sdf.format(d);
			System.out.println(t);
			//Paramos 1 seg
			Thread.sleep(1000);
		}

	}
}
