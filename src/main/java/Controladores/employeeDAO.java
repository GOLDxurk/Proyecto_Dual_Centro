package Controladores;

import java.sql.*;
//importamos el model de EMPLOYEE de Tablas
import Tablas.EMPLOYEES;
// Se importa la Clase ConexionOracleDBXE poder usar sus metodos,
// preparar sentencias y realizar la conexion con la base de datos
import Utilidades.ConexionOracleDBXE;

public class employeeDAO {

	// SQL plantilla sin EMPLOYEE_ID porque se auto genera
	private static String sql = "INSERT INTO EMPLOYEES ("
			+ "FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, MANAGER_ID, JOB_TITLE) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	public Integer insertarDatos(EMPLOYEES e) {
		// Empezamos por hacer laconexion usando un try para someterlo a una prueba de
		// errores y capturar posibles excepciones
		// ps es el objeto Statement que se encargara de ineracturar con el molde del
		// package Tablas EMPLOYEES
		try (Connection conn = ConexionOracleDBXE.conectar();
	             PreparedStatement ps = conn.prepareStatement(
	                     sql, new String[] { "EMPLOYEE_ID" })) {
			// primeras interacciones con el molde cargando los parametros en el mismo orden
			// que la plantilla sql por eso la numeracion del 1 al 7 saltandonos la PK porque
			// la preparamos como autogenerable
			ps.setString(1, e.getFirst_name());
			ps.setString(2, e.getLast_name());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPhone());
			ps.setString(5, e.getHire_date());
			ps.setInt(6, e.getManager_id());
			ps.setString(7, e.getJob_title());
			
			// Una vez preparado hacemos el update para que ejecute el insert
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			System.err.println("No se pudo insertar empleado " + e1.getMessage());
		}
		// Si hay un error en el proceso entonces se devuelve como nulo
		return null;
	}
}
