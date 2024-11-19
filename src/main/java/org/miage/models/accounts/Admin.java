package org.miage.models.accounts;

import org.miage.models.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends User {

    private Store store;

    public Admin(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        store = new Store();
    }

    public Admin(String nomUtilisateur, String motDePasse, Store store) {
        super(nomUtilisateur, motDePasse);
        this.store = store;
    }

    public void deleteAccount(User compte) {
        this.store.deleteAccount(compte);
        System.out.println("Compte " + compte.getIdUser() + " supprimé.");
    }

    public void modifyAccount(int index, String name, String password) {
            store.getUserList().get(index).setIdUser(name);
            store.getUserList().get(index).setPassword(password);
    }

    @Override
    public void displayMenu() {
        System.out.println("Menu Administrateur : \n1.Supprimer un compte\n2.Modifier un compte\n");
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
