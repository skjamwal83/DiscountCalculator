package com.shoppingcart.shopping.product;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Contain the information about the product.
 * 
 * @author sunil
 *
 */
public class Product {

	private final BigInteger productID;
	private ProductType productType;
	private final BigDecimal unitPrice;

	public Product(BigInteger productID, ProductType productType, BigDecimal unitPrice) {
		this.productID = productID;
		this.productType = productType;
		this.unitPrice = unitPrice;

	}

	public BigInteger id() {
		return this.productID;
	}

	public BigDecimal unitPrice() {
		return unitPrice;
	}

	public ProductType productType() {
		return productType;
	}

	@Override
	public String toString() {
		return "Product{" + "productID=" + productID + ", productType=" + productType + ", unitPrice=" + unitPrice
				+ '}';
	}
}
