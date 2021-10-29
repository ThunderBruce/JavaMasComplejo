package ejemplos;
import aplicacionGestionPersonas.Entrada;

public class ConversionTemperatura {

	public static void main(String[] args) {
		System.out.print("Introduzca grados Celsius:");
		double gradosC=Entrada.real();
		System.out.println("Reamur: "+convertirAReamur(gradosC));
		System.out.println("Faren: "+convertirAReamur(gradosC));
		System.out.println("Reamur: "+convertirAReamur(gradosC));
	
	}

	static double convertirAReamur(double gradosC) {
		return 80.0*gradosC/100.0 ;
	}
	
	static double convertirAFarenheit(double gradosC) {
		return 180.0*gradosC/100.0+32.0;
	}

	static double convertirAKelvin(double gradosC) {
		return gradosC+273.0;
	}
}
