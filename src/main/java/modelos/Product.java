package modelos;

public class Product {

	private long productId;
	private String productName;
	private String description;
	private double standardCost;
	private double listPrice;
	private long categoryId;

	public Product(long productId, String productName, String description, double standardCost, double listPrice,
			long categoryId) {

		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.standardCost = standardCost;
		this.listPrice = listPrice;
		this.categoryId = categoryId;
	}

	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getDescription() {
		return description;
	}

	public double getStandardCost() {
		return standardCost;
	}

	public double getListPrice() {
		return listPrice;
	}

	public long getCategoryId() {
		return categoryId;
	}

}
