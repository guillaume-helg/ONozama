package org.miage.models;

import org.junit.Before;
import org.miage.models.accounts.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        this.customer = new Customer("Brochet", "Poisson");
    }

    @org.junit.Test
    public void order() {
        Product product = new Product("Fleurs", 12.1, 2);
        this.customer.order(product, 2);
        assertEquals(1, this.customer.getOrderList().size());
        assertEquals(0, product.getStock());
    }

}