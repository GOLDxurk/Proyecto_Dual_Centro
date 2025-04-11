package Tablas;

public class PRODUCT_CATEGORIES {

	int category_id;
	String category_name;

	// constructor con pk
	public PRODUCT_CATEGORIES(int category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}

	// constructor sin pk
	public PRODUCT_CATEGORIES(String category_name) {
		super();
		this.category_name = category_name;
	}

	// setters y getters
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	// Resumen de propiedades con toString
	@Override
	public String toString() {
		return "PRODUCT_CATEGORIES [category_id=" + category_id + ", category_name=" + category_name + "]";
	}

}
