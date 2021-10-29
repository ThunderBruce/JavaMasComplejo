package aplicacionGestionPersonasEsqueleto;

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
public class Persona {
	//Constantes
	/**
	 * Sexo por defecto, hombre y mujer
	 */
	private final static char HOMBRE='H';
	private final static char MUJER='M';
	private final static char OTROS='O';
	private final static char SEXO_DEF=MUJER;

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
}

