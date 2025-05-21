package modelos;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {

	@Test
	public void testInventory() {
		Inventory inventory = new Inventory(2, 3, 4);
		assertEquals(2, inventory.getProductId());
		assertEquals(3, inventory.getWarehouseId());
		assertEquals(4, inventory.getQuantity());
	}

	@Test
	public void testGetProductId() {
		Inventory inventory = new Inventory(2, 1, 10);
		assertEquals(2, inventory.getProductId());
	}

	@Test
	public void testGetWarehouseId() {
		Inventory inventory = new Inventory(1, 4, 10);
		assertEquals(4, inventory.getWarehouseId());
	}

	@Test
	public void testGetQuantity() {
		Inventory inventory = new Inventory(1, 2, 5);
		assertEquals(5, inventory.getQuantity());
	}
}
