package com.shoppingcart.shopping.discount;

import com.shoppingcart.shopping.basket.Order;
import com.shoppingcart.shopping.customer.CustomerType;

/**
 * it is used to calculate the discount.
 * @author sunil
 *
 */
public class DiscountCalculator {

	public double getDiscount(Order basket) {
		double discountedAmount = 0.0;
		if (basket != null) {
			CustomerType customerType = basket.getCustomer().getCustomerType();
			Discount discount = DiscountFactory
					.getDiscountByCustomerType(customerType);
			if (discount != null) {
				discountedAmount = discount.getDiscount(basket.total()); 
			}
		}
		return discountedAmount;
	}

	public double getBillAmount(Order basket) {
		double totalAmountAfterDiscount = 0.0;
		if (basket != null) {
			double totalAmount = basket.total();
			Double discountedAmount = getDiscount(basket);
			totalAmountAfterDiscount = totalAmount - discountedAmount;
		}
		return totalAmountAfterDiscount;

	}

}
