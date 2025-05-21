package modelos;

import java.math.BigDecimal;

public class OrderItems {

	private long orderId;
	private long itemId;
	private long productId;
	private double quantity;
	private BigDecimal unitPrice;

	public OrderItems(long orderId, long itemId, long productId, double quantity, BigDecimal unitPrice) {

		this.orderId = orderId;
		this.itemId = itemId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public long getOrderId() {
		return orderId;
	}

	public long getItemId() {
		return itemId;
	}

	public long getProductId() {
		return productId;
	}

	public double getQuantity() {
		return quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

}
