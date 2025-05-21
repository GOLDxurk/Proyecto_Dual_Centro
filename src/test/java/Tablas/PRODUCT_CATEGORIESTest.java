package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PRODUCT_CATEGORIESTest {

	private PRODUCT_CATEGORIES categoria;

	@BeforeEach
	public void setUp() {
		categoria = new PRODUCT_CATEGORIES();
	}

	@Test
	public void testConstructorVacio() {
		PRODUCT_CATEGORIES category = new PRODUCT_CATEGORIES();
		assertThat(category, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		PRODUCT_CATEGORIES category = new PRODUCT_CATEGORIES(1, "Electronica");

		assertThat(category.getCategory_id(), is(1));
		assertThat(category.getCategory_name(), is("Electronica"));
	}

	@Test
	public void testConstructorSinPK() {
		PRODUCT_CATEGORIES category = new PRODUCT_CATEGORIES("Ropa");

		assertThat(category.getCategory_id(), is(0));
		assertThat(category.getCategory_name(), is("Ropa"));
	}

	@Test
	public void testSetAndGetCategoryId() {
		categoria.setCategory_id(5);
		assertThat(categoria.getCategory_id(), is(5));
	}

	@Test
	public void testSetAndGetCategoryName() {
		categoria.setCategory_name("Electronica");
		assertThat(categoria.getCategory_name(), containsString("Electronica"));
	}

	@Test
	public void testToStringNotNull() {
		categoria.setCategory_id(6);
		categoria.setCategory_name("Cosmetica");
		assertThat(categoria.toString(), containsString("6"));
		assertThat(categoria.toString(), containsString("Cosmetica"));
	}
}
