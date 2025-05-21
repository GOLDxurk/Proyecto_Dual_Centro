package Tablas;

public class CONTACTS {
	int contact_id; // Primary key
	String first_name;
	String last_name;
	String email;
	String phone;
	int customer_id;
	int fk_contacts_customers;

	// constructor vacio
	public CONTACTS() {
		super();
	}

	// constructor con pk
	public CONTACTS(int contact_id, String first_name, String last_name, String email, String phone, int customer_id,
			int fk_contacts_customers) {
		super();
		this.contact_id = contact_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.customer_id = customer_id;
		this.fk_contacts_customers = fk_contacts_customers;
	}

	// constructor sin pk para autogenerable
	public CONTACTS(String first_name, String last_name, String email, String phone, int customer_id,
			int fk_contacts_customers) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.customer_id = customer_id;
		this.fk_contacts_customers = fk_contacts_customers;
	}

	// Setters y Getters
	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getFk_contacts_customers() {
		return fk_contacts_customers;
	}

	public void setFk_contacts_customers(int fk_contacts_customers) {
		this.fk_contacts_customers = fk_contacts_customers;
	}
	// Resumen propiedades con ToString

	@Override
	public String toString() {
		return "CONTACTS [contact_id=" + contact_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone=" + phone + ", customer_id=" + customer_id + ", fk_contacts_customers="
				+ fk_contacts_customers + "]";
	}

}