package ejemplos;

public class Caracteres {

	public static void main(String[] args) {
		char letra='A';
		System.out.println(letra);
		letra=(char)(letra+1);
		System.out.println(letra);
		letra=(char)(letra+1);
		System.out.println(letra);
		
		for (int i='A';i<='Z';i++) {
			System.out.println("Codigo Unicode:"+i+" Caracter:"+(char)i);
		}

	}

}
