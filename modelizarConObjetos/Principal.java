package modelizarConObjetos;

public class Principal {

	public static void main(String[] args) {
		Remolque r=new Remolque(100, 2, new Neumatico(210, 55, 16, "Michelin"));
		System.out.println(r);
		r.getRueda().setAncho(200);
		r.setCapacidad(500);
		System.out.println(r);
		
		Neumatico n=new Neumatico(40, 40, 13, "Pirelli");
		Moto m=new Moto("Honda", 600, 50,new Neumatico(90, 15, 14, "Good year"), n);
		System.out.println(m);
		m.setRuedaDelantera(null);
		m.getRuedaTrasera().setMarca("Dunlop");
		m.setRuedaDelantera(new Neumatico(12, 12, 12, "Hankook"));
		System.out.println(m);

		Coche c=new Coche("Seat", 1800, "Verde", 0, 4, new Neumatico(220, 50, 15, "Pirelli"), null);
		System.out.println(c);
		c.setRem(r);
		System.out.println(c);
		
		//Creamos Coche2 creando array de neumaticos previamente
		Neumatico [] a=new Neumatico[4];
		a[0]=new Neumatico(200, 60, 15, "Michelin");
		a[1]=new Neumatico(150, 45, 17, "Firestone");
		a[2]=new Neumatico(120, 55, 16, "Dunlop");
		a[3]=new Neumatico(220, 70, 18, "Pirelli");
		Coche2 c2=new Coche2("Volvo", 2000, "Blanco", 0, a, null);
		System.out.println(c2);
		
		Coche2 c3=new Coche2("Renault");
		System.out.println(c3);
		
		Coche2 un127=new Coche2();
		System.out.println(un127);
		
		Coche2 cocheDe6Ruedas=new Coche2(6);
		System.out.println(cocheDe6Ruedas);
		Coche2 cocheDe3Ruedas=new Coche2(3);
		System.out.println(cocheDe3Ruedas);
		//Cambiamos la marca del cohe de 3 ruedas
		cocheDe3Ruedas.setMarca("Tuc tuc");
		System.out.println(cocheDe3Ruedas);
		cocheDe3Ruedas.getRueda()[1].setAncho(100);
		System.out.println(cocheDe3Ruedas);
		cocheDe3Ruedas.getRueda()[2]=new Neumatico(100, 80, 12, "Michelin");
		System.out.println(cocheDe3Ruedas);
		cocheDe3Ruedas.getRueda()[0]=null;
		System.out.println(cocheDe3Ruedas);
		//Aceleramos y frenamos el 127
		un127.acelerar(150);
		System.out.println("== 127 tras acelerar 150 ==");
		System.out.println(un127);
	}

}
