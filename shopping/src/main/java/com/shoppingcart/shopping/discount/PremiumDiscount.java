package com.shoppingcart.shopping.discount;

import com.shoppingcart.shopping.customer.CustomerType;

/**
 * Discounts available for Premium customers.
 * @author sunil
 *
 */
public class PremiumDiscount extends Discount {
 
	
	public PremiumDiscount(){
		DiscountFactory.regesterCustomertDiscount(CustomerType.PREMIUM, this);
	}

	
}
