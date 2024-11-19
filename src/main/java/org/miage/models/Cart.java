package org.miage.models;

public class Cart {
    private Product product;
    private int quantity;

    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Commande : " + product.getName() + ", Quantité : " + quantity;
    }
}
