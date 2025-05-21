package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class CountriesTest {

    @Test
    public void testCountries() {
        Countries country = new Countries("FR", "Francia", 11);
        assertThat(country, is(notNullValue()));
    }

    @Test
    public void testGetCountryID() {
        Countries country = new Countries("FR", "Francia", 11);
        assertThat(country.getCountryID(), is("FR"));
    }

    @Test
    public void testGetCountryName() {
        Countries country = new Countries("FR", "Francia", 11);
        assertThat(country.getCountryName(), is("Francia"));
    }

    @Test
    public void testGetRegionId() {
        Countries country = new Countries("FR", "Francia", 11L);
        assertThat(country.getRegionId(), is(11L));
    }
}
