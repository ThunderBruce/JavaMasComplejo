package ejemplos;

public class BarajaEspaniola {

	public static void main(String[] args) {
		System.out.println("== Baraja Española ==");
		String baraja[] = crearBaraja();
		mostrarCartas(baraja);
		
		System.out.println("== Primera Mano(aleatoria) ==");
		String m1[]=extraerCartas(20, baraja);
		mostrarCartas(m1);
		System.out.println("== Segunda Mano(aleatoria) ==");
		String m2[]=extraerCartas(20, baraja);
		mostrarCartas(m2);
		
		System.out.println(contarCartasIguales(m1,m2)+ " cartas iguales.");
		
		
		String m3[]= {"1O","2E","10B","2C"};
		System.out.println("\n== Tercera Mano ==");
		mostrarCartas(m3);
		String m4[]= {"2C","11E","7B","2E"};
		System.out.println("== Cuarta Mano ==");
		mostrarCartas(m4);
		System.out.println(contarCartasIguales(m3,m4)+ " cartas iguales.");
	
	}
	
	private static int contarCartasIguales(String[] m1, String[] m2) {
		int cnt=0;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2.length; j++) {
				if(m1[i].equals(m2[j]))
					cnt++;
			}
		}
		return cnt;
	}

	private static String[] crearBaraja() {
		String b[] = new String[40];
		for (int i = 0; i < b.length; i++) {
			int valorCarta = i % 10 + 1;
			if (valorCarta > 7)
				valorCarta = valorCarta + 2;
			String palo;
			if (i >= 0 && i <= 9)
				palo = "O";
			else {
				if (i >= 10 && i <= 19)
					palo = "C";
				else {
					if (i >= 20 && i <= 29)
						palo = "E";
					else {
						palo = "B";
					}
				}
			}
			String carta = valorCarta + palo;
			b[i] = carta;
		}
		return b;
	}

	private static String[] extraerCartas(int numero, String[] baraja) {
		String mano[] = new String[numero];
		
		if (numero > cartasDisponibles(baraja))
			return mano;
		
		for (int i = 0; i < mano.length; i++) {
			boolean extraida=false;
			int aleat;
			do {
				aleat=Aleatorios.generarAleatorio(0,baraja.length-1);
				extraida = !baraja[aleat].equals("");
			} while (!extraida);
			mano[i]=baraja[aleat];
			baraja[aleat]=""; //Borramos la carta para no volver a extraerla
		}
		return mano;
	}

	private static int cartasDisponibles(String[] baraja) {
		int cnt=0;
 		for (int i = 0; i < baraja.length; i++) {
			if (!baraja[i].equals(""))
				cnt++;
		}
 		return cnt;
	}

	private static void mostrarCartas(String[] b) {
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}


}
