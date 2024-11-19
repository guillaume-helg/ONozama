package org.miage.models;

import org.junit.*;
import org.miage.models.accounts.User;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        this.user = new User("Roche", "Bleu") {
            @Override
            public void displayMenu() {
                System.out.println("salut");
            }
        };
    }

    @Test
    public void getNomUtilisateur() {
        assertEquals("Roche", this.user.getIdUser());
    }

    @Test
    public void getMotDePasse() {
        assertEquals("Bleu", this.user.getPassword());
    }

}