package Utilidades;

import java.sql.*;

// clase conexion que sera la base para las actividades
// no necesita ser una clase abstracta ya qye al tener un import de
// sql la conexion esta ya hecha para cualquier otra clase
public class ConexionOracleDBXE {
	// Propiedades
	private static Connection conn = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "adriadmin";
	private static String PASS = "123456";

	public static void conectar() throws SQLException {

		// Creando conexion con la base de datos
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (conn != null) {
				System.out.println("Exito al conectar con Oracle DB");
			} else {
				System.out.println("Fallo al intentar conectar");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void cerrarConexion() throws SQLException {
		// Cerrando conexion
		if (conn != null) {
			conn.close();
		}
	}

}
