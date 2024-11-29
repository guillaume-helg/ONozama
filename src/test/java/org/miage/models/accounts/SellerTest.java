package org.miage.models.accounts;

import org.junit.Before;
import org.junit.Test;
import org.miage.models.Product;
import org.miage.models.Store;

import static org.junit.Assert.*;

public class SellerTest {
    private Seller seller;
    private Store store;

    @Before
    public void setUp() throws Exception {
        this.seller = new Seller("Yanis", "Degheb");
        this.store = new Store();
    }

    @Test
    public void addProduct() {
        Product p1 = new Product("Lapin", 12.0, 3);
        this.seller.addProduct(this.store, p1);
        assertEquals(1, this.store.getProductHashMap().size());
    }

    @Test
    public void deleteProduct() {
        Product p1 = new Product("Lapin", 12.0, 3);
        assertEquals(0, this.store.getProductHashMap().size());
        this.seller.addProduct(this.store, p1);
        assertEquals(1, this.store.getProductHashMap().size());
        this.seller.deleteProduct(this.store, p1);
        assertEquals(0, this.store.getProductHashMap().size());
    }
}