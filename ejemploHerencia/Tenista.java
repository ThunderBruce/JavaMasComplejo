package herencia.PersFutbTenis;

public class Tenista extends Persona {
	
	int ranking;

	public Tenista(String nif, String nombre, int edad, int ranking) {
		super(nif,nombre,edad);
		super.edad*=2;
		super.nombre=nombre;
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Tenista [ranking=" + ranking + ", nif=" + nif + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	


	
}
