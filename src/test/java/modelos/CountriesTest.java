package modelos;

import static org.junit.Assert.*;
import org.junit.Test;

public class CountriesTest {

    @Test
    public void testCountries() {
        Countries country = new Countries("FR", "Francia", 11);
        assertNotNull(country);
    }

    @Test
    public void testGetCountryID() {
        Countries country = new Countries("FR", "Francia", 11);
        assertEquals("FR", country.getCountryID());
    }

    @Test
    public void testGetCountryName() {
        Countries country = new Countries("FR", "Francia", 11);
        assertEquals("Francia", country.getCountryName());
    }

    @Test
    public void testGetRegionId() {
        Countries country = new Countries("FR", "Francia", 11);
        assertEquals(11, country.getRegionId());
    }
}
