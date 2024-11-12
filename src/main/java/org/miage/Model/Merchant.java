package org.miage.Model;


public class Merchant extends Account {

    public Merchant(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void addProduct(Store store, Product produit) {
        store.ajouterProduit(produit);
    }

    public void removeProduct(Store store, Product produit) {
        store.supprimerProduit(produit);
    }

    public void afficherMenu() {
        System.out.println("Menu Marchand : 1. Ajouter un produit, 2. Afficher les produits");
    }
}
