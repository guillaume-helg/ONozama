package org.miage.models;

import org.junit.Before;
import org.miage.models.accounts.Admin;
import org.miage.models.accounts.Customer;

public class AdminTest {

    private Admin admin;

    @Before
    public void setUp() throws Exception {
        this.admin = new Admin("Brochet", "Poisson");
    }

    @org.junit.Test
    public void supprimerCompte() {
        Store store = new Store();
        Customer customer = new Customer("Brochet", "Poisson");
        store.addAccount(customer);

        admin.supprimerCompte(customer); // TODO problème avec la méthode supprimer compte, manque le store dans lequel supprimer
    }

}