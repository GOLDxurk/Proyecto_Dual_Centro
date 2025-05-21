package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class COUNTRIESTest {

	private COUNTRIES pais;

	@BeforeEach
	public void setUp() {
		pais = new COUNTRIES();
	}

	@Test
	public void testConstructorVacio() {
		COUNTRIES country = new COUNTRIES();
		assertThat(country, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		COUNTRIES country = new COUNTRIES(100, "España", 3, 3);

		assertThat(country.getCountry_id(), is(100));
		assertThat(country.getCountry_name(), is("España"));
		assertThat(country.getRegion_id(), is(3));
		assertThat(country.getFk_countries_regions(), is(3));
	}

	@Test
	public void testConstructorSinPK() {
		COUNTRIES country = new COUNTRIES("Italia", 2, 2);

		assertThat(country.getCountry_id(), is(0)); // Valor por defecto
		assertThat(country.getCountry_name(), is("Italia"));
		assertThat(country.getRegion_id(), is(2));
		assertThat(country.getFk_countries_regions(), is(2));
	}

	@Test
	public void testSetAndGetCountryId() {
		pais.setCountry_id(100);
		assertThat(pais.getCountry_id(), is(100));
	}

	@Test
	public void testSetAndGetCountryName() {
		pais.setCountry_name("España");
		assertThat(pais.getCountry_name(), containsString("España"));
	}

	@Test
	public void testSetAndGetRegionId() {
		pais.setRegion_id(2);
		assertThat(pais.getRegion_id(), is(2));
	}

	@Test
	public void setAndGetfk_countries_regions() {
		pais.setFk_countries_regions(3);
		assertThat(pais.getFk_countries_regions(), is(3));
		;
	}

	@Test
	public void testToStringNotNull() {
		pais.setCountry_id(110);
		pais.setCountry_name("Alemania");
		pais.setRegion_id(8);
		pais.setFk_countries_regions(8);
		assertThat(pais.toString(), containsString("110"));
		assertThat(pais.toString(), containsString("Alemania"));
		assertThat(pais.toString(), containsString("8"));
		assertThat(pais.toString(), containsString("8"));
	}
}
