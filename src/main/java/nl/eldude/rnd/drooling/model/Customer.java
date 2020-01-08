package nl.eldude.rnd.drooling.model;

import nl.eldude.rnd.drooling.data.CustomerType;

public class Customer {

    private String firstName;
    private String lastName;
    private CustomerType customerType;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public CustomerType getCustomerType()
    {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType)
    {
        this.customerType = customerType;
    }
}
