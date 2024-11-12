package org.miage.Model;


public class Seller extends User {

    public Seller(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void addProduct(Store store, Product produit) {
        store.addProduct(produit, this);
    }

    public void deleteProduct(Store store, Product produit) {
        store.deleteProduct(produit, this);
    }

    public void afficherMenu() {
        System.out.println("Menu Marchand : 1. Ajouter un produit, 2. Afficher les produits");
    }
}
