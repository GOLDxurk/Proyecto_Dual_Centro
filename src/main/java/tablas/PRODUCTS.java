package Tablas;

public class PRODUCTS {

	int product_id;
	String product_name;
	String description;
	double standard_cost;
	double list_price;
	int category_id;
	int fk_products_categories;

	// constructor vacio
	public PRODUCTS() {
		super();
	}

	// constructor con pk
	public PRODUCTS(int product_id, String product_name, String description, double standard_cost, double list_price,
			int category_id, int fk_products_categories) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.standard_cost = standard_cost;
		this.list_price = list_price;
		this.category_id = category_id;
		this.fk_products_categories = fk_products_categories;
	}

	// constructor sin pk
	public PRODUCTS(String product_name, String description, double standard_cost, double list_price, int category_id,
			int fk_products_categories) {
		super();
		this.product_name = product_name;
		this.description = description;
		this.standard_cost = standard_cost;
		this.list_price = list_price;
		this.category_id = category_id;
		this.fk_products_categories = fk_products_categories;
	}

	// setters y getters
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getStandard_cost() {
		return standard_cost;
	}

	public void setStandard_cost(double standard_cost) {
		this.standard_cost = standard_cost;
	}

	public double getList_price() {
		return list_price;
	}

	public void setList_price(double list_price) {
		this.list_price = list_price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getFk_products_categories() {
		return fk_products_categories;
	}

	public void setFk_products_categories(int fk_products_categories) {
		this.fk_products_categories = fk_products_categories;
	}

	// Resumen de propiedades con toString
	@Override
	public String toString() {
		return "PRODUCTS [product_id=" + product_id + ", porduct_name=" + product_name + ", description=" + description
				+ ", standard_cost=" + standard_cost + ", list_price=" + list_price + ", category_id=" + category_id
				+ ", fk_products_categories=" + fk_products_categories + "]";
	}

}
