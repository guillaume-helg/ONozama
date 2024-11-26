package org.miage.models.accounts;

import org.junit.Before;
import org.junit.Test;
import org.miage.models.Store;

import static org.junit.Assert.*;

public class AdminTest {


    private Admin admin;
    private Customer customer;
    private Store store;

    @Before
    public void setUp() throws Exception {
        this.admin = new Admin("Roche", "Bleu");
        this.customer = new Customer("Jack", "Bauer");
        this.store = new Store();
        this.admin.setStore(this.store);
    }
    @Test
    public void testModifyAccount() {
        this.store.addAccount(this.customer);
        this.admin.modifyAccount(0, "Yop", "Yip");
    }

    @Test
    public void testDeleteAccount() {
    }

    @Test
    public void setStore() {
    }
}