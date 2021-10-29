package objetos;

public class Persona {
	//Atributos
	String dni;
	String nombre;
	String apellidos;
	int edad;
	boolean gafas;//true-Tiene gafas, false-No tiene gafas
	
	public Persona(String dni, String nombre, String apellidos, int edad, boolean gafas) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.gafas = gafas;
	}

	public Persona() {
		this("1A","","",1,false);
	}

	public Persona(String dni) {
		this(dni,"","",1,false);
	}

	

	public String getDni() {
		return dni;
	}

	public void setDni(String a) {
		this.dni = a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad<0)
			this.edad=0;
		else
			this.edad = edad;
	}

	public boolean isGafas() {
		return gafas;
	}

	public void setGafas(boolean gafas) {
		this.gafas = gafas;
	}

	@Override
	public String toString() {
		String t="Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad+ ", apellidos=" + apellidos+ ", " ;
		
		if (gafas)
			t=t+ "Lleva gafas";
		else
			t=t+ "No lleva gafas";
		
		t=t+"]";
		return t;
	}
}
