package modelos;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testConstructorCustomer() {
		Customer customer = new Customer(1, "Zarza Corp", "Calle Triana 2", "www.zz.com", 5000.0);
		assertEquals(1, customer.getCustomerId());
		assertEquals("Zarza Corp", customer.getName());
		assertEquals("Calle Triana 2", customer.getAddress());
		assertEquals("www.zz.com", customer.getWebsite());
		assertEquals(5000.0, customer.getCreditLimit(), 0.0001);
	}

	@Test
	public void testConstructorCustomerEliminar() {
		Customer customer = new Customer(99);
		assertEquals(99L, customer.getCustomerId());
	}

	@Test
	public void testGetCustomerId() {
		Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
		assertEquals(5, customer.getCustomerId());
	}

	@Test
	public void testGetName() {
		Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
		assertEquals("Epic Games", customer.getName());
	}

	@Test
	public void testGetAddress() {
		Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
		assertEquals("Calle Texas 2", customer.getAddress());
	}

	@Test
	public void testGetWebsite() {
		Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
		assertEquals("www.epicgames.com", customer.getWebsite());
	}

	@Test
	public void testGetCreditLimit() {
		Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
		assertEquals(7500.0, customer.getCreditLimit(), 0.0001);
	}

}
