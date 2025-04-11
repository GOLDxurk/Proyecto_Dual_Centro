package Tablas;

public class WAREHOUSES {

	int warehouse_id;
	String warehouse_name;
	int location_id;
	int fk_warehouse_locations;

	// constructor con pk
	public WAREHOUSES(int warehouse_id, String warehouse_name, int location_id, int fk_warehouse_locations) {
		super();
		this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
		this.location_id = location_id;
		this.fk_warehouse_locations = fk_warehouse_locations;
	}

	// constructor sin pk
	public WAREHOUSES(String warehouse_name, int location_id, int fk_warehouse_locations) {
		super();
		this.warehouse_name = warehouse_name;
		this.location_id = location_id;
		this.fk_warehouse_locations = fk_warehouse_locations;
	}

	// setters y getters
	public int getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public String getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public int getFk_warehouse_locations() {
		return fk_warehouse_locations;
	}

	public void setFk_warehouse_locations(int fk_warehouse_locations) {
		this.fk_warehouse_locations = fk_warehouse_locations;
	}

	// Resumen de propiedades con toString
	@Override
	public String toString() {
		return "WAREHOUSES [warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name + ", location_id="
				+ location_id + ", fk_warehouse_locations=" + fk_warehouse_locations + "]";
	}

}
