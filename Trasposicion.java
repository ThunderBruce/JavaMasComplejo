package ejemplos;

public class Trasposicion {

	public static void main(String[] args) {
		
		
		for (int i=1; i<=5;i++) {
			int filas=Aleatorios.generarAleatorio(1,10); 
			int cols=Aleatorios.generarAleatorio(1,8); 
			System.out.format("== Caso %d ==\n",i);
			int al[][]=Matrices.crearMatrizAleatoria(filas,cols);
			Matrices.mostrarMatriz(al);
			System.out.println();
			Matrices.mostrarMatriz(Matrices.trasponerMatriz(al));
		}
	}

}
