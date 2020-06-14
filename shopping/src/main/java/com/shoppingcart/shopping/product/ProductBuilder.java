package com.shoppingcart.shopping.product;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Builder used to create the product.
 * @author sunil
 *
 */
public class ProductBuilder {

	private ProductType productType = ProductType.CLOTHS;
	private BigInteger productID = new BigInteger("1234"); 
	private BigDecimal price = BigDecimal.TEN;
	

	private ProductBuilder(ProductType productType) {
		this.productType = productType;
	}

	public static ProductBuilder cloths() {
        return new ProductBuilder(ProductType.CLOTHS);
    }

	public static ProductBuilder video() {
		return new ProductBuilder(ProductType.VIDEO);
	}

    public ProductBuilder withId(BigInteger value) {
        this.productID = value;
        return this;
    }

    public ProductBuilder costing(BigDecimal price) {
        this.price = price;
	    return this;
    }

	

	public Product build() {
		return new Product(productID, productType, price);
	}
}
