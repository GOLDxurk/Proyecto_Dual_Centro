package Proyecto.Dual.Centro.Proyecto_Dual_Centro;

import java.sql.*;

// clase conexion que sera la base para las actividades
public class ConexionOracleDBXE {

	public static void main(String[] args) throws SQLException {
		// Propiedades
		Connection conn = null;
		Statement stmt = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "adriadmin";
		String PASS = "123456";
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
		} finally {
			// Cerrando conexion y el objeto statement
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
