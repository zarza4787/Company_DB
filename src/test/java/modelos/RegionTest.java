package modelos;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class RegionTest {

    @Test
    public void testConstructorRegion() {
        Region region = new Region(1, "Europa");
        assertThat(region.getRegionId(), is(1L));
        assertThat(region.getRegionName(), is("Europa"));
    }

    @Test
    public void testGetRegionId() {
        Region region = new Region(2, "América");
        assertThat(region.getRegionId(), is(2L));
    }

    @Test
    public void testGetRegionName() {
        Region region = new Region(3, "Asia");
        assertThat(region.getRegionName(), is("Asia"));
    }

    @Test
    public void testToString() {
        Region region = new Region(4, "África");
        assertThat(region.toString(), is("África"));
    }
}
