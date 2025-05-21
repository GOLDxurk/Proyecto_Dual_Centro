package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WAREHOUSESTest {

	private WAREHOUSES almacen;

	@BeforeEach
	public void setUp() {
		almacen = new WAREHOUSES();
	}

	@Test
	public void testConstructorConPK() {
		WAREHOUSES warehouse = new WAREHOUSES(1, "Central", 100, 100);

		assertThat(warehouse.getWarehouse_id(), is(1));
		assertThat(warehouse.getWarehouse_name(), is("Central"));
		assertThat(warehouse.getLocation_id(), is(100));
		assertThat(warehouse.getFk_warehouse_locations(), is(100));
	}

	@Test
	public void testConstructorSinPK() {
		WAREHOUSES warehouse = new WAREHOUSES("Norte", 200, 200);

		assertThat(warehouse.getWarehouse_id(), is(0));
		assertThat(warehouse.getWarehouse_name(), is("Norte"));
		assertThat(warehouse.getLocation_id(), is(200));
		assertThat(warehouse.getFk_warehouse_locations(), is(200));
	}

	@Test
	public void testSetAndGetWarehouseId() {
		almacen.setWarehouse_id(101);
		assertThat(almacen.getWarehouse_id(), is(101));
	}

	@Test
	public void testSetAndGetWarehouseName() {
		almacen.setWarehouse_name("Madrid Central");
		assertThat(almacen.getWarehouse_name(), containsString("Madrid"));
	}

	@Test
	public void testSetAndGetLocationId() {
		almacen.setLocation_id(10);
		assertThat(almacen.getLocation_id(), greaterThan(0));
	}

	@Test
	public void testSetAndGetFkWarehouseLocations() {
		almacen.setFk_warehouse_locations(10);
		assertThat(almacen.getFk_warehouse_locations(), equalTo(10));
	}

	@Test
	public void testToStringContainsAll() {
		almacen.setWarehouse_id(101);
		almacen.setWarehouse_name("Sevilla Central");
		almacen.setLocation_id(11);
		almacen.setFk_warehouse_locations(11);
		assertThat(almacen.toString(), containsString("101"));
		assertThat(almacen.toString(), containsString("Sevilla Central"));
		assertThat(almacen.toString(), containsString("11"));
		assertThat(almacen.toString(), containsString("11"));
	}
}
