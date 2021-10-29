package ejemplos;

import java.util.Random;

import utilidades.Entrada;

public class Aleatorios {

	public static void main(String[] args) {
		System.out.println("Tiramos diez veces un dado");
		for (int i = 1; i <= 10; i++) {
			System.out.println(tirarDado());
		}
		System.out.println("\nTiramos cinco veces ua moneda");
		for (int i = 1; i <= 5; i++) {
			System.out.println(tirarMoneda());
		}
		System.out.println("\nQué siginifica \"En plan\"?");
		for (int i = 1; i <= 5; i++) {
			System.out.println(enPlan());
		}
		System.out.print("\nDesde? ");
		int desde=Entrada.entero();
		System.out.print("\nHasta? ");
		int hasta=Entrada.entero();
		for (int i = 1; i <= 5; i++) {
			System.out.println(generarAleatorio(desde,hasta));
		}
		System.out.println(generarAleatorio(desde,hasta));
	}

	private static int generarAleatorio(int desde, int hasta) {
		if (hasta<desde)
			return 0;
		Random r=new Random();
		int n=r.nextInt(hasta-desde+1); //0..hasta-desde
		return n+desde;
	}

	private static String enPlan() {
		String significado="";
		Random r=new Random();
		int n=r.nextInt(5); //0..4
		switch(n) {
			case 0:significado="Es decir";
			break;
			case 1:significado="Por ejemplo";
			break;
			case 2:significado="Como...";
			break;
			case 3:significado="Hamburguesa con queso";
			break;
			case 4:significado="Me voy de viaje";
			break;
		}
		return significado;
	}

	private static String tirarMoneda() {
		Random r=new Random();
		int n=r.nextInt(2); //0..1
		if (n==0)
			return "cara";
		else
			return "cruz";
	}

	private static int tirarDado() {
		Random r=new Random();
		int n=r.nextInt(6); //0..5
		return n+1;
	}

}
