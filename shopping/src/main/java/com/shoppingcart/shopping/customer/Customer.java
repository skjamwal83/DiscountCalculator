package com.shoppingcart.shopping.customer;

import java.math.BigInteger;

/**
 * it contain the information about the customer.
 * @author sunil
 *
 */
public class Customer {

	private BigInteger customerId;

	private String name;

	private CustomerType customerType;

	public Customer(BigInteger customerId, String name, CustomerType customerType) {
		this.customerId = customerId;
		this.name = name;
		this.customerType = customerType;
	}

	public BigInteger getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	
	@Override
	public String toString() {
		return "custome{" + "customerId='" + customerId + '\'' + 
				"name='" + name	+ '\''+
				"customerType='" + customerType	+ '\'' + '}';
	}
}
