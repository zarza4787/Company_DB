package modelos;

// Esta clase es una combinacion de la tabla de order items, products y products category

public class DetallesPedido {

	private String categoryName, productName;
	private int quantity;
	private double unitPrice;

	public DetallesPedido(String categoryName, String productName, int quantity, double unitPrice) {
		this.categoryName = categoryName;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
