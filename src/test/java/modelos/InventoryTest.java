package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class InventoryTest {

    @Test
    public void testInventory() {
        Inventory inventory = new Inventory(2L, 3L, 4);
        assertThat(inventory.getProductId(), is(2L));    
        assertThat(inventory.getWarehouseId(), is(3L));
        assertThat(inventory.getQuantity(), is(4));     
    }

    @Test
    public void testGetProductId() {
        Inventory inventory = new Inventory(2L, 1L, 10);
        assertThat(inventory.getProductId(), is(2L));
    }

    @Test
    public void testGetWarehouseId() {
        Inventory inventory = new Inventory(1L, 4L, 10);
        assertThat(inventory.getWarehouseId(), is(4L));
    }

    @Test
    public void testGetQuantity() {
        Inventory inventory = new Inventory(1L, 2L, 5);
        assertThat(inventory.getQuantity(), is(5));
    }
}
