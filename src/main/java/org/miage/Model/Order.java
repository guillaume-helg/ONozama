package org.miage.Model;

public class Order {
    private Product produit;
    private int quantite;

    public Order(Product produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Commande : " + produit.getNom() + ", Quantité : " + quantite;
    }
}
