package org.miage.models;

import org.junit.*;
import org.miage.models.accounts.Customer;
import org.miage.models.accounts.Seller;
import org.miage.models.accounts.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StoreTest {

    private Store store;

    @Before
    public void setUp() throws Exception {
        this.store = new Store();
    }

    @Test
    public void addAccount() {
        this.store.addAccount(new Customer("John", "Doe"));
        assertEquals(1, this.store.getUserList().size());
    }

    @Test
    public void addProduct() {
        Seller seller = new Seller("John", "Doe");
        Product product = new Product("Brioche", 12.0, 3);
        this.store.addProduct(product, seller);
        assertEquals(1, this.store.getProductHashMap().size());
    }

    // TODO Je ne sais pas comment tester ça
    @Test
    public void displayProducts() {
        this.store.displayProducts();
    }

    @Test
    public void connection() {
        User julie = new Customer("JulieMyLove", "CremeChantilly");
        this.store.addAccount(julie);

        assertEquals("Connexion avec compte", julie, this.store.connection("JulieMyLove", "CremeChantilly"));
        assertNull("Connexion avec compte inexistant", this.store.connection("Romain", "Brochet"));
    }
}