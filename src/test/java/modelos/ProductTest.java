package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ProductTest {

    @Test
    public void testConstructorProduct() {
        Product product = new Product(1, "Teclado", "Teclado mecanico RGB", 25.50, 49.99, 10);

        assertThat(product.getProductId(), is(1L));
        assertThat(product.getProductName(), is("Teclado"));
        assertThat(product.getDescription(), is("Teclado mecanico RGB"));
        assertThat(product.getStandardCost(), closeTo(25.50, 0.001));
        assertThat(product.getListPrice(), closeTo(49.99, 0.001));
        assertThat(product.getCategoryId(), is(10L));
    }

    @Test
    public void testGetProductId() {
        Product product = new Product(2, "Mouse", "Raton Bluetooth", 10.00, 19.99, 11);
        assertThat(product.getProductId(), is(2L));
    }

    @Test
    public void testGetProductName() {
        Product product = new Product(3, "Monitor", "Monitor 24 pulgadas", 120.00, 159.99, 12);
        assertThat(product.getProductName(), is("Monitor"));
    }

    @Test
    public void testGetDescription() {
        Product product = new Product(4, "Silla", "Silla ergonomica", 60.00, 89.99, 13);
        assertThat(product.getDescription(), is("Silla ergonomica"));
    }

    @Test
    public void testGetStandardCost() {
        Product product = new Product(5, "Tablet", "Tablet Android", 150.00, 199.99, 14);
        assertThat(product.getStandardCost(), closeTo(150.00, 0.001));
    }

    @Test
    public void testGetListPrice() {
        Product product = new Product(6, "Laptop", "Portátil 14 pulgadas", 400.00, 549.99, 15);
        assertThat(product.getListPrice(), closeTo(549.99, 0.001));
    }

    @Test
    public void testGetCategoryId() {
        Product product = new Product(7, "Webcam", "Camara HD", 20.00, 29.99, 16);
        assertThat(product.getCategoryId(), is(16L));
    }
}
