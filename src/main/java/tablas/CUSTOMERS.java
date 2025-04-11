package Tablas;

public class CUSTOMERS {
	int customer_id;
	String name;
	String address;
	String website;
	double credit_limit;

	// constructor con pk
	public CUSTOMERS(int customer_id, String name, String address, String website, double credit_limit) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.address = address;
		this.website = website;
		this.credit_limit = credit_limit;
	}

	// constructor sin pk
	public CUSTOMERS(String name, String address, String website, double credit_limit) {
		super();
		this.name = name;
		this.address = address;
		this.website = website;
		this.credit_limit = credit_limit;
	}

	// getters y setters
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public double getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(double credit_limit) {
		this.credit_limit = credit_limit;
	}

	// Resumen propiedades con toString
	@Override
	public String toString() {
		return "CUSTOMERS [customer_id=" + customer_id + ", name=" + name + ", address=" + address + ", website="
				+ website + ", credit_limit=" + credit_limit + "]";
	}

}