package Proyecto.Dual.Centro.Proyecto_Dual_Centro;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionOracleDBXE {
	//aun en desarrollo
	// PROPIEDADES
	private Connection conn = null;
	private String URL, USER, PASS;

	public ConexionOracleDBXE() {
		conectar();
	}

	private void conectar() {
		try {
			Class.forName("");
			URL = "";
			USER = "adriadmin";
			PASS = "123456";
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			System.out.println("Error, no se pudo conectar a la base "
					+ "de datos");
		}
	}

	private void desconectar() {
		try {
		conn.close();	
		} catch (Exception e) {
				System.out.println("Error, no se pudo desconectar");
			}
	}

}