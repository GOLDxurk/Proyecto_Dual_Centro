package Controladores;

import java.sql.*;
import java.util.*;

//importamos el model de EMPLOYEE de Tablas
import Tablas.EMPLOYEES;
// Se importa la Clase ConexionOracleDBXE poder usar sus metodos,
// preparar sentencias y realizar la conexion con la base de datos
import Utilidades.ConexionOracleDBXE;

/**
 * DAO que gestiona las operaciones de inserción y consulta relacionadas con la
 * entidad EMPLOYEES. Usa la clase de utilidades para conectar con la base de
 * datos Oracle.
 */
public class employeeDAO {

	/**
	 * Sentencia SQL preparada para insertar un nuevo registro en la tabla
	 * EMPLOYEES. Evita escribir la sentencia manualmente en cada llamada al método.
	 */
	private static String sql = "INSERT INTO EMPLOYEES ("
			+ "EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, MANAGER_ID, JOB_TITLE) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	/**
	 * Genera automáticamente un nuevo ID para un empleado, haciendo una consulta a
	 * la base de datos para obtener el último valor y sumarle 1. Ideal para simular
	 * autoincremento si la tabla no lo hace por sí sola.
	 * 
	 * @return nuevo ID de empleado a insertar
	 */
	public static int autogenerarIDEmpleado() {
		int nuevoID = 1;
		try (Connection conn = ConexionOracleDBXE.conectar();
				PreparedStatement ps = conn.prepareStatement("SELECT MAX(EMPLOYEE_ID) FROM EMPLOYEES");
				ResultSet rs = ps.executeQuery()) {

			if (rs.next()) {
				nuevoID = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuevoID;

	}

	/**
	 * Inserta un objeto EMPLOYEES en la base de datos utilizando los datos pasados
	 * por parámetro. Se encarga de mapear los atributos del objeto a la sentencia
	 * SQL y ejecutar el insert.
	 *
	 * @param e objeto EMPLOYEES a insertar
	 * @return el nuevo ID asignado si se insertó correctamente, null si ocurrió un
	 *         error
	 */
	public Integer insertarDatos(EMPLOYEES e) {
		int nuevoID = autogenerarIDEmpleado();

		try (Connection conn = ConexionOracleDBXE.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, nuevoID);
			ps.setString(2, e.getFirst_name());
			ps.setString(3, e.getLast_name());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPhone());
			ps.setDate(6, new java.sql.Date(e.getHire_date().getTime()));
			ps.setInt(7, e.getManager_id());
			ps.setString(8, e.getJob_title());

			int filasInsertadas = ps.executeUpdate();

			if (filasInsertadas > 0) {
				return nuevoID;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return null;
	}

	/**
	 * Recupera una lista de empleados que pueden actuar como jefes. Se consulta la
	 * tabla buscando aquellos empleados que aparecen como managers.
	 *
	 * @return lista de objetos EMPLOYEES que cumplen la condición
	 */
	public static List<EMPLOYEES> obtenerJefes() {
		List<EMPLOYEES> jefes = new ArrayList<>();

		try {
			Connection conn = ConexionOracleDBXE.conectar();

			String sql = "SELECT DISTINCT employee_id, first_name, last_name FROM employees";
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
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jefes;
	}

}
