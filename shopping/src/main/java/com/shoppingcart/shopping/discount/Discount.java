package com.shoppingcart.shopping.discount;

import java.util.LinkedList;
import java.util.List;

import com.shoppingcart.shopping.discount.rules.DiscountRule;

/**
 * Type of discounts available depending upon the customer.
 * @author sunil
 *
 */
public abstract class Discount {
	
	List<DiscountRule> rules = new LinkedList<>();
	
	public void addRules(DiscountRule discountRule){
		rules.add(discountRule); 
	}

	double getDiscount(double totalPrice){ 
		double discount = 0.0;
		for (DiscountRule rule: rules) {
				
			if(rule.getDiscount() > 0) {
				double endRange = rule.getEndRange();
				if(totalPrice <= endRange){
					endRange = totalPrice;
				}
				discount += rule.applyRule(endRange);
			}
			 if(totalPrice <= rule.getEndRange()) {
				 return discount;
			 }
			
		}
		return discount;
	}

	
}
