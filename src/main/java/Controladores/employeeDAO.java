package Controladores;

import java.sql.*;
import java.util.*;

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
		// package Tablas EAMPLOYEES
		try (Connection conn = ConexionOracleDBXE.conectar();
				PreparedStatement ps = conn.prepareStatement(sql, new String[] { "EMPLOYEE_ID" })) {
			// primeras interacciones con el molde cargando los parametros en el mismo orden
			// que la plantilla sql por eso la numeracion del 1 al 7 saltandonos la PK
			// porque
			// la preparamos como autogenerable
			ps.setString(1, e.getFirst_name());
			ps.setString(2, e.getLast_name());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPhone());
			ps.setDate(5, new java.sql.Date(e.getHire_date().getTime()));
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

	// metodo que permitira hacer una select para poder visualizar los jefes en la
	// ventana
	public static List<EMPLOYEES> obtenerJefes() {
		List<EMPLOYEES> jefes = new ArrayList<>();

		try {
			ConexionOracleDBXE.conectar();
			Connection conn = ConexionOracleDBXE.conectar();

			String sql = "SELECT DISTINCT e.employee_id, e.first_name, e.last_name " + "FROM employees e "
					+ "WHERE e.employee_id IN (SELECT DISTINCT manager_id FROM employees WHERE manager_id IS NOT NULL)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EMPLOYEES jefe = new EMPLOYEES();
				jefe.setEmployee_id(rs.getInt("employee_id"));
				jefe.setFirst_name(rs.getString("first_name"));
				jefe.setLast_name(rs.getString("last_name"));
				jefes.add(jefe);
			}
			rs.close();
			ps.close();
			ConexionOracleDBXE.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jefes;
	}

}
