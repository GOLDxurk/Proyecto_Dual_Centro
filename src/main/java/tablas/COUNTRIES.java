package Tablas;

public class COUNTRIES {
	int country_id;
	String country_name;
	int region_id;
	int fk_countries_regions;

	// constructor con pk
	public COUNTRIES(int country_id, String country_name, int region_id, int fk_countries_regions) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.region_id = region_id;
		this.fk_countries_regions = fk_countries_regions;
	}

	// constructor sin pk
	public COUNTRIES(String country_name, int region_id, int fk_countries_regions) {
		super();
		this.country_name = country_name;
		this.region_id = region_id;
		this.fk_countries_regions = fk_countries_regions;
	}

	// setters y getters

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public int getFk_countries_regions() {
		return fk_countries_regions;
	}

	public void setFk_countries_regions(int fk_countries_regions) {
		this.fk_countries_regions = fk_countries_regions;
	}

	// Resumen propiedades con toString
	@Override
	public String toString() {
		return "COUNTRIES [country_id=" + country_id + ", country_name=" + country_name + ", region_id=" + region_id
				+ ", fk_countries_regions=" + fk_countries_regions + "]";
	}

}
