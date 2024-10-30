package org.miage.Model;

public class Product {
    private String nom;
    private double prix;
    private int stock;

    public Product(String nom, double prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Produit: " + nom + ", Prix: " + prix + ", Stock: " + stock;
    }
}
