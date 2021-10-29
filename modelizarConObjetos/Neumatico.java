package modelizarConObjetos;

public class Neumatico {
	int ancho;
	int perfil;
	int radio;
	String marca;
	
	public Neumatico(int ancho, int perfil, int radio, String marca) {
		this.ancho = ancho;
		this.perfil = perfil;
		this.radio = radio;
		this.marca = marca;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Neumatico [ancho=" + ancho + ", perfil=" + perfil + ", radio=" + radio + ", marca=" + marca + "]";
	}
	

}
