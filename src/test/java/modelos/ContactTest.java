package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testConstructorContacto() {
        Contact contact = new Contact(1L, "Alvaro", "Zarza", "alvaro@example.com", "123456789", 10L);
        assertThat(contact.getContactId(), is(1L));
        assertThat(contact.getFirstName(), is("Alvaro"));
        assertThat(contact.getLastName(), is("Zarza"));
        assertThat(contact.getEmail(), is("alvaro@example.com"));
        assertThat(contact.getPhone(), is("123456789"));
        assertThat(contact.getCustomerId(), is(10L));
    }

    @Test
    public void testConstructorContactoInsertar() {
        Contact contact = new Contact("Antonio", "Lopez", "antonio@example.com", "816489652", 20L);
        assertThat(contact.getFirstName(), is("Antonio"));
        assertThat(contact.getLastName(), is("Lopez"));
        assertThat(contact.getEmail(), is("antonio@example.com"));
        assertThat(contact.getPhone(), is("816489652"));
        assertThat(contact.getCustomerId(), is(20L));
    }

    @Test
    public void testConstructorContactoActualizar() {
        Contact contact = new Contact("Alejandro", "Gomez", "alejandro@example.com", "3654784");
        assertThat(contact.getFirstName(), is("Alejandro"));
        assertThat(contact.getLastName(), is("Gomez"));
        assertThat(contact.getEmail(), is("alejandro@example.com"));
        assertThat(contact.getPhone(), is("3654784"));
    }

    @Test
    public void testConstructorContactoEliminar() {
        Contact contact = new Contact(5L);
        assertThat(contact.getContactId(), is(5L));
        assertThat(contact.getFirstName(), is(nullValue()));
        assertThat(contact.getLastName(), is(nullValue()));
        assertThat(contact.getEmail(), is(nullValue()));
        assertThat(contact.getPhone(), is(nullValue()));
    }

    @Test
    public void testGetContactId() {
        Contact contact = new Contact(99L);
        assertThat(contact.getContactId(), is(99L));
    }

    @Test
    public void testGetFirstName() {
        Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
        assertThat(contact.getFirstName(), is("Martin"));
    }

    @Test
    public void testGetLastName() {
        Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
        assertThat(contact.getLastName(), is("Diaz"));
    }

    @Test
    public void testGetEmail() {
        Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
        assertThat(contact.getEmail(), is("martin@example.com"));
    }

    @Test
    public void testGetPhone() {
        Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55);
        assertThat(contact.getPhone(), is("123123123"));
    }

    @Test
    public void testGetCustomerId() {
        Contact contact = new Contact("Martin", "Diaz", "martin@example.com", "123123123", 55L);
        assertThat(contact.getCustomerId(), is(55L));
    }
}
