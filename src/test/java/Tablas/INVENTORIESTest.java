package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class INVENTORIESTest {
	private INVENTORIES inventario;

	@BeforeEach
	public void setUp() {
		inventario = new INVENTORIES();
	}

	@Test
	public void testConstructorVacio() {
		INVENTORIES inv = new INVENTORIES();
		assertThat(inv, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		INVENTORIES inv = new INVENTORIES(101, 5, 300, 101, 5);

		assertThat(inv.getProduct_id(), is(101));
		assertThat(inv.getWarehouse_id(), is(5));
		assertThat(inv.getQuantity(), is(300));
		assertThat(inv.getFk_inventories_products(), is(101));
		assertThat(inv.getFk_inventories_warehouse(), is(5));
	}

	@Test
	public void testConstructorSinPK() {
		INVENTORIES inv = new INVENTORIES(10, 200, 77, 3);

		assertThat(inv.getProduct_id(), is(0));
		assertThat(inv.getWarehouse_id(), is(10));
		assertThat(inv.getQuantity(), is(200));
		assertThat(inv.getFk_inventories_products(), is(77));
		assertThat(inv.getFk_inventories_warehouse(), is(3));
	}

	@Test
	public void testSetAndGetProductId() {
		inventario.setProduct_id(10);
		assertThat(inventario.getProduct_id(), is(10));
	}

	@Test
	public void testSetAndGetWarehouseId() {
		inventario.setWarehouse_id(5);
		assertThat(inventario.getWarehouse_id(), is(5));
	}

	@Test
	public void testSetAndGetQuantity() {
		inventario.setQuantity(200);
		assertThat(inventario.getQuantity(), greaterThan(100));
	}

	@Test
	public void testSetAndGetFk_inventories_products() {
		inventario.setFk_inventories_products(80);
		assertThat(inventario.getFk_inventories_products(), is(80));
	}

	@Test
	public void testSetAndGetFk_inventories_warehouse() {
		inventario.setFk_inventories_warehouse(9);
		assertThat(inventario.getFk_inventories_warehouse(), is(9));
	}

	@Test
	public void testToStringContainsAll() {
		inventario.setProduct_id(102);
		inventario.setWarehouse_id(6);
		inventario.setQuantity(200);
		inventario.setFk_inventories_products(102);
		inventario.setFk_inventories_warehouse(6);
		assertThat(inventario.toString(), containsString("102"));
		assertThat(inventario.toString(), containsString("6"));
		assertThat(inventario.toString(), containsString("200"));
		assertThat(inventario.toString(), containsString("102"));
		assertThat(inventario.toString(), containsString("6"));

	}

}
