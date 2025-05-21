package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class EMPLOYEESTest {
	private EMPLOYEES empleado;

	@BeforeEach
	public void setUp() {
		empleado = new EMPLOYEES();
	}

	@Test
	void testConstructorVacio() {
		EMPLOYEES e = new EMPLOYEES();
		assertThat(e, is(notNullValue()));
	}

	@Test
	void testConstructorConTodosLosCampos() {
		Date hoy = new Date();
		EMPLOYEES e = new EMPLOYEES(1, "Ana", "Pérez Perea", "anapepe@gmail.com", "123456789", hoy, 101, "Contable", 0);

		assertThat(e.getEmployee_id(), is(1));
		assertThat(e.getFirst_name(), is("Ana"));
		assertThat(e.getLast_name(), is("Pérez Perea"));
		assertThat(e.getEmail(), is("anapepe@gmail.com"));
		assertThat(e.getPhone(), is("123456789"));
		assertThat(e.getHire_date(), is(hoy));
		assertThat(e.getManager_id(), is(101));
		assertThat(e.getJob_title(), is("Contable"));
		assertThat(e.getFk_employees_manager(), is(0));
	}

	@Test
	void testConstructorSinPK() {
		Date hoy = new Date();
		EMPLOYEES e = new EMPLOYEES("Luis", "Gómez Torval", "luisgoto@gmail.com", "987654321", hoy, 102, "Analista", 0);

		assertThat(e.getEmployee_id(), is(0));
		assertThat(e.getFirst_name(), is("Luis"));
		assertThat(e.getLast_name(), is("Gómez Torval"));
		assertThat(e.getEmail(), is("luisgoto@gmail.com"));
		assertThat(e.getPhone(), is("987654321"));
		assertThat(e.getHire_date(), is(hoy));
		assertThat(e.getManager_id(), is(102));
		assertThat(e.getJob_title(), is("Analista"));
		assertThat(e.getFk_employees_manager(), is(0));
	}

	@Test
	public void testSetAndGetFirstName() {
		empleado.setFirst_name("Juan");
		assertThat(empleado.getFirst_name(), is("Juan"));
	}

	@Test
	public void testSetAndGetLastName() {
		empleado.setLast_name("Pérez");
		assertThat(empleado.getLast_name(), is("Pérez"));
	}

	@Test
	public void testSetAndGetEmail() {
		empleado.setEmail("juanper@gmail.com");
		assertThat(empleado.getEmail(), containsString("@gmail.com"));
	}

	@Test
	public void testSetAndGetPhone() {
		empleado.setPhone("123456789");
		assertThat(empleado.getPhone(), hasLength(9));
	}

	@Test
	public void testSetAndGetHireDate() {
		Date hoy = new Date();
		empleado.setHire_date(hoy);
		assertThat(empleado.getHire_date(), is(hoy));
	}

	@Test
	public void testSetAndGetManagerId() {
		empleado.setManager_id(200);
		assertThat(empleado.getManager_id(), greaterThanOrEqualTo(100));
	}

	@Test
	public void testSetAndGetJobTitle() {
		empleado.setJob_title("Programador");
		assertThat(empleado.getJob_title(), notNullValue());
	}

	@Test
	public void testSetAndGetFkEmployeesManager() {
		empleado.setFk_employees_manager(300);
		assertThat(empleado.getFk_employees_manager(), equalTo(300));
	}

	@Test
	public void testSetAndGetEmployeeId() {
		empleado.setEmployee_id(107);
		assertThat(empleado.getEmployee_id(), is(107));
	}

	@Test
	public void testToStringContainsAll() {
		empleado.setFirst_name("Ernesto");
		empleado.setLast_name("López Sanchez");
		empleado.setEmail("erlosan@gmail.com");
		empleado.setEmployee_id(108);

		String resultado = empleado.toString();

		assertThat(resultado, containsString("Ernesto"));
		assertThat(resultado, containsString("López Sanchez"));
		assertThat(resultado, containsString("108"));
	}
}
