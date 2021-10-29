package herencia.PersFutbTenis;

public class Futbolista extends Persona {
	
	String equipo;
	int goles;

	public Futbolista(String nif, String nombre, int edad, String equipo, int goles) {
		super(nif, nombre, edad);
		this.equipo=equipo;
		this.goles=goles;
	}

	@Override
	public String toString() {
		return "Futbolista [equipo=" + equipo + ", goles=" + goles + ", nif=" + nif + ", nombre=" + nombre + ", edad="
				+ edad + "]";
	}




	
}
