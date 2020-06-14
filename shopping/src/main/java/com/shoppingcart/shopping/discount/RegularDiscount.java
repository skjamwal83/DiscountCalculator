package com.shoppingcart.shopping.discount;

import com.shoppingcart.shopping.customer.CustomerType;

/**
 * Discounts available for regular customers.
 * @author sunil
 *
 */
public class RegularDiscount extends Discount {


	public RegularDiscount(){
		DiscountFactory.regesterCustomertDiscount(CustomerType.REGULAR, this);
	}

	
}
