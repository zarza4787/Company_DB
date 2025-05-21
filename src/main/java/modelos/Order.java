package modelos;

import java.util.Date;

public class Order {

	private long orderId;
	private long customerId;
	private String status;
	private long salesmanId;
	private Date orderDate;

	public Order(long orderId, long customerId, String status, long salesmanId, Date orderDate) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.status = status;
		this.salesmanId = salesmanId;
		this.orderDate = orderDate;
	}
	
	public Order(long orderId, long customerId, String status, long salesmanId) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.status = status;
		this.salesmanId = salesmanId;
	}

	public long getOrderId() {
		return orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getStatus() {
		return status;
	}

	public long getSalesmanId() {
		return salesmanId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

}
