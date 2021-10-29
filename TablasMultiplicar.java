package ejemplos;

public class TablasMultiplicar {

	public static void main(String[] args) {
		for (int i = 1; i <=10; i++) {
			System.out.format("\n=== Tabla del %2d ===\n",i);
			escribirTablaMultiplicar(i);
		}
	}

	private static void escribirTablaMultiplicar(int n) {
		for (int i = 1; i<=10; i++) {
			System.out.format("%2d x %2d = %3d\n",n,i,n*i);
		}
	}

}
