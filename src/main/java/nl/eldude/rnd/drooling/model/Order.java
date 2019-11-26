package nl.eldude.rnd.drooling.model;

import org.apache.commons.collections4.list.TreeList;

import java.util.List;

public class Order {

    private Customer customer;
    private String orderNumber;
    private List<LineItem> lineItems = new TreeList<>();
    private float total;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItem(final LineItem lineItem)
    {
        lineItems.add(lineItem);
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
