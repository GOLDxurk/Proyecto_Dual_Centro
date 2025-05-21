package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CUSTOMERSTest {
	private CUSTOMERS cliente;

	@BeforeEach
	public void setUp() {
		cliente = new CUSTOMERS();
	}

	@Test
	public void testConstructorVacio() {
		CUSTOMERS cliente = new CUSTOMERS();
		assertThat(cliente, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		CUSTOMERS cliente = new CUSTOMERS(1, "Empresa A", "Calle Falsa 123", "www.empresaa.com", 50000.0);

		assertThat(cliente.getCustomer_id(), is(1));
		assertThat(cliente.getName(), is("Empresa A"));
		assertThat(cliente.getAddress(), is("Calle Falsa 123"));
		assertThat(cliente.getWebsite(), is("www.empresaa.com"));
		assertThat(cliente.getCredit_limit(), is(50000.0));
	}

	@Test
	public void testConstructorSinPK() {
		CUSTOMERS cliente = new CUSTOMERS("Empresa B", "Avenida Real 321", "www.empresab.com", 75000.0);

		assertThat(cliente.getCustomer_id(), is(0));
		assertThat(cliente.getName(), is("Empresa B"));
		assertThat(cliente.getAddress(), is("Avenida Real 321"));
		assertThat(cliente.getWebsite(), is("www.empresab.com"));
		assertThat(cliente.getCredit_limit(), is(75000.0));
	}

	@Test
	public void testSetAndGetCustomerId() {
		cliente.setCustomer_id(2001);
		assertThat(cliente.getCustomer_id(), is(2001));
	}

	@Test
	public void testSetAndGetName() {
		cliente.setName("Empresa inventada");
		assertThat(cliente.getName(), startsWith("Empresa"));
	}

	@Test
	public void testSetAndGetAddress() {
		cliente.setAddress("Calle Mayor 123");
		assertThat(cliente.getAddress(), containsString("Mayor"));
	}

	@Test
	public void testSetAndGetWebsite() {
		cliente.setWebsite("https://google.com");
		assertThat(cliente.getWebsite(), startsWith("https"));
	}

	@Test
	public void testSetAndGetCreditLimit() {
		cliente.setCredit_limit(5000.0);
		assertThat(cliente.getCredit_limit(), greaterThan(1000.0));
	}

	@Test
	public void testToStringContainsName() {
		cliente.setName("Empresa ficticia");
		assertThat(cliente.toString(), containsString("ficticia"));
	}

}
