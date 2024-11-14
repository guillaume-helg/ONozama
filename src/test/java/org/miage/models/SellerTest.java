package org.miage.models;

import org.junit.Before;
import org.miage.models.accounts.Seller;

import static org.junit.Assert.assertEquals;

public class SellerTest {

    private Seller seller;

    @Before
    public void setUp() throws Exception {
        this.seller = new Seller("Yanis", "Degheb");
    }

    @org.junit.Test
    public void ajouterProduit() {
        Store store = new Store();
        Product product = new Product("Fleurs", 12.1, 2);
        this.seller.addProduct(store, product);

        assertEquals(1, store.getProductHashMap().size());
    }

}