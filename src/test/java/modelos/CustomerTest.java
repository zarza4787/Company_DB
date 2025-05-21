package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testConstructorCustomer() {
        Customer customer = new Customer(1L, "Zarza Corp", "Calle Triana 2", "www.zz.com", 5000.0);
        assertThat(customer.getCustomerId(), is(1L));
        assertThat(customer.getName(), is("Zarza Corp"));
        assertThat(customer.getAddress(), is("Calle Triana 2"));
        assertThat(customer.getWebsite(), is("www.zz.com"));
        assertThat(customer.getCreditLimit(), closeTo(5000.0, 0.0001));
    }

    @Test
    public void testConstructorCustomerEliminar() {
        Customer customer = new Customer(99);
        assertThat(customer.getCustomerId(), is(99L));
    }

    @Test
    public void testGetCustomerId() {
        Customer customer = new Customer(5L, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
        assertThat(customer.getCustomerId(), is(5L));
    }

    @Test
    public void testGetName() {
        Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
        assertThat(customer.getName(), is("Epic Games"));
    }

    @Test
    public void testGetAddress() {
        Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
        assertThat(customer.getAddress(), is("Calle Texas 2"));
    }

    @Test
    public void testGetWebsite() {
        Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
        assertThat(customer.getWebsite(), is("www.epicgames.com"));
    }

    @Test
    public void testGetCreditLimit() {
        Customer customer = new Customer(5, "Epic Games", "Calle Texas 2", "www.epicgames.com", 7500.0);
        assertThat(customer.getCreditLimit(), closeTo(7500.0, 0.0001));
    }
}
