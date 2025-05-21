package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class REGIONSTest {

	private REGIONS region;

	@BeforeEach
	public void setUp() {
		region = new REGIONS();
	}

	@Test
	public void testConstructorVacio() {
		REGIONS region = new REGIONS();
		assertThat(region, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		REGIONS region = new REGIONS(10, "Europa");

		assertThat(region.getRegion_id(), is(10));
		assertThat(region.getRegion_name(), is("Europa"));
	}

	@Test
	public void testConstructorSinPK() {
		REGIONS region = new REGIONS("Asia");

		assertThat(region.getRegion_id(), is(0)); // Valor por defecto
		assertThat(region.getRegion_name(), is("Asia"));
	}

	@Test
	public void testSetAndGetRegionId() {
		region.setRegion_id(1);
		assertThat(region.getRegion_id(), is(1));
	}

	@Test
	public void testSetAndGetRegionName() {
		region.setRegion_name("Europa");
		assertThat(region.getRegion_name(), containsString("Europa"));
	}

	@Test
	public void testToStringNotNull() {
		region.setRegion_id(4);
		region.setRegion_name("USA");
		assertThat(region.toString(), containsString("4"));
		assertThat(region.toString(), containsString("USA"));
	}

}
