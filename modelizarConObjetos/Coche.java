package modelizarConObjetos;

public class Coche {
	String marca;
	int cc;
	String color;
	int velocidad; //0-Parado
	int numRuedas;
	Neumatico rueda;
	Remolque rem;
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", cc=" + cc + ", color=" + color + ", velocidad=" + velocidad + ", numRuedas="
				+ numRuedas + ", rueda=" + rueda + ", rem=" + rem + "]";
	}
	
	
	public int getNumRuedas() {
		return numRuedas;
	}


	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}


	public Neumatico getRueda() {
		return rueda;
	}


	public void setRueda(Neumatico rueda) {
		this.rueda = rueda;
	}


	public Coche(String marca, int cc, String color, int velocidad, int numRuedas, Neumatico rueda, Remolque rem) {
		super();
		this.marca = marca;
		this.cc = cc;
		this.color = color;
		this.velocidad = velocidad;
		this.numRuedas = numRuedas;
		this.rueda = rueda;
		this.rem = rem;
	}


	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public Remolque getRem() {
		return rem;
	}
	public void setRem(Remolque rem) {
		this.rem = rem;
	}

	
	
	
}
