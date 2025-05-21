package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

import org.junit.Test;

public class OrderItemsTest {

	@Test
	public void testOrderItems() {
		OrderItems item = new OrderItems(1, 10, 100, 2.5, new BigDecimal("19.99"));

		assertThat(item.getOrderId(), is(1L));
		assertThat(item.getItemId(), is(10L));
		assertThat(item.getProductId(), is(100L));
		assertThat(item.getQuantity(), closeTo(2.5, 0.001));
		assertThat(item.getUnitPrice(), comparesEqualTo(new BigDecimal("19.99")));
	}

	@Test
	public void testGetOrderId() {
		OrderItems item = new OrderItems(2, 11, 101, 1.0, new BigDecimal("9.99"));
		assertThat(item.getOrderId(), is(2L));
	}

	@Test
	public void testGetItemId() {
		OrderItems item = new OrderItems(3, 12, 102, 3.0, new BigDecimal("5.00"));
		assertThat(item.getItemId(), is(12L));
	}

	@Test
	public void testGetProductId() {
		OrderItems item = new OrderItems(4, 13, 103, 4.0, new BigDecimal("3.50"));
		assertThat(item.getProductId(), is(103L));
	}

	@Test
	public void testGetQuantity() {
		OrderItems item = new OrderItems(5, 14, 104, 5.5, new BigDecimal("1.25"));
		assertThat(item.getQuantity(), closeTo(5.5, 0.001));
	}

	@Test
	public void testGetUnitPrice() {
		BigDecimal expectedPrice = new BigDecimal("10.00");
		OrderItems item = new OrderItems(6, 15, 105, 6.0, expectedPrice);
		assertThat(item.getUnitPrice(), comparesEqualTo(expectedPrice));
	}
}
