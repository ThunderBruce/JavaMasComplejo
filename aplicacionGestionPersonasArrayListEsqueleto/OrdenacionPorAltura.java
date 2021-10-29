package aplicacionGestionPersonasArrayListEsqueleto;

import java.util.Comparator;

public class OrdenacionPorAltura implements Comparator<Persona> {

	@Override
	public int compare(Persona arg0, Persona arg1) {
		
		double dif= -(arg0.getAltura()-arg1.getAltura()); //Altura Descendente
		if (dif==0) //Caso de igual edad se ordenan por nombre ascendente
			return arg0.getNombre().compareTo(arg1.getNombre());
		else{
				if (dif>0.0)
					return 1;
				else
					return -1;
		}
	}

}
