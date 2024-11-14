package org.miage.models;

import org.junit.*;
import org.miage.models.accounts.Customer;
import org.miage.models.accounts.User;

import static org.junit.Assert.assertEquals;

public class StoreTest {

    private Store store;

    @Before
    public void setUp() throws Exception {
        this.store = new Store();
    }

    @Test
    public void addAccount() {
    }

    @Test
    public void addProduct() {
    }

    @Test
    public void displayProducts() {
    }

    @Test
    public void connection() {
        User julie = new Customer("JulieMyLove", "CremeChantilly");
        this.store.addAccount(julie);

        assertEquals(julie, this.store.connection("JulieMyLove", "CremeChantilly"));
    }
}