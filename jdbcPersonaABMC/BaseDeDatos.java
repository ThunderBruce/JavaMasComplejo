package jdbcPersonaABMC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDeDatos {
	String tipoBD; //Tipo de Sistema Gestor de BD
	Connection cn; //Conexion con la BD
	
	public BaseDeDatos(String tipoBD) throws Exception {
		if (tipoBD==null)
			throw new Exception("No se ha indicado un tipo de base de datos");
		this.tipoBD=tipoBD.toUpperCase();
		switch (this.tipoBD){
			case "ORACLE":
				Class.forName ("oracle.jdbc.driver.OracleDriver");
				break;
			case "MYSQL":
				Class.forName ("com.mysql.jdbc.Driver");
				break;
			default:
				throw new Exception(tipoBD+": tipo base de datos desconocido");
		}
	}

	public void conectar(String ipServidor, String nombreBaseDatos,String usuario, String password) throws SQLException {
		String cadenaConexion="";
		switch (tipoBD){
			case "ORACLE":
				cadenaConexion="jdbc:oracle:thin:"+ipServidor+":1521:"+nombreBaseDatos;
				break;
			case "MYSQL":
				cadenaConexion="jdbc:mysql://"+ipServidor+":3306/"+nombreBaseDatos;
				break;
		}
		cn = DriverManager.getConnection(cadenaConexion,usuario,password);
	}
	
	public Persona consultaPersona(String dni) throws SQLException {
		//Comprueba que existe el dni y devuelve objeto persona
		PreparedStatement ps = null;
		String prep = "SELECT * FROM persona WHERE dni = ?";
		ResultSet rs;

		ps = cn.prepareStatement(prep);
		ps.setString(1, dni);

		rs = ps.executeQuery();

		if (rs.next()) { //Existe
			//Crea objeto Persona a partir de las columnas obtenidas con SELECT. Ojo al campo fecha(sql.Date hereda de util.Date) y sexo(obtenemos primer caracter de String)
			Persona p=new Persona(rs.getString("nombre"), rs.getDate("fechaNac"), rs.getString("sexo").charAt(0), rs.getDouble("peso"), rs.getDouble("altura"));
			p.setDni(rs.getString("dni"));
			return p;
		} else { //No existe
			return null;
		}
	}

	public void altaPersona(Persona p) throws SQLException {
		PreparedStatement ps = null;
		String prep = "INSERT INTO persona VALUES (?, ?, ?, ?, ?, ?)";
		
		ps = cn.prepareStatement(prep);
		ps.setString(1, p.getDni());
		ps.setString(2, p.getNombre());
		ps.setDate(3, new java.sql.Date(p.getFechaNac().getTime())); //Convierte java.util.Date a java.sql.Date
		ps.setString(4, String.valueOf(p.getSexo())); //Transforma char en String
		ps.setDouble(5, p.getAltura());
		ps.setDouble(6,p.getPeso());
		ps.executeUpdate();
	}

	public void modificaPersona(Persona p) throws SQLException {
		PreparedStatement ps = null;
		String prep = "UPDATE persona SET nombre=?,fechaNac=?,sexo=?,altura=?,peso=? WHERE dni=?";
		
		ps = cn.prepareStatement(prep);
		ps.setString(1, p.getNombre());
		ps.setDate(2, new java.sql.Date(p.getFechaNac().getTime())); //Convierte java.util.Date a java.sql.Date
		ps.setString(3, String.valueOf(p.getSexo())); //Transforma char en String
		ps.setDouble(4, p.getAltura());
		ps.setDouble(5,p.getPeso());
		ps.setString(6, p.getDni());
		ps.executeUpdate();
		
	}

	public void bajaPersona(String dni) throws SQLException {
		PreparedStatement ps = null;
		String prep = "DELETE FROM persona WHERE dni = ?";

		ps = cn.prepareStatement(prep);
		ps.setString(1, dni);
		ps.executeUpdate();
	}
}
