package modelos;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testConstructorOrder() {
		Date fecha = new Date();
		Order order = new Order(1, 100, "Pendiente", 200, fecha);

		assertEquals(1, order.getOrderId());
		assertEquals(100, order.getCustomerId());
		assertEquals("Pendiente", order.getStatus());
		assertEquals(200, order.getSalesmanId());
		assertEquals(fecha, order.getOrderDate());
	}

	@Test
	public void testOrderLongLongStringLong() {
		Order order = new Order(2, 101, "Enviado", 201);

		assertEquals(2, order.getOrderId());
		assertEquals(101, order.getCustomerId());
		assertEquals("Enviado", order.getStatus());
		assertEquals(201, order.getSalesmanId());
	}

	@Test
	public void testGetOrderId() {
		Order order = new Order(3, 102, "Cancelado", 202);
		assertEquals(3, order.getOrderId());
	}

	@Test
	public void testGetCustomerId() {
		Order order = new Order(4, 103, "Completado", 203);
		assertEquals(103, order.getCustomerId());
	}

	@Test
	public void testGetStatus() {
		Order order = new Order(5, 104, "En proceso", 204);
		assertEquals("En proceso", order.getStatus());
	}

	@Test
	public void testGetSalesmanId() {
		Order order = new Order(6, 105, "Entregado", 205);
		assertEquals(205, order.getSalesmanId());
	}

	@Test
	public void testGetOrderDate() {
		Date fecha = new Date();
		Order order = new Order(7, 106, "Aceptado", 206, fecha);
		assertEquals(fecha, order.getOrderDate());
	}
}
