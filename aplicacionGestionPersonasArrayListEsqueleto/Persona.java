package aplicacionGestionPersonasArrayListEsqueleto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Clase Persona
 *
 * Contiene información de una persona
 */
public class Persona implements Comparable<Persona>{
	//Constantes
	/**
	 * Sexo por defecto, hombre y mujer
	 */
	private final static char HOMBRE='H';
	private final static char MUJER='M';
	private final static char SEXO_DEF=HOMBRE;

	/**
	 * El peso de la persona esta por debajo del peso ideal
	 */
	public static final int DELGADO=-1;

	/**
	 * El peso de la persona esta en su peso ideal
	 */
	public static final int NORMAL=0;

	/**
	 * El peso de la persona esta por encima del peso ideal
	 */
	private static final int SOBREPESO=1;

	//Atributos

	/**
	 * Nombre de la persona
	 */
	private String nombre;

	/**
	 * Fecha de nacimiento de la persona (dia, mes, año)
	 */
	private Date fechaNac;

	/**
	 * DNI de la persona, se genera al construir el objeto
	 */
	private String dni;

	/**
	 * Sexo de la persona, H hombre M mujer
	 */
	private char sexo;

	/**
	 * Peso de la persona
	 */
	private double peso;

	/**
	 * Altura de la persona
	 */
	private double altura;

	//Métodos privados
	
	private void comprobarSexo(char sexo){

		//Si el sexo no es una H o una M, por defecto es H
		if(sexo!=HOMBRE && sexo!=MUJER){
			this.sexo=SEXO_DEF;
		}else{
			this.sexo=sexo;
		}
	}

	
	public static String generarDni(){
		final int divisor=23;

		String digitos8="";
		//Generamos un número de 8 digitos
		for (int i=0;i<8;i++){
			int dig=generarDigitoAleatorio(); //Genera digito
			String strDig=String.valueOf(dig); //Lo convierte a String
			digitos8=digitos8+strDig; //Lo añade a digitos8
		}
		//Calculamos la letra del DNI
		char letraDNI=calcularLetraDni(digitos8);

		//Devolvemos 8 digitos + letra
		return digitos8+letraDNI;
	}

	private static int generarDigitoAleatorio() {
		Random r=new Random();
		
		return r.nextInt(10); //Entero aleatorio entre 0 y 9
	}


	//Calcula la letra que corresponde a los 8 dígitos de un DNI
	private static char calcularLetraDni(String digitosDni){
		if (!digitosDni.matches("[0-9]{8}"))
				return ' '; //Devuelve espacio en blanco si no llegan 8 digitos 
		char letras[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y',
		          'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
		          'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

		return letras[Integer.valueOf(digitosDni)%23];
	}

	//Métodos publicos
	public int obtenerAnios(){
		GregorianCalendar gcNac=new GregorianCalendar();
		gcNac.setTime(fechaNac);//Objeto GregorianCalendar igual a la feccha de nacimiento
		GregorianCalendar ahora=new GregorianCalendar();
		int anios=ahora.get(Calendar.YEAR)-gcNac.get(Calendar.YEAR);
		if (gcNac.get(Calendar.DAY_OF_YEAR)>ahora.get(Calendar.DAY_OF_YEAR)) //Si el dia de nacimiento es posterior al dia actual restamos 1 a lo calculado anteriormente
			anios--;
		return anios;
	}
    
	
	/**
	 * Modifica el nombre de la persona
	 * @param nombre a cambiar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public String getDni() {
		return dni;
	}

	public char getSexo() {
		return sexo;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	/**
	 * Modifica el sexo de la persona, comprueba que es correcto
	 * @param sexo a cambiar
	 */
	public void setSexo(char sexo) {
		comprobarSexo(sexo);
	}

	/**
	 * Modifica el peso de la persona
	 * @param peso a cambiar
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Modifica la altura de la persona
	 * @param altura a cambiar
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}

	/**
	 * Calcula el indice de masa corporal
	 */
	public int calcularIMC(){
		//Calculamos el peso de la persona
		double pesoActual=peso/(Math.pow(altura, 2));
		//Segun el peso, devuelve un codigo
		if (pesoActual>=18.75 && pesoActual<=24.9){
			return NORMAL;
		}else if(pesoActual<18.75){
 			return DELGADO;
 		}else{
 			return SOBREPESO;
 		}
 	}
 	 /**
 	 * Indica si la persona es mayor de edad
 	 * @return true si es mayor de edad y false es menor de edad
 	 */
        public boolean esMayorDeEdad(){
 		boolean mayor=false;
 		if (obtenerAnios()>=18){
			mayor=true;
		}
		return mayor;
	}

	/**
	 * Devuelve un String con informacion del objeto 
	 */
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); //Mostraremos la fecha en formato DD/MM/AAAA
		String nacEdad=sdf.format(fechaNac)+ "("+obtenerAnios()+" años)";
		return "Persona [nombre=" + nombre + ", fechaNac=" + nacEdad + ", DNI=" + dni
				+ ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura
				+ "]";
	}

	/**
	 * Constructor por defecto
	 */
	public Persona(){
		this("", null, SEXO_DEF, 0, 0);
	}

	/**
	 * Constructor con 3 parametros
	 * @param nombre de la persona
	 * @param fecha de nacimiento de la persona
	 * @param sexo de la persona
	 */
	public Persona(String nombre, Date fechaNac, char sexo){
		this(nombre, fechaNac, sexo, 0, 0);
	}

	/**
	 * Constructor con 5 parametros
	 * @param nombre de la persona
	 * @param fecha de nacimiento de la persona
	 * @param sexo de la persona
	 * @param peso de la persona
	 * @param altura de la persona
	 */
	public Persona(String nombre, Date fechaNac, char sexo, double peso, double altura){
		this.nombre=nombre;
		this.fechaNac=fechaNac;
		this.peso=peso;
		this.altura=altura;
		this.dni=generarDni();
		setSexo(sexo); //Asigna el sexo realizando comprobacion
	}

	//Metodo estatico para comprobar cualquier DNI
	public static boolean dniCorrecto(String dni) {
		if (!dni.matches("[0-9]{8}[A-Z]"))
			return false;
		String digitos=dni.substring(0, 8);
		char letra=dni.charAt(8);
				
		return letra==calcularLetraDni(digitos);
	}
	
	//Metodo no estatico para comprobar que el atributo dni es un DNI correcto. Se apoya en el metodo estatico
	public boolean dniCorrecto() {
		return dniCorrecto(this.dni);//Llama al metodo estatico pasando como parametro el atributo dni
	}


	@Override
	public int compareTo(Persona o) {
		return this.getNombre().compareTo(o.getNombre());
	}
}

