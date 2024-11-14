package org.miage.Model;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store;

    public void setUp() throws Exception {
        this.store = new Store();
    }

    @org.junit.Test
    public void addAccount() {
    }

    @org.junit.Test
    public void addProduct() {
    }

    @org.junit.Test
    public void displayProducts() {
    }

    @org.junit.Test
    public void connection() {
        User julie = new Customer("JulieMyLove", "CremeChantilly");
        this.store.addAccount(julie);

        assertEquals(julie, this.store.connexion("JulieMyLove", "CremeChantilly"));
    }
}