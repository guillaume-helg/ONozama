package org.miage.models.accounts;

import org.miage.models.Store;

public class Admin extends User {
    public Admin(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void deleteAccount(Store store, User compte) {
        store.deleteAccount(compte);
        System.out.println("Compte " + compte.getIdUser() + " supprimé.");
    }

    public void modifyAccount(User compteAModifier, User compteModifie) {

    }

    @Override
    public void displayMenu() {
        System.out.println("Menu Administrateur : 1. Gérer les comptes, 2. Gérer les produits");
    }
}
