package org.miage.Model;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Account> comptes;
    private List<Product> produits;

    public Store() {
        this.comptes = new ArrayList<>();
        this.produits = new ArrayList<>();
    }

    public void ajouterCompte(Account compte) {
        comptes.add(compte);
        System.out.println("Compte ajouté : " + compte.getNomUtilisateur());
    }

    public void ajouterProduit(Product produit) {
        produits.add(produit);
        System.out.println("Produit ajouté au magasin : " + produit.getNom());
    }

    public void afficherProduits() {
        System.out.println("Produits disponibles dans le magasin :");
        for (Product produit : produits) {
            System.out.println(produit);
        }
    }
}
