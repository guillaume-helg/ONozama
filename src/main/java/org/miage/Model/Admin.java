package org.miage.Model;

public class Admin extends User {
    public Admin(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void supprimerCompte(User compte) {
        System.out.println("Compte " + compte.getIdUser() + " supprimé.");
    }

    public void modifyAccount(User compteAModifier, User compteModifie) {

    }

    @Override
    public void afficherMenu() {
        System.out.println("Menu Administrateur : 1. Gérer les comptes, 2. Gérer les produits");
    }
}
