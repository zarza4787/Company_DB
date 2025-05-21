package modelos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductCategoriesTest {

	@Test
	public void testConstructorProductCategories() {
		ProductCategories category = new ProductCategories(1, "CPU");
		assertNotNull(category);
		assertEquals(1, category.getCategoryId());
		assertEquals("CPU", category.getCategoryName());
	}

	@Test
	public void testGetCategoryId() {
		ProductCategories category = new ProductCategories(2, "Video Card");
		assertEquals(2, category.getCategoryId());
	}

	@Test
	public void testGetCategoryName() {
		ProductCategories category = new ProductCategories(3, "RAM");
		assertEquals("RAM", category.getCategoryName());
	}
}
