package modelos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductTest {

	@Test
	public void testConstructorProduct() {
		Product product = new Product(1, "Teclado", "Teclado mecánico RGB", 25.50, 49.99, 10);

		assertEquals(1, product.getProductId());
		assertEquals("Teclado", product.getProductName());
		assertEquals("Teclado mecánico RGB", product.getDescription());
		assertEquals(25.50, product.getStandardCost(), 0.001);
		assertEquals(49.99, product.getListPrice(), 0.001);
		assertEquals(10L, product.getCategoryId());
	}

	@Test
	public void testGetProductId() {
		Product product = new Product(2, "Mouse", "Raton Bluetooth", 10.00, 19.99, 11);
		assertEquals(2L, product.getProductId());
	}

	@Test
	public void testGetProductName() {
		Product product = new Product(3, "Monitor", "Monitor 24 pulgadas", 120.00, 159.99, 12);
		assertEquals("Monitor", product.getProductName());
	}

	@Test
	public void testGetDescription() {
		Product product = new Product(4, "Silla", "Silla ergonomica", 60.00, 89.99, 13);
		assertEquals("Silla ergonomica", product.getDescription());
	}

	@Test
	public void testGetStandardCost() {
		Product product = new Product(5, "Tablet", "Tablet Android", 150.00, 199.99, 14);
		assertEquals(150.00, product.getStandardCost(), 0.001);
	}

	@Test
	public void testGetListPrice() {
		Product product = new Product(6, "Laptop", "Portátil 14 pulgadas", 400.00, 549.99, 15);
		assertEquals(549.99, product.getListPrice(), 0.001);
	}

	@Test
	public void testGetCategoryId() {
		Product product = new Product(7, "Webcam", "Camara HD", 20.00, 29.99, 16);
		assertEquals(16, product.getCategoryId());
	}
}
