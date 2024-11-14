package org.miage.models;

import org.junit.Before;
import org.miage.models.accounts.Seller;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() throws Exception {
        this.product = new Product("Brochet", 12.0, 34);
    }

    @org.junit.Test
    public void getNom() {
        assertEquals("Brochet", this.product.getName());
    }

    @org.junit.Test
    public void getPrix() {
        assertEquals(12.0, this.product.getPrice(), 0.01);

    }

    @org.junit.Test
    public void getStock() {
        assertEquals(34, this.product.getStock(), 0.01);
    }

    @org.junit.Test
    public void testToString() {
    }
}