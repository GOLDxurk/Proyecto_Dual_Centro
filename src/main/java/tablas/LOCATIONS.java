package Tablas;

public class LOCATIONS {

	int location_id;
	String address;
	String postal_code;
	String city;
	String state;
	int country_id;
	int fk_location_countries;

	// constructor con pk
	public LOCATIONS(int location_id, String address, String postal_code, String city, String state, int country_id,
			int fk_location_countries) {
		super();
		this.location_id = location_id;
		this.address = address;
		this.postal_code = postal_code;
		this.city = city;
		this.state = state;
		this.country_id = country_id;
		this.fk_location_countries = fk_location_countries;
	}

	// constructor sin pk
	public LOCATIONS(String address, String postal_code, String city, String state, int country_id,
			int fk_location_countries) {
		super();
		this.address = address;
		this.postal_code = postal_code;
		this.city = city;
		this.state = state;
		this.country_id = country_id;
		this.fk_location_countries = fk_location_countries;
	}

	// getters y setters
	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getFk_location_countries() {
		return fk_location_countries;
	}

	public void setFk_location_countries(int fk_location_countries) {
		this.fk_location_countries = fk_location_countries;
	}

	// Resumen propiedades con toString
	@Override
	public String toString() {
		return "LOCATIONS [location_id=" + location_id + ", address=" + address + ", postal_code=" + postal_code
				+ ", city=" + city + ", state=" + state + ", country_id=" + country_id + ", fk_location_countries="
				+ fk_location_countries + "]";
	}

}
