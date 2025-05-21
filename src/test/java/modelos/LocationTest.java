package modelos;

import static org.junit.Assert.*;
import org.junit.Test;

public class LocationTest {

	@Test
	public void testConstructorLocation() {
		Location location = new Location(1, "Calle 123", "41020", "Sevilla", "Sevilla", "ES");
		assertEquals(1, location.getLocationId());
		assertEquals("Calle 123", location.getAddress());
		assertEquals("41020", location.getPostalCode());
		assertEquals("Sevilla", location.getCity());
		assertEquals("Sevilla", location.getState());
		assertEquals("ES", location.getCountryId());
	}

	@Test
	public void testGetLocationId() {
		Location location = new Location(42, "Av. Siempre Viva", "41920", "Sevilla", "San Juan de Aznalfarache", "ES");
		assertEquals(42L, location.getLocationId());
	}

	@Test
	public void testGetAddress() {
		Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
		assertEquals("Avenida Constitucion", location.getAddress());
	}

	@Test
	public void testGetPostalCode() {
		Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
		assertEquals("41020", location.getPostalCode());
	}

	@Test
	public void testGetCity() {
		Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
		assertEquals("Sevilla", location.getCity());
	}

	@Test
	public void testGetState() {
		Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
		assertEquals("Sevilla", location.getState());
	}

	@Test
	public void testGetCountryId() {
		Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
		assertEquals("ES", location.getCountryId());
	}

	@Test
	public void testToString() {
		Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
		assertEquals("Avenida Constitucion", location.toString());
	}
}
