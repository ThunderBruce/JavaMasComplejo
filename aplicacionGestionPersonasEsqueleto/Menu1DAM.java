package aplicacionGestionPersonasEsqueleto;

import java.util.ArrayList;

import ejemplos.Entrada;

public class Menu1DAM {
	String titulo;
	boolean numerico;
	ArrayList<String> opciones;
	ArrayList<String> valoresOpcion;//Valores que permiten seleccionar cada opcion (1,2,3...0 ó A,B,C...Z) Creamos este ArrayList cada vez que se muestra el menu
	
	public Menu1DAM(String titulo, boolean numerico) {
		this.titulo = titulo;
		this.numerico = numerico;
		opciones=new ArrayList<String>();
	}
	public void agregarOpcion(String op) {
		opciones.add(op);
	}
	public void mostrar() {
		valoresOpcion=new ArrayList<>();
		if (titulo!=null)
			System.out.println(titulo);
		String valor="";
		for (int i = 0; i < opciones.size(); i++) {
			if (numerico) {//Secuencia numerica, el ultimo es cero
				if (i==opciones.size()-1)
					valor="0";
				else
					valor=String.valueOf(i+1);
			}
			else {
				if (i==opciones.size()-1)
					valor="Z";
				else
					valor=String.valueOf((char)('A'+i));
			}
			valoresOpcion.add(valor);
			System.out.println(valor+"-"+opciones.get(i));
		}
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public boolean isNumerico() {
		return numerico;
	}
	public void setNumerico(boolean numerico) {
		this.numerico = numerico;
	}
	public String leerOpcion() {
		String op="";
		boolean bien;
		do {
			System.out.print("Elija una opción:");
			op=Entrada.cadena().trim().toUpperCase();
			bien=valoresOpcion.contains(op);//true si op está en el arraylist
			if (!bien)
				System.out.println("Opción incorrecta!!");
		}while(!bien);
		return op;
	}
	
	
}
