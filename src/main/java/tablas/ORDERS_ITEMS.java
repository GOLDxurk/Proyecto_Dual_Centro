package Tablas;

public class ORDERS_ITEMS {

	int order_id;
	int item_id;
	int product_id;
	double quantity;
	double unit_price;
	int fk_order_items;
	int fk_order_items_order;

	// constructor vacio
	public ORDERS_ITEMS() {
		super();
	}

	// constructor con pk
	public ORDERS_ITEMS(int order_id, int item_id, int product_id, double quantity, double unit_price,
			int fk_order_items, int fk_order_items_order) {
		super();
		this.order_id = order_id;
		this.item_id = item_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.fk_order_items = fk_order_items;
		this.fk_order_items_order = fk_order_items_order;
	}

	// constructor sin pk
	public ORDERS_ITEMS(int item_id, int product_id, double quantity, double unit_price, int fk_order_items,
			int fk_order_items_order) {
		super();
		this.item_id = item_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.fk_order_items = fk_order_items;
		this.fk_order_items_order = fk_order_items_order;
	}

	// setters y getters
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public int getFk_order_items() {
		return fk_order_items;
	}

	public void setFk_order_items(int fk_order_items) {
		this.fk_order_items = fk_order_items;
	}

	public int getFk_order_items_order() {
		return fk_order_items_order;
	}

	public void setFk_order_items_order(int fk_order_items_order) {
		this.fk_order_items_order = fk_order_items_order;
	}

	// Resumen propiedades con toString
	@Override
	public String toString() {
		return "ORDERS_ITEMS [order_id=" + order_id + ", item_id=" + item_id + ", product_id=" + product_id
				+ ", quiantity=" + quantity + ", unit_price=" + unit_price + ", fk_order_items=" + fk_order_items
				+ ", fk_order_items_order=" + fk_order_items_order + "]";
	}

}
