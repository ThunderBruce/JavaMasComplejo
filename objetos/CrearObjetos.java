package objetos;

public class CrearObjetos {

	public static void main(String[] args) {
		Persona p=new Persona();
		System.out.println(p);
		p.setNombre("Carlos");
		System.out.println(p);
		
		Persona p2=new Persona("34S", "Julian", "Torralba", 45, true);
		System.out.println(p2);

	}

}
