package org.miage.Model;

public class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Commande : " + product.getName() + ", Quantité : " + quantity;
    }
}
