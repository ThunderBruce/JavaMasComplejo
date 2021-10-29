package herencia.PersFutbTenis;

public class MeterEnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona [] pers=new Persona[5];
		
		pers[0]=new Persona("1", "Uno", 11);
		pers[1]=new Futbolista("2", "Dos", 22, "At.Madrid", 20);
		pers[2]=new Futbolista("3", "Tres", 33, "Valencia", 3);
		pers[3]=new Tenista("4", "Cuatro", 44, 4);
		pers[4]=new Tenista("5", "Cinco", 55, 5);
		
		for (int i=0;i<pers.length;i++){
			System.out.println(pers[i]);
			System.out.println(pers[i].getClass());
		}
	}

}
