package org.miage.models.accounts;

import org.junit.Before;
import org.junit.Test;
import org.miage.models.Product;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        this.customer = new Customer("Brochet", "Poisson");
    }

    @Test
    public void getCart() {
        Product p1 = new Product("Lapin", 12.3, 3);
        this.customer.addToCart(p1, 3);
        assertEquals(1, customer.getCart().size());
    }

    @Test
    public void addToCart() {
        Product p1 = new Product("Lapin", 12.3, 3);
        this.customer.addToCart(p1, 3);
        assertEquals(1, customer.getCart().size());
    }

    @Test
    public void removeFromCart() {
        Product p1 = new Product("Lapin", 12.3, 3);
        this.customer.removeFromCart(p1, 3);
        assertEquals(0, customer.getCart().size());
    }
}