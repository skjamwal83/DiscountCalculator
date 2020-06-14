package com.shoppingcart.shopping.discount;

import java.util.HashMap;

import com.shoppingcart.shopping.customer.CustomerType;

/**
 * A factory contain the linking between the customer type and the discounts available.
 * @author sunil
 *
 */
public class DiscountFactory {
	
	private static HashMap<CustomerType, Discount> customerTypeDiscount = new HashMap<CustomerType, Discount>();
	
	
	public static boolean regesterCustomertDiscount(CustomerType customerType, Discount discount){
		if(customerTypeDiscount.put(customerType, discount) != null){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static Discount getDiscountByCustomerType(CustomerType customerType) {
		return customerTypeDiscount.get(customerType);
	}

	public static Discount getDiscountForRegularCustomer() {
		return customerTypeDiscount.get(CustomerType.REGULAR);
	}

	public static Discount getDiscountForPremiumCustomer() {
		return customerTypeDiscount.get(CustomerType.PREMIUM);
	}

}
