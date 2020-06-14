package com.shoppingcart.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import com.shoppingcart.shopping.basket.Item;
import com.shoppingcart.shopping.basket.Order;
import com.shoppingcart.shopping.customer.Customer;
import com.shoppingcart.shopping.customer.CustomerBuilder;
import com.shoppingcart.shopping.discount.DiscountCalculator;
import com.shoppingcart.shopping.discount.PremiumDiscount;
import com.shoppingcart.shopping.discount.RegularDiscount;
import com.shoppingcart.shopping.discount.rules.DiscountRule;
import com.shoppingcart.shopping.product.ProductBuilder;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class ShoppingApplicationTests {

	RegularDiscount regularDiscount;

	PremiumDiscount premiumDiscount;

	DiscountCalculator discountCalculator;

	@BeforeAll
	public void initialise() {
		setRegularDiscount();
		setPremiumDiscount();
		discountCalculator = new DiscountCalculator();
	}

	public void setRegularDiscount() {
		regularDiscount = new RegularDiscount();
		regularDiscount.addRules(new DiscountRule(0, 5000, 0));
		regularDiscount.addRules(new DiscountRule(5000, 10000, 10));
		regularDiscount.addRules(new DiscountRule(10000, Double.MAX_VALUE, 20));
	}

	public void setPremiumDiscount() {
		premiumDiscount = new PremiumDiscount();
		premiumDiscount.addRules(new DiscountRule(0, 4000, 10));
		premiumDiscount.addRules(new DiscountRule(4000, 8000, 15));
		premiumDiscount.addRules(new DiscountRule(8000, 12000, 20));
		premiumDiscount.addRules(new DiscountRule(12000, Double.MAX_VALUE, 30));
	}

	public Customer createRegularCustomer() {
		return CustomerBuilder.regular().Name("Sunil").withId(new BigInteger("1")).build();
	}

	public Customer createPremiurCustomer() {
		return CustomerBuilder.premium().Name("Sunil").withId(new BigInteger("2")).build();
	}

	public Item createItem(int amount, int quantity) {
		return new Item(ProductBuilder.cloths().costing(new BigDecimal(amount)).build(), quantity);
	}

	public Order createOrder(int amount, int quantity, Customer customer) {
		Order order = new Order(customer);
		order.addItems(createItem(amount, quantity));
		return order;
	}

	@Test
	void testDiscountForRegularCustomer() {
		Customer customer = createRegularCustomer();

		Order order = createOrder(1000, 5, customer);
		assertEquals(order.total(), 5000.0);
		assertEquals(5000.0, discountCalculator.getBillAmount(order));

		order = createOrder(1000, 10, customer);
		assertEquals(order.total(), 10000.0);
		assertEquals(9500.0, discountCalculator.getBillAmount(order));

		order = createOrder(1000, 15, customer);
		assertEquals(order.total(), 15000.0);
		assertEquals(13500.0, discountCalculator.getBillAmount(order));

	}

	@Test
	void testDiscountForPremiumCustomer() {
		Customer customer = createPremiurCustomer();

		Order order = createOrder(1000, 4, customer);
		assertEquals(order.total(), 4000.0);
		assertEquals(3600.0, discountCalculator.getBillAmount(order));

		order = createOrder(1000, 8, customer);
		assertEquals(order.total(), 8000.0);
		assertEquals(7000.0, discountCalculator.getBillAmount(order));

		order = createOrder(1000, 12, customer);
		assertEquals(order.total(), 12000.0);
		assertEquals(10200.0, discountCalculator.getBillAmount(order));

		order = createOrder(1000, 20, customer);
		assertEquals(order.total(), 20000.0);
		assertEquals(15800.0, discountCalculator.getBillAmount(order));

	}

}
