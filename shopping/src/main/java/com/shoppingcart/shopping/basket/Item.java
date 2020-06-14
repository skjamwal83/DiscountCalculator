package com.shoppingcart.shopping.basket;

import java.math.BigDecimal;

import com.shoppingcart.shopping.product.Product;
import com.shoppingcart.shopping.product.ProductType;

/**
 * item has the information for product and the quantity of the product purchased;
 * @author sunil
 *
 */
public class Item {
	private final int quantity;
	private final Product product;

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public BigDecimal totalPrice() {
		return BigDecimal.valueOf(quantity * product.unitPrice().doubleValue());
	}

	public ProductType productType() {
		return this.product.productType();
	}

	public int quantity() {
		return quantity;
	}

	
	@Override
	public String toString() {
		return "ShoppingBasketItem{" + "product=" + product + ", quantity="
				+ quantity + '}';
	}
}
