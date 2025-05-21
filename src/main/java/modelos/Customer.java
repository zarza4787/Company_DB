package modelos;

public class Customer {

	private long customerId;
	private String name, address, website;
	private double creditLimit;

	public Customer(long customerId, String name, String address, String website, double creditLimit) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.website = website;
		this.creditLimit = creditLimit;
	}

	// Constructor para eliminar customer
	public Customer(long customerId) {
		this.customerId = customerId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getWebsite() {
		return website;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

}
