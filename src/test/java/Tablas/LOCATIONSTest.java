package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LOCATIONSTest {

	private LOCATIONS location;

	@BeforeEach
	public void setUp() {
		location = new LOCATIONS();
	}

	@Test
	public void testConstructorVacio() {
		LOCATIONS loc = new LOCATIONS();
		assertThat(loc, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		LOCATIONS loc = new LOCATIONS(1, "Calle Real", "28001", "Madrid", "Madrid", 34, 34);

		assertThat(loc.getLocation_id(), is(1));
		assertThat(loc.getAddress(), is("Calle Real"));
		assertThat(loc.getPostal_code(), is("28001"));
		assertThat(loc.getCity(), is("Madrid"));
		assertThat(loc.getState(), is("Madrid"));
		assertThat(loc.getCountry_id(), is(34));
		assertThat(loc.getFk_location_countries(), is(34));
	}

	@Test
	public void testConstructorSinPK() {
		LOCATIONS loc = new LOCATIONS("Gran Vía", "08001", "Barcelona", "Cataluña", 56, 56);

		assertThat(loc.getLocation_id(), is(0));
		assertThat(loc.getAddress(), is("Gran Vía"));
		assertThat(loc.getPostal_code(), is("08001"));
		assertThat(loc.getCity(), is("Barcelona"));
		assertThat(loc.getState(), is("Cataluña"));
		assertThat(loc.getCountry_id(), is(56));
		assertThat(loc.getFk_location_countries(), is(56));
	}

	@Test
	public void testSetAndGetAddress() {
		location.setAddress("Calle Real 45");
		assertThat(location.getAddress(), containsString("Real"));
	}

	@Test
	public void testSetAndGetPostalCode() {
		location.setPostal_code("28001");
		assertThat(location.getPostal_code(), matchesPattern("\\d{5}"));
	}

	@Test
	public void testSetAndGetCity() {
		location.setCity("Madrid");
		assertThat(location.getCity(), equalTo("Madrid"));
	}

	@Test
	public void testSetAndGetFk_location_countries() {
		location.setFk_location_countries(2);
		assertThat(location.getFk_location_countries(), is(2));
	}

	@Test
	public void testSetAndGetCountryId() {
		location.setCountry_id(7);
		assertThat(location.getCountry_id(), is(7));
	}

	@Test
	public void testToStringContainsAll() {
		location.setLocation_id(102);
		location.setAddress("Calle Totalmente Real 69");
		location.setPostal_code("28007");
		location.setCity("Madrid");
		location.setState("Madrid");
		location.setCountry_id(34);
		location.setFk_location_countries(34);
		assertThat(location.toString(), containsString("102"));
		assertThat(location.toString(), containsString("Calle Totalmente Real 69"));
		assertThat(location.toString(), containsString("28007"));
		assertThat(location.toString(), containsString("Madrid"));
		assertThat(location.toString(), containsString("Madrid"));
		assertThat(location.toString(), containsString("34"));
		assertThat(location.toString(), containsString("34"));

	}
}
