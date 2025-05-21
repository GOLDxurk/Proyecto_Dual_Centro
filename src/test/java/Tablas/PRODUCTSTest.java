package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PRODUCTSTest {
	private PRODUCTS producto;

	@BeforeEach
	public void setUp() {
		producto = new PRODUCTS();
	}

	@Test
	void testConstructorVacio() {
		PRODUCTS e = new PRODUCTS();
		assertThat(e, is(notNullValue()));
	}

	@Test
	void testConstructorConPK() {
		PRODUCTS producto = new PRODUCTS(1, "Portátil", "MacBook Mini\"", 400.00, 550.00, 3, 10);

		assertThat(producto.getProduct_id(), is(1));
		assertThat(producto.getProduct_name(), is("Portátil"));
		assertThat(producto.getDescription(), is("MacBook Mini\""));
		assertThat(producto.getStandard_cost(), is(400.00));
		assertThat(producto.getList_price(), is(550.00));
		assertThat(producto.getCategory_id(), is(3));
		assertThat(producto.getFk_products_categories(), is(10));
	}

	@Test
	void testConstructorSinPK() {
		PRODUCTS producto = new PRODUCTS("Monitor", "27 pulgadas", 120.00, 160.00, 5, 12);

		assertThat(producto.getProduct_name(), is("Monitor"));
		assertThat(producto.getDescription(), is("27 pulgadas"));
		assertThat(producto.getStandard_cost(), is(120.00));
		assertThat(producto.getList_price(), is(160.00));
		assertThat(producto.getCategory_id(), is(5));
		assertThat(producto.getFk_products_categories(), is(12));
	}

	@Test
	public void testSetAndGetProductId() {
		producto.setProduct_id(10);
		assertThat(producto.getProduct_id(), is(10));
	}

	@Test
	public void testSetAndGetProductName() {
		producto.setProduct_name("Teclado");
		assertThat(producto.getProduct_name(), is("Teclado"));
	}

	@Test
	public void testSetAndGetDescription() {
		producto.setDescription("Teclado mecánico");
		assertThat(producto.getDescription(), containsString("mecánico"));
	}

	@Test
	public void testSetAndGetStandardCost() {
		producto.setStandard_cost(20.5);
		assertThat(producto.getStandard_cost(), greaterThan(0.0));
	}

	@Test
	public void testSetAndGetListPrice() {
		producto.setList_price(30.0);
		assertThat(producto.getList_price(), greaterThanOrEqualTo(30.0));
	}

	@Test
	public void testSetAndGetCategoryId() {
		producto.setCategory_id(3);
		assertThat(producto.getCategory_id(), is(3));
	}

	@Test
	public void testToStringContainsName() {
		producto.setProduct_name("Teclado");
		assertThat(producto.toString(), containsString("Teclado"));
	}
}