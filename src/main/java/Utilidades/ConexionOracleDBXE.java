package Utilidades;

import java.sql.*;

/**
 * Clase encargada de establecer y cerrar conexiones con la base de datos
 * Oracle. Funciona como base común para todas las operaciones JDBC del
 * proyecto.
 */
public class ConexionOracleDBXE {
	// Propiedades
	private static Connection conn = null;
	private static Statement st = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "adriadmin";
	private static String PASS = "123456";

	/**
	 * Crea una conexión con la base de datos usando las credenciales configuradas.
	 * Muestra por consola si la conexión ha sido exitosa o no.
	 *
	 * @return objeto Connection activo para operar con la base de datos
	 */
	public static Connection conectar() throws SQLException {

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
		return conn;
	}

	/**
	 * Cierra la conexión con la base de datos si está abierta. También se encarga
	 * de cerrar el Statement, si existe.
	 */
	public static void cerrarConexion() throws SQLException {

		if (conn != null) {
			conn.close();
		}

		if (st != null) {
			st.close();
		}
	}

}
