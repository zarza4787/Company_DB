package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class LocationTest {

    @Test
    public void testConstructorLocation() {
        Location location = new Location(1, "Calle 123", "41020", "Sevilla", "Sevilla", "ES");
        assertThat(location.getLocationId(), is(1L));
        assertThat(location.getAddress(), is("Calle 123"));
        assertThat(location.getPostalCode(), is("41020"));
        assertThat(location.getCity(), is("Sevilla"));
        assertThat(location.getState(), is("Sevilla"));
        assertThat(location.getCountryId(), is("ES"));
    }

    @Test
    public void testGetLocationId() {
        Location location = new Location(42, "Av. Siempre Viva", "41920", "Sevilla", "San Juan de Aznalfarache", "ES");
        assertThat(location.getLocationId(), is(42L));
    }

    @Test
    public void testGetAddress() {
        Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
        assertThat(location.getAddress(), is("Avenida Constitucion"));
    }

    @Test
    public void testGetPostalCode() {
        Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
        assertThat(location.getPostalCode(), is("41020"));
    }

    @Test
    public void testGetCity() {
        Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
        assertThat(location.getCity(), is("Sevilla"));
    }

    @Test
    public void testGetState() {
        Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
        assertThat(location.getState(), is("Sevilla"));
    }

    @Test
    public void testGetCountryId() {
        Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
        assertThat(location.getCountryId(), is("ES"));
    }

    @Test
    public void testToString() {
        Location location = new Location(1, "Avenida Constitucion", "41020", "Sevilla", "Sevilla", "ES");
        assertThat(location.toString(), is("Avenida Constitucion"));
    }
}
