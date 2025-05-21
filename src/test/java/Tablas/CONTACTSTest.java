package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CONTACTSTest {

	private CONTACTS contacto;

	@BeforeEach
	public void setUp() {
		contacto = new CONTACTS();
	}

	@Test
	public void testConstructorVacio() {
		CONTACTS contacto = new CONTACTS();
		assertThat(contacto, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		CONTACTS contacto = new CONTACTS(1, "Ana", "García Lopez", "agarlop@gmail.com", "123456789", 1001, 1001);

		assertThat(contacto.getContact_id(), is(1));
		assertThat(contacto.getFirst_name(), is("Ana"));
		assertThat(contacto.getLast_name(), is("García Lopez"));
		assertThat(contacto.getEmail(), is("agarlop@gmail.com"));
		assertThat(contacto.getPhone(), is("123456789"));
		assertThat(contacto.getCustomer_id(), is(1001));
		assertThat(contacto.getFk_contacts_customers(), is(1001));
	}

	@Test
	public void testConstructorSinPK() {
		CONTACTS contacto = new CONTACTS("Luis", "Martínez Rodriguez", "lumarro@gmail.com", "987654321", 2002, 2002);

		assertThat(contacto.getContact_id(), is(0)); // Valor por defecto
		assertThat(contacto.getFirst_name(), is("Luis"));
		assertThat(contacto.getLast_name(), is("Martínez Rodriguez"));
		assertThat(contacto.getEmail(), is("lumarro@gmail.com"));
		assertThat(contacto.getPhone(), is("987654321"));
		assertThat(contacto.getCustomer_id(), is(2002));
		assertThat(contacto.getFk_contacts_customers(), is(2002));
	}

	@Test
	public void testSetAndGetContactId() {
		contacto.setContact_id(1);
		assertThat(contacto.getContact_id(), is(1));
	}

	@Test
	public void testSetAndGetFirstName() {
		contacto.setFirst_name("Lucía");
		assertThat(contacto.getFirst_name(), equalTo("Lucía"));
	}

	@Test
	public void testSetAndGetLastName() {
		contacto.setLast_name("Pérez Raigada");
		assertThat(contacto.getLast_name(), equalTo("Pérez Raigada"));
	}

	@Test
	public void testSetAndGetEmail() {
		contacto.setEmail("lupera@gmail.com");
		assertThat(contacto.getEmail(), containsString("@gmail.com"));
	}

	@Test
	public void testSetAndGetPhone() {
		contacto.setPhone("666777888");
		assertThat(contacto.getPhone(), startsWith("6"));
	}

	@Test
	public void testSetAndGetCustomerId() {
		contacto.setCustomer_id(101);
		assertThat(contacto.getCustomer_id(), is(101));
	}

	@Test
	public void testSetAndGetFk_contacts_customers() {
		contacto.setFk_contacts_customers(101);
		assertThat(contacto.getFk_contacts_customers(), is(101));
	}

	@Test
	public void testToStringNotNull() {
		contacto.setContact_id(8);
		contacto.setFirst_name("Adrián");
		contacto.setLast_name("Acevedo Reinoso");
		contacto.setEmail("aacerei@gmail.com");
		contacto.setPhone("612345987");
		contacto.setCustomer_id(105);
		contacto.setFk_contacts_customers(105);
		assertThat(contacto.toString(), containsString("8"));
		assertThat(contacto.toString(), containsString("Adrián"));
		assertThat(contacto.toString(), containsString("Acevedo Reinoso"));
		assertThat(contacto.toString(), containsString("aacerei@gmail.com"));
		assertThat(contacto.toString(), containsString("612345987"));
		assertThat(contacto.toString(), containsString("105"));
		assertThat(contacto.toString(), containsString("105"));
	}
}
