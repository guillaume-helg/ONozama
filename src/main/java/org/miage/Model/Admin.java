package org.miage.Model;

public class Admin extends Account {
    public Admin(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void supprimerCompte(Account compte) {
        System.out.println("Compte " + compte.getNomUtilisateur() + " supprimé.");
    }

    @Override
    public void afficherMenu() {
        System.out.println("Menu Administrateur : 1. Gérer les comptes, 2. Gérer les produits");
    }
}
