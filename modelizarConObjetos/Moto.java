package modelizarConObjetos;

public class Moto {
	String modelo;
	int cc;
	int velocidad;
	Neumatico ruedaTrasera;
	Neumatico ruedaDelantera;
	public Moto(String modelo, int cc, int velocidad, Neumatico ruedaTrasera, Neumatico ruedaDelantera) {
		super();
		this.modelo = modelo;
		this.cc = cc;
		this.velocidad = velocidad;
		this.ruedaTrasera = ruedaTrasera;
		this.ruedaDelantera = ruedaDelantera;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public Neumatico getRuedaTrasera() {
		return ruedaTrasera;
	}
	public void setRuedaTrasera(Neumatico ruedaTrasera) {
		this.ruedaTrasera = ruedaTrasera;
	}
	public Neumatico getRuedaDelantera() {
		return ruedaDelantera;
	}
	public void setRuedaDelantera(Neumatico ruedaDelantera) {
		this.ruedaDelantera = ruedaDelantera;
	}
	@Override
	public String toString() {
		return "Moto [modelo=" + modelo + ", cc=" + cc + ", velocidad=" + velocidad + ", ruedaTrasera=" + ruedaTrasera
				+ ", ruedaDelantera=" + ruedaDelantera + "]";
	}
	
	
}
