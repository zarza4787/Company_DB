package modelos;

public class ProductCategories {

	private long categoryId;
	private String categoryName;

	public ProductCategories(long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

}
