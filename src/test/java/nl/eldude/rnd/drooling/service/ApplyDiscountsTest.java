package nl.eldude.rnd.drooling.service;

import nl.eldude.rnd.drooling.data.CustomerType;
import nl.eldude.rnd.drooling.model.Customer;
import nl.eldude.rnd.drooling.model.Item;
import nl.eldude.rnd.drooling.model.LineItem;
import nl.eldude.rnd.drooling.model.Order;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * (C) Copyright 2019 Hewlett Packard Enterprise Development LP
 *
 * @author Gabriel Inäbnit - 2019-11-26
 */
public class ApplyDiscountsTest
{

	private final ApplyDiscountsService applyDiscountsService = new ApplyDiscountsService();
	private Order order;

	@Before
	public void setUp()
	{
		// the customer
		Customer customer = new Customer();
		customer.setFirstName("el");
		customer.setLastName("Dude");
		// the item
		Item item = new Item();
		item.setSku("SKU01");
		item.setDescription("Item SKU");
		item.setPrice(7.5f);
		// the line item
		LineItem lineItem = new LineItem();
		lineItem.setItem(item);
		lineItem.setQuantity(5);
		// the order
		order = new Order();
		order.setCustomer(customer);
		order.addLineItem(lineItem);
	}

	@Test
	public void when_customer_is_club_apply_ten_percent_discount()
	{
		order.getCustomer().setCustomerType(CustomerType.CLUB);
		order = applyDiscountsService.applyDiscounts(order);
		assertEquals("10", order.getLineItems().get(0).getDiscount());
	}


}
