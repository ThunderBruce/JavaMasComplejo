package menus;

public class AplicacionQueUsaMenus {

	public static void main(String[] args) {
		Menu1DAM m=new Menu1DAM("\n== BANCO ==", false);
		m.agregarOpcion("Altas");
		m.agregarOpcion("Bajas");
		m.agregarOpcion("Modificaciones");
		m.agregarOpcion("Salir");
		String op;
		do {
			m.mostrar();
			op=m.leerOpcion();
			switch(op) {
			case "A":
				altas();
				break;
			case "B":
				bajas();
				break;
			case "C":
				modificaciones();
				break;
			}
		}while(!op.equals("Z"));
		System.out.println("ADIOS.");
	}

	private static void modificaciones() {
		System.out.println("== Modificaciones ==");
	}

	private static void bajas() {
		System.out.println("== Bajas ==");
	}

	private static void altas() {
		System.out.println("== Altas ==");
	}
}
