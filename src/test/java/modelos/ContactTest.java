package modelos;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {

	@Test
	public void testConstructorContacto() {
		Contact contact = new Contact(1, "Alvaro", "Zarza", "alvaro@example.com", "123456789", 10);
		assertEquals(1, contact.getContactId());
		assertEquals("Alvaro", contact.getFirstName());
		assertEquals("Zarza", contact.getLastName());
		assertEquals("alvaro@example.com", contact.getEmail());
		assertEquals("123456789", contact.getPhone());
		assertEquals(10, contact.getCustomerId());
	}

	@Test
	public void testConstructorContactoInsertar() {
		Contact contact = new Contact("Antonio", "Lopez", "antonio@example.com", "816489652", 20);
		assertEquals("Antonio", contact.getFirstName());
		assertEquals("Lopez", contact.getLastName());
		assertEquals("antonio@example.com", contact.getEmail());
		assertEquals("816489652", contact.getPhone());
		assertEquals(20, contact.getCustomerId());
	}

	@Test
	public void testConstructorContactoActualizar() {
		Contact contact = new Contact("Alejandro", "Gomez", "alejandro@example.com", "3654784");
		assertEquals("Alejandro", contact.getFirstName());
		assertEquals("Gomez", contact.getLastName());
		assertEquals("alejandro@example.com", contact.getEmail());
		assertEquals("3654784", contact.getPhone());
		assertEquals(0, contact.getContactId());
		assertEquals(0, contact.getCustomerId());
	}

	@Test
	public void TestConstructorContactoEliminar() {
		Contact contact = new Contact(5);
		assertEquals(5, contact.getContactId());
		assertNull(contact.getFirstName());
		assertNull(contact.getLastName());
		assertNull(contact.getEmail());
		assertNull(contact.getPhone());
		assertEquals(0, contact.getCustomerId());
	}

	@Test
	public void testGetContactId() {
		Contact contact = new Contact(99);
		assertEquals(99, contact.getContactId());
	}

	@Test
	public void testGetFirstName() {
		Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
		assertEquals("Martin", contact.getFirstName());
	}

	@Test
	public void testGetLastName() {
		Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
		assertEquals("Diaz", contact.getLastName());
	}

	@Test
	public void testGetEmail() {
		Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
		assertEquals("martin@example.com", contact.getEmail());
	}

	@Test
	public void testGetPhone() {
		Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
		assertEquals("123123123", contact.getPhone());
	}

	@Test
	public void testGetCustomerId() {
		Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
		assertEquals(55, contact.getCustomerId());
	}
}
