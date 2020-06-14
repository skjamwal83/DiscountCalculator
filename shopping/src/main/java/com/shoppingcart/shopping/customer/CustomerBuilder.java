package com.shoppingcart.shopping.customer;

import java.math.BigInteger;

/**
 * Customer builder is used to build the customer.
 * @author sunil
 *
 */
public class CustomerBuilder {
	
	private CustomerType customerType = CustomerType.PREMIUM;
	private BigInteger id;
    private String name;

	private CustomerBuilder(CustomerType customerType) {
		this.customerType = customerType;
	}

	public static CustomerBuilder regular() {
        return new CustomerBuilder(CustomerType.REGULAR);
    }

	public static CustomerBuilder premium() {
		return new CustomerBuilder(CustomerType.PREMIUM);
	}

    public CustomerBuilder withId(BigInteger value) {
        this.id = value;
        return this;
    }

    public CustomerBuilder Name(String name) {
        this.name = name;
	    return this;
    }

	
	public Customer build() {
		return new Customer(id, name,customerType);
	}

}
