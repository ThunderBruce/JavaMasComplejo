package ejemplos;

public class Utilidades {
	//Redondea un numero real a los decimales que se indiquen
	public static double redondear( double numero, int decimales )
	{
		return Math.rint(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
	}

	//Nos devuelve el numero de digitos de un numero entero n
	public static int numeroDigitos(int n)
	{
		int cnt=0; //Cuenta el numero de divisiones que podemos hacer hasta obtener un cociente 0
		int cociente=n;
		do {
			cociente=cociente/10;
			cnt++;
		} while (cociente!=0);
		
		return cnt;
	}
	
	//Aisla en un array los digitos un numero entero n
	public static int[] extraerDigitos(int n)
	{
		int digitos[]=new int[numeroDigitos(n)];
		int cnt=0; //Cuenta el numero de divisiones que podemos hacer hasta obtener un cociente 0
		int cociente=n;
		do {
			int digito = cociente%10;
			cociente=cociente/10;
			cnt++;
			digitos[digitos.length-cnt]=digito;
		} while (cociente!=0);
		
		return digitos;
	}
	
	//Lee un numero entre 0 y 999
	public static String convertirNumeroEnTexto(int n)
	{
		if (n<0 || n >999)
			return "No sé leer este número";
		
		if (esEspecial(n))
			return textoNumeroEspecial(n);
		
		String texto="";
		int []digs=extraerDigitos(n);
		if (digs.length==3)
			texto=texto+textoCentena(digs[digs.length-3])+" ";
		if (digs.length>1) {
			if (digs[digs.length-2]>0) {//Decena
				texto=texto+textoDecena(digs[digs.length-2]);
				if (digs[digs.length-1] > 0)//unidad)
					texto=texto+" y ";
			}
		}
		texto=texto+textoUnidad(digs[digs.length-1]);
		
		return texto;
	}
	
	private static boolean esEspecial(int n) {
		switch(n) {
		case 0: 
		case 10: 
		case 11: 
		case 12:
		case 13:
		case 14: 
		case 15:
		case 100: 
			return true;
		default:
			return false;
		}
	}

	private static String textoNumeroEspecial(int e) {
		String texto="";
		switch(e) {
		case 0: texto="cero";
		break;
		case 10: texto="diez";
		break;
		case 11: texto="once";
		break;
		case 12: texto="doce";
		break;
		case 13: texto="trece";
		break;
		case 14: texto="catorce";
		break;
		case 15: texto="quince";
		break;
		case 100: texto="cien";
		break;
		}
		return texto;
	}

	private static String textoUnidad(int uni) {
		String texto="";
		switch(uni) {
		case 1: texto="uno";
		break;
		case 2: texto="dos";
		break;
		case 3: texto="tres";
		break;
		case 4: texto="cuatro";
		break;
		case 5: texto="cinco";
		break;
		case 6: texto="seis";
		break;
		case 7: texto="siete";
		break;
		case 8: texto="ocho";
		break;
		case 9: texto="nueve";
		break;
		}
		return texto;
	}

	private static String textoDecena(int dec) {
		String texto="";
		switch(dec) {
		case 1: texto="dieci";
		break;
		case 2: texto="veinti";
		break;
		case 3: texto="treinta";
		break;
		case 4: texto="cuarenta";
		break;
		case 5: texto="cincuenta";
		break;
		case 6: texto="sesenta";
		break;
		case 7: texto="setenta";
		break;
		case 8: texto="ochenta";
		break;
		case 9: texto="noventa";
		break;
		}
		return texto;
	}

	private static String textoCentena(int cent) {
		String texto="";
		switch(cent) {
		case 1: texto="ciento";
		break;
		case 2: texto="doscientos";
		break;
		case 3: texto="trescientos";
		break;
		case 4: texto="cuatrocientos";
		break;
		case 5: texto="quinientos";
		break;
		case 6: texto="seiscientos";
		break;
		case 7: texto="setecientos";
		break;
		case 8: texto="ochocientos";
		break;
		case 9: texto="novecientos";
		break;
		}
		return texto;
	}
}
