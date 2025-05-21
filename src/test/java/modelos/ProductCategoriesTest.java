package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ProductCategoriesTest {

	@Test
	public void testConstructorProductCategories() {
		ProductCategories category = new ProductCategories(1, "CPU");

		assertThat(category.getCategoryId(), is(1L));
		assertThat(category.getCategoryName(), is("CPU"));
	}

	@Test
	public void testGetCategoryId() {
		ProductCategories category = new ProductCategories(2, "Video Card");
		assertThat(category.getCategoryId(), is(2L));
	}

	@Test
	public void testGetCategoryName() {
		ProductCategories category = new ProductCategories(3, "RAM");
		assertThat(category.getCategoryName(), is("RAM"));
	}
}
