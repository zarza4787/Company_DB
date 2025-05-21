package modelos;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegionTest {

    @Test
    public void testConstructorRegion() {
        Region region = new Region(1, "Europa");
        assertNotNull(region);
        assertEquals(1, region.getRegionId());
        assertEquals("Europa", region.getRegionName());
    }

    @Test
    public void testGetRegionId() {
        Region region = new Region(2, "América");
        assertEquals(2, region.getRegionId());
    }

    @Test
    public void testGetRegionName() {
        Region region = new Region(3, "Asia");
        assertEquals("Asia", region.getRegionName());
    }

    @Test
    public void testToString() {
        Region region = new Region(4, "África");
        assertEquals("África", region.toString());
    }
}
