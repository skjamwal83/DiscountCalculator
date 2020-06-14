package com.shoppingcart.shopping.discount;

import com.shoppingcart.shopping.customer.CustomerType;

/**
 * Discounts available for standard customers.
 * @author sunil
 *
 */
public class NoDiscount extends Discount {

	
	NoDiscount(){
		DiscountFactory.regesterCustomertDiscount(CustomerType.STANDARD, this);
	}

	
	
}
