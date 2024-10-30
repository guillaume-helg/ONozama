package org.miage.Model;

import java.util.ArrayList;
import java.util.List;

public class Merchant extends Account {
    private List<Product> products;

    public Merchant(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.products = new ArrayList<>();
    }

    public void ajouterProduit(Product produit) {
        products.add(produit);
        System.out.println("Produit ajouté : " + produit.getNom());
    }

    public void afficherProduits() {
        System.out.println("Produits de " + nomUtilisateur + ":");
        for (Product produit : products) {
            System.out.println(produit);
        }
    }

    public void afficherMenu() {
        System.out.println("Menu Marchand : 1. Ajouter un produit, 2. Afficher les produits");
    }
}
