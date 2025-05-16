package Controladores;

import java.sql.*;
import java.util.*;

//importamos el model de EMPLOYEE de Tablas
import Tablas.EMPLOYEES;
// Se importa la Clase ConexionOracleDBXE poder usar sus metodos,
// preparar sentencias y realizar la conexion con la base de datos
import Utilidades.ConexionOracleDBXE;

public class employeeDAO {
	private int id;
	// Esta es la plantilla de insercion de datos que se guardara en una propiedad
	// llamada sql
	// que nos permitira insertar datos en la base de datos
	private static String sql = "INSERT INTO EMPLOYEES ("
			+ "EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, MANAGER_ID, JOB_TITLE) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	// Tenia dos opciones, o modificar  el comportamiento de la tabla en la base de datos para que se
	// autogenere EMPLOYEE_ID o hacer una consulta a la base de datos para obtener el ultimo id y hacer una suma
	// para incrementar la propiedad id y usarla con el proposito de insertar el empleado con un nuevo EMPLOYEE_ID
	public int autogenerarIDEmpleado(int nuevoID) {
		nuevoID = 1;
		try (Connection conn = ConexionOracleDBXE.conectar();
				PreparedStatement ps = conn.prepareStatement("SELECT MAX(EMPLOYEE_ID) FROM EMPLOYEES");
				ResultSet rs = ps.executeQuery()) {

			if (rs.next()) {
				nuevoID = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id = nuevoID;

	}

	public Integer insertarDatos(EMPLOYEES e) {
		id = autogenerarIDEmpleado(id);
		// Empezamos por hacer laconexion usando un try para someterlo a una prueba de
		// errores y capturar posibles excepciones
		// ps es el objeto Statement que se encargara de ineracturar con el molde del
		// package Tablas EAMPLOYEES
		try (Connection conn = ConexionOracleDBXE.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
			// primeras interacciones con el molde cargando los parametros en el mismo orden
			// que la plantilla sql por eso la numeracion del 1 al 7 saltandonos la PK
			// porque
			// la preparamos como autogenerable
			ps.setInt(1, id);
			ps.setString(2, e.getFirst_name());
			ps.setString(3, e.getLast_name());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPhone());
			ps.setDate(6, new java.sql.Date(e.getHire_date().getTime()));
			ps.setInt(7, e.getManager_id());
			ps.setString(8, e.getJob_title());

			// Una vez preparado hacemos el update para que ejecute el insert
			int filasInsertadas = ps.executeUpdate();

			if (filasInsertadas > 0) {
				return id;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// Si hay un error en el proceso entonces se devuelve como nulo
		return null;
	}

	// metodo que permitira hacer una select de todos los osibles jefes para poder
	// visualizar en la
	// ventana del ejecicio formativo uno
	// el arrayList rellena y es capaz de expandirse por cada nuevo posible jefe
	public static List<EMPLOYEES> obtenerJefes() {
		List<EMPLOYEES> jefes = new ArrayList<>();

		try {
			ConexionOracleDBXE.conectar();
			Connection conn = ConexionOracleDBXE.conectar();

			String sql = "SELECT DISTINCT e.employee_id, e.first_name, e.last_name " + "FROM employees e "
					+ "WHERE e.employee_id IN (SELECT DISTINCT employee_id FROM employees WHERE employee_id IS NOT NULL)";
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
