package herencia.PersFutbTenis;

public class Persona {
	String nif;
	String nombre;
	int edad;
	
	public Persona() {
	edad=12;
	nif="999K";
	}
	public Persona(String nif, String nombre, int edad) {
		this.nif = nif;
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", edad=" + edad
				+ "]";
	}
	
	
}
