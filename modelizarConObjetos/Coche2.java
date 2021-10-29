package modelizarConObjetos;

import java.util.Arrays;

public class Coche2 {
	private String marca;
	private int cc;
	private String color;
	private int velocidad; //0-Parado
	private Neumatico [] rueda;
	private Remolque rem;
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", cc=" + cc + ", color=" + color + ", velocidad=" + velocidad + ", rueda=" + Arrays.toString(rueda) + ", rem=" + rem + "]";
	}
	

	public Coche2(String marca, int cc, String color, int velocidad, Neumatico [] rueda, Remolque rem) {
		super();
		this.marca = marca;
		this.cc = cc;
		this.color = color;
		this.velocidad = velocidad;
		this.rueda = rueda;
		this.rem = rem;
	}

	public Coche2(String marca) {
		this(marca,1600,"Negro",0,null,null);
		Neumatico [] ruedas=new Neumatico[4];
		for (int i = 0; i < ruedas.length; i++) {
			ruedas[i]=new Neumatico(150, 60, 16, "Michelin");
		}
		setRueda(ruedas);
	}


	public Coche2() {
		this("Seat",950,"Naranja",0,null,null);
		Neumatico [] ruedas=new Neumatico[4];
		for (int i = 0; i < ruedas.length; i++) {
			ruedas[i]=new Neumatico(140, 55, 16, "Pirelli");
		}
		setRueda(ruedas);
	}

	public Coche2(int numRuedas) {
		this("Porsche",2500,"Amarillo",0,null,null);
		Neumatico [] ruedas=new Neumatico[numRuedas];
		for (int i = 0; i < ruedas.length; i++) {
			ruedas[i]=new Neumatico(220, 60, 15, "Hankook");
		}
		setRueda(ruedas);
	}





	public Neumatico[] getRueda() {
		return rueda;
	}

	public void setRueda(Neumatico[] rueda) {
		this.rueda = rueda;
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
	
	public void frenar(int decremento) {
		velocidad-=decremento;
	}

	public void acelerar(int incremento) {
		  
		
		setVelocidad(getVelocidad()+incremento);
	}
	
	
}
