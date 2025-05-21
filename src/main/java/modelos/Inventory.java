package modelos;

public class Inventory {

	private long productId;
	private long warehouseId;
	private int quantity;

	public Inventory(long productId, long warehouseId, int quantity) {
		this.productId = productId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public long getWarehouseId() {
		return warehouseId;
	}

	public int getQuantity() {
		return quantity;
	}

}
