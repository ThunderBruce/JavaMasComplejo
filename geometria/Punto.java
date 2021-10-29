package geometria;

public class Punto {
	double x;
	double y;
	int serie; //1,2,3,... orden en que ha nacido(new) cada objeto. Para asignarlo en el constructor nos apoyamos en el atributo estático cny
	static int cnt=0;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String toString() {
		return "Punto [x=" + x + ", y=" + y+", serie="+serie+"]";
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
		cnt++;
		serie=cnt;
	}
	
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public static int getCnt() {
		return cnt;
	}
	public static void setCnt(int cnt) {
		Punto.cnt = cnt;
	}
	public Punto() {
		this(0,0);
	}
	public double calcularDistancia(Punto p) {
	  return calcularDistancia(this, p);
	}
	
	public static double calcularDistancia(Punto a,Punto b) {
		   return Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));
		}
}
