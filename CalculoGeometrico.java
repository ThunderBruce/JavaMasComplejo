package ejemplos;

import utilidades.Entrada;

public class CalculoGeometrico {

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion=Entrada.entero();
			if (opcionCorrecta(opcion)) {
				switch (opcion) {
				case 1:circunferencia();
					break;
				case 2:circulo();
					break;
				case 3:esfera();
					break;
				}
			}
			else
				System.out.println("Opcion incorecta!!");
		} while (opcion!=0);

	}
	
	private static double redondear( double numero, int decimales )
	{
		return Math.rint(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
	}

	private static void esfera() {
		System.out.print("Introduzca radio de la esfera:");
		double r=Entrada.real();
		double v=calcularVolumenEsfera(r);
		System.out.println("El volumen es: "+redondear(v,2));
	}

	private static double calcularVolumenEsfera(double r) {
		return 4.0*Math.PI*r*r*r/3.0;
	}

	private static void circulo() {
		System.out.print("Introduzca radio del círculo:");
		double r=Entrada.real();
		double s=calcularSuperficieCirculo(r);
		System.out.println("La superficie es: "+redondear(s,2));
	}

	private static double calcularSuperficieCirculo(double r) {
		return Math.PI*r*r;
	}

	private static void circunferencia() {
		System.out.print("Introduzca radio de la circunferencia:");
		double r=Entrada.real();
		double l=calcularLongitudCircunferencia(r);
		System.out.println("La longitud es: "+redondear(l,2));
	}

	private static double calcularLongitudCircunferencia(double r) {
		return 2.0*Math.PI*r;
	}

	private static boolean opcionCorrecta(int opcion) {
		return opcion>=0 && opcion<=3;
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("1-Calcular longitud de circunferencia");
		System.out.println("2-Calcular área de círculo");
		System.out.println("3-Calcular volumen de estera");
		System.out.println("0-Salir");
		System.out.print("Seleccione opcion: ");
	}

}
