package aplicacionGestionPersonasArrayListEsqueleto;

import java.util.Comparator;

public class OrdenacionPorEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona arg0, Persona arg1) {
		
		int dif= -(arg0.obtenerAnios()-arg1.obtenerAnios()); //Edad descendente
		if (dif==0) //Caso de igual edad se ordenan por nombren ascendente
			return arg0.getNombre().compareTo(arg1.getNombre());
		else
				return dif;
	}

}
