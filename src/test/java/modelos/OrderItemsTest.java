package modelos;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class OrderItemsTest {

	@Test
	public void testOrderItems() {
		OrderItems item = new OrderItems(1, 10, 100, 2.5, new BigDecimal("19.99"));

		assertEquals(1, item.getOrderId());
		assertEquals(10, item.getItemId());
		assertEquals(100, item.getProductId());
		assertEquals(2.5, item.getQuantity(), 0.001);
		assertEquals(new BigDecimal("19.99"), item.getUnitPrice());
	}

	@Test
	public void testGetOrderId() {
		OrderItems item = new OrderItems(2, 11, 101, 1.0, new BigDecimal("9.99"));
		assertEquals(2, item.getOrderId());
	}

	@Test
	public void testGetItemId() {
		OrderItems item = new OrderItems(3, 12, 102, 3.0, new BigDecimal("5.00"));
		assertEquals(12, item.getItemId());
	}

	@Test
	public void testGetProductId() {
		OrderItems item = new OrderItems(4, 13, 103, 4.0, new BigDecimal("3.50"));
		assertEquals(103, item.getProductId());
	}

	@Test
	public void testGetQuantity() {
		OrderItems item = new OrderItems(5, 14, 104, 5.5, new BigDecimal("1.25"));
		assertEquals(5.5, item.getQuantity(), 0.001);
	}

	@Test
	public void testGetUnitPrice() {
		BigDecimal expectedPrice = new BigDecimal("10.00");
		OrderItems item = new OrderItems(6, 15, 105, 6.0, expectedPrice);
		assertEquals(expectedPrice, item.getUnitPrice());
	}
}
