package com.shoppingcart.shopping.discount.rules;

/**
 * Various type of discounts ranges.
 * @author sunil
 *
 */
public class DiscountRule {
	
	private double startRange = 0.0;
	
	private double endRange = 0.0;
	
	private double discount = 0;
	
	
	public DiscountRule(double startRange, double endRange, double discount){
		this.startRange = startRange;
		this.endRange = endRange;
		this.discount = discount;
		
	}
	
	public double applyRule(double endPrice){
		double priceAmount = endPrice - startRange;
		return  (double)(priceAmount*(discount/100.0f));
	}

	public double getStartRange() {
		return startRange;
	}

	public void setStartRange(double startRange) {
		this.startRange = startRange;
	}

	public double getEndRange() {
		return endRange;
	}

	public void setEndRange(double endRange) {
		this.endRange = endRange;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	

}
