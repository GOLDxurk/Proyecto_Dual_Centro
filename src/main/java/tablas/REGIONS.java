package Tablas;

public class REGIONS {

	int region_id;
	String region_name;

	// Constructor con pk
	public REGIONS(int region_id, String region_name) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
	}

	// Constructor sin pk
	public REGIONS(String region_name) {
		super();
		this.region_name = region_name;
	}

	// setter y gertters
	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	// Resumen de propiedades con toString
	@Override
	public String toString() {
		return "REGIONS [region_id=" + region_id + ", region_name=" + region_name + "]";
	}

}
