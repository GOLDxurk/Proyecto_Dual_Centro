package Tablas;

public class INVENTORIES {

	int product_id;
	int warehouse_id;
	int quantity;
	int fk_inventories_products;
	int fk_inventories_warehouse;

	// constructor vacio
	public INVENTORIES() {
		super();
	}

	// constructor con pk
	public INVENTORIES(int product_id, int warehouse_id, int quantity, int fk_inventories_products,
			int fk_inventories_warehouse) {
		super();
		this.product_id = product_id;
		this.warehouse_id = warehouse_id;
		this.quantity = quantity;
		this.fk_inventories_products = fk_inventories_products;
		this.fk_inventories_warehouse = fk_inventories_warehouse;
	}

	// constructor sin pk
	public INVENTORIES(int warehouse_id, int quantity, int fk_inventories_products, int fk_inventories_warehouse) {
		super();
		this.warehouse_id = warehouse_id;
		this.quantity = quantity;
		this.fk_inventories_products = fk_inventories_products;
		this.fk_inventories_warehouse = fk_inventories_warehouse;
	}

	// setters y getters
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFk_inventories_products() {
		return fk_inventories_products;
	}

	public void setFk_inventories_products(int fk_inventories_products) {
		this.fk_inventories_products = fk_inventories_products;
	}

	public int getFk_inventories_warehouse() {
		return fk_inventories_warehouse;
	}

	public void setFk_inventories_warehouse(int fk_inventories_warehouse) {
		this.fk_inventories_warehouse = fk_inventories_warehouse;
	}

	// Resumen propiedades con toString
	@Override
	public String toString() {
		return "INVENTORIES [product_id=" + product_id + ", warehouse_id=" + warehouse_id + ", quantity=" + quantity
				+ ", fk_inventories_products=" + fk_inventories_products + ", fk_inventories_warehouse="
				+ fk_inventories_warehouse + "]";
	}

}
