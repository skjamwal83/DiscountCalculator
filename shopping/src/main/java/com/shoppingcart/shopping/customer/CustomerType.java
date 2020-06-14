package com.shoppingcart.shopping.customer;

/**
 * type of customers available.
 * 
 * @author sunil
 *
 */
public enum CustomerType {
	REGULAR("Regular"), PREMIUM("Premium"), STANDARD("Standard");
    //standard is added for new customer type.
	private final String customerType;

	CustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerType() {
		return this.customerType;
	}

}
