package modelizarConObjetos;

public class Remolque {
	int capacidad;//Litros que caben
	int numRuedas;
	Neumatico rueda;
	public Remolque(int capacidad, int numRuedas, Neumatico rueda) {
		super();
		this.capacidad = capacidad;
		this.numRuedas = numRuedas;
		this.rueda = rueda;
	}
	@Override
	public String toString() {
		return "Remolque [capacidad=" + capacidad + ", numRuedas=" + numRuedas + ", rueda=" + rueda + "]";
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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
	
	
}
