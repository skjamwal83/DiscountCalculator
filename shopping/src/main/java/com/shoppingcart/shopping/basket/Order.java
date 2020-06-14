package com.shoppingcart.shopping.basket;

import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.shopping.customer.Customer;
import com.shoppingcart.shopping.product.ProductType;

/**
 * it contain the information regarding the customer and the item purchased.
 * @author sunil
 *
 */
public class Order {
	private final Customer customer;
	private List<Item> items = new ArrayList<>();

	public Order(Customer customer) {
		this.customer = customer;

	}

	void add(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void addItems(Item item) {
		this.items.add(item);
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Double total() {
		Double total = 0.0;
		for (Item item : items) {
			total += item.totalPrice().doubleValue();
		}
		return total;
	}

	public boolean contains(ProductType productType) {
		for (Item item : items) {
			if (item.productType() == productType) {
				return true;
			}
		}
		return false;
	}

	

	@Override
	public String toString() {
		return "ShoppingBasket{" + "customer=" + customer + ", items=" + items + '}';
	}
}
