package aplicacionGestionPersonasArrayListEsqueleto;

import java.util.Comparator;

public class OrdenacionPorDNI implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		
		return -o1.getDni().compareTo(o2.getDni());
	}

}
