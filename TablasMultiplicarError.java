package ejemplos;

public class TablasMultiplicarError {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			System.out.format("\n=== Tabla del %2d ===\n", i);
			escribirTablaMultiplicar(i);
		}
		int cnt = 4;
		while (cnt <= 6);{
			System.out.format("\n=== Tabla del %2d ===\n", cnt);
			escribirTablaMultiplicar(cnt);
			cnt++;
		}
		for (int i = 7; i <= 10; i++) {
			System.out.format("\n=== Tabla del %2d ===\n", i);
			escribirTablaMultiplicar(i);
		}
	}

	private static void escribirTablaMultiplicar(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.format("%2d x %2d = %3d\n", n, i, n * i);
		}
	}

}
