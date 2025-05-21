package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Date;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testConstructorOrder() {
		Date fecha = new Date();
		Order order = new Order(1, 100, "Pendiente", 200, fecha);

		assertThat(order.getOrderId(), is(1L));
		assertThat(order.getCustomerId(), is(100L));
		assertThat(order.getStatus(), is("Pendiente"));
		assertThat(order.getSalesmanId(), is(200L));
		assertThat(order.getOrderDate(), is(fecha));
	}

	@Test
	public void testOrderLongLongStringLong() {
		Order order = new Order(2, 101, "Enviado", 201);

		assertThat(order.getOrderId(), is(2L));
		assertThat(order.getCustomerId(), is(101L));
		assertThat(order.getStatus(), is("Enviado"));
		assertThat(order.getSalesmanId(), is(201L));
	}

	@Test
	public void testGetOrderId() {
		Order order = new Order(3, 102, "Cancelado", 202);
		assertThat(order.getOrderId(), is(3L));
	}

	@Test
	public void testGetCustomerId() {
		Order order = new Order(4, 103, "Completado", 203);
		assertThat(order.getCustomerId(), is(103L));
	}

	@Test
	public void testGetStatus() {
		Order order = new Order(5, 104, "En proceso", 204);
		assertThat(order.getStatus(), is("En proceso"));
	}

	@Test
	public void testGetSalesmanId() {
		Order order = new Order(6, 105, "Entregado", 205);
		assertThat(order.getSalesmanId(), is(205L));
	}

	@Test
	public void testGetOrderDate() {
		Date fecha = new Date();
		Order order = new Order(7, 106, "Aceptado", 206, fecha);
		assertThat(order.getOrderDate(), is(fecha));
	}
}
