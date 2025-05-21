package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class ORDERSTest {

	private ORDERS order;

	@BeforeEach
	public void setUp() {
		order = new ORDERS();
	}

	@Test
	void testConstructorVacio() {
		ORDERS order = new ORDERS();
		assertThat(order, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		Date fecha = new Date();
		ORDERS order = new ORDERS(1001, 10, "Procesado", 20, fecha, 30, 40);

		assertThat(order.getOrder_id(), is(1001));
		assertThat(order.getCustomer_id(), is(10));
		assertThat(order.getStatus(), is("Procesado"));
		assertThat(order.getSalesman_id(), is(20));
		assertThat(order.getOrder_date(), is(fecha));
		assertThat(order.getFk_orders_customers(), is(30));
		assertThat(order.getFk_orders_employees(), is(40));
	}

	@Test
	public void testConstructorSinPK() {
		Date fecha = new Date();
		ORDERS order = new ORDERS(11, "Enviado", 21, fecha, 31, 41);

		assertThat(order.getOrder_id(), is(0));
		assertThat(order.getCustomer_id(), is(11));
		assertThat(order.getStatus(), is("Enviado"));
		assertThat(order.getSalesman_id(), is(21));
		assertThat(order.getOrder_date(), is(fecha));
		assertThat(order.getFk_orders_customers(), is(31));
		assertThat(order.getFk_orders_employees(), is(41));
	}

	@Test
	public void testSetAndGetOrderId() {
		order.setOrder_id(1001);
		assertThat(order.getOrder_id(), is(1001));
	}

	@Test
	public void testSetAndGetCustomerId() {
		order.setCustomer_id(2002);
		assertThat(order.getCustomer_id(), is(2002));
	}

	@Test
	public void testSetAndGetStatus() {
		order.setStatus("Procesando");
		assertThat(order.getStatus(), containsString("Procesando"));
	}

	@Test
	public void testSetAndGetOrderDate() {
		Date hoy = new Date();
		order.setOrder_date(hoy);
		assertThat(order.getOrder_date(), is(hoy));
	}

	@Test
	public void testSetAndGetSalesmanId() {
		order.setSalesman_id(500);
		assertThat(order.getSalesman_id(), greaterThan(0));
	}

	@Test
	public void testSetAndGetFk_orders_customers() {
		order.setFk_orders_customers(500);
		assertThat(order.getFk_orders_customers(), is(500));
	}

	@Test
	public void testSetAndGetFk_orders_employees() {
		order.setFk_orders_employees(600);
		assertThat(order.getFk_orders_employees(), is(600));
	}

	@Test
	public void testToStringContainsAll() {
		Date fecha = new Date();
		order.setOrder_id(100);
		order.setCustomer_id(50);
		order.setStatus("Enviado");
		order.setSalesman_id(10);
		order.setOrder_date(fecha);
		order.setFk_orders_customers(300);
		order.setFk_orders_employees(400);
		assertThat(order.toString(), containsString("100"));
		assertThat(order.toString(), containsString("50"));
		assertThat(order.toString(), containsString("Enviado"));
		assertThat(order.toString(), containsString("10"));
		assertThat(order.toString(), containsString(""));
		assertThat(order.toString(), containsString("300"));
		assertThat(order.toString(), containsString("400"));
	}
}