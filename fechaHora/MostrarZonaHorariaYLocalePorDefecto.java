package fechaHora;

import java.util.Locale;
import java.util.TimeZone;

public class MostrarZonaHorariaYLocalePorDefecto {

	public static void main(String[] args) {
		System.out.println(TimeZone.getDefault().getID());
		System.out.println(Locale.getDefault().getDisplayName());

	}

}
